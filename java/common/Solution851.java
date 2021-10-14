package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 811. 子域名访问计数
 * 一个网站域名，如"discuss.leetcode.com"，包含了多个子域名。作为顶级域名，常用的有"com"，下一级则有"leetcode.com"，最低的一级为"discuss.leetcode.com"。当我们访问域名"discuss.leetcode.com"时，也同时访问了其父域名"leetcode.com"以及顶级域名 "com"。
 *
 * 给定一个带访问次数和域名的组合，要求分别计算每个域名被访问的次数。其格式为访问次数+空格+地址，例如："9001 discuss.leetcode.com"。
 *
 * 接下来会给出一组访问次数和域名组合的列表cpdomains 。要求解析出所有域名的访问次数，输出格式和输入格式相同，不限定先后顺序。
 */
public class Solution851 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            int num = Integer.parseInt(cpdomain.split(" ")[0]);
            String[] domains = cpdomain.split(" ")[1].split("\\.");
            StringBuilder s = new StringBuilder();
            for (int i= domains.length-1;i>=0;i--){
                s.insert(0, domains[i] + ".");
                if (!map.containsKey(s.toString())) map.put(s.toString(), num);
                else map.put(s.toString(), map.get(s.toString()) + num);
            }
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            list.add(entry.getValue() + " " + entry.getKey().substring(0,entry.getKey().length()-1));
        }
        return list;
    }
}
