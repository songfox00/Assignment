import java.util.*;

public class VectorRainfall {
	public static void main(String[] args) {
		Vector<Integer>v=new Vector<Integer>();
		Scanner sc= new Scanner(System.in);
		
		int sum=0;
		while(true) {
			System.out.print("������ �Է�(0 �Է½� ����)>>");
			int n=sc.nextInt();	//������ �Է�
			if(n==0)	//�������� 0�̸� ����
				break;
			v.add(n);	//���Ϳ� �߰�
			sum+=n;	//��� �� ���� ��
			
			for(int i=0;i<v.size();i++) {
				System.out.print(v.get(i)+" ");	//���Ϳ� �ִ� �� ��� ���
			}
			System.out.print("\n");
			int avg=sum/v.size();	//���
			System.out.println("���� ��� "+avg);
		}
		sc.close();
	}
}
