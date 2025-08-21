package th.mfu;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calbmi")
public class BMICalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        double weight = Double.parseDouble(request.getParameter("weight"));
        double height = Double.parseDouble(request.getParameter("height"));

        double bmiValue = weight / (height * height);
        int bmi = (int) Math.round(bmiValue);

        String type;
        if (bmi < 18.5) {
            type = "underweight";
        } else if (bmi < 25) {
            type = "normal";
        } else if (bmi < 30) {
            type = "overweight";
        } else {
            type = "obese";
        }

        // response ให้ test อ่านได้
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><body>");
            out.println("<h2>Result is " + bmi + "</h2>");
            out.println("<p>" + type + "</p>");
            out.println("</body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // reuse logic ของ doGet()
        doGet(request, response);
    }
}