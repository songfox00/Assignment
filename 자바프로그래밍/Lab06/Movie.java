
public class Movie {
	private String title;	//제목
	private String name;	//감독
	private String genre;	//장르
	private int year;	//년도
	
	public Movie(String title, String name, String genre,int year) {	//생성자
		this.title=title;
		this.name=name;
		this.genre=genre;
		this.year=year;
	}
	
	public String getTitle() {	//접근자와 설정자
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
