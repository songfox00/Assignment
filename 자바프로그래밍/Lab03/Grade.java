import java.util.Scanner;

public class Grade {
	public int math;	//멤버 변수 선언
	public int science;
	public int english;
	public Grade(int a, int b, int c) {	//생성자 작성(수학,과학,영어 점수를 위한 매개 변수 3개 받아서 멤버 변수에 저장)
		math=a;
		science=b;
		english=c;
	}
	public int average() {	//세 과목의 평균을 리턴하는 average() 메소드 작성
		return (math+science+english)/3;
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("수학, 과학, 영어 순으로 3개의 점수 입력>>");
		int math=scan.nextInt();	//값 입력
		int science=scan.nextInt();
		int english=scan.nextInt();
		Grade me=new Grade(math,science,english);	//me 객체 선언
		System.out.println("평균은"+me.average());	//average()는 평균을 계산하여 리턴
		scan.close();
	}
}
