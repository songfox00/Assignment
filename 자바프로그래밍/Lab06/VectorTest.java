import java.util.*;

public class VectorTest {
	public static void main(String[] args) {
		Vector<Integer>v = new Vector<Integer>();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수(-1이 입력될 때까지)>>");
		while(true) {
			int n= sc.nextInt();
			if(n==-1)	//-1이 입력되면 while문 벗어남
				break;
			v.add(n);	//-1이 아니라면 벡터에 추가
		}
		System.out.println("삭제 전:"+v);
		int max=v.get(0);	//벡터의 첫번째 숫자
		int idx=0;	//가장 큰 수의 인덱스
		for(int i=1;i<v.size();i++) {
			if(max<v.get(i)) {	//가장 큰 수를 max에 저장
				max=v.get(i);
				idx=i;
			}
		}
		System.out.println("가장 큰 수 "+max+"삭제");
		v.remove(idx);	//max 삭제
		System.out.println("삭제 후:"+v);
		
		int min=v.get(0);	
		for(int i=1;i<v.size();i++) {
			if(min>v.get(i)) {	//가장 작은 수를 min에 저장
				min=v.get(i);
				idx=i;
			}
		}
		System.out.println("가장 작은 수 "+min+"삭제");
		v.remove(idx);	//min 삭제
		System.out.println("삭제 후:"+v);
		
		sc.close();
	}
}
