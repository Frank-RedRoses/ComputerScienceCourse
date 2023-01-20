package week5.functionsandlibraries.lectures.staticmethods;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdIn;

/******************************************************************************
 *  Compilation:  javac PlayThatTuneDeluxe.java
 *  Execution:    java PlayThatTuneDeluxe < data.txt
 * 
 * PlayThatTuneDeluxe.java is a version of PlayThatTune that encapsulates the 
 * sound wave calculation and adds harmonics
 *
 *  % java PlayThatTuneDeluxe 0.5 < elise.txt
 *
 *  Data files
 *  ----------
 *  https://introcs.cs.princeton.edu/java/21function/elise.txt
 *  https://introcs.cs.princeton.edu/java/21function/freebird.txt
 *  https://introcs.cs.princeton.edu/java/21function/Ascale.txt
 *  https://introcs.cs.princeton.edu/java/21function/National_Anthem.txt
 *  https://introcs.cs.princeton.edu/java/21function/looney.txt
 *  https://introcs.cs.princeton.edu/java/21function/StairwayToHeaven.txt
 *  https://introcs.cs.princeton.edu/java/21function/entertainer.txt
 *  https://introcs.cs.princeton.edu/java/21function/old-nassau.txt
 *  https://introcs.cs.princeton.edu/java/21function/arabesque.txt
 *  https://introcs.cs.princeton.edu/java/21function/firstcut.txt
 *  https://introcs.cs.princeton.edu/java/21function/tomsdiner.txt
 *  https://introcs.cs.princeton.edu/java/21function/portal.txt
 *
 ******************************************************************************/

public class PlayThatTuneDeluxe {

    // returns weighted sum of two arrays
    public static double[] sum(double[] a, double[] b, double awt, double btw) {

        // precondition: array have the same length
        assert a.length == b.length;

        // compute the weighted sum
        double[] c = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i]*awt +b[i]*btw;
        }
        return c;
    }

    // create a pure tone of a given frequency for the given duration
    // ( a pure tone is a sinusoidal waveform hz)
    public static double[] tone(double hz, double duration) {
        int n = (int) (StdAudio.SAMPLE_RATE * duration);
        double[] a = new double[n + 1];
        for (int i = 0; i <= n; i++) {
            a[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
        }
        return a;
    }
    

    // create a note with harmonics of the given picth and duration
    // where 0 = concert A
    public static double[] note(int pitch, double duration) {
        double hz = 440.0 * Math.pow(2, pitch / 12.0);  // 1 pitch of 12 notes (sinusodial waveform formula)
        double[] a = tone(hz, duration);
        double[] hi = tone(2*hz, duration);
        double[] lo = tone(hz/2, duration);
        double[] har = sum(hi, lo, 0.5, 0.5);
        return sum(a, har, 0.5, 0.5);   
    }

    // read in notes from standard input and play them on standard audio
    public static void main(String[] args) {
        
        // read in pitch-duration pairs from standar input
        while (!StdIn.isEmpty()) {
            int pitch = StdIn.readInt();
            double duration = StdIn.readDouble();
            double[] a  = note(pitch, duration);
            StdAudio.play(a);
        }
    }
}
