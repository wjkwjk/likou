package common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 904. 水果成篮
 * 在一排树中，第 i 棵树产生 tree[i] 型的水果。
 * 你可以从你选择的任何树开始，然后重复执行以下步骤：
 *
 * 把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。
 * 移动到当前树右侧的下一棵树。如果右边没有树，就停下来。
 * 请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。
 *
 * 你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。
 *
 * 用这个程序你能收集的水果树的最大总量是多少？
 */
public class Solution904 {

    /**
     * 本质上就是找一个最长的连续子数组，要求子数组中有两种不同的元素
     * @param fruits
     * @return
     */

    public int totalFruit(int[] fruits) {
        int left = 0, right = 0;
        int maxC = 0;
        Map<Integer, Integer> kinds = new HashMap<>();
        for (;right < fruits.length;right++){
            if (kinds.containsKey(fruits[right])){
                kinds.put(fruits[right], kinds.get(fruits[right])+1);
                continue;
            }
            if (kinds.size() < 2){
                kinds.put(fruits[right], 1);
            }else {
                maxC = Math.max(maxC, right - left);
                kinds.put(fruits[left], kinds.get(fruits[left])-1);
                if (kinds.get(fruits[left]) == 0){
                    kinds.remove(fruits[left]);
                }
                left++;
                right--;
            }
        }
        maxC = Math.max(maxC, right - left);
        return maxC;
    }
}
//[3,3,3,1,2,1,1,2,3,3,4]