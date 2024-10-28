package edu.kirkwood.java2eedemo2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/temp-converter")
public class TemperatureConverter extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("temperature.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fahrenheitStr = request.getParameter("fahrenheit");
        String resultMessage = null;
        String errorMessage = null;

        try {
            double fahrenheit = Double.parseDouble(fahrenheitStr);
            if (fahrenheit < -459.67) {
                errorMessage = "Temperature must be -459.67°F or higher.";
            } else {
                double celsius = (fahrenheit - 32) * 5.0 / 9.0;
                resultMessage = String.format("(%.1f°F - 32) × 5/9 = %.1f°C", fahrenheit, celsius);
            }
        } catch (NumberFormatException e) {
            errorMessage = "Invalid temperature. Please enter a numeric value.";
        }
        request.setAttribute("resultMessage", resultMessage);
        request.setAttribute("errorMessage", errorMessage);

        request.getRequestDispatcher("temperature.jsp").forward(request, response);
    }
}


