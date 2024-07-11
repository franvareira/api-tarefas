package Models;

import Utils.FileOperations;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"email","password"})
public class RealizarLoginModel {

    private final String email;
    private final String password;

    public RealizarLoginModel(){

        this.email= FileOperations.getProperties("UserData").getProperty("email");
        this.password=FileOperations.getProperties("UserData").getProperty("password");

    }

    public String getEmail() {

        return email;
    }

    public String getPassword() {
        return password;
    }

}
