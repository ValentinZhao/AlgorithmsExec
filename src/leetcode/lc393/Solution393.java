package lc393;

/**
 * 这道题考察我们UTF-8编码，这种互联网所采用的通用的编码格式的产生是为了解决ASCII只能表示英文字符的局限性，和统一Unicode的实现方式。下面这段摘自维基百科UTF-8编码：
 *
 * 对于UTF-8编码中的任意字节B，如果B的第一位为0，则B独立的表示一个字符(ASCII码)；
 * 如果B的第一位为1，第二位为0，则B为一个多字节字符中的一个字节(非ASCII字符)；
 * 如果B的前两位为1，第三位为0，则B为两个字节表示的字符中的第一个字节；
 * 如果B的前三位为1，第四位为0，则B为三个字节表示的字符中的第一个字节；
 * 如果B的前四位为1，第五位为0，则B为四个字节表示的字符中的第一个字节；
 * 因此，对UTF-8编码中的任意字节，根据第一位，可判断是否为ASCII字符
 * 根据前二位，可判断该字节是否为一个字符编码的第一个字节；
 * 根据前四位（如果前两位均为1），可确定该字节为字符编码的第一个字节，并且可判断对应的字符由几个字节表示；
 * 根据前五位（如果前四位为1），可判断编码是否有错误或数据传输过程中是否有错误。
 *
 * 在论坛里看到了一种非常简洁的方法，大神就是大神啊
 * 这种方法也是要记连续1的个数
 * 如果是标识字节，先将其向右平移五位，如果得到110，则说明后面跟了一个字节
 * 否则向右平移四位，如果得到1110，则说明后面跟了两个字节
 * 否则向右平移三位，如果得到11110，则说明后面跟了三个字节
 * 否则向右平移七位，如果为1的话，说明是10000000这种情况，不能当标识字节，直接返回false。
 * 在非标识字节中，向右平移六位，如果得到的不是10，则说明不是以10开头的，直接返回false
 * 否则cnt自减1，成功完成遍历返回true
 *
 * 那么再自我总结一下这个算法就是，UTF-8编码需要第一个标志字节，这个字节的前面的1的数量，决定了后面有几个字节跟着
 * 那么大体的流程就是通过读标志位来确定后面有几个字节，如果读完了数组发现后面的字节数量和标志位对的上就可以返回true，期间有很多条件返回false
 * 我们一步步来看
 */
public class Solution393 {
    public boolean validUtf8(int[] data) {
        int count = 0;
        for (int c : data) {
            if (count == 0) {
                if ((c >> 5) == 0b110) count = 1;
                else if ((c >> 4) == 0b1110) count = 2;
                else if ((c >> 3) == 0b11110) count = 3;
                else if ((c >> 7) != 0) return false;
            } else {
                // 我们在下表中可以看到，除标志字节，后面的字节全都是以"10"开头的，表示非ASCII字节码，当然最后一位可以以0开头
                if ((c >> 6) != 0b10) return false;
                count--;
            }
        }
        return count == 0;
    }
}

/**
 *    Char. number range  |        UTF-8 octet sequence
 *       (hexadecimal)    |              (binary)
 *    --------------------+---------------------------------------------
 *    0000 0000-0000 007F | 0xxxxxxx
 *    0000 0080-0000 07FF | 110xxxxx 10xxxxxx
 *    0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
 *    0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
 */
