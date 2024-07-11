package Models;

import Utils.FakersGenerator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CriarContatoModel {

    private String name;
    private String lastName;
    private String email;
    private String age;
    private String phone;
    private String address;
    private String state;
    private String city;

    private FakersGenerator faker = new FakersGenerator();

    public CriarContatoModel(){

        this.name = faker.getName();
        this.lastName = "Automation DB";
        this.email = faker.setEmail();
        this.age = "32";
        this.phone = "99997788";
        this.address = "Rua Nova DBServer";
        this.state = "Rio Grande do Sul";
        this.city = "Porto Alegre";
    }

    public String getName() {
        return name;
    }

    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

}
