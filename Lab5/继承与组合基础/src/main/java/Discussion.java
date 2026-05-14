
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Discussion {
    private List<Person> talker;
    public Discussion()
    {
        this.talker=new ArrayList<>();
    }
    public void addPerson(Person p)
    {
        talker.add(p);
    }
    public void broadcast()
    {
        Random random=new Random();
        int k=random.nextInt(talker.size());
        Person p=talker.get(k);
        for(Person temp:talker)
        {
            if(temp!=p)
            {
                p.chatWith(temp, "Computer Science");
            }
        }
    }
}
