package lc468;

public class Solution468 {
    public String validIPAddress(String IP) {
        if (IP.equals("")) return "Neither";
        if (isIPV4(IP)) return "IPv4";
        if (isIPV6(IP)) return "IPv6";
        return "Neither";
    }

    private boolean isIPV6(String ip) {
        if (ip.charAt(0) == ':' || ip.charAt(ip.length() - 1) == ':') return false;
        String[] ips = ip.split("\\:");
        if (ips.length != 8) return false;
        for (int i = 0; i < 8; i++) {
            if (ips[i].length() > 4 || ips[i].length() == 0) return false;
            for (int j = 0; j < ips[i].length(); j++) {
                if (    !(ips[i].charAt(j) >= '0' && ips[i].charAt(j) <= '9') ||
                        !(ips[i].charAt(j) >= 'a' && ips[i].charAt(j) <= 'f') ||
                        !(ips[i].charAt(j) >= 'A' && ips[i].charAt(j) <= 'F')) return false;
            }
        }
        return true;
    }

    private boolean isIPV4(String ip) {
        if (ip.charAt(0) == '.' || ip.charAt(ip.length() - 1) == '.') return false;
        String[] ips = ip.split("\\.");
        if (ips.length != 4) return false;
        for (int i = 0; i < 4; i++) {
            try {
                if (ips[i].startsWith("0") && ips[i].length() > 1) return false;
                if (Integer.valueOf(ips[i]) > 255 || ips[i].charAt(0) == '-' || ips[i].charAt(0) == '+') return false;
            } catch(NumberFormatException e) {
                System.out.println(e);
                return false;
            }
        }
        return true;
    }
}
