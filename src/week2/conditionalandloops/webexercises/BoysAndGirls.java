package week2.conditionalandloops.webexercises;
/********************************************************************************
 * Boys and girls. 
 * Repeat the previous question, but assume the couple keeps having children until 
 * they have another child which is of the same sex as the first child. 
 * 
 * How does your answer change if p is different from 1/2?
 * 
 * Surprisingly, the average number of children is 2 if p = 0 or 1, and 3 
 * for all other values of p. But the most likely value is 2 for all values of p.
 * 
 **********************************************************************************/

public class BoysAndGirls {

    public static void main(String[] args) {
        double probGirl = 0.40;
        int trials = 50;
        int average = 0;
        int nChildren;
        int cTwoChild = 0;
        int cThreeChild = 0;
        int cFourChild = 0;
        int cFivePlusChild = 0;

        for (int i = 0; i < trials; i++) {
            nChildren = 0;
            boolean firstGirl = false;
            boolean firstBoy = false;

            while(true) {
                double p = Math.random();
                if (p < probGirl) {
                    nChildren++;
                    if (firstGirl) break;
                    else if (nChildren == 1) firstGirl = true;
                } else {
                    nChildren++;
                    if (firstBoy) break;
                    else if (nChildren == 1) firstBoy = true;
                }
            }
            
            average += nChildren;
            if (nChildren >= 5) cFivePlusChild++;
            else if (nChildren == 4) cFourChild++;
            else if (nChildren == 3) cThreeChild++;
            else if (nChildren == 2) cTwoChild++;
        }

        average /= trials;

        System.out.println("Trials = " + trials + ", average children: " + average);
        System.out.println("Frequency for 2 children: " + cTwoChild*100/trials + "%");
        System.out.println("Frequency for 3 children: " + cThreeChild*100/trials + "%");
        System.out.println("Frequency for 4 children: " + cFourChild*100/trials + "%");
        System.out.println("Frequency for 5 or more children: " + cFivePlusChild*100/trials + "%");
    }
    
}
