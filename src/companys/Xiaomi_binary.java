package companys;

import java.util.Scanner;

public class Xiaomi_binary{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		int y = m ^ n;
		int count = 0;
		while(y != 0){
			y = y & (y - 1);
			//a&=(a-1)�õ������ǽ�a���λ��1��Ϊ0�����
			//ԭ������ڵ�����ȡ�����֮��Ľ������������ֵΪ1�ĵط���ʾԭ���������ڴ���λ����ͬ
			//������ÿ�ζ�ȥ������������һλ��Ϊ�㲢��0�Ƚ�
			//�����ʱ��Ϊ�㣬˵�������һλ֮ǰ������1��Ҳ���ǻ��в���ͬ����λ�����Ǿ�ʹcount++
			//ֻ���ҽ����һλ��Ϊ��ʹ������������λȫΪ��ʱ����ʱ��Ҳ�����ڲ���ͬ����λ�ˣ����˳�ѭ��
			++count;
		}
		System.out.println(count);
	}
}
