import com.cs5800.hackerrank.DayOfTheProgrammer;
import com.neu.cs5800.*;
import com.neu.cs5800.utils.Utils;

import java.io.*;
import java.util.*;

import static com.neu.cs5800.utils.Utils.isInteger;

public class Main {
    public static void main(String[] args) {
//        int[] caps = new int[]{127, 257, 509, 1021, 2053, 4099, 8191};
//
//
//        for (int i = 0; i < 1; i++) {
//            int cap = 8191;
//
//            LinearProbingHashTable lp = new LinearProbingHashTable(8191);
////            DoubleHashingHashTable dh = new DoubleHashingHashTable(cap);
//            int seed = 10000;
//
//            try {
//                Random random = new Random();
//                while (true) {
//                    lp.insert(String.valueOf(random.nextInt(seed)), "texts");
////                    dh.insert(String.valueOf(random.nextInt(seed)), 111);
//                }
//
//            } catch (Exception e) {
//                System.out.println("当前cap：" + cap);
////                System.out.println("当前元素数：" + lp.getSize());
////                System.out.println("当前load：" + lp.getSize() / cap);
//            }
//
//            String[] keys = lp.getKeys();
//
//            for (int j = 0; j < keys.length; j++) {
//                System.out.println("当前key：" + keys[j]);
//                lp.get(keys[j]);
//            }
//            System.out.println("当前map：" + lp.getMap());
//
//        }


        InvertedIndex invertedIndex = new InvertedIndex();
        readAllDocs(invertedIndex);
        String word;
        StringBuilder builder = new StringBuilder();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter to search for a word:");
        word = sc.nextLine();
        if (word.contains("AND")) {
            String[] words = word.split("\\s+");
            String word1 = words[0], word2 = words[2];
            List<List<Integer>> res1 = invertedIndex.search(word1);
            List<List<Integer>> res2 = invertedIndex.search(word2);
            for (List<Integer> invertedList1 : res1) set1.add(invertedList1.get(0));
            for (List<Integer> invertedList2 : res2) set2.add(invertedList2.get(0));
            set1.addAll(set2);
            for (Integer id : set1) {
                builder.append(id);
                builder.append(" & ");
            }
            builder.delete(builder.lastIndexOf(" & "), builder.length()-1);
            System.out.println("Your AND result: " + builder.toString());
        } else if (word.contains("OR")) {
            String[] words = word.split("\\s+");
            String word1 = words[0], word2 = words[2];
            List<List<Integer>> res1 = invertedIndex.search(word1);
            List<List<Integer>> res2 = invertedIndex.search(word2);
            for (List<Integer> invertedList1 : res1) set1.add(invertedList1.get(0));
            for (List<Integer> invertedList2 : res2) set2.add(invertedList2.get(0));
            set1.retainAll(set2);
            for (Integer id : set1) {
                builder.append(id);
                builder.append(" & ");
            }
            if (builder.length() > 0)
                builder.delete(builder.lastIndexOf(" & "), builder.length()-1);
            else builder.append("null");
            System.out.println("Your OR result: " + builder.toString());
        } else {
            List<List<Integer>> res = invertedIndex.search(word);
            System.out.println("Your inverted list: " + res);
            for (List<Integer> invertedList : res) {
                builder.append(invertedList.get(0));
                builder.append(" & ");
            }
            builder.delete(builder.lastIndexOf(" & "), builder.length()-1);
            System.out.println("Your search result: " + builder.toString());
        }
    }

    private static void readAllDocs(InvertedIndex invertedIndex) {
        File folder = new File("/Users/codemao/zzl/neu-course-materials/cs5800/Assignments/poems");
        File[] listOfFiles = folder.listFiles();

        int numberOfDocs = 0;

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    if (!file.getName().contains(".txt")) continue;
                    numberOfDocs++;
                    System.out.println(file.getName());
                    addVocabulary(invertedIndex, file.getName());
                }
            }
        }
        System.out.println("Number of documents: " + numberOfDocs);
    }

    private static void addVocabulary(InvertedIndex invertedIndex, String fileName) {
        // fileName -> i.e., "doc146.txt"
        String filePrefix = "/Users/codemao/zzl/neu-course-materials/cs5800/Assignments/poems/";
        String fileEntireName = filePrefix + fileName;
        // retrieve the document id out of file name
        // i.e. "doc146.txt" -> 146
        int documentId = Integer.valueOf(fileName.replaceAll("[^0-9]", ""));
        invertedIndex.buildIndices(fileEntireName, documentId);
        InvertedIndex.TrieNode root = invertedIndex.getRoot();
        int res = Utils.countTrie(root);
        System.out.println("Trie Vocabulary: " + res);
    }

    private static void indexAllPoems() {
        try {
            String filePrefix = "/Users/codemao/zzl/neu-course-materials/cs5800/Assignments";
            BufferedReader buff = new BufferedReader(new FileReader(filePrefix + "/Poem-collection.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePrefix + "/default-writer.txt"));
            String line = buff.readLine();
            while (line != null) {
                if (isInteger(line)) {
                    writer.close();
                    writer = new BufferedWriter(new FileWriter(filePrefix+"/poems/doc"+line+".txt"));
                    buff.readLine(); // skip \\n
                } else {
                    line = line.toLowerCase();
                    line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();
                    writer.write(line);
                    writer.newLine();
                }
                line = buff.readLine();
            }

            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void patternMatch() {
        BufferedReader buff;
        BufferedReader buffMoby;

        try {
            buff = new BufferedReader(new FileReader("/Users/codemao/zzl/neu-course-materials/cs5800/Assignments/words_alpha.txt"));
            buffMoby = new BufferedReader(new FileReader("/Users/codemao/zzl/neu-course-materials/cs5800/Assignments/mobydick.txt"));
            PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(String::length));
            String curr = buff.readLine();
            while (curr != null) {
                pq.offer(curr);
                curr = buff.readLine();
            }

            String line = buffMoby.readLine();
            StringBuilder sb = new StringBuilder();
            while (line != null) {
                sb.append(line);
                line = buffMoby.readLine();
            }
            String novelMobyDick = sb.toString();

            String[][] dict = generateRandomDict(pq);

            testMultipleMatchingOnMoby(novelMobyDick, dict);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testMultipleMatchingOnMoby(String novel, String[][] dict) {
        TextSearch ts = new TextSearch();

        for (int i = 0; i < 10; i++) {
            long start = System.currentTimeMillis();
            for (int j = 0; j < 100; j++) {
                ts.naiveSearch(novel, dict[i][j]);
            }
            long end = System.currentTimeMillis();
            System.out.print("Word Length：" + (i+1) + " ");
            System.out.println("Time Consuming：" + (end - start));
        }
    }

    private static String[][] generateRandomDict(PriorityQueue<String> pq) {
        List<List<String>> buckets = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            buckets.add(new ArrayList<>());
            while (!pq.isEmpty() && pq.peek().length() == i) {
                buckets.get(i-1).add(pq.poll());
            }
        }
        String[][] dict = new String[10][100];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int tmpSize = buckets.get(i).size();
            for (int j = 0; j < 100; j++) {
                dict[i][j] = buckets.get(i).get(random.nextInt(tmpSize));
            }
        }

        return dict;
    }
}
