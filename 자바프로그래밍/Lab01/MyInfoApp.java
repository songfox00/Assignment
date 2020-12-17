import java.util.Scanner;

public class MyInfoApp {
	public static void main(String args[]) {
		System.out.println("이름, 학과, 학번을 입력해주세요.");	//질문 출력
		Scanner scan = new Scanner(System.in);
		
		String name=scan.next();	//이름 입력받아 저장
		String major=scan.next();	//학과 입력받아 저장
		int num=scan.nextInt();		//학번 입력받아 저장
		
		System.out.println("이름: "+name);	//이름 출력
		System.out.println("학과: "+major);	//학과 출력
		System.out.println("학번: "+num);		//학번 출력
	}
}
