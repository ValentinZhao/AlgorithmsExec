public class cut {
	public static int buttom_up_cut(int[] p) {
		        int []r=new int[p.length+1];
        for(int i=1;i<=p.length;i++)
        {
            int q=-1;
            // 内层循环，前一个j-1是因为j是从1开始的，j-1保证数组可以从0读起
	    // i-j保证了（由于j是从1开始）r数组从r[0]到r[i-1]都能在内层循环被遍历一次
	    // 它就保证了取到了每个子结构能取到最优解
            for(int j=1;j<=i;j++)
                q=Math.max(q, p[j-1]+r[i-j]);
	    // 外层循环主要是为了轮询r数组，把每次最优解q给到r[i]
            r[i]=q;
        }
        return r[p.length];
	}
}
