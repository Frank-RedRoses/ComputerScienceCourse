package week2.conditionalandloops.exercises;

public class AllEqual {

    public static void main(String[] args) {
        int value0 = Integer.parseInt(args[0]);
        int value1 = Integer.parseInt(args[1]);
        int value2 = Integer.parseInt(args[2]);

        if ( value0 == value1 && value0 == value2) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }
    
}
