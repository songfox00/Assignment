import java.util.*;

public class CustomerManager {
	public static void main(String[] args) {
		HashMap<String, Integer>h=new HashMap<String, Integer>();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("** ����Ʈ ���� ���α׷��Դϴ� **");
		while(true) {
			System.out.print("�̸��� ����Ʈ �Է�>> ");
			String name=sc.next();	//�̸� ����
			if(name.equals("�׸�"))	//'�׸�' �Է��ϸ� ����
				break;
			int point=sc.nextInt();	//����Ʈ ����
			
			Integer p=h.get(name);	//�̸����� ����Ʈ �˻�
			if(p!=null)	//����Ʈ�� �ִٸ�
				point+=p;
			
			h.put(name, point);	//�̸��� ���� ����Ʈ �ؽøʿ� ����
			
			Set<String> key=h.keySet();	
			Iterator<String>it=key.iterator();
			while(it.hasNext()) {
				String cus=it.next();	//�� �̸�
				int sco=h.get(cus);	//�̸����� �ؽøʿ��� ����Ʈ ã�Ƽ� ����
				System.out.print("("+cus+","+sco+")");
			}
			System.out.println();
		}
		sc.close();
	}
}
