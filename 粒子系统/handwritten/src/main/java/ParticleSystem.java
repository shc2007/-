import java.util.ArrayList;
import java.util.Iterator;
public class ParticleSystem{
    private ArrayList<Particle> particles;
    private double dt;
    private double runtime;
    private double elapsedTime;
    private double emissionTimer;
    private double emissionRate;
    private double fountainX=0.5;
    private double fountainY=0.05;
    private double gravity=9.8;
    private void setupCanvas() 
    {
        StdDraw.setXscale(-0.1, 1.1);
        StdDraw.setYscale(-0.1, 1.1);
        StdDraw.enableDoubleBuffering();
    }
    public ParticleSystem(double dt,double runtime,int cnt)
    {
        this.particles=new ArrayList<>();
        this.dt=dt;
        this.runtime=runtime;
        this.emissionRate=cnt;
        this.emissionTimer=0;
        setupCanvas();
    }
    private void emitaParticle()
    {
        double base=90.0;
        double spread=30.0;
        double angleDeg=base+(Math.random()-0.5)*spread;
        double angleRad=Math.toRadians(angleDeg);
        double baseSpeed=3.0;
        double speed=baseSpeed*(0.85+Math.random()*0.3);
        double vx=speed*Math.cos(angleRad);
        double vy=speed * Math.sin(angleRad);
        double radius=0.006+Math.random()*0.008;
        int r=50+(int)(Math.random()*80);  
        int g=100+(int)(Math.random()*100);
        int b=200 + (int)(Math.random()*55); 
        double life=0.8+Math.random()*0.7;
        double alpha=150+Math.random()*70;
        Particle p = new Particle(fountainX, fountainY, vx, vy, 0, -gravity,life, radius, r, g, b, alpha);
        particles.add(p);
    }
    private void updateParticles() {
        Iterator<Particle> iterator=particles.iterator();
        while(iterator.hasNext()) 
        {
            Particle p=iterator.next();
            p.update(dt);
            if (!p.isalive()) 
            {
                iterator.remove();
            }
        }
    }
    private void drawParticles() 
    {
        for(Particle p:particles){
            p.draw();
        }
    }
    public void run() {
        long lastTime=System.nanoTime();
        while(elapsedTime<runtime) 
        {
            emissionTimer+=dt;
            double emissionInterval=1.0/emissionRate;
            while(emissionTimer>=emissionInterval && particles.size() < 10000) {
                emitaParticle();
                emissionTimer-=emissionInterval;
            }
            updateParticles();
            StdDraw.clear();
            drawParticles();
            StdDraw.show();
            try {
                long now=System.nanoTime();
                long elapsed=now-lastTime;
                long targetTime=(long)(dt*1e9);
                if (elapsed<targetTime){
                    Thread.sleep((targetTime-elapsed)/1_000_000);
                }
                lastTime=System.nanoTime();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            elapsedTime+=dt;
        }
    }
    public static void main(String[] args) {
        double dt=0.016;
        double runtime=5.0;
        int emissionRate=50;
        if(args.length>0){
            try{
                emissionRate = Integer.parseInt(args[0]);
            } catch (NumberFormatException e){
                System.out.println("Invalid emission rate, using default: 50");
            }
        }
        if(args.length>1){
            try{
                dt=Double.parseDouble(args[1]);
            } catch(NumberFormatException e){
                System.out.println("Invalid dt, using default: 0.016");
            }
        }
        if(args.length>2){
            try {
                runtime=Double.parseDouble(args[2]);
            } catch(NumberFormatException e) {
                System.out.println("Invalid runtime, using default: 5.0");
            }
        }
        ParticleSystem ps=new ParticleSystem(dt, runtime, emissionRate);
        ps.run();
    }
}
