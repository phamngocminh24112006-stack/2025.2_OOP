package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
	public static final Comparator<Media> COMPARE_BY_TITLE_COST =
	        new MediaComparatorByTitleCost();

	public static final Comparator<Media> COMPARE_BY_COST_TITLE =
	        new MediaComparatorByCostTitle();

	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	public Media() {
		super();
	}
	public Media(String title) {
        this.title = title;
    }
    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public boolean isMatch(String title) {
        return this.title.equalsIgnoreCase(title);
    }
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Media)) {
			return false;
		}
		Media other = (Media) obj;
		return this.title.equals(other.title);
	}
	@Override
	public String toString() {
	    return getTitle() + " - "
	            + getCategory() + " - "
	            + getCost() + " $";
	}
}
