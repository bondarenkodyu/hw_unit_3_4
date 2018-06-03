package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginService {


    public LoginService() {
    }

    public boolean isRegistered(String login, String pass){
        String savedPass = null;
        return Objects.nonNull(savedPass) && savedPass.equals(pass);
    }

}
