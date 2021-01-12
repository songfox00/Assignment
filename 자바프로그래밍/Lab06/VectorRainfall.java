import java.util.*;

public class VectorRainfall {
	public static void main(String[] args) {
		Vector<Integer>v=new Vector<Integer>();
		Scanner sc= new Scanner(System.in);
		
		int sum=0;
		while(true) {
			System.out.print("강수량 입력(0 입력시 종료)>>");
			int n=sc.nextInt();	//강수량 입력
			if(n==0)	//강수량이 0이면 종료
				break;
			v.add(n);	//벡터에 추가
			sum+=n;	//모든 값 합한 것
			
			for(int i=0;i<v.size();i++) {
				System.out.print(v.get(i)+" ");	//벡터에 있는 수 모두 출력
			}
			System.out.print("\n");
			int avg=sum/v.size();	//평균
			System.out.println("현재 평균 "+avg);
		}
		sc.close();
	}
}
