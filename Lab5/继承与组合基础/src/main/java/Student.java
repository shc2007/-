
public class Student extends Person{
    private String major;
    public Student(int age, Gender gender, Name name, String major)
    {
        super(age, gender, name);
        this.major=major;
    }
    @Override
    public void talk()
    {
        System.out.println("Hi,how is your homework going?");
    }
    @Override
    public String toString()
    {
        return super.toString()+", Major: "+major;
    }
    
}
