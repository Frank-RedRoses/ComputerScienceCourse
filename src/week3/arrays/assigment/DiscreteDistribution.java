package week3.arrays.assigment;

public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] intervalMaxValue = new int[args.length];
        for (int i = 1; i < args.length; i++) {
            intervalMaxValue[i] = intervalMaxValue[i - 1] + Integer.parseInt(args[i]);
        }
        for (int i = 0; i < m; i++) {
            int rNumber = (int) (Math.random() * intervalMaxValue[args.length - 1]);
            for (int j = 0; j < intervalMaxValue.length; j++) {
                if (rNumber < intervalMaxValue[j]) {
                    System.out.print(j + " ");
                    break;
                }
            }
            if (i % 25 == 24) System.out.println();
        }
    }
}
