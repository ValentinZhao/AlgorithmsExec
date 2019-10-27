package com.neu.cs5800;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class AVLInsertion {
    private int comparisons = 0;
    public int[] dataset = new int[11];

    public AVLNode generateAVL() {
        Random random = new Random();
        Set<Integer> set = new HashSet<>();
        int max = (int) Math.pow(2, 20);
        int nodesCount = 0;
        int factor = 10;
        AVLNode root = null;
        while (true) {
            int num = random.nextInt(max);
            if (set.contains(num)) continue;
            root = insertAVL(root, num);
            set.add(num);
            nodesCount++;
            if (nodesCount == (int) Math.pow(2, factor)) {
//                printHeights(root, factor);
                printComparisons(root, factor);
                dataset[factor%10] = comparisons;
                comparisons = 0;
                factor++;

            }
            if (set.size() == max-1) break;
        }
//        printHeights(root, factor);
        printComparisons(root, factor);
        dataset[10] = comparisons;
        comparisons = 0;
        return root;
    }

    public AVLNode serachAVL(AVLNode root, int target) {
        if (root == null || root.val == target) return root;
        comparisons++;
        if (root.val > target) return serachAVL(root.left, target);
        else return serachAVL(root.right, target);
    }

    public AVLNode insertAVL(AVLNode root, int val) {
        if (root == null) return new AVLNode(val);

        if (val > root.val) root.right = insertAVL(root.left, val);
        else root.left = insertAVL(root.left, val);

        root.height = Math.max(getNodeHeight(root.left), getNodeHeight(root.right)) + 1;
        int diff = getDiff(root);

        if (diff > 1 && val < root.left.val)
            return rightRotate(root);
        if (diff < -1 && val > root.right.val)
            return leftRotate(root);
        if (diff > 1 && val > root.left.val) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (diff < -1 && val < root.right.val) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root; // return the tree node we have constructed

    }

    AVLNode rightRotate(AVLNode root) {
        AVLNode left = root.left;
        AVLNode T2 = left.right;

        left.right = root;
        root.left = T2;

        root.height = Math.max(getNodeHeight(root.left), getNodeHeight(root.right)) + 1;
        left.height = Math.max(getNodeHeight(left.left), getNodeHeight(left.right)) + 1;

        return left;
    }

    AVLNode leftRotate(AVLNode root) {
        AVLNode right = root.right;
        AVLNode T2 = right.left;

        right.left = root;
        root.right = T2;

        root.height = Math.max(getNodeHeight(root.left), getNodeHeight(root.right)) + 1;
        right.height = Math.max(getNodeHeight(right.left), getNodeHeight(right.right)) + 1;

        return right;
    }

    private int getNodeHeight(AVLNode root) {
        if (root == null) return 0;
        return root.height;
    }

    private int getDiff(AVLNode root) {
        if (root == null) return 0;
        return getNodeHeight(root.left) - getNodeHeight(root.right);
    }

    private int getHeight(AVLNode root) {
        if (root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return 1 + Math.max(left, right);
    }

    private int getMinHeight(AVLNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null)
            return 1 + getMinHeight(root.left);
        if (root.right == null)
            return 1 + getMinHeight(root.right);
        return Math.min(getMinHeight(root.left), getMinHeight(root.right)) + 1;
    }

    private void printHeights(AVLNode root, int layer) {
        int minH = getMinHeight(root);
        int maxH = getHeight(root);
        int avg = (minH + maxH) >> 1;
        System.out.println("第" + layer + "层: ");
        System.out.println("min: " + minH + ", avg: " + avg + ", max: " + maxH);
        System.out.println(minH + " " + avg + " " + maxH);
    }

    private void printComparisons(AVLNode root, int layer) {
        Random random = new Random();
        int tar = random.nextInt((int) Math.pow(2, layer));
        serachAVL(root, tar);
        System.out.println("第" + layer + "层： " + comparisons);
    }
}
