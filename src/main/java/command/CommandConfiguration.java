package command;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"dao.entities.mysqlImpl", "dao", "service", "command", "servlets"})
public class CommandConfiguration {

    @Bean(name = "login")
    public Command getLogin(){
        return new LoginCommand();
    }

    @Bean(name = "logout")
    public Command getLogout(){
        return new LogoutCommand();
    }

}
