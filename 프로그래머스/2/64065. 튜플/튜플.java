import java.util.*;

class Solution {
    public int[] solution(String s) {
        HashMap<Integer,Integer> map=new HashMap<>();
        String[] tuples = s.substring(1, s.length() - 1).split(",");
        for(int i=0;i<tuples.length;i++){
            int temp=Integer.parseInt(tuples[i].replaceAll("[^0-9]", ""));
            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        int[] answer = new int[map.size()];
        for(int key:map.keySet()){
            answer[map.size()-map.get(key)]=key;
        }
        return answer;
    }
}