
public class Print2DArray {
	public static void main(String[] args) {
		int n[][]= {{1}, {1, 2, 3}, {1}, {1, 2, 3, 4}, {1, 2}};
		
		for(int i=0;i<n.length;i++) {	//배열의 행 개수 만큼 반복
			for(int j=0;j<n[i].length;j++) {	//행의 열 개수 만큼 반복
				System.out.print(n[i][j]+"\t");	//값 출력
			}
			System.out.print("\n");	//행 바꿈
		}
	}
}
