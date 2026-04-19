public class DigitalVideoDisc {
	private static int nbDigitalVideoDiscs = 0;
	private int id;
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	public void setTitle (String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public int getId() {
		return id;
	}
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
	public DigitalVideoDisc (String category, String title, float cost) {
		this.category= category;
		this.title = title;
		this.cost = cost;
	}
	public DigitalVideoDisc (String director, String category, String title, float cost) {
		this.director = director;
		this.category = category;
		this.title = title;
		this.cost = cost;
	}
	public DigitalVideoDisc (String title, String category, String director, int length, float cost) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		
		nbDigitalVideoDiscs ++;
		this.id = nbDigitalVideoDiscs;
	}

	
	public boolean isMatch (String title) {
		return this.title.toLowerCase().contains(title.toLowerCase());
	}
	
	@Override
	public String toString() {
		return "DVD - " + title + " - " + category + " - "
				+ director + " - " + length +": " + cost + " $";
	}
	
}
