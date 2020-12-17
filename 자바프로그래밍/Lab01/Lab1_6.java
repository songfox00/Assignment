import java.util.Scanner;

public class Lab1_6 {
	public static void main(String args[]) {
		System.out.print("1~99 사이의 정수를 입력하시오>>");	//질문 출력
		Scanner scan=new Scanner(System.in);
		int num=scan.nextInt();	//정수 입력받아 저장
		
		int ten=num/10;	//십의 자리
		int one=num%10;	//일의 자리
		int flap=0;	//박수 칠 횟수
		
		if(ten%3==0) {	//십의 자리가 3의 배수일 때
			flap++;		//박수 횟수 +1
		}
		if(one%3==0) {	//일의 자리가 3의 배수일 때
			flap++;		//박수 횟수 +1
		}
		
		switch(flap) {	//flap에 따라 박수 횟수 출력
		case 0:
			System.out.println("박수없음");
			break;
		case 1:
			System.out.println("박수짝");
			break;
		case 2:
			System.out.println("박수짝짝");
			break;
		}
	}
}
