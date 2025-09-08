import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> sabbathAlbums = new ArrayList<>();

        // add Ozzy era albums in random order
        sabbathAlbums.add("Black Sabbath - 1970");
        sabbathAlbums.add("Masters of Reality - 1971");
        sabbathAlbums.add("Sabotage - 1975");
        sabbathAlbums.add("Paranoid - 1970");
        sabbathAlbums.add("Vol. 4 - 1972");
        sabbathAlbums.add("Sabbath Bloody Sabbath - 1973");
        sabbathAlbums.add("Technical Ecstasy - 1976");
        sabbathAlbums.add("Never Say Die! - 1978");

        // get element of current list
        System.out.println("Black Sabbath: " + sabbathAlbums.get(2));

        // determine size of current list
        System.out.println("Number of Ozzy era Black Sabbath albums: " + sabbathAlbums.size());

        // remove sub-par albums from list
        sabbathAlbums.remove(7);
        sabbathAlbums.remove(6);

        // print out new list total
        System.out.println("The number of great Ozzy Sabbath albums: " + sabbathAlbums.size());

        // use isEmpty on list
        if (!sabbathAlbums.isEmpty()){
            System.out.println("Album list contains albums.");
        } else {
            System.out.println("Album list is empty!");
        }
        //use sort method as is
        java.util.Collections.sort(sabbathAlbums); // sorts alphabetically
        System.out.println(sabbathAlbums);

        // Sort using a custom comparator
        Collections.sort(sabbathAlbums, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String date1 = s1.substring(s1.length() - 4);
                String date2 = s2.substring(s2.length() - 4);
                return Integer.compare(Integer.parseInt(date1), Integer.parseInt(date2));
            }
        });

        // Print sorted list
        System.out.println("......................................");
        System.out.println("The Essential Black Sabbath Albums in Chronological Order:");
        for (String album : sabbathAlbums) {
            System.out.println("\\m/ " + album + " \\m/");
        }
    }
}