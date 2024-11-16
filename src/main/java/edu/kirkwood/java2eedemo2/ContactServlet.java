package edu.kirkwood.java2eedemo2;

import edu.kirkwood.shard.AzureEmail;
import edu.kirkwood.shard.Helpers;
import edu.kirkwood.shard.Validators;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/contact.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String subject = req.getParameter("subject");
        String messageBody = req.getParameter("messageBody");

        boolean hasError = false;

        // Validate email
        if (!Validators.isValidEmail(email)) {
            req.setAttribute("emailError", "Invalid email address.");
            hasError = true;
        }

        // Validate subject
        if (Helpers.isEmpty(subject)) {
            req.setAttribute("subjectError", "Subject cannot be blank.");
            hasError = true;
        }

        // Validate message body
        if (Helpers.isEmpty(messageBody)) {
            req.setAttribute("messageError", "Message cannot be blank.");
            hasError = true;
        }

        if (hasError) {
            // Keep form data on invalid submission
            req.setAttribute("email", email);
            req.setAttribute("subject", subject);
            req.setAttribute("messageBody", messageBody);
            req.getRequestDispatcher("/contact.jsp").forward(req, resp);
        } else {
            String adminEmail = System.getenv("ADMIN_EMAIL");

            // Send email using AzureEmail class
            String error = AzureEmail.sendEmail(adminEmail, subject, messageBody);

            // Check if there was an error sending the email
            if (error.isEmpty()) {
                req.setAttribute("successMessage", "Email sent successfully.");
            } else {
                req.setAttribute("errorMessage", "Failed to send email: " + error);
            }

            req.getRequestDispatcher("/contact.jsp").forward(req, resp);
        }
    }
}
