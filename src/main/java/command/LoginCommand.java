package command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Service
public class LoginCommand implements Command{

    @Autowired
    private LoginService loginService;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter("login");
        String pass = req.getParameter("password");
        if(loginService.isRegistered(login, pass)){
            HttpSession session = req.getSession();
            session.setAttribute("user", login);
            resp.sendRedirect("quizzes");
        } else {
            resp.sendRedirect("registration.jsp");
        }
    }

    @Override
    public String toString() {
        return "LoginCommand";
    }
}
