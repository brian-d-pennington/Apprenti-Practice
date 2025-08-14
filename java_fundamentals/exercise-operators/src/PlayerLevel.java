public class PlayerLevel {

    public static void main(String[] args) {
        //    Declare and initialize variables:
        int currentXP = 1200; // experience points
        int level = 5;
        int xpToNextLevel = 1500;
        boolean levelUp;

//     1. Use Arithmetic Operators:
//            Add +300 XP when completing a quest (+=).
        currentXP += 300;
        System.out.println("Quest complete. XP now: " + currentXP);
//            Reduce xpToNextLevel dynamically as XP increases (-=).
        xpToNextLevel -= 300;
        System.out.println("Experience points to next level decrease along with point increase. Now: " +xpToNextLevel);
//            Multiply XP if player earns a double XP boost (*=).
        currentXP *= 2;
        System.out.println("XP doubled after boost earned. XP now: "+ currentXP);
//     2. Use Comparison Operators:
//            Check if currentXP is greater than or equal to xpToNextLevel.
        boolean enoughXP = currentXP >= xpToNextLevel;
        System.out.println("Does player have enough XP to advance to next level? "+enoughXP);
//            Check if the player has reached Level 10.
        boolean reachLevelTen = level == 10;
        System.out.println("Has player reached level 10? "+reachLevelTen);
//      3. Use Logical Operators:
//            Determine if the player levels up (XP requirement met AND level < 10).
        levelUp = currentXP >= xpToNextLevel && level < 10;
        System.out.println("Can player level up? "+levelUp);
//            Determine if the player is a pro (Level > 7 OR XP over 5000).
        boolean isPro = level > 7 || currentXP > 5000;
        System.out.println("Is player Pro? "+isPro);
//       4. Print the updated values and level-up status.

    }


}
