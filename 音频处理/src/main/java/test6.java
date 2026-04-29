public class test6 {
    public static void main(String []args){
        String filename=args[0];
        double []s=StdAudio.read(filename);
        double fin=Double.parseDouble(args[1]);
        double fout=Double.parseDouble(args[2]);
        int t0,t1;
        t0=(int)Math.floor(fin*44100);
        t1=(int)Math.floor(fout*44100);
        double []out=new double[s.length];
        for(int i=0;i<s.length;i++)
        {
            double rat=1.0;
            if(i<t0)
            {
                rat=(double) i/t0;
            }
            else if(i>=s.length-t1)
            {
                rat=1.0-(double)((i-(s.length-t1))/t1);
            }
            out[i]=s[i]*rat;
        }
        StdAudio.save("t6.wav", out);
        StdAudio.play("t6.wav");
    }
}
