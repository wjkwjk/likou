package common;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution90_2 {

    //可以先排序，若是上一个相同的元素没有选中，则当前元素也不选

    void A(ArrayList<List<Integer>> lists, List<Integer> list, int index, ArrayList<Integer> temp, ArrayList<HashMap<Integer, Integer>> M){
        if (index >= list.size()){
            ArrayList<Integer>t = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i=0;i<temp.size();i++){
                t.add(temp.get(i));
                if (map.containsKey(temp.get(i))) map.put(temp.get(i), map.get(temp.get(i)) + 1);
                else map.put(temp.get(i), 1);
            }
            int flag = 0;
            for (int i=0;i<M.size();i++){
                if (M.get(i).size() != map.size())  continue;
                else{
                    for (Map.Entry<Integer, Integer>entry:M.get(i).entrySet()){
                        if (map.get(entry.getKey()) != entry.getValue())    break;
                        flag++;
                    }
                    if (flag == M.get(i).size()){
                        break;
                    }
                    flag=0;
                }
            }
            if (flag==0){
                lists.add(t);
                M.add(map);
            }
            return;
        }
        A(lists, list, index+1, temp, M);
        temp.add(list.get(index));
        A(lists, list, index+1, temp, M);
        temp.remove(temp.size()-1);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<nums.length;i++) list.add(nums[i]);
        ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
        A(lists, list, 0, new ArrayList<>(), new ArrayList<HashMap<Integer, Integer>>());

        return lists;
    }

}
