package lc609;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution609 {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] dirInfo = path.split(" ");
            String dir = dirInfo[0];
            for (int i = 1; i < dirInfo.length; i++) {
                String[] fileInfo = fileInfoSeperator(dirInfo[i]);
                String fullDir = dir + '/' + fileInfo[0];
                if (!map.containsKey(fileInfo[1])) map.put(fileInfo[1], new ArrayList<>());
                map.get(fileInfo[1]).add(fullDir);
            }
        }
        for (String key : map.keySet()) {
            list.add(map.get(key));
        }
        return list;
    }

    private String[] fileInfoSeperator(String s) {
        Pattern pattern = Pattern.compile("(\\w+\\.txt)\\((.*?)\\)");
        Matcher matcher = pattern.matcher(s);
        String[] results = new String[2];
        while(matcher.find()) {
            results[0] = matcher.group(1);
            results[1] = matcher.group(2);
        }
        return results;
    }
}
