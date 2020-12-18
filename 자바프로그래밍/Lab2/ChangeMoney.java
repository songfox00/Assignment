import java.util.Scanner;

public class ChangeMoney {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);	//Scanner 객체 생성
		int unit[]= {50000, 10000, 1000,500,100,50,10,1};	//환산할 돈의 종류
		
		System.out.print("금액을 입력하시오>> ");	//입력 받기 위한 출력문
		int money=scan.nextInt();	//입력값 저장
		
		for(int i=0;i<unit.length;i++) {	//unit 배열 크기 만큼 반복
			int result=0;	//개수 출력할 변수
			
			result=money/unit[i];	//	'/'을 이용하여 개수 알아냄 
			if(result==0)	// 개수가 0이면 출력하지 않고 넘어감
				continue;
			
			System.out.println(unit[i]+"원 짜리 : "+result+"개");	//결과 출력
			money%=unit[i];		// '%'을 이용하여 나머지를 가지고 다시 진행
		}
		scan.close();	//Scanner 종료
	}
}
