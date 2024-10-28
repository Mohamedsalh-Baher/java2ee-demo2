package edu.kirkwood.ecommerce.controller;


import edu.kirkwood.ecommerce.model.Cylinder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/volume")
public class VolumeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException {
        String radiusParam = request.getParameter("radius");
        String heightParam = request.getParameter("height");

        double radius;
        double height;
        String result;

        try {
            radius = Double.parseDouble(radiusParam);
            height = Double.parseDouble(heightParam);

            if (radius < 0 || height < 0) {
                result = "Radius and height must be non-negative values.";
            } else {
                Cylinder cylinder = new Cylinder(radius, height);
                result = cylinder.toString();  // Get the formula with the volume
            }
        } catch (NumberFormatException e) {
            result = "Invalid input. Please enter numeric values for radius and height.";
        }

        request.setAttribute("result", result);
        request.getRequestDispatcher("volume.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("volume.jsp").forward(request, response);
    }
}
