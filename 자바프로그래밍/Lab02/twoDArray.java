
public class twoDArray {
	public static void main(String[] args) {
		int arr[][]=new int[4][4];	//4X4 2차원 배열 생성
		
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++)
				arr[i][j]=0;	//배열의 모든 원소를 0으로 초기화
		int cnt=0;	//생성한 숫자 개수
				
		while(cnt<10) {
			int r=(int)(Math.random()*10+1);	//랜덤 정수 생성
			int cidx=(int)(Math.random()*4);	//배열이 행 인덱스 랜덤 생성
			int ridx=(int)(Math.random()*4);	//배열의 열 인덱스 랜덤 생성
			
			if(arr[cidx][ridx]!=0) {	//배열 원소가 0이 아니면 건너뜀
				continue;
			}
			else {			//0이면 랜덤 숫자 저장
				arr[cidx][ridx]=r;
				cnt++;	//생성된 숫자 갯수 증가
			}
		}
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				System.out.print(arr[i][j]+"\t");	//2차원 배열 출력
			}
			System.out.print("\n");	//행 바꿈
		}
	}
}
