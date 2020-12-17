import java.util.Scanner;

public class Lab1_8 {
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		System.out.print("x1, y1 입력>>");//질문 출력
		int x1=scan.nextInt();	//x1 입력받아 저장
		int y1=scan.nextInt();	//y1 입력받아 저장
		
		System.out.print("x2, y2 입력>>");//질문출력
		int x2=scan.nextInt();	//x2 입력받아 저장
		int y2=scan.nextInt();	//y2 입력받아 저장
		
		if(x1>200)	//x1이 200을 넘을 때
			System.out.println("충돌 없음"); //충돌 없음 출력
		else if(y1>200)	//y1이 200을 넘을 때
			System.out.println("충돌 없음");	//충돌 없음 출력
		else if(x2>=100&&y2>=100)	//x1, y1이 200을 넘지 않고 x2와 y2가 100보다 크거나 같을 때
			System.out.println("충돌 발생");	//충돌 발생 출력
		else //x2, y2가 100을 넘지 않을 때
			System.out.println("충돌 없음");	//충돌 없음 출력
	}
}
