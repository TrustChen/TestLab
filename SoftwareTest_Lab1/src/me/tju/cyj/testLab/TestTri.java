package me.tju.cyj.testLab;

import java.util.Scanner;

public class TestTri {
	public static void main(String [] args){
		readLength();
		checkTri(a, b, c);
	}
	
	private static int a;
	private static int b;
	private static int c;
	
	public static void readLength(){
		Scanner input = new Scanner(System.in);
		System.out.print("�����������εĵ�һ���߳��ȣ�");
		a = input.nextInt();
		System.out.print("�����������εĵڶ����߳��ȣ�");
		b = input.nextInt();
		System.out.print("�����������εĵ������߳��ȣ�");
		c = input.nextInt();
	}
	
	public static int checkTri(int a, int b, int c){
		int max;
		if(a >= b && a >= c){
			max = a;
		}else if(b >= a && b >= c){
			max = b;
		}else{
			max = c;
		}
		
		if(max == a){
			if( b * b + c * c < a * a){
				System.out.println("����������Ƕ۽�������");
				return 2;
			}else if(b * b + c * c == a * a){
				System.out.println("�����������ֱ��������");
				return 1;
			}else{
				System.out.println("��������������������");
				return 0;
			}
		}else if(max == b){
			if( a * a + c * c < b * b){
				System.out.println("����������Ƕ۽�������");
				return 2;
			}else if( a * a + c * c == b * b){
				System.out.println("�����������ֱ��������");
				return 1;
			}else{
				System.out.println("��������������������");
				return 0;
			}
		}else{
			if( a * a + b * b < c * c){
				System.out.println("����������Ƕ۽�������");
				return 2;
			}else if( a * a + b * b == c * c){
				System.out.println("�����������ֱ��������");
				return 1;
			}else{
				System.out.println("��������������������");
				return 0;
			}
		}		
	}	
}
