package lc690;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DFS秒
 */
public class Solution690 {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) map.put(e.id, e);
        return getImportanceDFS(map, id);
    }

    private int getImportanceDFS(Map<Integer, Employee> map, int id) {
        Employee root = map.get(id);
        int jointImportance = root.importance;
        for (int sub : root.subordinates) {
            jointImportance += getImportanceDFS(map, sub);
        }
        return jointImportance;
    }

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };
}
