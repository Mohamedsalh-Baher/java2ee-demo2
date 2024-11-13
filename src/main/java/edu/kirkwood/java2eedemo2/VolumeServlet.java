package edu.kirkwood.java2eedemo2;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(value = "/volume")
public class VolumeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String heightStr = request.getParameter("height");
        String radiusStr = request.getParameter("radius");

        try {
            if (heightStr == null || heightStr.trim().isEmpty() || radiusStr == null || radiusStr.trim().isEmpty()) {
                throw new IllegalArgumentException("Height and radius must be provided.");
            }

            double height = Double.parseDouble(heightStr.trim());
            double radius = Double.parseDouble(radiusStr.trim());

            if (height < 0 || radius < 0) {
                throw new IllegalArgumentException("Negative values are not allowed.");
            }
            Cylinder cylinder = new Cylinder(radius, height);
            request.setAttribute("cylinder", cylinder);

            RequestDispatcher dispatcher = request.getRequestDispatcher("volume.jsp");
            dispatcher.forward(request, response);

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Please enter valid numeric values for radius and height.");
            request.getRequestDispatcher("volume.jsp").forward(request, response);

        } catch (IllegalArgumentException e) {
            // Handle any other input-related exceptions
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("volume.jsp").forward(request, response);
        }
    }
}
