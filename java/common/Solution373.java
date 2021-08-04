package common;

import java.util.*;

/**
 * 373. 查找和最小的K对数字
 * 给定两个以升序排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 *
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 *
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 */

public class Solution373 {

    private void swap(List<Integer> x, List<Integer> y){
        int temp;
        temp = x.get(0);
        x.set(0, y.get(0));
        y.set(0, temp);

        temp = x.get(1);
        x.set(1, y.get(1));
        y.set(1, temp);
    }

    public void downAdjust(List<List<Integer>> L, int root, int end){
        while (root <= end){
            int rootval = L.get(root).get(0) + L.get(root).get(1);
            int rootleftval = Integer.MAX_VALUE;
            int rootrightval = Integer.MAX_VALUE;
            if (root * 2 > end)   break;
            else {
                int swaptar = root;
                rootleftval = L.get(root * 2).get(0) + L.get(root * 2).get(1);
                if (root * 2 + 1 > end)    swaptar = root * 2;
                else {
                    rootrightval = L.get(root * 2 + 1).get(0) + L.get(root * 2 + 1).get(1);
                    swaptar = rootleftval >= rootrightval ? root * 2 + 1 : root * 2;
                }
                if (rootval > L.get(swaptar).get(0) + L.get(swaptar).get(1))
                    swap(L.get(root), L.get(swaptar));
                else break;

                root = swaptar;
            }
        }
    }

    public void upAdjust(List<List<Integer>> L, int root){
        while (root >= 1){
            int rootval = L.get(root).get(0) + L.get(root).get(1);
            if (root / 2 < 1)   break;
            int prerootval = L.get(root/2).get(0) + L.get(root/2).get(1);
            if (rootval < prerootval)   swap(L.get(root), L.get(root/2));
            else break;
            root /= 2;
        }
    }

    public void createMinHeap(List<List<Integer>> L){
        for (int i=L.size()/2;i>=1;i--){
            downAdjust(L, i, L.size()-1);
        }
    }

    public List<List<Integer>> MinHeapSort(List<List<Integer>> L, int k){
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        int end = L.size() - 1;
        while (k > 0 && end >= 1){
            r.add(new ArrayList<>(L.get(1)));
            swap(L.get(1), L.get(end));
            downAdjust(L, 1, --end);
            k--;
        }
        return r;
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> L = new ArrayList<List<Integer>>();
        L.add(new ArrayList<>(Arrays.asList(Integer.MIN_VALUE, Integer.MIN_VALUE)));
        for (int i : nums1) {
            for (int j : nums2) {
                L.add(new ArrayList<>(Arrays.asList(i, j)));
            }
        }
        createMinHeap(L);
        return MinHeapSort(L, k);
    }

    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums1.length;i++)    map.put(nums1[i],i);
        int[] p = new int[nums1.length];
        List<List<Integer>> L = new ArrayList<List<Integer>>();
        L.add(new ArrayList<>(Arrays.asList(Integer.MIN_VALUE, Integer.MIN_VALUE)));
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        for (int i=0;i<p.length;i++){
            L.add(new ArrayList<>(Arrays.asList(nums1[i], nums2[p[i]])));
        }

        int m = 0;
        while (k > 0 && m < nums1.length){
            r.add(new ArrayList<>(L.get(1)));
            int x = ++p[map.get(L.get(1).get(0))];
            swap(L.get(1), L.get(L.size()-1-m));
            downAdjust(L, 1, L.size()-2-m);
            if (x<nums2.length){
                L.get(L.size()-1-m).set(1, nums2[x]);
                upAdjust(L, L.size()-1-m);
            }
            else m++;
            k--;
        }
        return r;
    }
}
