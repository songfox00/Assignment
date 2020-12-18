import java.util.Scanner;

public class RandomArray {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);	//Scanner 객체 생성
		
		System.out.print("정수 몇개? ");	//입력받기 위한 출력문
		int n=scan.nextInt();	//입력값 저장
		int arr[]=new int[n];	//입력값 크기 만큼 정수 배열 생성
		
		
		for(int i=0;i<arr.length;i++) {	//배열 크기만큼 반복
			int k=(int)(Math.random()*100+1);	//1~100 범위의 랜덤 정수 k 생성
			if(i==0) {
				arr[i]=k;
				continue;
			}
			for(int j=0;j<i;j++) {	//정수 k가 배열 0~i-1에 있는지 검사
				if(arr[j]==k) {
					i--;
					break;
				}
				else
					arr[i]=k;
			}
		}
		
		int cnt=0;	//출력한 개수 세는 변수
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");	//배열 출력
			cnt++;
			if(cnt==10) {	//10개를 출력했으면
				System.out.print("\n");	//행 바꿈
				cnt=0;	
			}
		}	
		scan.close();	//Scanner 종료
	}
}
