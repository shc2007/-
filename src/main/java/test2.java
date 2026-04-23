public class test2{
    public static void main(String []args)
    {
        String s=args[0];
        String []part=s.split("@");
        System.out.println(part[0]);
        System.out.println(part[1]);
    }
}