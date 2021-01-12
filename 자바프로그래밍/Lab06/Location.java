
public class Location {
	private String name;	//도시
	private double lon;	//경도
	private double lat;	//위도
	
	public Location(String name, double lon, double lat) {	//생성자
		this.name=name;	
		this.lon=lon;
		this.lat=lat;
	}
	
	public String GetterName() {	//접근자 설정자
		return name;
	}
	public void SetterName(String n){
		name=n;
	}
	public Double GetterLon() {
		return lon;
	}
	public void SetterLon(Double a) {
		lon=a;
	}
	public Double GetterLat() {
		return lat;
	}
	public void SetterLat(Double b) {
		lat=b;
	}
}
