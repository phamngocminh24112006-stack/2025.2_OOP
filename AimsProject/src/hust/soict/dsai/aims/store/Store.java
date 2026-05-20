package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Store {
	public static final int MAX_ITEMS_IN_STORE = 100;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	public ArrayList<Media> getItemsInStore() {
	    return itemsInStore;
	}
	
	public void print() {

	    System.out.println("***********************STORE***********************");

	    for (int i = 0; i < itemsInStore.size(); i++) {

	        System.out.println((i + 1) + ". "
	                + itemsInStore.get(i).toString());
	    }

	    System.out.println("***************************************************");
	}
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
