package lc364;

import java.util.List;

public class Solution364 {
    int sum = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        int height = getHeight(nestedList);
        for (NestedInteger ni : nestedList) {
            getSumDFS(ni, height);
        }
        return sum;
    }

    private void getSumDFS(NestedInteger ni, int height) {
        if (ni.isInteger()) {
            sum += ni.getInteger() * height;
            return;
        }
        for (NestedInteger nii : ni.getList()) {
            getSumDFS(nii, height - 1);
        }
    }

    private int getHeight(List<NestedInteger> nestedList) {
        int maxHeight = 1;
        for (NestedInteger ni : nestedList) {
            if (!ni.isInteger()) {
                maxHeight = Math.max(maxHeight, 1 + getHeight(ni.getList()));
            } else {
                maxHeight = Math.max(maxHeight, 1);
            }
        }
        return maxHeight;
    }

    class NestedInteger {
        // Constructor initializes an empty nested list.
        private int val;

        private List<NestedInteger> nestedList;

        public NestedInteger() {};

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
            this.val = value;
        };

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return nestedList == null;
        };

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return this.val;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
            this.val = value;
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
            nestedList.add(ni);
        };

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return nestedList;
        };
    }
}
