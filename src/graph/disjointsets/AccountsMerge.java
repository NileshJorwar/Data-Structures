package src.graph.disjointsets;

import java.util.*;
import java.util.stream.Collectors;

public class AccountsMerge {
    public static void main(String[] args) {
        List<List<String>> ls = List.of(
                List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                List.of("John", "johnsmith@mail.com", "john00@mail.com"),
                List.of("Mary", "mary@mail.com"),
                List.of("John", "johnnybravo@mail.com"));

        //johnsmith@mail.com - 0
        //john_newyork@mail.com - 0
        //0-->1
        //john00@mail.com - 1 since 1's ultimate parent is 0; put it under 0
        //mary@mail.com - 2
        //johnnybravo@mail.com - 3

        List<List<String>> ans = accountsMerge(ls);
        System.out.println(ans);
    }

    private static List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        int len = accounts.size();
        Map<String, Integer> map = new HashMap<>();
        DisjointSetsPractice disjointSetsPractice =
                new DisjointSetsPractice(len);
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (!map.containsKey(email)) {
                    map.put(email, i);
                } else {
                    disjointSetsPractice.unionBySize(i, map.get(email));
                }
            }
        }

        List<List<String>> mergedEmails = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            mergedEmails.add(new ArrayList<>());
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String email = entry.getKey();
            int ultimateParent = disjointSetsPractice.findUltimateParent(entry.getValue());
            mergedEmails.get(ultimateParent).add(email);
        }

        for (int i = 0; i < len; i++) {
            if (mergedEmails.get(i).size() == 0)
                continue;
            Collections.sort(mergedEmails.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for (String s : mergedEmails.get(i)) {
                temp.add(s);
            }
            ans.add(temp);
        }
        return ans;
    }


}
