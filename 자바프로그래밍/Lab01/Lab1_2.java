import java.util.Scanner;

public class Lab1_2 {
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		System.out.print("2자리수 정수 입력(10~99)>>");	//질문 출력
		int num=scan.nextInt();	//숫자 입력받아 저장
		int ten=num/10;	//10으로 나눈 몫이 십의 자리
		int one=num%10;	//10으로 나눈 나머지가 일의자리
		if(ten==one) //십의 자리와 일의 자리가 같은지 비교후 출력
			System.out.print("Yes! 10의 자리와 1의 자리가 같습니다");
		else
			System.out.print("No! 10의 자리와 1의 자리가 다릅니다.");
	}
}
