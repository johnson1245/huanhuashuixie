package com.lsx.model;

import com.google.gson.Gson;
import com.lsx.util.DBUtil;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/*******************************************************************************
 * Copyright (c) 2005-2017 Gozap, Inc.
 * connectPro
 * com.lsx.model
 * Created by lishuxia on 2017/11/14 上午11:30.
 * Description: 
 *******************************************************************************/
public class SelectStu extends HttpServlet{

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp){
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;

        try {
            out = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        resp.setContentType("text/html");
        resp.setHeader("Cache-Control", "no-store");
        resp.setHeader("Pragma", "no-cache");
        resp.setDateHeader("Expires", 0);

        DBUtil db = new DBUtil();
        db.getConnection();
        String selectStr =  String.valueOf(req.getParameter("selectStr"));

        List result = db.selectMember(selectStr);
        Gson gson = new Gson();
        out.print(gson.toJson(result));
        db.close();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        processRequest(request, response);
    }
}