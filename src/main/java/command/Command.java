package command;

import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public interface Command {

    void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException;

}
