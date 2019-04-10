package SegTreeNode;

public class SegTreeNode {
    public int min, max; // range [min, max]
    public int count; // customized field for problem315
    public SegTreeNode left, right;

    public SegTreeNode (int min, int max){
        this.max = max;
        this.min = min;
        count = 0;
    }

    public int mid() {
        return (max + 1 - min) / 2 + min;
    }
}
