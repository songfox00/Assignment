import java.util.Scanner;

public class Lab1_10 {
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		System.out.print("원의 중심 x1, y1, 반지름 radius1 >> ");//질문 출력
		int x1=scan.nextInt();	//x1 입력받아 저장
		int y1=scan.nextInt();	//y1 입력받아 저장
		int radius1=scan.nextInt();	//radius1 입력받아 저장
		
		System.out.print("원의 중심 x2, y2, 반지름 radius2 >> ");//질문 출력
		int x2=scan.nextInt();	//x2 입력받아 저장
		int y2=scan.nextInt();	//y2 입력받아 저장
		int radius2=scan.nextInt();	//radius2 입력받아 저장
		
		double distance=Math.sqrt(Math.pow((x2-x1), 2)+Math.pow((y2-y1), 2));	//두 원의 중심점끼리의 거리 저장
		if(distance<radius1+radius2)	//distance가 두 원의 반지름의 합보다 작으면 겹친다 출력
			System.out.println("두 원은 서로 겹친다.");
		else	//distance가 두 원의 반지름의 합보다 크면 겹치지 않는다 출력
			System.out.println("두 원은 서로 겹치지 않는다.");
	}
}
