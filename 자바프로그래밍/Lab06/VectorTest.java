import java.util.*;

public class VectorTest {
	public static void main(String[] args) {
		Vector<Integer>v = new Vector<Integer>();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("����(-1�� �Էµ� ������)>>");
		while(true) {
			int n= sc.nextInt();
			if(n==-1)	//-1�� �ԷµǸ� while�� ���
				break;
			v.add(n);	//-1�� �ƴ϶�� ���Ϳ� �߰�
		}
		System.out.println("���� ��:"+v);
		int max=v.get(0);	//������ ù��° ����
		int idx=0;	//���� ū ���� �ε���
		for(int i=1;i<v.size();i++) {
			if(max<v.get(i)) {	//���� ū ���� max�� ����
				max=v.get(i);
				idx=i;
			}
		}
		System.out.println("���� ū �� "+max+"����");
		v.remove(idx);	//max ����
		System.out.println("���� ��:"+v);
		
		int min=v.get(0);	
		for(int i=1;i<v.size();i++) {
			if(min>v.get(i)) {	//���� ���� ���� min�� ����
				min=v.get(i);
				idx=i;
			}
		}
		System.out.println("���� ���� �� "+min+"����");
		v.remove(idx);	//min ����
		System.out.println("���� ��:"+v);
		
		sc.close();
	}
}
