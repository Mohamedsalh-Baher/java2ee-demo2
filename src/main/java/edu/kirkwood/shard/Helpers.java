package edu.kirkwood.shard;

import org.jsoup.Jsoup;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Helpers {
    public static String round(double number, int numDecPlaces) {
        //        DecimalFormat decimalFormat = new DecimalFormat("0.#"); // Step 1: Instantiate a DecimalFormat object
//        // Step 2: Set the DecimalFormat pattern - 0.# means something will always print to the left of the decimal
//        decimalFormat.setMaximumFractionDigits(numDecPlaces); // Step 3: Call the non-static method to set the number of decimal places
//        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
//        return decimalFormat.format(number); // Step 4: Format the decimal number as a string and return it.
        BigDecimal bigDecimal = new BigDecimal(Double.toString(number));
        bigDecimal = bigDecimal.setScale(numDecPlaces, RoundingMode.HALF_UP).stripTrailingZeros();
        return bigDecimal.toString();

    }

    public static String html2text(String html) {
        return Jsoup.parse(html).text();
    }
}