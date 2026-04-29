public class test3 {
    public static void main(String []args){
        String filename=args[0];
        double k=1.0;
        double []s=StdAudio.read(filename);
        double peak=0.0;
        double []out=new double[s.length];
        for(int j=0;j<s.length;j++)
        {
            double temp=Math.abs(s[j]);
            if(peak<temp)
            {
                peak=temp;
            }
        }
        if(peak==0.0)
        {
            ;
        }
        else{
            k=0.99/peak;
        }
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
        StdAudio.save("t3.wav", out);
        //StdAudio.play("t3.wav");
    }
}
