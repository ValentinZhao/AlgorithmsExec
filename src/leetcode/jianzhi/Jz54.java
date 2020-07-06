package jianzhi;

public class Jz54 {
    private String s = "";
    private int[] ocr = new int[256];
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        ocr[ch]++;
        s += ch;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for (int i = 0; i < s.length(); i++) {
            if (ocr[s.charAt(i)] == 1) return s.charAt(i);
        }

        return '#';
    }
}
