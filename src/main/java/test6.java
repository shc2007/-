import java.io.*;
import java.util.ArrayList;
public class test6 {
    public static void main(String []args)
    {
        int i=0;
        String outputfile="6.txt";
        while (i<args.length) { 
            String inputfile=args[i];
            String [] sentences=getAllLinesFromFile(inputfile);
            int j=0;
            while(j<sentences.length)
            {
                writeStringToFile(sentences[j], outputfile);
                writeStringToFile("\n", outputfile);
                j++;
            }
            i++;
        }
        String [] standout=getAllLinesFromFile(outputfile);
        int k=0;
        while(k<standout.length)
        {
            System.out.println(standout[k]);
            k++;
        }
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
    public static String[] getAllLinesFromFile(String fileName) {
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