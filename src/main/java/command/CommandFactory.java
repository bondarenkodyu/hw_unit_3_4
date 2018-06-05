package command;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CommandFactory {

    private AnnotationConfigApplicationContext context;

    @PostConstruct
    public void init(){
        context = new AnnotationConfigApplicationContext(CommandConfiguration.class);
        context.refresh();
    }

    public Command create(String key){
        return (Command) context.getBean(key);
    }
}
