class Dice{
	private int value;
	public Dice() {
		value=0;
	}
	void roll() {
		value= (int)(Math.random()*6+1);	//랜덤함수를 사용하여 1~6 사이의 값을 저장
	}
	int getValue() {
		return value;	//주사위 변의 값을 반환
	}
}
public class DiceTest {
	public static void main(String[] args) {
		Dice dice1=new Dice();	//주사위 2개 객체 생성
		Dice dice2=new Dice();
		int cnt=0;	//주사위 굴린 횟수
		do {
			dice1.roll();	//주사위 2개 각각 굴리는 메소드 호출
			dice2.roll();
			int a=dice1.getValue();	//주사위 값 다른 변수 저장 후 사용
			int b=dice2.getValue();
			System.out.println("주사위1="+a+" 주사위2="+b);	//실행 결과와 같이 주사위의 각 면의 값을 출력
			cnt++;	//실행 횟수 증가
			
			if(a==1 && b==1)	//주사위 각각이 1이면 반복문 빠져나감
				break;
		}while(true);
		
		System.out.println("(1,1)이 나오는데 걸린 횟수 = "+cnt);
	}
}
