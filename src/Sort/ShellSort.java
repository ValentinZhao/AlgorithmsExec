package Sort;

import java.util.Scanner;

public class ShellSort {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		int[] a = new int[num];
		for(int i = 0; i < num; i++){
			a[i] = s.nextInt();
		}
		shellSort(a);
		for(int i = 0; i < num; i++){
			if(i == num - 1){
				System.out.print(a[i]);
				break;
			}
			System.out.print(a[i] + " ");
		}
	}

	private static void shellSort(int[] a) {
		if(a == null || a.length == 0){
			return;
		}		
		int d = a.length / 2;
		while(d >= 1){
			shellInsert(a, d);
			d = d / 2;
		}
	}
	
	private static void shellInsert(int[] a, int d){
		for(int i = d; i < a.length - 1; i++){
			int j = i - d;
			int temp = a[i]; //待插入的数
			while(j >= 0 && a[j] > temp){
				a[j+d] = a[j];
				j -= d; //把j归位,退出循环时j是增量后的数组值，需要在上一次循环结束时退回前一个增量
			}
			if(j != i - d){//存在比其小的数
				a[j+d] = temp;
			}
		}
	}
}
