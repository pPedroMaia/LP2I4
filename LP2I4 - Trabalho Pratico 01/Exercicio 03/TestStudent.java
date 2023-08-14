/*
* Pedro Henrique de Oliveira Maia dos Santos CB3013197  
*/

public class TestStudent {
    public static void main(String[] args) {
        Student classStudent = new Student("Douglas", "Rua Maria", "S", 20, 10);

        System.out.println(classStudent.toString());

        classStudent.setYear(29);
        classStudent.setAddress("Avenida Brasil");
        classStudent.setProgram("N");
        classStudent.setFee(10);

        System.out.println(classStudent.getYear());
        System.out.println(classStudent.getAddress());
        System.out.println(classStudent.getName());
        System.out.println(classStudent.getProgram());
        System.out.println(classStudent.getFee());

    }
}