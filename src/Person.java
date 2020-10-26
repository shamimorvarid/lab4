public class Person {
    private String firstName;
    private String lastName;
    public Person(String fName, String lName){
        firstName = fName;
        lastName = lName;

    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }

    public String toString(){
        return firstName + " " + lastName;
    }


}
