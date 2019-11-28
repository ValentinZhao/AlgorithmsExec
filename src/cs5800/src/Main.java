import com.cs5800.hackerrank.DayOfTheProgrammer;
import com.neu.cs5800.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] caps = new int[]{127, 257, 509, 1021, 2053, 4099, 8191};


        for (int i = 0; i < 1; i++) {
            int cap = 8191;

//            LinearProbingHashTable lp = new LinearProbingHashTable(8191);
            DoubleHashingHashTable dh = new DoubleHashingHashTable(cap);
            int seed = 10000;

            try {
                Random random = new Random();
                while (true) {
//                    lp.insert(String.valueOf(random.nextInt(seed)), "texts");
                    dh.insert(String.valueOf(random.nextInt(seed)), 111);
                }

            } catch (Exception e) {
                System.out.println("当前cap：" + cap);
//                System.out.println("当前元素数：" + lp.getSize());
//                System.out.println("当前load：" + lp.getSize() / cap);
            }

            DoubleHashingHashTable.HashEntry[] table = dh.getTable();

            for (int j = 1; j < table.length; j++) {
                DoubleHashingHashTable.HashEntry entry = table[j];
                System.out.println("当前key：" + entry.getKey());
                dh.get(entry.getKey());
            }
            System.out.println("当前map：" + dh.getMap());

        }

//        patternMatch();

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
