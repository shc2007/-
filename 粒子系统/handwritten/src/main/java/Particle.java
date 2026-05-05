import java.awt.Color;
public class Particle{
    private double x,y;
    private double vx,vy;
    private double ax,ay;
    private double life,maxlife;
    private double radius;
    private int red,green,blue;
    private double alpha;
    public Particle(double x, double y, double vx, double vy, double ax, double ay,double life, double radius, int r, int g, int b, double alpha) 
    {
        this.x=x;
        this.y=y;
        this.vx=vx;
        this.vy=vy;
        this.ax=ax;
        this.ay=ay;
        this.life=life;
        this.maxlife=life;
        this.radius=radius;
        this.red=r;
        this.green=g;
        this.blue=b;
        this.alpha=alpha;
    }
    public void update(double dt)
    {
        vx+=ax*dt;
        vy+=ay*dt;
        x+=vx*dt;
        y+=vy*dt;
        life-=dt;
    }
    public boolean isalive()
    {
        return life>0;
    }
    public void draw()
    {
        int calpha=(int)(alpha*life/maxlife);
        Color color=new Color(red,green,blue, calpha);
        StdDraw.setPenColor(red,green,blue);
        StdDraw.filledCircle(x, y, radius);
    }
}
