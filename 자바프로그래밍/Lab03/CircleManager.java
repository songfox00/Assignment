import java.util.Scanner;

class Circle{
	private double x,y;
	private int radius;
	public Circle(double x, double y, int radius) {	//x,y,radius 초기화
		this.x=x;
		this.y=y;
		this.radius=radius;
	}
	public void show() {	//화면에 출력
		System.out.println("("+x+","+y+")"+radius);
	}
	public double getArea() {	//PI 값은 Math클래스의 PI 상수 활용
		return Math.PI*radius*radius;	//면적 계산하여 반환
	}
}

public class CircleManager {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		Circle c[]=new Circle[3];	//c 객체 배열 선언
		for(int i=0;i<3;i++) {
			System.out.print("x, y, radius>>");
			double x=scan.nextDouble();		//값 읽기
			double y=scan.nextDouble();
			int radius=scan.nextInt();
			c[i]=new Circle(x,y,radius);	//객체 생성
		}
		for(int i=0;i<c.length;i++)
			c[i].show();		//모든 Circle 객체 출력(해당 메소드 출력)
		int biggestIndex=0;	//가장 큰 면적을 가진 index
		for(int i=1;i<3;i++) {
			if(c[i].getArea()>c[i-1].getArea())	//면적 함수를 통해 비교
				biggestIndex=i;	//가장 큰 면적을 가진 index를 저장
		}
		System.out.print("가장 면적이 큰 원은 ");
		c[biggestIndex].show();	//가장 큰 면적 가진 원의 정보 출력
		scan.close();
	}
}
