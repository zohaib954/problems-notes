package LLD.DesignPatterns.Creational.Builder;

public class Student {
    //All data members should be private;
    private int id;
    private String name;
    private String universityName;
    private int gradYear;
    private int psp;
    private int age;
    private String phoneNumber;

    //Constructor should be private so that without validating no one could intantiate the object
    private Student(int id, String name, String universityName, int gradYear, int psp, int age, String phoneNumber){
        this.id = id;
        this.name = name;
        this.universityName = universityName;
        this. gradYear = gradYear;
        this.psp = psp;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public static Builder builder(){
        return new Builder();
    }

    //This will take input and validate input and return object of student;
    public static class Builder {
        private int id;
        private String name;
        private String universityName;
        private int gradYear;
        private int psp;
        private int age;
        private String phoneNumber;

        public Builder id(int id){
            this.id = id;
            return this;
        }
        
        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder universityName(String universityName){
            this.universityName = universityName;
            return this;
        }

        public Builder gradYear(int gradYear){
            this.gradYear = gradYear;
            return this;
        }

        public Builder psp(int psp){
            this.psp = psp;
            return this;
        }

        public Builder age(int age){
            this.age = age;
            return this;
        }

        public Builder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }
        
        private void validate(){
            if(this.gradYear > 2023){
                throw new GradYearInvalidException();
            }
            if(this.age < 18){
                throw new InvalidAgeException();
            }
            if(this.name == null){
                throw new InvalidNameException();
            }
        }

        public Student build(){
            validate();
            return new Student(id, universityName, name, gradYear, psp, age, phoneNumber);
        }
    }

    @Override
    public String toString(){
        return "Student{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", universityName='" + universityName + '\'' +
        ", gradYear=" + gradYear +
        ", psp=" + psp +
        ", age=" + age +
        ", phoneNumber='" + phoneNumber + '\'' +
        '}';
    }
}