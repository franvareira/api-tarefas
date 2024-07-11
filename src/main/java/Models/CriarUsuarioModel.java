package Models;

import Utils.FileOperations;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CriarUsuarioModel {

    private final String email;
    private final String password;
    private final String passwordConfirmation;



    public CriarUsuarioModel(){

        this.email= FileOperations.getProperties("UserData").getProperty("email");
        this.password=FileOperations.getProperties("UserData").getProperty("password");
        this.passwordConfirmation=FileOperations.getProperties("UserData").getProperty("passwordConfirmation");

    }

    public String getEmail() {

        return email;
    }
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password_confirmation")
    public String getPasswordConfirmation() {

        return passwordConfirmation;
    }



}
