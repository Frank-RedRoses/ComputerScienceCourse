package week2.conditionalandloops.webexercises;
/****************************************************************************
 * Boys and girls. 
 * A couple beginning a family decides to keep having children until they have 
 * at least one of either sex. Estimate the average number of children they will 
 * have via simulation. Also estimate the most common outcome (record the frequency 
 * counts for 2, 3, and 4 children, and also for 5 and above). 
 * 
 * Assume that the probability p of having a boy or girl is 1/2.
 * 
 ***************************************************************************/

public class FamilyPlanning {
    
    public static void main(String[] args) {
        int trials = 500;
        int average = 0;
        int nChildren = 0;
        int counterTwoChild = 0;
        int counterThreeChild = 0;
        int counterFourChild = 0;
        int counterFivePlusChild = 0;

        for (int i = 0; i < trials; i++) {
            int girls = 0;
            int boys = 0;
            while (girls == 0 || boys == 0) {
                // while there is no boy or girl generate random number
                double p = Math.random();
                // if less than 50% is a girl, otherwise is a boy.
                if (p < 0.5) girls++;
                else boys++;
            }
            // stats
            nChildren = girls + boys;
            average += nChildren;
            if (nChildren >= 5) counterFivePlusChild++;
            else if (nChildren == 4) counterFourChild++;
            else if (nChildren == 3) counterThreeChild++;
            else if (nChildren == 2) counterTwoChild++;
        }

        average /= trials;

        System.out.println("Trials = " + trials + ", average children: " + average);
        System.out.println("Frequency for 2 children: " + counterTwoChild*100/trials + "%");
        System.out.println("Frequency for 3 children: " + counterThreeChild*100/trials + "%");
        System.out.println("Frequency for 4 children: " + counterFourChild*100/trials + "%");
        System.out.println("Frequency for 5 or more children: " + counterFivePlusChild*100/trials + "%");
    }
    
}
