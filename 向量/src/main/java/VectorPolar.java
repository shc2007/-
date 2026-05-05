
public class VectorPolar {
    double radius,angle;
    public VectorPolar(double radius,double angle)
    {
        this.radius=radius;
        this.angle=Math.atan2(Math.sin(angle), Math.cos(angle));
    }
}
