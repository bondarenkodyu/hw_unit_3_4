package service;

import dao.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginService {

    @Autowired
    private Credentials credentials;

    public LoginService() {
    }

    public boolean isRegistered(String login, String pass){
        String savedPass = getCredentials().get(login);
        return Objects.nonNull(savedPass) && savedPass.equals(pass);
    }

    public Credentials getCredentials() {
        return credentials;
    }

}
