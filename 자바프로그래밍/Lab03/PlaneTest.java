class Plane{
	private String com;	//멤버 변수(필드) 선언
	private String model;	
	private int num;
	static int planes=0;
	
	public Plane() {	//생성자 작성: 2~3개 중복 정의
		this.com="";
		this.model="";
		this.num=0;
		planes++;
	}
	public Plane(String c, String n, int i) {
		this.com=c;
		this.model=n;
		this.num=i;
		planes++;
	}
	public Plane(String c) {
		this.com=c;
		this.model="";
		this.num=0;
		planes++;
	}
	
	public String getCom() {	//멤버 변수를 접근할 수 있는 접근자와 설정자 메소드 작성
		return com;
	}
	public String getmodel() {	
		return model;
	}
	public int getnum() {
		return num;
	}
	public void setCom(String c) {
		com=c;
	}
	public void setmodel(String p) {
		model=p;
	}
	public void setnum(int i) {
		num=i;
	}
	
	
	public static int getPlanes() {	//정적 변수 접근할 수 있는 접근자 메소드
		return planes;
	}
	
	public String toString() {	//객체의 정보를 문자열로 반환하는 toString 메소드
		return "Plane [model="+com+" "+model+", seats="+num+"]";
	}
}
public class PlaneTest {
	public static void main(String[] args) {
		Plane plane1=new Plane("보잉", "777",200);	//Plane 객체 여러개 생성
		Plane plane2=new Plane();
		
		plane2.setCom("에어비스");	//접근자 메소드와 설정자 메소드를 호출
		plane2.setmodel("- A380");
		plane2.setnum(500);
		
		Plane plane3=new Plane("보잉", "737", 120);
		
		System.out.println("전체 보유 비행기 수 = "+Plane.getPlanes());	//전체 보유 비행기 수 출력
		System.out.println("각 비행기 정보 출력");	//비행기 정보 출력
		System.out.println(plane1.toString());
		System.out.println(plane2.toString());
		System.out.println(plane3.toString());
		
	}
}
