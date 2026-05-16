
public abstract class Person{
    public enum  Gender
    {
        MALE,FEMALE;
    }
    private Name name;
    private int age;
    private Gender gender;

    public abstract void work();
    public Person(){
        this.name = new Name("tomie", "he");
    }
    public Person(int a,Gender g,Name n)
    {
        this.age=a;
        this.gender=g;
        this.name=n;
    }
    public Name getName()
    {
        return this.name;
    }
    public void setName(Name n)
    {
        this.name=n;
    }
    public void talk()
    {
        System.out.println("Hi, how is it going?");
    }
    public void talk(String topic)
    {
        System.out.println("Let's talk about "+topic);
    }
    public void chatWith(Person p,String topic)
    {
        String a=this.name.toString();
        String b=p.name.toString();
        System.out.printf(a+" to "+b);
        talk(topic);
    }
    @Override
    public String toString()
    {
        return name.toString()+","+age+","+gender;
    }
}
