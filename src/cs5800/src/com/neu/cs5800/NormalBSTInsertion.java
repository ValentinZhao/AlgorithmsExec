package com.neu.cs5800;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NormalBSTInsertion {
    private int comparisons = 0;
    public int[] dataset = new int[11];

    public BSTNode generateBST() {
        Random random = new Random();
        Set<Integer> set = new HashSet<>();
        int max = (int) Math.pow(2, 20);
        int nodesCount = 0;
        int factor = 10;
        BSTNode root = null;
        while (true) {
            int num = random.nextInt(max);
            if (set.contains(num)) continue;
            root = insertBST(root, num);
            set.add(num);
            nodesCount++;
            if (nodesCount == (int) Math.pow(2, factor)) {
                printHeights(root, factor);
                printComparisons(root, factor);
                dataset[factor%10] = comparisons;
                comparisons = 0;
                factor++;
            }
            if (set.size() == max-1) break;
        }
        printHeights(root, factor);
        printComparisons(root, factor);
        dataset[10] = comparisons;
        comparisons = 0;
        return root;
    }

    public BSTNode serachBST(BSTNode root, int target) {
        if (root == null || root.val == target) return root;
        comparisons++;
        if (root.val > target) return serachBST(root.left, target);
        else return serachBST(root.right, target);
    }

    public BSTNode insertBST(BSTNode root, int val) {
        BSTNode node = new BSTNode(val);
        if (root == null) {
            return node;
        }

        if (val < root.val) root.left = insertBST(root.left, val);
        else root.right = insertBST(root.right, val);
        return root;
    }

    private int getHeight(BSTNode root) {
        if (root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return 1 + Math.max(left, right);
    }

    private int getMinHeight(BSTNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null)
            return 1 + getMinHeight(root.left);
        if (root.right == null)
            return 1 + getMinHeight(root.right);
        return Math.min(getMinHeight(root.left), getMinHeight(root.right)) + 1;
    }

    private void printHeights(BSTNode root, int layer) {
        int minH = getMinHeight(root);
        int maxH = getHeight(root);
        int avg = (minH + maxH) >> 1;
        System.out.println("第" + layer + "层: ");
        System.out.println("min: " + minH + ", avg: " + avg + ", max: " + maxH);
        System.out.println(minH + " " + avg + " " + maxH);
    }

    private void printComparisons(BSTNode root, int layer) {
        Random random = new Random();
        int tar = random.nextInt((int) Math.pow(2, layer));
        serachBST(root, tar);
        System.out.println("第" + layer + "层： " + comparisons);
    }
}
