package com.example.Product_Discount_Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", urlPatterns = "/index")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        float price= Float.parseFloat(request.getParameter("List Price"));
        float discount= Float.parseFloat(request.getParameter("Discount Percent"));
        float discountAmount= (float) (price*discount*0.01);
        float discountPrice=price+discountAmount;
        writer.println("<html>");
        writer.println("<h1>luong chiet khau:"+discountAmount+"</h1>");
        writer.println("<h1>gia:" + discountPrice +"</h1>");
        writer.println("</html>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
