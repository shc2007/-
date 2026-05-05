import java.math.BigInteger;
import  java.util.ArrayList;
import java.util.List;
public class test2{
    public static void main(String[] args) {
        BigRational res1=hnum(10);
        String res=res1.toDecimal(10);
        System.out.println("n=10:调和级数"+res);
        int []a=new int[10];
        a[0]=1;
        for(int i=1;i<10;i++)
        {
            a[i]=2;
        }
        List<BigRational> res2=fnum(a);
        System.out.println("根号2连分数:"+res2);
        int []b=new int[10];
        b[0]=2;
        int k=1;
        for (int i=1;i<10;i++) {
            if(i%3==1) 
            {
                b[i]=1;
            } 
            else if(i%3==2) 
            {
                b[i]=2*k;
                k++;
            } 
            else
            {
                b[i]=1;
            }
        }
        List<BigRational> res3=fnum(b);
        System.out.println("e连分数:"+res3);
    }
    public static BigRational hnum(int n)
    {
        BigRational sum=new BigRational();
        for(int i=1;i<=n;i++)
        {
            BigRational temp=new BigRational(BigInteger.ONE,BigInteger.valueOf(i));
            sum=sum.add(temp);
        }
        return sum;
    }
    public static List<BigRational> fnum(int []a)
    {
        List<BigRational> res=new ArrayList<>();
        BigInteger pPrev2=BigInteger.ZERO;
        BigInteger pPrev1=BigInteger.ONE;
        BigInteger qPrev2=BigInteger.ONE;
        BigInteger qPrev1=BigInteger.ZERO;
        for (int i=0;i<a.length;i++) {
            BigInteger ai=BigInteger.valueOf(a[i]);
            BigInteger pCurr=ai.multiply(pPrev1).add(pPrev2);
            BigInteger qCurr=ai.multiply(qPrev1).add(qPrev2);
            BigRational temp=new BigRational(pCurr, qCurr);
            res.add(temp);
            pPrev2=pPrev1;
            pPrev1=pCurr;
            qPrev2=qPrev1;
            qPrev1=qCurr;
        }
        return res;
    }
}
