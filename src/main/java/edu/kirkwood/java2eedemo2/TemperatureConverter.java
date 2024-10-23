package edu.kirkwood.java2eedemo2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/temp-converter")
public class TemperatureConverter extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fahrenheitStr = request.getParameter("fahrenheit");
        double fahrenheit;
        String resultMessage;

        // Validate input
        try {
            fahrenheit = Double.parseDouble(fahrenheitStr);
            if (fahrenheit < -459.67) {
                resultMessage = "Temperature must be -459.67 or higher.";
            } else {
                double celsius = (fahrenheit - 32) * 5.0 / 9.0;
                resultMessage = String.format(
                        "(%.1f°F - 32) × 5/9 = %.1f°C", fahrenheit, celsius);
            }
        } catch (NumberFormatException e) {
            resultMessage = "Invalid temperature.";
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Conversion Result</h1>");
        out.println("<p>" + resultMessage + "</p>");
        out.println("<a href='index.jsp'>Back to Index</a>");
        out.println("</body></html>");
    }
}

