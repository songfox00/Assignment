import java.util.Scanner;

public class GBBWithComputer {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);	//Scanner 객체 생성
		
		String str[]= {"가위","바위","보"};		
		System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");	//게임 시작 출력
		
		while (true) {
		System.out.print("가위 바위 보!>>");		//사용자로부터 입력받기 위한 출력문
		String user=scan.next();	//사용자의 선택 저장
		
		if("그만".equals(user)) {		//그만을 입력하면 반복문을 끝냄
			System.out.println("게임을 종료합니다...");	//게임 종료 출력
			break;
		}
		
		int flag=0;		//사용자가 이겼는지 판단하는 변수
		int n=(int)(Math.random()*3);	//0,1,2 중에서 랜덤하게 결정
		if(str[n].equals(user)) {	//사용자와 컴퓨터가 낸 것이 같으면
			System.out.println("사용자 = "+user+", 컴퓨터 = "+str[n]+", 비겼습니다.");	//결과 출력
			continue;
		}
		
		if(str[n].equals("바위")) {	//컴퓨터가 바위, 사용자가 보를 낼 경우
			if("보".equals(user))
				flag=1;		//flag=1이면 사용자가 이긴 것
			}
		else if(str[n].equals("가위")) {	//컴퓨터가 가위, 사용자가 주먹을 낼 경우
			if("주먹".equals(user))
				flag=1;		//사용자 이김
		}
		else {		//컴퓨터가 보, 사용자가 가위를 낼 경우
			if("가위".equals(user))
				flag=1;		//사용자 이김
		}
		
		if(flag==1)	//사용자가 이긴 경우
			System.out.println("사용자 = "+user+", 컴퓨터 = "+str[n]+", 사용자가 이겼습니다.");	//결과 출력
		else	//컴퓨터가 이긴 경우 그대로 flag=0이므로
			System.out.println("사용자 = "+user+", 컴퓨터 = "+str[n]+", 컴퓨터가 이겼습니다.");	//결과 출력
		}
		scan.close(); 	//Scanner 종료
	}
}
