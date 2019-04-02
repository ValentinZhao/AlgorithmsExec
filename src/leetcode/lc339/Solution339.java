package lc339;

import java.util.List;

public class Solution339 {
    int sum = 0;
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null) return sum;
        for (NestedInteger ni : nestedList) {
            getSumDFS(ni, 1);
        }
        return sum;
    }

    private void getSumDFS(NestedInteger ni, int level) {
        if (ni.isInteger()) {
            sum += ni.getInteger() * level;
            return;
        }
        for (NestedInteger nii : ni.getList()) {
            getSumDFS(nii, level + 1);
        }
    }
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
