//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String firstName = "Nigel";
        String lastName = "Tufnel";
        String fullName = firstName + " " + lastName;

        System.out.println("Full name: " + fullName);
        System.out.println("Length of full name: " + fullName.length());
        System.out.println("The first character of full name: " + fullName.charAt(0));
        System.out.println("The position of letter T is: " + fullName.indexOf('T'));

        // substring exercises
        String sentence = "Learning Java is fun!";
        System.out.println("Substring from 0-8: " + sentence.substring(0,8));
        System.out.println("Substring from 9-13: " + sentence.substring(9,13));
        int indexOfFun = sentence.indexOf("fun!");
        System.out.println("Substring from last word: " + sentence.substring(indexOfFun));

        // splitting strings
        String csvData = "apple,banana,grape,orange";
        String[] splitFromCsv = csvData.split(",");
        for (String fruit : splitFromCsv) {
            System.out.println(fruit);
        }

        // Replacing characters
        String foxSentence = "The quick brown fox.";
        String updatedFoxSentence = foxSentence.replace("quick", "slow").replace(" ", "_");
        System.out.println(updatedFoxSentence);

        // null variables

        String shouldBeEmpty = null;
        String appearsEmpty = "";
        if (shouldBeEmpty == null) {
            System.out.println("Cannot process null string variable");
        }
        System.out.println("Printing length of appearsEmpty variable: " + appearsEmpty.length());
    }
}