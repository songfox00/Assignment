import java.io.Serializable;

class Item implements Serializable{	//Serializable 인터페이스
	protected String title;	//제목
	protected String dir;	//감독
	protected String year;	//년도
	protected int star;	
	protected String story;
	protected String review;
	protected String genre, act, age;
	protected String publish;
	protected String path;
	public String getTitle() {	//접근자와 설정자
		return title;
	}
	public String getDir() {
		return dir;
	}
	public String getAct() {
		return act;
	}
	public String getAge() {
		return age;
	}
	public String getGenre() {
		return genre;
	}
	public String getPub() {
		return publish;
	}
	public String getYear() {
		return year;
	}
	public int getStar() {
		return star;
	}
	public String getStory() {
		return story;
	}
	public String getReview() {
		return review;
	}
	public String getPath() {
		return path;
	}
	public void setTitle(String t) {
		title=t;
	}
	public void setDir(String n) {
		dir=n;
	}
	public void setYear(String y) {
		year=y;
	}
	public void setStar(int s) {
		star=s;
	}
}
