
public class Movie {
	private String title;	//����
	private String name;	//����
	private String genre;	//�帣
	private int year;	//�⵵
	
	public Movie(String title, String name, String genre,int year) {	//������
		this.title=title;
		this.name=name;
		this.genre=genre;
		this.year=year;
	}
	
	public String getTitle() {	//�����ڿ� ������
		return title;
	}
	public String getName() {
		return name;
	}
	public String getGenre() {
		return genre;
	}
	public int getYear() {
		return year;
	}
	public void setTitle(String t) {
		title=t;
	}
	public void setName(String n) {
		name=n;
	}
	public void setGenre(String g) {
		genre=g;
	}
	public void setYear(int y) {
		year=y;
	}
}
