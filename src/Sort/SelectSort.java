package Sort;

import java.util.Scanner;

public class SelectSort {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int num = scanner.nextInt();
			int[] a = new int[num];
			for(int i = 0; i < num; i++){
				a[i] = scanner.nextInt();
			}
			System.out.println(a.length);
			for(int i = 0; i < num; i++){
				if(i == num - 1){
					System.out.print(a[i]);
					break;
				}
				System.out.print(a[i] + " ");
			}
		}
	}	
}
