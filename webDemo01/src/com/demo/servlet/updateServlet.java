package com.demo.servlet;

import com.demo.dao.FruitDAO;
import com.demo.dao.impl.FruitDAOImpl;
import com.demo.pojo.fruit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update.do")
public class updateServlet extends ViewBaseServlet{

    FruitDAO fruitDAO = new FruitDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String name = req.getParameter("name");
        int  price = Integer.parseInt(req.getParameter("price"));
        int number = Integer.parseInt(req.getParameter("number"));
        int uid = Integer.parseInt(req.getParameter("uid"));

        fruit fru = new fruit(uid,name,price,number);

        fruitDAO.updateFruitListById(fru);

        resp.sendRedirect("/fruit");
    }
}
