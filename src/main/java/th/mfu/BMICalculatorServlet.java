package th.mfu;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet("/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        double weight = Double.parseDouble(request.getParameter("weight"));
        double height = Double.parseDouble(request.getParameter("height"));
        
        
        //TODO: calculate bmi
        double bmirun = weight / (height * height);
        int bmi = (int)Math.round(bmirun);
        

        //TODO: determine the built from BMI
        String builtType; 
        if (bmi < 18.5) {
            builtType = "Underweight";
        } else if (bmi < 25) {
            builtType = "Normal";
        } else if (bmi < 30) {
            builtType = "Overweight";
        } else if (bmi < 35) {
            builtType = "Obese";
        } else {
            builtType = "Extremely Obese";
        }
        
        
        //TODO: add bmi and built to the request's attribute
        request.setAttribute("bmi", bmi);
        request.setAttribute("builtType", builtType);


        //TODO: forward to jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/bmi_result.jsp");
        dispatcher.forward(request, response);
    }
}
           
    
    

