package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {

	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	public CompactDisc() {
		super();
	}
	public CompactDisc (String title) {
		super(title);
	}
	public CompactDisc (String title, String category, String director, int length, float cost, String artist) {
		super (title, category, director, length, cost);
		this.artist = artist;
	}
	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track track) {
		if (tracks.contains(track)) {
			System.out.println ("The track already exists");
		}
		else {
			tracks.add(track);
			System.out.println ("The track has been added");
		}
	}
	public void removeTrack (Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
			System.out.println ("The track has been removed");
		}
		else {
			System.out.println ("The track does not exist");
		}
	}
	@Override
	public int getLength() {
		int totalLength = 0;
		for (Track track: tracks) {
			totalLength += track.getLength();
		}
		return totalLength;
	}
	@Override
	public void play() {
		System.out.println("Playing CD: " + getTitle());
        System.out.println("CD length: " + getLength());

        for (Track track : tracks) {
            track.play();
        }
		
	}
	@Override
	public String toString() {
	    return "CD - "
	            + getTitle() + " - "
	            + getCategory() + " - "
	            + getArtist() + " - "
	            + getLength() + " min: "
	            + getCost() + " $";
	}
}
