package LLD.DesignPatterns.Creational.Builder;

public class Main {
    public static void main(String[] args) {
        Student s = Student.builder().age(23)
                    .gradYear(2024)
                    .name("Zohaib")
                    .id(10)
                    .universityName("VTU")
                    .phoneNumber("99999999")
                    .psp(100)
                    .build();
        System.out.println(s);
    }
}
