package week8.adt.lecture;

import edu.princeton.cs.algs4.StdOut;

public class GeneFinder {

    public static void findGeneIn(String dna) {
        int beg = -1;
        for (int i = 0; i <= dna.length() - 3; i++) {
            String codon = dna.substring(i, i + 3);
            if (codon.equals("ATG")) {
                beg = i;
                i += 3;
            } else if (beg != -1 && 
                        (codon.equals("TAA") || 
                        codon.equals("TAG") || 
                        codon.equals("TGA"))) {
                String gene  = dna.substring(beg + 3, i);
                if (gene.length() > 0 && gene.length() % 3 == 0) {
                    StdOut.println(gene);
                    beg = -1;
                    i +=3;
                }
            }
        }
    }

    public static void main(String[] args) {
        String dna = args[0];
        findGeneIn(dna);
    }
    //GCGCATAGC
}
