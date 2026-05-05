
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
public class BigRational{
    private BigInteger numerator,denominator;
    public BigRational() {
        numerator=BigInteger.ZERO;
        denominator=BigInteger.ONE;
    }
    public BigRational(BigInteger num,BigInteger den)
    {
        this.numerator=num;
        this.denominator=den;
    }
    private static BigRational normalize(BigInteger num,BigInteger den)
    {
        if(num.equals(BigInteger.ZERO))
        {
            BigRational temp=new BigRational(BigInteger.ZERO, BigInteger.ONE);
            return temp;
        }
        if(den.signum()<0)
        {
            num=num.negate();
            den=den.negate();
        }
        BigInteger gcd=num.gcd(den);
        if(!gcd.equals(BigInteger.ONE))
        {
            num=num.divide(gcd);
            den=den.divide(gcd);
        }
        return new BigRational(num,den);
    }
    public BigRational(String s)
    {
        if(s.contains("/"))
        {
        String []parts=s.split("/");
        BigInteger num=new BigInteger(parts[0].trim());
        BigInteger den=new BigInteger(parts[1].trim());
        BigRational temp=normalize(num,den);
        this.numerator=temp.numerator;
        this.denominator=temp.denominator;
        }
        else if(s.contains("."))
        {
            int index=s.indexOf(".");
            String s1=s.substring(0,index);
            String s2=s.substring(index+1);
            String temp=s1+s2;
            BigInteger num=new BigInteger(temp);
            BigInteger den=BigInteger.TEN.pow(s2.length());
            BigRational temp1=normalize(num, den);
            this.numerator=temp1.numerator;
            this.denominator=temp1.denominator;
        }
        else
        {
            BigInteger num=new BigInteger(s);
            BigRational temp=normalize(num, BigInteger.ONE);
            this.numerator=temp.numerator;
            this.denominator=temp.denominator;
        }
    }
    public BigRational add(BigRational x)
    {
        BigInteger num=this.numerator.multiply(x.denominator).add(this.denominator.multiply(x.numerator));
        BigInteger den=this.denominator.multiply(x.denominator);
        return normalize(num, den);
    }
    public BigRational subtract(BigRational x)
    {
        BigInteger num=this.numerator.multiply(x.denominator).subtract(this.denominator.multiply(x.numerator));
        BigInteger den=this.denominator.multiply(x.denominator);
        return normalize(num, den);
    } 
    public BigRational multiply(BigRational x)
    {
        BigInteger num=this.numerator.multiply(x.numerator);
        BigInteger den=this.denominator.multiply(x.denominator);
        if(num.equals(BigInteger.ZERO))
        {
            return new BigRational(BigInteger.ZERO,BigInteger.ONE);
        }
        return normalize(num, den);
    }
    public BigRational divide(BigRational x)
    {
        BigInteger num=this.numerator.multiply(x.denominator);
        BigInteger den=this.denominator.multiply(x.numerator);
        if(num.equals(BigInteger.ZERO))
        {
            return new BigRational(BigInteger.ZERO, BigInteger.ONE);
        }
        return normalize(num, den);
    }
    public int compare(BigRational x)
    {
        BigInteger num1=this.numerator.multiply(x.denominator);
        BigInteger num2=x.numerator.multiply(denominator);
        return num1.compareTo(num2);
    }
    public boolean equals(BigRational x)
    {
        return this.numerator.equals(x.numerator) && this.denominator.equals(x.denominator);
    }
    public String toString()
    {
        if(denominator.equals(BigInteger.ONE))
        {
            return numerator.toString();
        }
        return numerator+"/"+denominator;
    }
    public String toDecimal(int digits)
    {
        BigDecimal num=new BigDecimal(this.numerator);
        BigDecimal den=new BigDecimal(this.denominator);
        BigDecimal res=num.divide(den,digits,RoundingMode.HALF_UP);
        String plain=res.toPlainString();
        if(!plain.contains("."))
        {
            plain=plain+"."+"0".repeat(digits);
        }
        else
        {
            int len=plain.length()-plain.indexOf(".")-1;
            if(len<digits)
            {
                plain=plain+"0".repeat(digits-len);
            }
        }
        return plain;
    }
    
}