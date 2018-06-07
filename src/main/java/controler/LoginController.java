package controler;


import command.Command;
import command.LoginCommand;
import command.LogoutCommand;
import logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    private LoginCommand loginCommand;

    @Autowired
    private LogoutCommand logoutCommand;


    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public void loginLogout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stringCommand = req.getParameter("command");
        Log.writeInfo("Specified command {%s}", stringCommand);
        Command command = null;
        try {
            if ("login".equalsIgnoreCase(stringCommand)){
                command = loginCommand;
            } else {
                command = logoutCommand;
            }
            Log.writeInfo("Start execution of {%s} command", command);
            command.execute(req, resp);
            Log.writeInfo("Finish execution of {%s} command", command.toString());
        } catch (Exception e) {
            Log.writeError(e, "Unable to execute {%s} command", command);
        }
    }

}
