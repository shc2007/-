public class test3{
    public static void main(String []args)
    {
        String s=args[0];
        int k=s.lastIndexOf(".");
        if(k!=-1)
        {
            String subs=s.substring(k+1);
            System.out.println(subs);
        }

    }
}