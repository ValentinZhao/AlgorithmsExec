package nowcoder;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NiuniuFindJob {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        int[] b=new int[m];//放小伙伴的能力
        Map<Integer,Integer> map=new TreeMap<Integer,Integer>();
        for(int i=0;i<n;i++){//首先读入工作难度和薪酬
            int key=input.nextInt();
            int value=input.nextInt();
            map.put(key,value);
        }
        for(int i=0;i<m;i++){//

            int t=input.nextInt();
            b[i]=t;

            if(!map.containsKey(t)){//小伙伴能力>=工作难度，工作难度边界处，直接对应薪酬
                map.put(t,0);//不在工作难度边界处的，放入map，且对应薪酬为0
            }
        }
        int max=Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            max=Math.max(max,entry.getValue());
            map.put(entry.getKey(),max);//更新不在工作难度边界处的薪酬
        }
        for(int i=0;i<m;i++){
            System.out.println(map.get(b[i]));
        }
    }
}