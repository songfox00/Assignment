
public class Rectangle {
	public int x,y,width,height;	//int 타입의 x,y,width,height 필드: 사각형을 구성하는 점과 크기 정보
	
	public Rectangle(int a,int b, int c, int d) {	//x,y,width,height 값을 매개 변수로 받아 필드를 초기화하는 생성자
		x=a;
		y=b;
		width=c;
		height=d;
	}
	
	public int square() { //사각형 넓이 리턴
		return width*height;
	}
	
	public void show() {	//사각형의 좌표와 넓이를 화면에 출력
		System.out.println("("+x+","+y+")에서 크기가 "+width+"x"+height+"인 사각형");
	}
	
	public boolean contains(Rectangle r) {	//매개 변수로 받은 r이 현 사각형 안에 있으면 true 리턴
		if(r.x>x && r.y>y && width*height>r.square())
			return true;
		return false;
	}
	
	public static void main(String args[]) {
		Rectangle r=new Rectangle(2,2,8,7);	//객체 생성
		Rectangle s=new Rectangle(5,5,6,6);
		Rectangle t=new Rectangle(1,1,10,10);
		
		r.show();
		System.out.println("s의 면적은"+s.square());	//결과 출력
		if(t.contains(r)) System.out.println("t는 r을 포함합니다.");
		if(t.contains(s)) System.out.println("t는 s를 포함합니다.");
	}
}
