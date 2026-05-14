
import java.util.Random;

public class PersonFactory {

    private static final String[] FIRST_NAMES = {"Alice","Bob","Charlie","Diana","Eve","Frank","Grace"};
    private static final String[] LAST_NAMES = {"Smith","Johnson","Williams","Brown","Jones","Garcia","Miller"};
    private static final String[] MAJORS = {"Computer Science", "Mathematics", "Physics", "Literature", "History"};
    private static final String[] SUBJECTS = {"Algorithms", "Calculus", "Quantum Mechanics", "English", "World History"};

    public static Person createRandomPerson(){
        Random random=new Random();
        String firstName=FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String lastName=LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        Name name=new Name(firstName, lastName);
        Person.Gender gender=random.nextBoolean() ? Person.Gender.MALE : Person.Gender.FEMALE;
        int age=18+random.nextInt(30);
        if(random.nextBoolean())
        {
            String major=MAJORS[random.nextInt(MAJORS.length)];
            return new Student(age,gender,name,major);
        } else 
            {
            String subject=SUBJECTS[random.nextInt(SUBJECTS.length)];
            return new Teacher(age,gender,name,subject);
        }
    }
}
