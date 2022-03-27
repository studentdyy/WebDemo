package com.demo.servlet;

import com.demo.dao.FruitDAO;
import com.demo.dao.impl.FruitDAOImpl;
import com.demo.pojo.fruit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/add.do")
public class addServlet extends ViewBaseServlet{

    FruitDAO fruitDAO = new FruitDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String name = req.getParameter("name");
        int  price = Integer.parseInt(req.getParameter("price"));
        int number = Integer.parseInt(req.getParameter("number"));

        fruitDAO.addFruit(new fruit(0,name,price,number));

        resp.sendRedirect("/fruit");


    }
}
