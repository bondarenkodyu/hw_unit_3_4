package service;

import dao.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private Credentials credentials;

    public RegistrationService() {
    }

    public void addNew(String login, String pass){
        credentials.add(login, pass);
    }

}
