package edu.acc.jweb.cats2;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CatServlet", urlPatterns = {"/main"})
public class CatServlet extends HttpServlet {
    
    private ArrayList<Cat> cats = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {        
        if (cats.isEmpty()) {
            cats = getCats();
        }
        String choice = request.getParameter("choice");
        if (choice == null) {
            request.setAttribute("cats", cats);
            getServletContext().getRequestDispatcher("/WEB-INF/views/menu.jsp").forward(request, response);
        }
        else {
            Cat cat = findCat(choice);
            request.setAttribute("cat", cat);
            getServletContext().getRequestDispatcher("/WEB-INF/views/cat.jsp").forward(request, response);
        }
    }
    
    private Cat findCat(String choice) {
        for (Cat cat : cats) {
            if (choice.equals(cat.color)) {
                return cat;
            } 
        }
        return null;
    }

    private ArrayList<Cat> getCats() {
        Cat cat = new Cat("Calico","/Cats2/images/calico.jpg");
        this.cats.add(cat);
        cat = new Cat("Gray Tabby","/Cats2/images/graytabby.jpg");
        this.cats.add(cat);
        cat = new Cat("Tuxedo","/Cats2/images/tuxedo.jpg");
        this.cats.add(cat);
        return cats;
    }
    
}
