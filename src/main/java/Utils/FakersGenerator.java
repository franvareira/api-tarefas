package Utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakersGenerator {

    private String email;
    private String name;
    private String lastName;
    private final Faker faker;

    public FakersGenerator(){

       faker = new Faker(new Locale("pt-BR"));
    }

    public  String setEmail(){

        String email= faker.internet().emailAddress();
        FileOperations.setProperties("UserData","email",email);
        return email;
    }

    public String getName(){

        String name = faker.name().firstName();
        return name;

    }


}
