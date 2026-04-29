public class test1 {
    public static void main(String []args){
        String filename=args[0];
        double []s=StdAudio.read(filename);
        StdAudio.play(filename);
        System.out.println("閲囨牱鐐规暟閲忥細"+s.length);
        System.out.println("鏃堕暱锛堢锛?"+s.length/44100.0);
        double m=s[0];
        for(int i=1;i<s.length;i++)
        {
            if(m<s[i])
            {
                m=s[i];
            }
        }
        System.out.println("宄板€兼尟骞?"+m);
        System.out.println("rms = " + rms(s));
    }
    public static double rms(double[] s) {
        double sum = 0.0;
        for (double v : s) sum += v * v;
        return Math.sqrt(sum / s.length);
    }
}
