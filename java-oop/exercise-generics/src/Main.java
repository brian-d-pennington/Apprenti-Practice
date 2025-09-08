import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        class Box<T> {
            private T value;
            private String label;

            public Box(String label){
                this.label = label;
            }

            public void Set(T value){
                this.value = value;
            }

            public T getValue(){
                return value;
            }

            public void display(){
                System.out.println(label + " contains " + value);
            }

            public void add(Box<T> boxOne) {
            }
        }

        Box<Integer> box = new Box<>("Number Box");
        box.Set(42);
        box.display();

        ArrayList<Box<Integer>> boxList = new ArrayList<>();

        Box<Integer> boxOne = new Box<>("I am box 1");
        Box<Integer> boxTwo = new Box<>("I am box 2");
        Box<Integer> boxThree = new Box<>("I am box 3");

        boxOne.Set(10);
        boxTwo.Set(20);
        boxThree.Set(30);

        boxList.add(boxOne);
        boxList.add(boxTwo);
        boxList.add(boxThree);

        for (Box<Integer> b : boxList){
            b.display();
        }

        Queue<Box<String>> queueList = new LinkedList<>();
        Box<String> queueBoxOne = new Box<>("Queue Box 1");
        Box<String> queueBoxTwo = new Box<>("Queue Box 2");
        Box<String> queueBoxThree = new Box<>("Queue Box 3");

        queueBoxOne.Set("first in line");
        queueBoxTwo.Set("second in line");
        queueBoxThree.Set("third in line");

        queueList.add(queueBoxOne);
        queueList.add(queueBoxTwo);
        queueList.add(queueBoxThree);

        while (!queueList.isEmpty()){
            Box<String> b = queueList.poll();
            b.display();
        }
    }
}
