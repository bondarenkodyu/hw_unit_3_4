package service;


import org.springframework.stereotype.Service;

@Service
public class LoginService {


    public LoginService() {
    }

    public boolean isRegistered(String login, String pass){
        String savedPass = "root";
        String user = "root";
        return user.equals(login) && savedPass.equals(pass);
    }

}
