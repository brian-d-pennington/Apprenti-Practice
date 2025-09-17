import java.util.Scanner;

public class Decisions {
    public static void main(String[] args) {

//  Decisions Exercise
//        Objective
//        Create a text-based adventure game where the player explores a mysterious cave.
//                Use if statements, else-if chains, nested ifs, and switch statements to control the
//        story and outcomes.

        Scanner console = new Scanner(System.in);

        String fightOrFlee = "";
        String artifact = "";
        Boolean thanksMessage = true;

        System.out.println("Would you like to enter the cave? y/n");
        String enterCave = console.nextLine();

        switch (enterCave) {
            case "y":
                System.out.println("You have chosen to enter the cave!");
                // nested if/else statement to move left or right
                System.out.println("Would you like to move left or right? left/right");
                String chooseLeftOrRight = console.nextLine();
                if (chooseLeftOrRight.equals("left")) {
                    System.out.println("You have encountered a monster!!");
                    // nested statement to fight or flee
                    System.out.println("Would you like to fight or flee? fight/flee");
                    fightOrFlee = console.nextLine();
                    if (fightOrFlee.equals("fight")) {
                        System.out.println("You chose to fight, and succeeded!");
                        break;
                    } else {
                        System.out.println("You chose to flee, and barely escaped!");
                        break;
                    }
                } else { // input equals "right"
                    System.out.println("You have reached the treasure room!");
                    // switch case logic for artifact choices
                    System.out.println("Select one of these artifacts: sword, key, map");
                    artifact = console.nextLine();
                    switch (artifact) {
                        case "sword":
                            System.out.println("Now you will be able to defeat any monsters!");
                            break;
                        case "key":
                            System.out.println("You can now enter any shortcut paths!");
                            break;
                        case "map":
                            System.out.println("You can now navigate around any danger!");
                            break;
                    }
                }
                break;
            case "n":
                System.out.println("You have decided not to enter the cave. Goodbye");
                thanksMessage = false;
                break;
            default:
                System.out.println("You entered incorrectly.");
                thanksMessage = false;
                break;
        }
        // exit message, unless they hit default statement and didn't play game
        if (thanksMessage) {
            System.out.println("Thanks for playing!");
        }

        // status report of what they did in the game, if they chose certain paths
        if (fightOrFlee != "") {
            System.out.println("You chose to " + fightOrFlee);
        }
        if (artifact != "") {
            System.out.println("You walked away with a " +artifact);
        }

        

    }
}
