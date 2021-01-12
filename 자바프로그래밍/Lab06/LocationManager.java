import java.util.*;

public class LocationManager {
	public static void main(String[] args) {
		HashMap<String, Location>h=new HashMap<String, Location>();
		Scanner sc=new Scanner(System.in);
	
		System.out.println("����,�浵,������ �Է��ϼ���.");
		for(int i=0;i<4;i++) {
			System.out.print(">> ");
			String s=sc.nextLine();	//����, ����, �浵 �Է¹���
			StringTokenizer st=new StringTokenizer(s,",");	//,�� �������� ����
			String name=st.nextToken().trim();	//���� ����
			double lon=Double.parseDouble(st.nextToken().trim());
			double lat=Double.parseDouble(st.nextToken().trim());
			
			Location l=new Location(name, lon, lat);	//Location ��ü ����
			h.put(name, l);	//�ؽøʿ� ����
		}
		
		Set<String> key=h.keySet();	
		Iterator<String>it=key.iterator();
		System.out.println("----------------------");
		while(it.hasNext()) {
			String name=it.next();	//���� �̸�
			Location l=h.get(name);	//���� �̸��� Ű���ؼ� �ؽøʿ��� Location ��ü ����
			
			System.out.print(l.GetterName()+"\t");
			System.out.print(l.GetterLon()+"\t");
			System.out.println(l.GetterLat()+"\t");
		}
		System.out.println("----------------------");
		
		while(true) {
			System.out.print("���� �̸�>> ");
			String name=sc.next();	//���� �̸�
			if(name.equals("�׸�"))
				break;
			
			Location l=h.get(name);	//�ؽøʿ��� ���� �̸����� �˻�
			if(l==null) {	//�ؽøʿ� ���ð� ������
				System.out.println(name+"�� �����ϴ�.");
				continue;
			}
			System.out.print(l.GetterName()+"\t");
			System.out.print(l.GetterLon()+"\t");
			System.out.println(l.GetterLat()+"\t");
		}
		sc.close();
}
}
