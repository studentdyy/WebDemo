package com.demo.servlet;

import com.demo.dao.FruitDAO;
import com.demo.dao.impl.FruitDAOImpl;
import com.demo.pojo.fruit;
import com.demo.until.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/fruit")
public class fruitServlet extends ViewBaseServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    FruitDAO fruitDAO = new FruitDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int pageNum = 1;
        HttpSession session = req.getSession();


        String flag = req.getParameter("flag");
        String keyWord = null;
        if(StringUtil.isNotEmpty(flag) && "search".equals(flag)){
            //点击了查询按钮并且字符不为空，说明调用查询方法
            //设置回第一页
            pageNum = 1;
            keyWord = req.getParameter("keyWord");
            if(StringUtil.isEmpty(keyWord)){
                keyWord="";
            }
            session.setAttribute("keyWord",keyWord);
        }else{
            //否则就是正常的分页展示
            //此时keyWord应该从session作用域获取,为了让keyWord显示在搜索框内

            String pageNumStr = req.getParameter("pageNum");
            if(StringUtil.isNotEmpty(pageNumStr)){
                pageNum = Integer.parseInt(pageNumStr);
            }
            Object keyWordObj = session.getAttribute("keyWord");
            //第一次输入网址keyWord为null，所以要判断
            if(keyWordObj != null){
                keyWord = (String) keyWordObj;
            }else{
                keyWord="";
            }
        }




        List<fruit> fruitList = fruitDAO.getFruitListByPageNum(keyWord,pageNum);

        //总记录条数
        int count = (fruitDAO.getFruitCount(keyWord)).intValue();
        //总页数
        int pageCount = (count+5 - 1)/5;

        session.setAttribute("pageCount",pageCount);
        session.setAttribute("fruitList",fruitList);
        //更新当前页的值
        session.setAttribute("pageNum",pageNum);

        super.processTemplate("fruitListIndex",req,resp);

    }
}
