import java.util.List;

/**
 * 通过构建一个图来解决，node是房间，edge是钥匙，构建完之后看哪个节点没有连接，有分离出来的节点就说明无法access
 */
public class Solution841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        visitAllRoom(rooms, 0, visited);
        for (boolean v : visited) if (!v) return false;
        return true;
    }

    private void visitAllRoom(List<List<Integer>> rooms, int roomNumber, boolean[] visited) {
        if (roomNumber != 0 && visited[roomNumber]) return;
        visited[roomNumber] = true;
        List<Integer> keys = rooms.get(roomNumber);
        for (int key : keys) {
            visitAllRoom(rooms, key, visited);
        }
    }

}
