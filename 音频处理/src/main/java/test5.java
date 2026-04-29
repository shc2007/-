public class test5 {
    public static void main(String []args){
        String filename=args[0];
        double t0=Double.parseDouble(args[1]);
        double t1=Double.parseDouble(args[2]);
        int s0,s1;
        s0=(int)Math.floor(t0*44100);
        s1=(int)Math.floor(t1*44100);
        double []s=StdAudio.read(filename);
        if(s1>s.length)
        {
            s1=s.length;
        }
        int outlen=s1-s0;
        double []out=new double[outlen];
        for(int i=0;i<outlen;i++)
        {
            out[i]=s[i+s0];
        }
        StdAudio.save("t5.wav", out);
        StdAudio.play("t5.wav");
    }
}
