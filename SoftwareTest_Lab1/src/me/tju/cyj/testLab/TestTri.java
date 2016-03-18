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
		System.out.print("请输入三角形的第一条边长度：");
		a = input.nextInt();
		System.out.print("请输入三角形的第二条边长度：");
		b = input.nextInt();
		System.out.print("请输入三角形的第三条边长度：");
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
				System.out.println("这个三角形是钝角三角形");
				return 2;
			}else if(b * b + c * c == a * a){
				System.out.println("这个三角形是直角三角形");
				return 1;
			}else{
				System.out.println("这个三角形是锐角三角形");
				return 0;
			}
		}else if(max == b){
			if( a * a + c * c < b * b){
				System.out.println("这个三角形是钝角三角形");
				return 2;
			}else if( a * a + c * c == b * b){
				System.out.println("这个三角形是直角三角形");
				return 1;
			}else{
				System.out.println("这个三角形是锐角三角形");
				return 0;
			}
		}else{
			if( a * a + b * b < c * c){
				System.out.println("这个三角形是钝角三角形");
				return 2;
			}else if( a * a + b * b == c * c){
				System.out.println("这个三角形是直角三角形");
				return 1;
			}else{
				System.out.println("这个三角形是锐角三角形");
				return 0;
			}
		}		
	}	
}
