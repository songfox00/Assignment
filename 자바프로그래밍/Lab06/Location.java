
public class Location {
	private String name;	//����
	private double lon;	//�浵
	private double lat;	//����
	
	public Location(String name, double lon, double lat) {	//������
		this.name=name;	
		this.lon=lon;
		this.lat=lat;
	}
	
	public String GetterName() {	//������ ������
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
