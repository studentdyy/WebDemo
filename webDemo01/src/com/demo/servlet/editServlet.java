package com.demo.servlet;

import com.demo.dao.FruitDAO;
import com.demo.dao.impl.FruitDAOImpl;
import com.demo.pojo.fruit;
import com.demo.until.StringUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit.do")
public class editServlet extends ViewBaseServlet {

    FruitDAO fruitDAO = new FruitDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uidStr = req.getParameter("uid");
        if(StringUtil.isNotEmpty(uidStr)){
            int uid = Integer.parseInt(uidStr);
            fruit fru = fruitDAO.getFruitListById(uid);
            req.setAttribute("fruit",fru);
            super.processTemplate("edit",req,resp);
        }

    }
}
