package hust.soict.dsai.aims.media;
public class DigitalVideoDisc extends Disc {
	private static int nbDigitalVideoDiscs = 0;

	
	private String director;
	private int length;
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public DigitalVideoDisc(String title) {
		super(title);
	}
	public DigitalVideoDisc (String category, String title, float cost) {
		super (title, category, cost);
	}
	public DigitalVideoDisc (String title, String category, String director, int length, float cost) {
		super (title, category, director, length, cost);
		
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
