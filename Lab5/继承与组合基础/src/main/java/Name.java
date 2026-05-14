
public class Name{
    private String firstName,lastName;
    public static void main(String[] args){
        Name name=new Name();
        System.out.println(name.firstName);
        System.out.println(name.lastName);
    }
    public Name() {
        firstName="Unknown";
        lastName="Unknown";
    }
    public Name(String f, String l) 
    {
        this.firstName=f;
        this.lastName=l;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String f)
    {
        firstName=f;
    }
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String l)
    {
        lastName=l;
    }
    @Override
    public String toString()
    {
        String res;
        res=this.firstName+" "+this.lastName;
        return res;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this==obj) return true;
        if (obj==null || getClass()!=obj.getClass()) return false;
        Name name=(Name) obj;
        return firstName.equals(name.firstName) &&
               lastName.equals(name.lastName);
    }
    
}