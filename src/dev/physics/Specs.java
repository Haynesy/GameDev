package dev.physics;

import dev.physics.engine.Units;

/**
 * Created with IntelliJ IDEA.
 * User: Haynesy
 * Date: 6/11/2014
 * Time: 10:25 PM
 */
public class Specs {

    /*
    Units of measure

    International
        meter, kilogram, second, kelvin
        newton (kg-m/s^2)
        gravity = 6.67e-11 (N - m^2 / kg^2)

    English
        pound (lbm), foot (ft), seconds, Fahrenheit (F) or Rankine (R)
     */

    /*
    Summation notation

    m^total =  m1 + m2 + m3 + m4 + m5

    or

    m^total = (5 (Big E) j=1) mj

    * */

    public static void main(String[] args){
        System.out.printf("Gravity: %.13f", Units.GRAVITY);
    }
}
