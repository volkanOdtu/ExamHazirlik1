package collections;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class grouping2 {

	public static void main(String[] args) {
		//3 apple, 2 banana, others 1
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("10.00")),
                new Item("banana", 20, new BigDecimal("20.00")),
                new Item("orange", 10, new BigDecimal("30.00")),
                new Item("watermelon", 10, new BigDecimal("30.00")),
                new Item("papaya", 20, new BigDecimal("10.00")),
                new Item("apple", 10, new BigDecimal("10.00")),
                new Item("banana", 10, new BigDecimal("20.00")),
                new Item("apple", 20, new BigDecimal("10.00"))
                );

        //price olarak groupluyoruz
        Map<BigDecimal, List<Item>> groupByPriceMap = items.stream().collect(Collectors.groupingBy(Item::getPrice));
        
        //name olarak groupluyoruz ve count unu aliyoruz
        Map<String, Long> itemsGroupedByNameCountMap = items.stream().collect(Collectors.groupingBy(Item::getName ,Collectors.counting()));

       //name olarak groupluyoruz ve toplam buluyoruz
        Map<String, Integer> itemsGroupedByNameSumMap = items.stream().collect(Collectors.groupingBy(Item::getName ,Collectors.summingInt(Item::getQty) ));
        
        itemsGroupedByNameSumMap.entrySet().forEach(item -> System.out.println( item.getKey() + ":" + item.getValue()  ));

        
        
	}

}

 class Item {

    private String name;
    private int qty;
    private BigDecimal price;

    public Item(String name,int qty ,BigDecimal price) {
    	 this.name = name;
    	 this.qty = qty;
    	 this.price = price;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
    
    //constructors, getter/setters
}
