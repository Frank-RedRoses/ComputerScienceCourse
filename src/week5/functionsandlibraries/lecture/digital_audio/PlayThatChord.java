package week5.functionsandlibraries.lecture.digital_audio;

import edu.princeton.cs.algs4.StdAudio;

/** 
 * Produce chords by averaging waveforms. 
 * 
 * % java PlayThatChord 0 3 5.0
 * 
 **/
public class PlayThatChord {
    // creates an average waveform from 2 tones.
    public static double[] avg(double[] a, double[] b) {
        double[] c = new double[a.length];
        for (int i = 0; i < a.length; i++)
            c[i] = a[i] / 2.0 + b[i] / 2.0;
        return c;
    }

    // make the chorch. 440.0 Hz is the "standard pitch" value of note A.
    public static double[] chord(int pitch1, int pitch2, double d) {
        double hz1 = 440.0 * Math.pow(2, pitch1 / 12.0);    // compute the 1st pitch
        double hz2 = 440.0 * Math.pow(2, pitch2 / 12.0);    // compute the 2nd pitch
        double[] a = PlayThatNote.tone(hz1, d);     // First tone
        double[] b = PlayThatNote.tone(hz2, d);     // Second tone
        return avg(a, b);                           // Average of both
    }

    public static void main(String[] args) {
        int pitch1 = Integer.parseInt(args[0]);     //  a note frequenzy from 0(A2) to 12(A3) 
        int pitch2 = Integer.parseInt(args[1]);     //  a note frequenzy from 0(A2) to 12(A3)
        double duration = Double.parseDouble(args[2]);
        double[] a = chord(pitch1, pitch2, duration);   // Create the chord
        StdAudio.play(a);   // play the sound
    }

}
