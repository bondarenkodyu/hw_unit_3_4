package servlets;

import model.Quiz;
import service.QuizService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "quizzesServlet", urlPatterns = "/quizzes")
public class QuizzesServlet extends HttpServlet{

//    QuizService service = new QuizService();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("quizzes", service.getAll());
//        req.getRequestDispatcher("quizzes.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        String desc = req.getParameter("desc");
//        String author = req.getParameter("author");
//        service.add(new Quiz(name, desc, author));
//        doGet(req, resp);
//    }
}
