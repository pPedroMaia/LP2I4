/*
* Pedro Henrique de Oliveira Maia dos Santos CB3013197  
*/

public class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {

        String personFormat = String.format("Person[name=%s, address=%s]", this.name, this.address);

        return personFormat;
    }
}