import java.util.Scanner;

public class Lab1_4 {
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		
		System.out.print("정수 3개 입력>>");	//질문 출력
		int first=scan.nextInt();	//첫번째 숫자 저장
		int second=scan.nextInt();	//두번째 숫자 저장
		int third=scan.nextInt();	//세번째 숫자 저장
		int mid;	//중간값
		if(first>second) {	
			if(second>third) {	//first>second>third
				mid=second;
			}
			else {			
				if(first>third)	//first>third>second
					mid=third;
				else
					mid=first;	//third>first>second
			}
		}
		else {	//second>first
			if(first>third)	//second>first>third
				mid=first;
			else {
				if(second>third)	//second>third>first
					mid=third;
				else	//first>second>third
					mid=second;
			}	
		}
		System.out.println("중간 값은 "+mid);	//중간값 출력
	}
}
