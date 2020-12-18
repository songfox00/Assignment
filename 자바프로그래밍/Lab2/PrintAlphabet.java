import java.util.Scanner;

public class PrintAlphabet {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);	//Scanner 객체 생성
		
		System.out.print("소문자 알파벳 하나를 입력하시오>> ");	//입력받기 위한 질문 출력
		String s=scan.next();	//입력값 저장
		char c=s.charAt(0);	//문자열의 첫 번째 문자
		char w=c;	//w에도 저장
		
		for(char i='a';i<=c;i++) {	//'a'에서 c만큼 반복
			for(char t='a';t<=w;t++) {	//'a'에서 w만큼 반복
				System.out.print(t);	//값 출력
		}
			w--;	//출력할 문자를 하나씩 줄임
			System.out.print("\n");	//행 바꿈
		}
		scan.close();	//Scanner 종료
	}
}
