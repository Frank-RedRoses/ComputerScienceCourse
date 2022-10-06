package week1.builtindatatype.webexercises;

/*
 * Write a program that reads in three parameters and prints true if all three are equal, 
 * and false otherwise.
 */
public class ThreeEqualParams {
    public static void main(String[] args) {
        String arg0 = args[0];
        String arg1 = args[1];
        String arg2 = args[2];
        
        System.out.println(arg0.equals(arg1) && arg1.equals(arg2));

    }
    
}
