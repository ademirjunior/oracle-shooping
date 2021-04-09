package labs.pm.data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public abstract class Product implements Rateable<Product>{

	public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
	private int id;
	private String name;
	private BigDecimal price;
	private Rating rating;
	
	Product (int id, String name, BigDecimal price, Rating rating) {
		this.id = id;
		this.name =name;
		this.price = price;
		this.rating = rating;
	}
	
	Product (int id, String name, BigDecimal price) {
		this(id, name, price, Rating.NOT_RATED);
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public BigDecimal getPrice() {
		return price;
	}

	public BigDecimal getDiscount() {
		return price.multiply(DISCOUNT_RATE).setScale(2, RoundingMode.HALF_UP);
	}
	
	public Rating getRating() {
		return rating;
	}
	
	public LocalDate getBestBefore() {
		return LocalDate.now();
	}
	
	//public abstract Product applyingRating (Rating newRating);

	@Override
	public String toString() {
		return id + ", " + name + ", " + price + ", " + getDiscount() + ", "+ rating.getStars() + ", " + getBestBefore();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
