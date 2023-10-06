package week5.functionsandlibraries.lecture.digital_audio;

import edu.princeton.cs.algs4.StdAudio;

/**
 * Crash course in sound:
 * <p>
 * <b>Sound</b> is the perception of the vibration of molecules.
 * <p>
 * A <b>musical tone</b> is a steady periodic sound.
 * <p>
 * A <b>pure tone</b> is a sinusoidal waveform.
 * <p>
 * Western musical scale:
 * <lu><li> - Concert pitch A is 440 Hz (standard value).
 * <li>  - 12 notes, are on logarithmic scale. (frequency = 440*2^(i/12)) 
 * </lu>
 * <p>
 * To represent a waveform, sample at regular intervals and save the values 
 * in an array.
 * 
 * The CD standard is 44,100 samples/sec.<p>
 * 
 *  % java PlayThatNote 440.0 3.0
 */
public class PlayThatNote {
    
    /** 
     * Creates an array that represents the waveform of a given frequency.
     * 
     * @param hz a pitch
     * @param duration time or size of the tone
     * @return  an array with 44100 samples * duration, that represents the waveform
     **/
    public static double[] tone(double hz, double duration) {   // hz == pitch
        int N = (int) (44100 * duration);   // CD standard
        double[] a = new double[N + 1];     // size of the waveform
        for (int i = 0; i <= N; i++)
            a[i] = Math.sin(2 * Math.PI * i * hz / 44100);  // sinusoidal waveform formula
        return a;   // return an array with 44100 samples that represents the waveform
    }

    public static void main(String[] args) {
        double hz = Double.parseDouble(args[0]);
        double duration = Double.parseDouble(args[1]);
        double[] a = tone(hz, duration);
        StdAudio.play(a);
    }
}
