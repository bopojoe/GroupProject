package project;

/**
 * @author Kevin Power 20075681 | 24/11/17
 */


public class Actor {
    private String name;
    private int age;
    private String gender;
    private String nationality;


    // constructor
    public Actor(String name, int age, String gender, String nationality) {
        this.name = sanitizeName(name);
        this.age = age;
        this.gender = gender;
        this.nationality = nationality;
    }


    public String getName() {
        return name;
    }

    private String sanitizeName(String name) {

        if (name.length() > 30) {
            return name.substring(0, 30);
        } else {
            return name;
        }
    }

    public void setName(String name) {
        this.name = sanitizeName(name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }


    @Override
    public String toString() {
        String str = "Actor info:[name:" + getName() + ", " + "age:" + getAge() + ", " + "gender: " + getGender() + ", " + "nationality: " + getNationality() + "] \n";
        return str;
    }


}


