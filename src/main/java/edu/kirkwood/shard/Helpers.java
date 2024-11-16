package edu.kirkwood.shard;

import org.jsoup.Jsoup;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class Helpers {
    public static String round(double number, int numDecPlaces) {
//        DecimalFormat decimalFormat = new DecimalFormat("0.#"); // Step 1: Instantiate a DecimalFormat object
//        // Step 2: Set the DecimalFormat pattern - 0.# means something will always print to the left of the decimal
//        decimalFormat.setMaximumFractionDigits(numDecPlaces); // Step 3: Call the non-static method to set the number of decimal places
//        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
//        return decimalFormat.format(number); // Step 4: Format the decimal number as a string and return it.
        // Source: ChatGPT https://chatgpt.com/share/671fcc74-41d4-8007-9179-f0f8586b5908
        BigDecimal bigDecimal = new BigDecimal(Double.toString(number));
        bigDecimal = bigDecimal.setScale(numDecPlaces, RoundingMode.HALF_UP).stripTrailingZeros();
        return bigDecimal.toString();
    }

    public static String html2text(String html) {
        return Jsoup.parse(html).text();
    }
    // Method to check if a string is empty or null
    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    // Method to remove HTML tags from a string
    public static String removeHtml(String input) {
        return input.replaceAll("<[^>]*>", "").trim();
    }

}