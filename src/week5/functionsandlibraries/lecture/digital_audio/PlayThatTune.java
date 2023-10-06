package week5.functionsandlibraries.lecture.digital_audio;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdIn;

/**
 * Read a list of tones and durations from standard input to play a tune.<p>
 * There are 12 notes, are on logarithmic scale. (pitch 440*2^(i/12)):<p>
 * <pre>
 * Notes:
 * A     = 440*2^(0/12) 
 * A#/Bb = 440*2^(1/12)
 * B     = 440*2^(2/12)
 * ...   
 * G#/Ab = 440*2^(11/12)
 * A     = 440*2^(12/12)
 * </pre>
 * 
 * <pre>
 * % more < elise.txt
 * 7 .125
 * 6 .125
 * 7 .125
 * 6 .125
 * 7 .125
 * 2 .125
 * 5 .125
 * 3 .125
 * 0 .25
 * </pre>
 * 
 * % java PlayThatTune 2.0 < elise.txt
 */
public class PlayThatTune {
    public static void main(String[] args) {    
        double tempo = Double.parseDouble(args[0]);     // Control the tempo from command-line
        while (!StdIn.isEmpty()) {
            int pitch = StdIn.readInt();        // read in the note (0-12), on logarithmic scale
            double duration = StdIn.readDouble() * tempo;   // read in duration of note
            double hz = 440 * Math.pow(2, pitch / 12.0);
            double[] a = PlayThatNote.tone(hz, duration);   // compute the tone
            StdAudio.play(a);
        }
        StdAudio.close();
    }

}
