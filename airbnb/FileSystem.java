/**
开始的时候是写两个 function, create 和 get
create("/a",1)
get("/a") //得到 1
create("/a/b",2)
get("/a/b") //得到 2
create("/c/d",1) //Error,因为它的上一级“/c”并不存在
get("/c") //Error,因为“/c”不存在

follow up: 每个文件路径又有自己的callback，使用watch来增加callback，每次set的时候触发
 */
class Solution {
    private static Map<String, Integer> pathMap;
    private static Map<String, Runnable> funcMap;

    public boolean create(String path, int value) {
        if (pathMap.containsKey(path)) {
            return false;
        }

        // 如果直接设置了/a/b，但是却没有它的父目录/a的话，这时候也是不行的
        if (!pathMap.containsKey(path.substring(0, path.lastIndexOf("/")))) {
            return false;
        }

        pathMap.put(path, value);
        return true;
    }

    public boolean set(String path, int value) {
        if (!path.containsKey(path)) return false;
        pathMap.put(path, value);

        String curPath = path;
        while (curPath.length() > 0) {
            if (funcMap.containsKey(curPath)) {
                funcMap.get(curPath).run();
            }
            int lastIndex = curPath.lastIndexOf("/");
            curPath = curPath.substring(0, lastIndex);
        }
        return true;
    }

    public int get(String path) {
        return pathMap.get(path);
    }

    public boolean watch(String path, Runnable cb) {
        if (!pathMap.containsKey(path)) {
            return false;
        }

        funcMap.put(path, cb);
        return true;
    }
}