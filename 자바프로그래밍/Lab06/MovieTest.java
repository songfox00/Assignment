import java.util.*;

public class MovieTest {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		HashMap<String, Movie>h=new HashMap<String, Movie>();
		
		while(true) {
		System.out.println("==========영화 정보 관리==========");
		System.out.println("1. 입력/2. 출력/3. 검색/4. 수정/5. 삭제/6. 종료");
		System.out.print("메뉴입력>> ");
		int n=sc.nextInt();	//메뉴
		sc.nextLine();	//nextLine() 오류 생기지 않기 위해서
		if(n==6)	//6이면 종료
			break;
		
		if(n==1) {	//1. 입력
			System.out.print("제목:");	//제목, 감독, 장르, 년도 입력 받음
			String title=sc.nextLine();
			System.out.print("감독:");
			String name=sc.nextLine();
			System.out.print("장르:");
			String genre=sc.nextLine();
			System.out.print("년도:");
			int year=sc.nextInt();
			
			Movie movie= new Movie(title, name, genre, year);	
			h.put(title, movie);	//해시맵에 저장
		}
		
		if(n==2) {	//2. 출력
			Set<String>key=h.keySet();
			Iterator<String> it=key.iterator();
			while(it.hasNext()) {
				String title=it.next();	//제목
				Movie m=h.get(title);	//제목을 키로 Movie 객체 사용
				
				System.out.println("[제목:"+m.getTitle()+", 감독:"+m.getName()+", 장르:"+m.getGenre()+", 개봉년도:"+m.getYear()+"]");
			}
		}
		
		if(n==3) {//3. 검색
			System.out.print("검색할 제목 입력: ");
			String title=sc.nextLine();	//제목
			
			Movie m=h.get(title);//제목을 키로 Movie 객체 사용
			System.out.println("[제목:"+m.getTitle()+", 감독:"+m.getName()+", 장르:"+m.getGenre()+", 개봉년도:"+m.getYear()+"]");
		}
		
		if(n==4) {//4. 수정
			System.out.print("수정할 제목 입력: ");
			String t=sc.nextLine();
			
			Movie m=h.get(t);	
			System.out.println("[제목:"+m.getTitle()+", 감독:"+m.getName()+", 장르:"+m.getGenre()+", 개봉년도:"+m.getYear()+"]");
			
			System.out.print("제목:");	//정보 새로 입력
			String title=sc.nextLine();
			System.out.print("감독:");
			String name=sc.nextLine();
			System.out.print("장르:");
			String genre=sc.nextLine();
			System.out.print("년도:");
			int year=sc.nextInt();
			
			
			Movie movie= new Movie(title, name, genre, year);	//다시 객체 만듬
			h.put(title, movie);	//해시맵에 정보 갱신
		}
		if(n==5) {	//5. 삭제
			System.out.print("삭제할 제목 입력: ");
			String title=sc.nextLine();
			h.remove(title);	//title이 키인 요소 삭제
		}
		}
		sc.close();
	}
}
