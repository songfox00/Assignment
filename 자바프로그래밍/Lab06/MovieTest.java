import java.util.*;

public class MovieTest {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		HashMap<String, Movie>h=new HashMap<String, Movie>();
		
		while(true) {
		System.out.println("==========��ȭ ���� ����==========");
		System.out.println("1. �Է�/2. ���/3. �˻�/4. ����/5. ����/6. ����");
		System.out.print("�޴��Է�>> ");
		int n=sc.nextInt();	//�޴�
		sc.nextLine();	//nextLine() ���� ������ �ʱ� ���ؼ�
		if(n==6)	//6�̸� ����
			break;
		
		if(n==1) {	//1. �Է�
			System.out.print("����:");	//����, ����, �帣, �⵵ �Է� ����
			String title=sc.nextLine();
			System.out.print("����:");
			String name=sc.nextLine();
			System.out.print("�帣:");
			String genre=sc.nextLine();
			System.out.print("�⵵:");
			int year=sc.nextInt();
			
			Movie movie= new Movie(title, name, genre, year);	
			h.put(title, movie);	//�ؽøʿ� ����
		}
		
		if(n==2) {	//2. ���
			Set<String>key=h.keySet();
			Iterator<String> it=key.iterator();
			while(it.hasNext()) {
				String title=it.next();	//����
				Movie m=h.get(title);	//������ Ű�� Movie ��ü ���
				
				System.out.println("[����:"+m.getTitle()+", ����:"+m.getName()+", �帣:"+m.getGenre()+", �����⵵:"+m.getYear()+"]");
			}
		}
		
		if(n==3) {//3. �˻�
			System.out.print("�˻��� ���� �Է�: ");
			String title=sc.nextLine();	//����
			
			Movie m=h.get(title);//������ Ű�� Movie ��ü ���
			System.out.println("[����:"+m.getTitle()+", ����:"+m.getName()+", �帣:"+m.getGenre()+", �����⵵:"+m.getYear()+"]");
		}
		
		if(n==4) {//4. ����
			System.out.print("������ ���� �Է�: ");
			String t=sc.nextLine();
			
			Movie m=h.get(t);	
			System.out.println("[����:"+m.getTitle()+", ����:"+m.getName()+", �帣:"+m.getGenre()+", �����⵵:"+m.getYear()+"]");
			
			System.out.print("����:");	//���� ���� �Է�
			String title=sc.nextLine();
			System.out.print("����:");
			String name=sc.nextLine();
			System.out.print("�帣:");
			String genre=sc.nextLine();
			System.out.print("�⵵:");
			int year=sc.nextInt();
			
			
			Movie movie= new Movie(title, name, genre, year);	//�ٽ� ��ü ����
			h.put(title, movie);	//�ؽøʿ� ���� ����
		}
		if(n==5) {	//5. ����
			System.out.print("������ ���� �Է�: ");
			String title=sc.nextLine();
			h.remove(title);	//title�� Ű�� ��� ����
		}
		}
		sc.close();
	}
}
