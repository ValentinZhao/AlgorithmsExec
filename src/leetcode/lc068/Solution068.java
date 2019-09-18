package lc068;

import java.util.ArrayList;
import java.util.List;

public class Solution068 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ret = new ArrayList<>();
        if(words.length == 0 || maxWidth == 0) {
            ret.add(""); //for some reason OJ expects list with empty string for empty array input
            return ret;
        }

        for(int i = 0, w; i < words.length; i = w) {
            int len = -1; //We need to skip the space for last word hence start len = -1
            //check how many words fit into the line
            for(w = i; w < words.length && len + words[w].length() + 1 <= maxWidth; w++) {
                len += words[w].length() + 1; // 1 extra for the space
            }

            //calculate the number of extra spaces that can be equally distributed
            //also calculate number of extra spaces that need to be added to first few
            //words till we fill the line width
            //For example line width is 20 we have three words of 3 4 2 4 length
            //[our_,life_,is_,good_,_,_,_,_,] ==> [our_,_,_,life_,_,_is_,_,good]
            //   Note _, indicates space
            //Count number of empty spaces at end of line:= width-len = 20-(15) = 5
            //These five spaces need to be equally distributed between 4-1 = 3 gaps
            //n words will have n-1 gaps between them
            // 5 / 3 = 1 extra space between each word (in addition to default 1 space,
            //                                          total space count = 2)
            // 5 % 3 = 2 extra spaces between first three words as shown above

            int evenlyDistributedSpaces = 1; //If we don't enter loop at line # 37 then we need to have default value
            int extraSpaces = 0;
            int numOfGapsBwWords = w-i-1; //w is already ponting to next index and -1 since
            //n words have n-1 gaps between them

            //Moreover we don't need to do this computation if we reached the last word
            //of array or there is only one word that can be accommodate on the line
            //then we don't need to do any justify text. In both cases text can be left,
            //left-aligned

            if(w != i+1 && w != words.length) {
                //additional 1 for the default one space between words
                evenlyDistributedSpaces = ((maxWidth-len) / numOfGapsBwWords) + 1;
                extraSpaces = (maxWidth-len)%numOfGapsBwWords;
            }

            StringBuilder sb = new StringBuilder(words[i]);
            for(int j = i+1; j < w; j++) {
                for(int s = 0; s < evenlyDistributedSpaces; s++) {
                    sb.append(' ');
                }
                if(extraSpaces > 0) {
                    sb.append(' ');
                    extraSpaces--;
                }
                sb.append(words[j]);
            }

            //Handle the above two cases we skipped, where there is only one word on line
            //or we reached end of word array. Last line should remain left aligned.
            int remaining = maxWidth-sb.length();
            while(remaining > 0) {
                sb.append(' ');
                remaining--;
            }
            ret.add(sb.toString());
        }
        return ret;
    }
}

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            res.add("");
            return res;
        }
        for (int i = 0, w; i < words.length; i = w) {
            int len = -1; // 我们会给每个词后面加一个空格，但是最后一个词不需要空格，在这里先减去
            for (w = i; w < words.length && len + words[w].length() <= maxWidth; w++) {
                len += words[w].length() + 1;
            }
            int extraSpaceForEvenDistributed = 1; // 用于给每个gap中增加的空格数
            int extraSpace = 0; // 均匀分配后可能还剩余的空格数，它会被分配给前面几个gap中，直到分配完为止
            //  此时w指向的就是下一行的第一个词了所以无需+1，w - i就是添加单词的数量。那么我们知道n个词有n-1个gap，有
            int numOfGaps = w - i - 1;

            // 当某一行只能装下一词，并且它是最后一词的话，那它就不需要分配空格，自己占最后一行即可
            // 此时的len就是所有词的长度加上每个词后面的一个空格（除了最后一词外）
            if (w != i+1 && w != words.length) {
                extraSpaceForEvenDistributed = (maxWidth-len) / numOfGaps + 1;
                extraSpace = (maxWidth - len) % numOfGaps;
            }
            StringBuilder builder = new StringBuilder(words[i]);
            for (int j = i+1; j < w; j++) {
                for (int k = 0; k < extraSpaceForEvenDistributed; k++) {
                    builder.append(" ");
                }
                if (extraSpace > 0) {
                    builder.append(" ");
                    extraSpace--;
                }
                builder.append(words[j]);
            }
            int remaining = maxWidth - builder.length();
            while (remaining > 0) {
                builder.append(" ");
                remaining--;
            }
            res.add(builder.toString());
        }
        return res;
    }
}