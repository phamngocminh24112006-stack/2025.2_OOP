package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
	public static final int MAX_ITEMS_IN_STORE = 100;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	private int qtyInStore = 0;
	
	public void addMedia (Media media) {
		if (itemsInStore.size() < MAX_ITEMS_IN_STORE) {
			itemsInStore.add(media);
			System.out.println ("The media has been added to the store");
		} else {
			System.out.println ("The store is full");
		}
	}
	
	public void removeMedia (Media media) {
		if (itemsInStore.remove(media)) {
			System.out.println ("The media has been removed from the store");
		} else {
			System.out.println ("The media was not found in the store");
		}
	}
}
