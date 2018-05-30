package dao;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class Credentials {

    private Map<String, String> credentials;

    @PostConstruct
    public void init(){
       credentials = new HashMap<>();
       credentials.put("root", "root");
    }

    public void add(String login, String pass){
        credentials.put(login, pass);
    }

    public void delete(String login){
        credentials.remove(login);
    }

    public String get(String login){
        return credentials.get(login);
    }

}
