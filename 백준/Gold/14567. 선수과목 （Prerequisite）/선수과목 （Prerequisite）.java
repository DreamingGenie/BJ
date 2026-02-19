
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  //1번
  static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
  static int answer=Integer.MAX_VALUE;
  static int N;
  static int M;
  static ArrayList<Integer>[] arr;
  static boolean[] complete;
  static boolean[] nextcomplete;
  static int[] ansarr;

  public static void main(String[] args) throws IOException{
      // TODO Auto-generated method stub
      //int T=Integer.parseInt(br.readLine());
	  int T=1;

      for(int t=1;t<=T;t++ ) {
          input();
          //print();
          study(0,0);
          for(int i=0;i<N;i++) {
        	  System.out.print(ansarr[i]+1+" ");
          }
      }
  }
  public static void study(int index,int value) {
      //System.out.println(index+" "+value);
      if(index>=N) {
          for(int i=0;i<N;i++) {
              if(!complete[i])
                  return;

          }
          answer=Math.min(answer, value);
          return;
      }
      boolean checker=false;
      for(int i=0;i<N;i++) {
          if(complete[i])
              continue;
          if(check(i))
          {
              checker=true;
              break;
          }
      }
      if(!checker)
          return;

      int count=0;

      for(int i=0;i<N;i++) {
          //System.out.println("count1 "+ count+" "+complete[i]+" "+check(i));
          if(complete[i])
              continue;
          if(!check(i))
              continue;

          nextcomplete[i]=true;
          ansarr[i]=value;
          count++;
          //System.out.println("count2 "+ count);
      }

      for(int i=0;i<N;i++) {
          complete[i]=nextcomplete[i];
      }

      study(index+count,value+1);
  }
  public static boolean check(int index) {
      for(int i : arr[index]) {
          if(!complete[i-1])
              return false;
      }
      return true;
  }
  public static void input() throws IOException {
	  StringTokenizer st=new StringTokenizer(br.readLine());
      N=Integer.parseInt(st.nextToken());
      M=Integer.parseInt(st.nextToken());
      arr=new ArrayList[N];
      complete=new boolean[N];
      nextcomplete=new boolean[N];
      ansarr=new int[N];
      answer=Integer.MAX_VALUE;
      for(int i=0;i<N;i++) {
          arr[i]=new ArrayList<Integer>();
      }
      for(int i=0;i<M;i++) {
    	  st=new StringTokenizer(br.readLine());
          int A=Integer.parseInt(st.nextToken());
          int B=Integer.parseInt(st.nextToken());
          arr[B-1].add(A);
      }
  }
}
