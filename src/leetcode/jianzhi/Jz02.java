package jianzhi;

public class Jz02 {
    public String replaceSpace(StringBuffer str) {
        String tmp = str.toString();
        return tmp.replaceAll("\\s", "%20");
    }
}
