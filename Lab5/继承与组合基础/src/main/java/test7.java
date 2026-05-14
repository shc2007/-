public class test7{
    public static void main(String[] args){
        Person p = new Student(18,Person.Gender.MALE,new Name("Tom", "Jerry"),"Computer Science"); 
        p.talk(); 
        p.talk("Math"); 
    }
    
}
