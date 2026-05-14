public class test6{
    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0]=new Person(18, Person.Gender.MALE, new Name("Jerry","Tom"));
        people[1]=new Student(20, Person.Gender.FEMALE, new Name("Alice", "Smith"), "Computer Science");
        people[2]=new Teacher(35, Person.Gender.MALE, new Name("Bob", "Johnson"), "Mathematics");
        for(Person temp:people)
        {
            temp.talk();
        }
    }
}
