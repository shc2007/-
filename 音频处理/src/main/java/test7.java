public class test7 {
    public static void main(String []args){
        String filename=args[0];
        double []s=StdAudio.read(filename);
        double delay=Double.parseDouble(args[1]);
        double a=Double.parseDouble(args[2]);
        double []out=new double[s.length];
        int d=(int)Math.floor(delay*44100);
        for(int i=0;i<s.length;i++)
        {
            if(i-d>=0)
            {
            double temp=s[i]+a*s[i-d];
            if(temp>1.0)
            {
                out[i]=1.0;
            }
            else if(temp<-1.0)
            {
                out[i]=-1.0;
            }
            else
            {
                out[i]=temp;
            }
            }
            else{
                out[i]=s[i];
            }
        }
        StdAudio.save("t7new.wav", out);
        StdAudio.play("t7new.wav");
    }
}
