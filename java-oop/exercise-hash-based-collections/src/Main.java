import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static <T> void main(String[] args) {
        Map<Integer,String> monthMap = new HashMap<>();

        // add k/v pairs to hash map
        monthMap.put(1,"January");
        monthMap.put(2,"February");
        monthMap.put(3,"March");
        monthMap.put(4,"April");
        monthMap.put(5,"May");
        monthMap.put(6,"June");
        monthMap.put(7,"July");
        monthMap.put(8,"August");
        monthMap.put(9,"September");
        monthMap.put(10,"October");
        monthMap.put(11,"November");
        monthMap.put(12,"December");

        // use a loop to print keys and values
        for (int count : monthMap.keySet()) {
            System.out.println(count + ": " + monthMap.getOrDefault(count,""));
        }

        // deck of cards
        Map<String, List<String>> deckOfCards = new HashMap<>();
        List<String> suits = new ArrayList<>();
        List<String> cardType = new ArrayList<>();

        // populate suits list for loop
        suits.add("Hearts");
        suits.add("Diamonds");
        suits.add("Clubs");
        suits.add("Spades");

        String stringHolder; // generically named to populate type list
        for (int i = 1; i < 14; i++) {
            if (i == 1) {
                stringHolder = "Ace";
            } else if (i == 11) {
                stringHolder = "Jack";
            } else if (i == 12) {
                stringHolder = "Queen";
            } else if (i == 13) {
                stringHolder = "King";
            } else {
                stringHolder = String.valueOf(i);
            }

            cardType.add(stringHolder);

            for (String suit : suits) {
            deckOfCards.put(suit, cardType);
            }

        }

        for (Map.Entry<String, List<String>> entry : deckOfCards.entrySet()) {
            String suit = entry.getKey();
            List<String> cards = entry.getValue();

            for (String card : cards) {
                System.out.println(card + " of " + suit);
            }
        }
    }
}
