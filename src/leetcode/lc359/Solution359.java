package lc359;

import java.util.HashMap;
import java.util.Map;

public class Solution359 {
    class Logger {

        private Map<String, Integer> map;
        /** Initialize your data structure here. */
        public Logger() {
            map = new HashMap<>();
        }

        /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
         If this method returns false, the message will not be printed.
         The timestamp is in seconds granularity. */
        public boolean shouldPrintMessage(int timestamp, String message) {
            if (!map.containsKey(message)) {
                map.put(message, timestamp);
                return true;
            } else {
                // 这种情况，比如说连续的出现同一个message的timestamp，如果不在map put一次，我们会一直引用第一次出现的时间，其实是不对的
                // 一定要记得无论上下那种情况都要更新timestamp
                boolean res = timestamp - map.get(message) >= 10;
                map.put(message, timestamp);
                return res;
            }

        }
    }
}
