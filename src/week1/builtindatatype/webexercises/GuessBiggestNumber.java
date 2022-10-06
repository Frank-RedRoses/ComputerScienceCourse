package week1.builtindatatype.webexercises;

/*
 * Guess the biggest number. Consider the following game. Alice writes down two 
 * integers between 0 and 100 on two cards. Bob gets to select one of the two cards 
 * and see its value. After looking at the value, Bob commits to one of the two cards. 
 * If he chooses a card with the largest value, he wins; otherwise he loses. Devise a 
 * strategy (and corresponding computer program) for Bob so that he guarantees to win 
 * strictly more than half the time.
 */

 /*
  * The strategy, in short, is:
  * Prior to selecting the slip, B should select some probability distribution D on R (real numbers)
  * that is everywhere positive. A normal or uniform distribution will suffice.
  * 
  * B should generate a random number y ∈ R distributed according to D.
  *
  * Let x be the number on the slip selected by B. If x > y, then B predicts that x is the larger of 
  * the two numbers; if x < y she predicts that x is the smaller of the two numbers. (y=x occurs with 
  * probability 0 and can be disregarded.)
  *
  */

public class GuessBiggestNumber {
    
    public static void main(String[] args) {

        int cardA = (int) (100 * Math.random());
        int cardB = (int) (100 * Math.random());
        int randomY = (int) (100 * Math.random());
        
        System.out.println("Prediction:");
        System.out.println("The card A is greater than card B = " + (cardA > randomY));
        System.out.println("Fact: " + (cardA > cardB));
        System.out.println("Card A = " + cardA);
        System.out.println("Card B = " + cardB);
    }
}
