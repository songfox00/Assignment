import java.util.*;

public class LocationManager {
	public static void main(String[] args) {
		HashMap<String, Location>h=new HashMap<String, Location>();
		Scanner sc=new Scanner(System.in);
	
		System.out.println("도시,경도,위도를 입력하세요.");
		for(int i=0;i<4;i++) {
			System.out.print(">> ");
			String s=sc.nextLine();	//도시, 위도, 경도 입력받음
			StringTokenizer st=new StringTokenizer(s,",");	//,를 기준으로 나눔
			String name=st.nextToken().trim();	//공백 제거
			double lon=Double.parseDouble(st.nextToken().trim());
			double lat=Double.parseDouble(st.nextToken().trim());
			
			Location l=new Location(name, lon, lat);	//Location 객체 생성
			h.put(name, l);	//해시맵에 저장
		}
		
		Set<String> key=h.keySet();	
		Iterator<String>it=key.iterator();
		System.out.println("----------------------");
		while(it.hasNext()) {
			String name=it.next();	//도시 이름
			Location l=h.get(name);	//도시 이름을 키로해서 해시맵에서 Location 객체 얻음
			
			System.out.print(l.GetterName()+"\t");
			System.out.print(l.GetterLon()+"\t");
			System.out.println(l.GetterLat()+"\t");
		}
		System.out.println("----------------------");
		
		while(true) {
			System.out.print("도시 이름>> ");
			String name=sc.next();	//도시 이름
			if(name.equals("그만"))
				break;
			
			Location l=h.get(name);	//해시맵에서 도시 이름으로 검색
			if(l==null) {	//해시맵에 도시가 없으면
				System.out.println(name+"는 없습니다.");
				continue;
			}
			System.out.print(l.GetterName()+"\t");
			System.out.print(l.GetterLon()+"\t");
			System.out.println(l.GetterLat()+"\t");
		}
		sc.close();
}
}
