package edu.kirkwood.java2eedemo2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/convert2")
public class InchToMillimeterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String inchesStr = request.getParameter("inches");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            double inches = Double.parseDouble(inchesStr);

            if (inches < 0) {
                out.println("<h3>Error: Input cannot be negative.</h3>");
            } else {

                double millimeters = inches * 25.4;
                out.println("<h2>Conversion Result</h2>");
                out.println("<p>" + inches + " inches is equal to " + millimeters + " millimeters.</p>");
            }
        } catch (NumberFormatException e) {
            out.println("<h3>Error: Please enter a valid number.</h3>");
        } finally {
            out.close();
        }
    }
}
