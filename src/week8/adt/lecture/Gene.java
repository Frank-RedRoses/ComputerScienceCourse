package week8.adt.lecture;

import edu.princeton.cs.algs4.StdOut;

public class Gene {

    // Checks if a given string is a potencial gene.
    public static boolean isPotencialGene(String dna) {
        // genes only start with "ATG" and have to be a multiple of 3
        if (dna.length() % 3 != 0) return false;
        if (!dna.startsWith("ATG")) return false;
        for (int i = 0; i < dna.length() - 3; i += 3) {
            String condon = dna.substring(i, i + 3);
            if (condon.equals("TAA")) return false;
            if (condon.equals("TAG")) return false;
            if (condon.equals("TGA")) return false;
        }
        if (dna.endsWith("TAA")) return true;
        if (dna.endsWith("TAG")) return true;
        if (dna.endsWith("TGA")) return true;
        return false;
    }

        
    public static void main(String[] args) {
        StdOut.println(isPotencialGene(args[0]));
    }
}
