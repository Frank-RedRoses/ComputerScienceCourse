package week2.conditionalandloops.webexercises;
/********************************************************************
 * Alice tosses a fair coin until she sees two consecutive heads. 
 * Bob tosses another fair coin until he sees a head followed by a tail. 
 * Write a program to estimate the probability that Alice will make fewer tosses than Bob? 
 * 
 * Solution: 39/121.
 **********************************************************************/
public class TossAFairCoin {
    public static void main(String[] args) {
        int trials = 500;
        int aliceFewTosses = 0;
        
        for (int i = 0; i < trials; i++) {
            int aliceCounter = 0;
            int bobCounter = 0;
            boolean consecutiveHeads = false;
            boolean headFollowedTail = false;
            int alicePrevT = 0;
            int bobPrevT = 0;

            while (!consecutiveHeads) {
                int toss = (int) (Math.random()*2);
                aliceCounter++;
                if (alicePrevT == 1 && toss == alicePrevT) {
                    consecutiveHeads = true;
                } else {
                    alicePrevT = toss;
                }
            }
    
            while (!headFollowedTail) {
                int toss = (int) (Math.random()*2);
                bobCounter++;
                if (bobPrevT == 1 && toss == 0) {
                    headFollowedTail = true;
                } else {
                    bobPrevT = toss;
                }
            }

            if (aliceCounter <  bobCounter) aliceFewTosses++;
        }
            
        System.out.println("Alice has few tosses by " + aliceFewTosses + " times");
        System.out.println("Probability that Alice will make fewer tosses than Bob:");
        System.out.println(aliceFewTosses*1.0/trials*100);
        System.out.println("Solution = " + 39.0*100.0/121.0);
    }
    
}
