package controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.QuizService;

@Controller
public class QuizController {

    @Autowired
    private QuizService quizService;


    @RequestMapping(method = RequestMethod.GET, value = "/quizzes")
    public String getQuizzes(Model model){
        model.addAllAttributes(quizService.getAll());
        return "quizzes";
    }

}
