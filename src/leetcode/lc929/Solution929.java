package lc929;

import java.util.HashSet;
import java.util.Set;

public class Solution929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String address : emails) {
            String[] parts = address.split("@");
            String[] local = parts[0].split("\\+");
            set.add(local[0].replace(".", "") + "@" + parts[1]);
        }
        return set.size();
    }
}

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] parts = email.split("@");
            String[] local = parts[0].split("\\+");
            String address = local[0].replace(".", "") + "@" + parts[1];
            set.add(address);
        }
        return set.size();
    }
}
