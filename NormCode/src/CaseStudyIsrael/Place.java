package CaseStudyIsrael;

public class Place implements Comparable<Place>{
	private Room data;
	public Place(Room data) {
		this.data=data;
	}
	public void next(){
		data=data.getNext();
	}
	public Room getRoom() {
		return data;
	}
	
	public Boolean isDirty(){
		return data.isDirty();
	}
	public void setDirty(Boolean v){
		data.setDirty(v);
	}
	public String getName(){
		return data.getName();
	}
	
	@Override
	public int compareTo(Place arg0) {
		return this.getName().compareTo(arg0.getName());
	}
	
	
}
