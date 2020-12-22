import java.util.Vector;

class ItemCollections{
	Vector<Item>vItem = new Vector<Item>();
	
	
	public void ItemSave(Item item) {
		vItem.add(item);
	}
	public void ItemEditB(int index, Book book) {
		vItem.set(index, book);
	}
	public void ItemEditM(int index, Movie movie) {
		vItem.set(index, movie);
	}
	
	public void ItemDel(int index) {
		vItem.remove(index);
	}
	public void TitleFind(String title, Vector<String> v) {
		for(int i=0;i<vItem.size();i++) {
			String name=vItem.get(i).getTitle();
			if(name.contains(title)) {
				v.add(name);
			}
		}
	}
	public void StarFind(int star, Vector v) {
		for(int i=0;i<vItem.size();i++) {
			int st=vItem.get(i).getStar();
			if(st>=star) {
				v.add(vItem.get(i).getTitle());
			}
		}
	}
}
