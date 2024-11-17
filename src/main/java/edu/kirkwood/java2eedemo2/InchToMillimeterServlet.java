package edu.kirkwood.java2eedemo2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/convert2")
public class InchToMillimeterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("InchToMillimeter.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String inchesStr = request.getParameter("inches");
        String errorMessage = null;
        String resultMessage = null;
        String inchesInput = inchesStr; // To retain the user's input.

        if (inchesStr == null || inchesStr.trim().isEmpty()) {
            errorMessage = "Error: Input cannot be empty.";
        } else {
            try {
                double inches = Double.parseDouble(inchesStr.trim());
                if (inches < 0) {
                    errorMessage = "Error: Input cannot be negative.";
                } else {
                    double millimeters = inches * 25.4;
                    resultMessage = inches + " inches is equal to " + millimeters + " millimeters.";
                }
            } catch (NumberFormatException e) {
                errorMessage = "Error: Please enter a valid number.";
            }
        }

        request.setAttribute("errorMessage", errorMessage);
        request.setAttribute("resultMessage", resultMessage);
        request.setAttribute("inchesInput", inchesInput);

        request.getRequestDispatcher("InchToMillimeter.jsp").forward(request, response);
    }
}
