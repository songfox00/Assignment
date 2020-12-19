import java.util.Scanner;

class Phone{
	public String name;
	public String num;
	
	public Phone(String a, String b){	//name, num 초기화
		name=a;
		num=b;
	}
	
}

public class PhoneBook {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		System.out.print("인원수>>");
		int n=scan.nextInt();	//인원수 입력
		Phone c[]=new Phone[n];		//c 객체 배열 생성
		
		for(int i=0;i<n;i++) {
			System.out.print("이름과 전화번호(이름과 번호는 빈 칸없이 입력)>>");
			String name=scan.next();	//값읽기
			String num=scan.next();
			c[i]=new Phone(name, num);	//Phone 객체 생성
		}
		System.out.println("저장되었습니다...");
		
		while(true) {
			System.out.print("검색할 이름>>");
			String name=scan.next();	//검색할 이름 입력 받음
			
			if(name.equals("그만"))	//그만을 입력하면 종료
				break;
			
			int flag=0;	//이름이 있는지 확인하는 변수
			for(int i=0;i<n;i++) {
				if(name.equals(c[i].name)) {	//c[i].name과 입력받은 값이 같은지 비교
					System.out.println(name+"의 번호는 "+c[i].num+" 입니다.");
					flag=1;	//같은 것이 있다면 flag=1
					break;
				}
			}
			if(flag==0)	//저장되어 있는 사람이 아닐 때
				System.out.println(name+"의 번호는 없습니다.");
		}
		scan.close();
	}
}
