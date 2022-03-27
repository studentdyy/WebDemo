package com.demo.servlet;

import com.demo.dao.FruitDAO;
import com.demo.dao.impl.FruitDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/delete.do")
public class deleteServlet extends ViewBaseServlet{

    FruitDAO fruitDAO = new FruitDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uid = Integer.parseInt(req.getParameter("uid"));
        if(uid!=0){
            fruitDAO.deleteFruitById(uid);

            resp.sendRedirect("/fruit");
        }

    }
}
