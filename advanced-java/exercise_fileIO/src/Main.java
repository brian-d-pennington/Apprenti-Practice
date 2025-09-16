import java.io.*;

public class Main {
    public static void main(String[] args) {
        // *******Reflection questions at bottom of page***********

        // create file
        File file = new File("student_data.txt");
        try {
            if (file.createNewFile()){
                System.out.println("Student Data File Created");
            } else {
                System.out.println("Student Data File Already Exists.");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        // write to file
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println("Alice, A");
            writer.println("Bob, B");
            writer.println("Charlie, A+");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        // append data to file
        try (FileWriter fileWriter = new FileWriter("student_data.txt", true);
             PrintWriter writer = new PrintWriter(fileWriter)) {
            writer.println("David, B+");
            writer.println("Eva, A");
        } catch (IOException e){
            e.printStackTrace();
        }
        // read from file
        try (FileReader fileReader = new FileReader("student_data.txt");
             BufferedReader reader = new BufferedReader(fileReader)){
            for (String line = reader.readLine(); line != null; line = reader.readLine()){
                System.out.println(line);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        // absolute & relative paths

        // absolute
//        /Users/brianpennington/Desktop/javaPractice/Apprenti-Practice/advanced-java/exercise_fileIO/student_data.txt
        // relative
//        student_data.txt
        // or
//        ./exercise_fileIO/student_data.txt

        // delete file
        boolean success = file.delete();
        if (success) {
            System.out.println("Colors File was deleted.");
        } else {
            System.out.println("Unable to delete colors file");
        }
    }
}
// REFLECTION QUESTIONS:

//1. Relative paths are better to use on shared projects because they need to map files correctly regardless
// of whatever system is running the program. For instance, the users/brianpennington/ etc path would be
// meaningless on any other system.

//2. Without try-with-resources or try-catch-finally data handling, the java stack would eventually overload
//with memory data and the program would crash.

//3. Appending data makes the most sense for projects that progress over time, such as with the grades example:
//new student grades can be added (appended) to the file as the semester progresses.

//4. File IO is necessary any time data is going to or coming from an external system. For instance, maybe
//company sales are tracked on a spreadsheet over the month and need to be added to a system to process
//and collect the data. Values could be fed into the program via a CSV file and then further handled
//by more sophisticated application processing.