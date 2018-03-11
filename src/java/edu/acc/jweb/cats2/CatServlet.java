/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.acc.jweb.cats2;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gene
 */
@WebServlet(name = "CatServlet", urlPatterns = {"/main"})
public class CatServlet extends HttpServlet {
    
    private ArrayList<Cat> cats = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {        
        req.setAttribute("color", "calico");
        getServletContext().getRequestDispatcher("/WEB-INF/views/cat.jsp").forward(req, resp);
        
        if (cats == null) {
            cats = getCats();
        }
    }

    private ArrayList<Cat> getCats() {
        Cat cat = new Cat("calico","/WEB-INF/images/calico.jpg");
        this.cats.add(cat);
        return cats;
    }
    
}
