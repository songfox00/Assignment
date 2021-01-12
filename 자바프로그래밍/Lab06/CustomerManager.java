import java.util.*;

public class CustomerManager {
	public static void main(String[] args) {
		HashMap<String, Integer>h=new HashMap<String, Integer>();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("** 포인트 관리 프로그램입니다 **");
		while(true) {
			System.out.print("이름과 포인트 입력>> ");
			String name=sc.next();	//이름 저장
			if(name.equals("그만"))	//'그만' 입력하면 종료
				break;
			int point=sc.nextInt();	//포인트 저장
			
			Integer p=h.get(name);	//이름으로 포인트 검색
			if(p!=null)	//포인트가 있다면
				point+=p;
			
			h.put(name, point);	//이름과 누적 포인트 해시맵에 저장
			
			Set<String> key=h.keySet();	
			Iterator<String>it=key.iterator();
			while(it.hasNext()) {
				String cus=it.next();	//고객 이름
				int sco=h.get(cus);	//이름으로 해시맵에서 포인트 찾아서 저장
				System.out.print("("+cus+","+sco+")");
			}
			System.out.println();
		}
		sc.close();
	}
}
