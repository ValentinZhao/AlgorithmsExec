package com.neu.cs5800;

public class AVLNode {
    int val;
    int height;
    AVLNode left, right;

    public AVLNode(int _val) {
        this.val = _val;
        this.height = 1;
    }
}
