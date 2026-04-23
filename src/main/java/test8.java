import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class test8{
    public static void main(String []args)
    {
       String inputfile="7.txt";
       String [] inpuStrings=getAllLinesFromFile(inputfile);
       int maxn=inpuStrings[0].length(),minn=inpuStrings[0].length();
       for(int i=1;i<inpuStrings.length;i++)
       {
        if(inpuStrings[i].length()>maxn)
        {
            maxn=inpuStrings[i].length();
        }
        if(inpuStrings[i].length()<minn)
        {
            minn=inpuStrings[i].length();
        }
       }
       System.out.println(maxn);
       System.out.println(minn);
    }
     public static String[] getAllLinesFromFile(String fileName){
        int numLines = 0;
        BufferedReader br = null;
        ArrayList<String> strList = new ArrayList<String>();
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));

            String temp = null;
            while((temp = br.readLine()) != null){  
                strList.add(temp);
            }
            numLines = strList.size();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String[] res = new String[numLines];
        for(int i  = 0; i < numLines; i++) {
            res[i] = strList.get(i);
        }
		return res;
	}
}
