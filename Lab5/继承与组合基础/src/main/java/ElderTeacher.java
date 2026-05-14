public class ElderTeacher extends Teacher {
    private static ElderTeacher instance=null;
    private ElderTeacher(int age,Gender gender,Name name,String subject)
    {
        super(age, gender, name, subject);
    }
    public static ElderTeacher getInstance()
    {
        if(instance==null)
        {
            instance=new ElderTeacher(48, Person.Gender.MALE,new Name("Tom","Jerry"),"Computer Science");
        }
            return instance;
    }
    public static void main(String[] args) {
        ElderTeacher tea1=ElderTeacher.getInstance();
        ElderTeacher tea2=ElderTeacher.getInstance();
        ElderTeacher tea3=ElderTeacher.getInstance();
        System.out.println("tea1==tea2?"+(tea1==tea2));
        System.out.println("tea1==tea3?"+(tea1==tea3));
        System.out.println("tea2==tea3?"+(tea2==tea3));
    }
}
