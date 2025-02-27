package week1.elementsofprogramming.exercises;
/**
 * Modify "UseArgument.java" to make a program "UseThree.java" that
 * takes three names and prints out a proper sentence with the 
 * names in the reverse of the order given, so that for example, 
 * "java UseThree Alice Bob Carol" gives "Hi Carol, Bob, and Alice."
 * 
 * public static void main(String[] args) {
 *    System.out.print("Hi, ");
 *       System.out.print(args[0]);
 *       System.out.println(". How are you?");
 *   }
 */
public class UseThree {

    public static void main(String[] args) {
        System.out.print("Hi ");
        System.out.print(args[2] +", ");
        System.out.print(args[1] +", and ");
        System.out.print(args[0] +".");
    }
}
