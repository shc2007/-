public class test5{
    public static void main(String []args)
    {
        String s1=args[0];
        String s2=args[1];
        int i=s1.length()-1;
        int j=s2.length()-1;
        int carry=0;
        String res1="";
        while (i>=0 || j>=0 || carry>0){
            int sum=carry;
            if (i>=0){
                sum+=s1.charAt(i)-'0';
                i--;
            }
            
            if (j>=0){
                sum+=s2.charAt(j)-'0';
                j--;
            }
            res1+=(char)((sum%2)+'0');
            carry=sum/2;
        }
        String res="";
        for(int k=res1.length()-1;k>=0;k--)
        {
            res+=res1.charAt(k);
        }
        System.out.println(res);
    }
}