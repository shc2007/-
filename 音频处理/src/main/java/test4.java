public class test4 {
    public static void main(String []args){
        String filename=args[0];
        double []s=StdAudio.read(filename);
        double []out=new double[s.length];
        for(int i=0;i<s.length;i++)
        {
            out[i]=s[s.length-1-i];
        }
        StdAudio.save("t4new.wav", out);
        StdAudio.play("t4new.wav");
    }
}
