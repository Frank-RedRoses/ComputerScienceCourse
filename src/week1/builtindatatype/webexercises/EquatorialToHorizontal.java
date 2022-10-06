package week1.builtindatatype.webexercises;

/*
 *  Equatorial to horizontal coordinates. The equatorial coordinate system is widely 
 * used by astronomers to indicate the position of a star on the celestial sphere. 
 * The position is specified by its declination δ, its hour angle H, and its latitude φ. 
 * The horizontal coordinate system (a.k.a. Alt/Az coordinate system) is useful for 
 * determining the setting/rising time of celestial objects. The position is specified 
 * by its altitude (vertical angle from the horizon) and and its azimuth (horizontal angle). 
 * Given a star's position using equatorial coordinates, find its position in horizontal 
 * coordinates using the formulas below.
 * 
 * Altitude = asin (sin φ sin δ  + cos φ cos δ cos H)
 * 
 * Azimuth  = acos ((cos φ sin δ  - sin φ cos δ cos H) / cos (Altitude) )
 * 
 * Example:
 * An observer O at geogr. latitude 50° N and longitude 10° E, on 1991/05/19 at 13:00 UT,
 * will see a star of right ascension RA=55.8° and declination delta=19.7° at azimuth az=43.6° 
 * and altitude h=53.4°.
 * (Sidereal time is 81.7°, hour angle is 25.9°).
 * Note: Azimuth is a value between 90°(north hemisphere) and -90°(south hemisphere).
 */

public class EquatorialToHorizontal {

    public static void main(String[] args) {
        double hourAngle = Double.parseDouble(args[0]);    // hour angle H
        double declination = Double.parseDouble(args[1]);       // declination δ
        double latitude = Double.parseDouble(args[2]);       // latitude φ

        double sinDec = Math.sin(Math.toRadians(declination));
        double cosDec = Math.cos(Math.toRadians(declination));
        double sinLat = Math.sin(Math.toRadians(latitude));
        double cosLat = Math.cos(Math.toRadians(latitude));
        double cosH = Math.cos(Math.toRadians(hourAngle));

        double altitudeRad = Math.asin(sinLat * sinDec + cosLat * cosDec * cosH);
        double altitude = Math.toDegrees(altitudeRad);
        double azimuthRad = Math.acos((cosLat * sinDec - sinLat * cosDec *cosH) / Math.cos(altitudeRad));
        double azimuth = Math.toDegrees(azimuthRad) - 90;

        System.out.println("Altitude = " + altitude);
        System.out.println("Azimuth = " + azimuth);
        
    }
    
}
