package lc165;

public class Solution165 {
    public int compareVersion(String version1, String version2) {
        int len = Math.max(version1.length(), version2.length());
        int[] v1 = new int[len];
        int[] v2 = new int[len];
        String[] strArray1 = version1.split("\\.");
        String[] strArray2 = version2.split("\\.");
        for (int i = 0; i < strArray1.length; i++) {
            v1[i] = Integer.parseInt(strArray1[i]);
        }
        for (int i = 0; i < strArray2.length; i++) {
            v2[i] = Integer.parseInt(strArray2[i]);
        }
        int index = 0;
        while (index < len) {
            if (v1[index] > v2[index]) return 1;
            else if (v1[index] < v2[index]) return -1;
            index++;
        }
        return 0;
    }
}
