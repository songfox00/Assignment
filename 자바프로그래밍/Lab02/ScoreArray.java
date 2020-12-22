import java.util.Scanner;

public class ScoreArray {
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);	//스캐너 객체 생성
		
		String course[]= {"Java", "C++", "HTML5","컴퓨터구조", "안드로이드"};	//과목 종류
		int score[]= {95,88,76,62,55};	//과목당 점수
		
		while(true) {		//name에 "그만"이 입력될때까지
		System.out.print("과목 이름>>");	//과목명을 받기 위한 출력문
		String name=scan.next();		//과목이름
		
		if("그만".equals(name))		//name에 "그만"이 입력되면 while문을 나감
			break;
		
		int flag=0;				//과목이 있는지 판별
		for(int i=0;i<5;i++) {	//과목 개수 만큼 반복
			if(course[i].equals(name)) {	//사용자가 입력한 과목명이 있는 과목인지 판별
				System.out.println(course[i]+"의 점수는 "+score[i]); //입력받은 과목명과 점수 출력
				flag=1;		//과목이 있으면 1
				break;
			}
		}
		if(flag==0)			//flag==0d이면 과목이 없다는 것
			System.out.println("없는 과목입니다.");	//과목 없음 출력
		}
		scan.close();	//Scanner 종료
	}
}
