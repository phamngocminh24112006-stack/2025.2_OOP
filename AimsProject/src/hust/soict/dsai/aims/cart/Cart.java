package hust.soict.dsai.aims.cart;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

import java.util.Collections;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media>  itemsOrdered = new ArrayList<Media>();
	public ArrayList<Media> getItemsOrdered() {
	    return itemsOrdered;
	}
	public void addMedia(Media media) {
	    if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
	       itemsOrdered.add(media);
	       System.out.println("The media has been added.");
	    } else {
	       System.out.println("The cart is full.");
	    }
	}

	public void removeMedia(Media media) {
	    if (itemsOrdered.remove(media)) {
	       System.out.println("The media has been removed.");
	    } else {
	       System.out.println("Media not found.");
	    }
	}

	public float totalCost() {
		float total = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			total += itemsOrdered.get(i).getCost();
		}
		return total;
		
	}
	
	public void print() {
	    System.out.println("***********************CART***********************");
	    System.out.println("Ordered Items:");

	    float totalCost = 0;

	    for (int i = 0; i < itemsOrdered.size(); i++) {
	        System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
	        totalCost += itemsOrdered.get(i).getCost();
	    }

	    System.out.println("Total cost: " + totalCost);
	    System.out.println("***************************************************");
	}
	public void searchById(int id) {
	    for (int i = 0; i < itemsOrdered.size(); i++) {
	        if (itemsOrdered.get(i).getId() == id) {
	            System.out.println(itemsOrdered);
	            return;
	        }
	    }
	    System.out.println("No matching DVD found.");
	}
	
	public void searchByTitle(String title) {
	    boolean found = false;

	    for (int i = 0; i < itemsOrdered.size(); i++) {
	        if (itemsOrdered.get(i).isMatch(title)) {
	            System.out.println(itemsOrdered.get(i));
	            found = true;
	        }
	    }

	    if (!found) {
	        System.out.println("No matching DVD found.");
	    }
	}
	
	public void sortByTitle() {
	    Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}

	public void sortByCost() {
	    Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}
}
