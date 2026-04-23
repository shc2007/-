import java.io.*;
import java.util.ArrayList;
public class test4{
    public static void main(String []args)
    {
        String []s=getAllLinesFromFile("test4.txt");
        String outfile="test4o.txt";
        for(int i=0;i<s.length;i++)
        {
            String temp=s[i];
            int left=0;
            int right=temp.length()-1;
            boolean flag=true;
            while(left<right)
            {
                if(temp.charAt(left)!=temp.charAt(right))
                {
                    flag=false;
                }
                else{
                    left++;
                    right--;
                }
            }
            if(flag==true)
            {
                writeStringToFile(temp, outfile);
                writeStringToFile("\n", outfile);
            }
        }
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
    public static void writeStringToFile(String str, String fileName) {
		BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true), "UTF-8"));
            bw.write(str);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}