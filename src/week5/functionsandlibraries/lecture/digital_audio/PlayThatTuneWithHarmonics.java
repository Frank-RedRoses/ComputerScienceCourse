package week5.functionsandlibraries.lecture.digital_audio;

/**
 * % java PlayThatTune 1.5 < elise.txt
 */
public class PlayThatTuneWithHarmonics {

    /** 
     * Creates an array that represents the waveform of a given frequency.
     * 
     * @param hz a pitch
     * @param duration time or size of the tone
     * @return  an array with 44100 samples * duration, that represents the waveform
     **/
    public static double[] tone(double hz, double duration) {   // hz == pitch
        int N = (int) (44100 * duration);   // CD standard
        double[] a = new double[N + 1];
        for (int i = 0; i <= N; i++)
            a[i] = Math.sin(2 * Math.PI * i * hz / 44100);
        return a;   // return an array with 44100 samples that represents the waveform
    }

    /** 
     * Creates an average tone waveform from 2 given tone waveforms.
     **/
    public static double[] avg(double[] a, double[] b) {
        double[] c = new double[a.length];
        for (int i = 0; i < a.length; i++)
            c[i] = a[i] / 2.0 + b[i] / 2.0;
        return c;
    }

    /**
     * Add harmonics to PlayThatTune to produce a more realistic sound.
     * 
     * @param pitch 12 notes, on logarithmic scale, 2^i/12 from 0 to 12.
     * @param duration 
     * @return a array that represents a more realistic sound
     */
    public static double[] note(int pitch, double duration) {
        double hz = 440.0 * Math.pow(2, pitch / 12.0);
        double[] a = tone(1.0 * hz, duration);      // pure pitch
        double[] hi = tone(2.0 * hz, duration);     // high octave
        double[] lo = tone(0.5 * hz, duration);     // low octave
        double[] harmonic = avg(hi, lo);            // average of high and low
        return avg(a, harmonic);                    // add pure pitch to average
    }

}
