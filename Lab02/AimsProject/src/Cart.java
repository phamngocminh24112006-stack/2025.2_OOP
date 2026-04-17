public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc [MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	public void addDigitalVideoDisc (DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED)
		{
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered ++;
			System.out.println("The disc has been added");
		}
		else {
			System.out.println("The cart is almost full");
		}
	}
	public void addDigitalVideoDisc (DigitalVideoDisc []dvdList) {
		for (int i = 0; i< dvdList.length;i++)
		{
			if (qtyOrdered < MAX_NUMBERS_ORDERED) {
				itemsOrdered[qtyOrdered] = dvdList[i];
				qtyOrdered ++;
			}
			else {
				System.out.println("The cart is almost full");
				break;
			}
		}
		
	}
	public void addDigitalVideoDisc (DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
	        itemsOrdered[qtyOrdered] = dvd1;
	        qtyOrdered++;
	    } else {
	        System.out.println("The cart is almost full");
	        return;
	    }

	    if (qtyOrdered < MAX_NUMBERS_ORDERED) {
	        itemsOrdered[qtyOrdered] = dvd2;
	        qtyOrdered++;
	    } else {
	        System.out.println("The cart is almost full");
	    }
	}
	public void removeDigitalVideoDisc (DigitalVideoDisc disc) {
		boolean found = false;
		for (int i = 0; i<qtyOrdered; i++)
		{
			if (itemsOrdered[i] == disc) {
				found = true;
				for (int j = i; j < qtyOrdered; j++) {
					itemsOrdered[j] = itemsOrdered[j+1];
				}
				itemsOrdered[qtyOrdered - 1] = null;
				qtyOrdered --;
				System.out.println ("The disc has been removed");
				break;
			}
		}
		if (found == false) {
			System.out.println ("The disc was not found");
		}
	}
	public float totalCost() {
		float total = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			total += itemsOrdered[i].getCost();
		}
		return total;
		
	}
}
