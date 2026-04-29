public class test8 {
    public static void main(String []args){
        String filename1=args[0];
        String filename2=args[1];
        double []s1=StdAudio.read(filename1);
        double []s2=StdAudio.read(filename2);
        double alpha=Double.parseDouble(args[2]);
        double beta=Double.parseDouble(args[3]);
        double []out=new double[Math.max(s2.length, s1.length)];
        for(int i=0;i<Math.max(s2.length, s1.length);i++)
        {
            double temp=alpha*s1[i]+beta*s2[i];
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
        StdAudio.save("t7new.wav", out);
        StdAudio.play("t7new.wav");
    }
}
