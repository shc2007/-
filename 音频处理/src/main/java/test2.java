public class test2 {
    public static void main(String []args){
        String filename=args[0];
        double k=Double.parseDouble(args[1]);
        double []s=StdAudio.read(filename);
        double []out=new double[s.length];
        for(int i=0;i<s.length;i++)
        {
            double temp=k*s[i];
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
        StdAudio.save("out.wav",out);
        StdAudio.play("out.wav");
    }
}
