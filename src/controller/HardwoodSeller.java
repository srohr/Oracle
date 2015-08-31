/**
 * 
 */
package controller;

import model.WoodItem;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author Esteban
 *
 */
public class HardwoodSeller {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length != 1) {
            System.out.printf("ERROR! Usage: Hardwood <filepath>\n");
            System.out.printf("Recieved args: %s\n", Arrays.toString(args));
        }
        else{
            HardwoodSeller h = new HardwoodSeller();
            h.readInputFile(args[0]);
        }
	}
	
	public void readInputFile(String inputFilePath){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));

            while (reader.ready()){
                String l1 = reader.readLine();
                String l2 = reader.readLine();
                l2 = l2.replace(":", ";");

                String [] s1 = l1.split(";");
                String [] s2 = l2.split(";");

                WoodItem w [] = new WoodItem[(s2.length/2)];
                HashSet<Double> times = new HashSet<Double>();
                Double totalPrice = 0.0;

                for (int i = 0; i < w.length; i++){
                    w[i] = new WoodItem(s2[2*i]);
                    totalPrice += w[i].getPricePerUnit()*(Integer.valueOf(s2[2 * i + 1]));

                    w[i].getDaseDeliveryTime();
                    times.add(w[i].GetDeliveryTime(Integer.valueOf(s2[2 * i + 1])));
                }

                //System.out.printf("\tTimes: %s\n", times);
                Double deltime = Collections.max(times);

                System.out.printf("%s @ %s (%s)\n", s1[0], s1[1], s1[2]);
                for (int i = 0; i < w.length; i++){
                    System.out.printf("%s: %s Units\n", s2[2*i], s2[2*i + 1]);
                }
                System.out.printf("Delivery Time: %g Hours\nTotal Price: $%g\n\n", deltime, totalPrice);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	/*public Double deliveryTime(){
		Double deliveryETA = 0.0;
		return deliveryETA;
	}*/
	
}
