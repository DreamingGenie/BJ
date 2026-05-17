import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int size=words.length;
        int max=Integer.MAX_VALUE/10;
        //boolean[] visited=new boolean[size];
        HashMap<String,Integer> wordmap=new HashMap<>();
        Queue<String> q=new ArrayDeque<>();
        for(int i=0;i<size;i++){
            wordmap.put(words[i],max);
        }
        wordmap.put(begin,0);
        q.add(begin);
        while(!q.isEmpty()){
            String temp=q.poll();
            if(temp.equals(target)){
                answer=wordmap.get(temp);
                break;
            }
            
            char[] tempc=temp.toCharArray();
            for(int i=0;i<size;i++){
                String next=words[i];
                char[] nextc=next.toCharArray();
                int diff=0;
                for(int j=0;j<temp.length();j++){
                    if(tempc[j]!=nextc[j])
                        diff++;
                    if(diff>1)
                        break;
                }
                if(diff==1&&wordmap.get(next)==max){
                    q.add(next);
                    wordmap.put(next,wordmap.get(temp)+1);    
                }
            }
        }
        return answer;
    }
}