
public class VectorCart {
    private final double x,y;

    public VectorCart(double x,double y){
        this.x=x;
        this.y=y;
    }
    public VectorCart add(VectorCart v)
    {
        return new VectorCart(this.x+v.x, this.y+v.y);
    }
    public VectorCart subtract(VectorCart v)
    {
        return new VectorCart(this.x-v.x, this.y-v.y);
    }
    public VectorCart scale(double c)
    {
        return new VectorCart(this.x*c, this.y*c);
    }
    public double dot(VectorCart v)
    {
        return this.x*v.x+this.y*v.y;
    }
    public double cross(VectorCart v)
    {
        return this.x*v.y-this.y*v.x;
    }
    public double norm()
    {
        double len=Math.sqrt(x*x+y*y);
        return len;
    }
    public VectorCart normalize()
    {
        double len=norm();
        return new VectorCart(this.x/len, this.y/len);
    }
    public double angleTo(VectorCart v)
    {
        double n1=norm();
        double n2=v.norm();
        if(Math.abs(n1)<1e-7 || Math.abs(n2)<1e-7)
        {
            throw new ArithmeticException("零向量不能运算");
        }
        double cos=this.dot(v)/(n1*n2);
        return Math.acos(cos);
    }
    public double getX()
    {
        return this.x;
    }
    public double getY()
    {
        return this.y;
    }
    public boolean equals(VectorCart v)
    {
        return Math.abs(this.x-v.x)<1e-7 && Math.abs(this.y-v.y)<1e-7;
    }
    public String toString()
    {
        return String.format("(%.4f,%.4f)",x,y);
    }
    public VectorPolar toPolar()
    {
        double r=norm();
        double theta=Math.atan2(y, x);
        return new VectorPolar(r,theta);
    }
    public double angle()
    {
        return Math.atan2(y, x);
    }
    public double radius()
    {
        return Math.sqrt(x*x+y*y);
    }
    public VectorCart rotate(double alpha)
    {
        double r=radius();
        double theta=angle();
        double newTheta=theta+alpha;
        return new VectorCart(r*Math.cos(newTheta),r*Math.sin(newTheta));
    }
     public VectorCart projectOnto(VectorCart v) 
     {
        if (v.x==0 && v.y==0){
            throw new ArithmeticException("零向量不可运算");
        }
        double dot=this.dot(v);
        double vNormSq=v.dot(v);
        double scalar=dot/vNormSq;
        return v.scale(scalar);
    }
}