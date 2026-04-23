public class test7 {
    public static void main(String []args)
    {
       String s="102";
       System.out.println(Integer.parseInt(s));
       int k=Integer.parseInt(s);
       int left;
       String res1="";
       while(k>1)
        {
            int temp=k;
            k=k/2;
            left=temp%2;
            res1+=(char)(left+'0');
        }    
        if(k==1)
        {
            res1+='1';
        }
        String res="";
        for(int i=res1.length()-1;i>=0;i--)
        {
            res+=res1.charAt(i);
        }
        System.out.println(res);
}
}
