package labs.pm.app;

import java.math.BigDecimal;
import java.time.LocalDate;

import labs.pm.data.ProductManager;
import labs.pm.data.Rating;

public class Shop {

	public static void main(String[] args) {

		ProductManager pm = new ProductManager("en-GB");

		//pm.createProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
		pm.parseProduct("D,101,Tea,1.99,0,2019-09-19");
		pm.printProductReport(101);
		pm.parseReview("101,4,Nice hot cup of Tea");
//		pm.reviewProduct(101, Rating.FOUR_STARS, "Nice hot cup of tea");
//		pm.reviewProduct(101, Rating.TWO_STARS, "Rather weak tea");
//		pm.reviewProduct(101, Rating.FOUR_STARS, "Fine tea");
//		pm.reviewProduct(101, Rating.FOUR_STARS, "Good tea");
//		pm.reviewProduct(101, Rating.FIVE_STARS, "Perfect tea");
//		pm.reviewProduct(101, Rating.THREE_STARS, "Just add some lemon");
		
		pm.printProductReport(101);
		
		pm.createProduct(102, "Hamburger", BigDecimal.valueOf(1.99), Rating.NOT_RATED, LocalDate.now());
		
		//pm.printProductReport(102);
		
		pm.reviewProduct(102, Rating.FOUR_STARS, "Nice lunch");
		pm.reviewProduct(102, Rating.TWO_STARS, "Rather weak meat");
		pm.reviewProduct(102, Rating.FOUR_STARS, "Fine hamburger");
		pm.reviewProduct(102, Rating.FOUR_STARS, "Good hamburger");
		pm.reviewProduct(102, Rating.FIVE_STARS, "Perfect hamburger");
		pm.reviewProduct(102, Rating.THREE_STARS, "Just add some sausage");
		//pm.printProductReport(102);
		
		pm.createProduct(103, "Cake", BigDecimal.valueOf(3.99), Rating.NOT_RATED);
		pm.reviewProduct(103, Rating.FOUR_STARS, "Nice lunch");
		pm.reviewProduct(103, Rating.TWO_STARS, "Expected more chocolate");
		pm.reviewProduct(103, Rating.FOUR_STARS, "Fine cake");
		pm.reviewProduct(103, Rating.FOUR_STARS, "Good cake");
		pm.reviewProduct(103, Rating.FIVE_STARS, "Perfect cake");
		pm.reviewProduct(103, Rating.THREE_STARS, "Just add some sausage");
		//pm.printProductReport(103);
		//Comparator<Product> ratingSorter = (p1, p2) -> p1.getRating().ordinal() - p2.getRating().ordinal();
		//pm.printProducts(ratingSorter);
		//Comparator<Product> pricingSorter = (p1, p2) -> p2.getPrice().compareTo(p1.getPrice());
		//pm.printProducts(pricingSorter);
		pm.printProducts(p -> p.getPrice().floatValue() < 2 ,(p1, p2) -> p2.getRating().ordinal() - p1.getRating().ordinal());
		pm.getDiscount().forEach((rating, discount)-> System.out.println(rating + 't' + discount));
		//pm.printProducts((p1, p2) -> p2.getPrice().compareTo(p1.getPrice()));
		
		//pm.printProducts(pricingSorter.thenComparing(ratingSorter).reversed());
	}
}