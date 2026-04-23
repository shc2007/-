public class test1{
    public static void main(String []args)
    {
        String s=args[0];
        int k;
        k=s.indexOf("@");
        if(k==-1)
        {
            System.out.println("No");
        }
        else{
            System.out.println("Yes");
        }
    }
}