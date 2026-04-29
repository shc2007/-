public class test1 {
    public static void main(String []args){
        String filename=args[0];
        double []s=StdAudio.read(filename);
        StdAudio.play(filename);
        System.out.println("采样点数量："+s.length);
        System.out.println("时长（秒）："+s.length/44100.0);
        double m=s[0];
        for(int i=1;i<s.length;i++)
        {
            if(m<s[i])
            {
                m=s[i];
            }
        }
        System.out.println("峰值振幅："+m);
        System.out.println("rms = " + rms(s));
    }
    public static double rms(double[] s) {
        double sum = 0.0;
        for (double v : s) sum += v * v;
        return Math.sqrt(sum / s.length);
    }
}
