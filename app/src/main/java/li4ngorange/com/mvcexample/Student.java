package li4ngorange.com.mvcexample;

import java.io.Serializable;

/**
 * Created by liangorange on 10/20/15.
 */
// Java Bean
public class Student implements Serializable {

    private String name;
    private String number;
    private String gender;

    public Student() {
        this.name = "Johnny";
        this.number = "12345-54321";
        this.gender = "male";
    }

    public Student(String name, String number, String gender) {

        this.name = name;
        this.number = number;
        this.gender = gender;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
