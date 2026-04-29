public class test9 {
    public static void main(String []args){
        String filename1=args[0];
        double []s1=StdAudio.read(filename1);
        double delay=Double.parseDouble(args[1]);
        double a=Double.parseDouble(args[2]);
        int k=Integer.parseInt(args[3]);
        double []out=new double[s1.length];
        int d=(int)Math.floor(delay*44100);
        for(int i=0;i<s1.length;i++)
        {
            double temp=s1[i];
            for(int j=0;j<k;j++)
            {
                if(i>=(j+1)*d)
                {
                double p=Math.pow(a, j+1);
                temp+=p*s1[i-(j+1)*d];
                }
            }
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
        StdAudio.save("t9.wav", out);
        StdAudio.play("t9.wav");
    }
}
