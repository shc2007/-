import java.io.*;
import java.util.*;
public class Clean{
    private static boolean printstats=false;
    private static PrintWriter logwriter=null;
    private static int totallines=0;
    private static int goodlines=0;
    private static int badlines=0;
    public static void main(String []args)
    {
        String inputfile=null;
        String outputfile=null;
        String badfile=null;
        String mode="clean";
        String format="formal";
        boolean dedup=false;
        String logfile=null;
        for(int i=0;i<args.length;i++)
        {
            switch(args[i])
            {
                case"-i":
                {
                    if(i+1<args.length) inputfile=args[++i];
                    break;
                }
                case"-o":
                {
                    if(i+1<args.length) outputfile=args[++i];
                    break;
                }
                case"--bad":
                {
                    if(i+1<args.length) badfile=args[++i];
                    break;
                }
                case"--mode":
                {
                    String m=args[++i];
                    if (!m.equals("clean") && !m.equals("emails"))
                    {
                        System.out.println("错误：--mode 只能是 clean 或 emails");
                        System.exit(1);
                    }
                    mode=m;
                    break;
                }
                case"--format":
                {
                    if(i+1<args.length) format=args[++i];
                    break;
                }
                case"--dedup":
                {
                    dedup=true;
                    break;
                }
                case"--log":
                {
                    if(i+1<args.length) logfile=args[++i];
                    break;
                }
                case"--stats":
                {
                    printstats=true;
                    break;
                }
                default:
                    System.out.println("未知参数");
                    System.exit(1);
            }
        }
        if(inputfile==null)
        {
            System.out.println("未知参数");
                    System.exit(1);
        }
        initlog(logfile);
        log("输入文件"+inputfile);
        log("模式"+mode+","+"格式"+format+","+"去重"+dedup);
        String[] lines=getAllLinesFromFile(inputfile);
        totallines=lines.length;
        log("读取到"+totallines+"行");
        List<String> goodResults=new ArrayList<>();
        List<String> badResults=new ArrayList<>();
        Set<String> email=new LinkedHashSet<>();
        for(int i=0;i<lines.length;i++)
        {
            String line=lines[i];
            ProcessResult result=processline(line, mode, format);
            if(result.isGood)
            {
                goodlines++;
                if("clean".equals(mode))
                {
                    goodResults.add(result.formattedLine);
                }
            else if("emails".equals(mode))
            {
                if(!dedup)
                {
                    goodResults.add(result.emails);
                }
                else{
                    email.add(result.emails);
                }
            }
            log("第"+(i+1)+"行:合法 "+result.formattedLine);
            }
            else{
                badlines++;
                badResults.add(line);
                log("第"+(i+1)+"行:不合法 "+result.errorReason);
            }
        }
        if("emails".equals(mode) && dedup)
        {
            goodResults.addAll(email);
        }
        if(outputfile!=null)
        {
            writeLinesToFile(goodResults, outputfile);
            log("好数据已写入");
        }
        else
        {
            for(String line:goodResults)
            {
                System.out.println(line);
            }
        }
        if(badfile!=null && !badResults.isEmpty())
        {
            writeLinesToFile(badResults, badfile);
            log("坏数据已写入");
        }
        if(printstats)
        {
            printStatistics();
        }
        log("程序结束，总行数"+totallines+",好行:"+goodlines+",坏行:"+badlines);
        closeLog();
    }
    public static void initlog(String logfile)
    {
        if(logfile!=null)
        {
            try {
                logwriter=new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(logfile),"UTF-8")));

            } catch (IOException e) {
                System.out.println("日志创建错误");
            }
        }
    }
    public static void log(String ms)
    {
        if(logwriter!=null)
        {
        logwriter.println(new Date()+ms);
        logwriter.flush();
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
    static class ProcessResult{
        boolean isGood=false;
        String formattedLine="";
        String emails="";
        String errorReason="";
    }
    public static String[] splitline(String line)
    {
        String []parts=line.split("[,;|]+");
        for(int i=0;i<parts.length;i++)
        {
            parts[i]=parts[i].trim();
        }
        return parts;
    }
    public static String cleanstr(String string)
    {
        if(string==null)
        {
            return "";
        }
        return string.trim().replaceAll("\\s+", " ");
    }
    public static boolean judgment(String jud)
    {
        if (!jud.matches("[a-zA-Z0-9@.]+"))
        {
            return false;
        }
        int k1=jud.indexOf("@");
       int k2=jud.indexOf("@",k1+1);
       if(k1==-1 || k2!=-1)
       {
        return false;
       }
        if(k1==0 || k1==jud.length()-1)
        {
            return false;
        }
        String subs1=jud.substring(0,k1);
        String subs2=jud.substring(k1+1);
        if(!subs2.contains("."))
        {
            return false;
        }
       String[] parts = jud.split("\\.",-1);
        for(String part : parts){
            if (part.isEmpty()){
                return false;
            }
            char first=part.charAt(0);
            char last=part.charAt(part.length() - 1);
            if (!Character.isLetterOrDigit(first) || !Character.isLetterOrDigit(last)){
                return false;
            }
        }
        return true;
    }
    public static String formatfield(String field,String format)
    {
        if("lower".equals(format))
        {
            return field.toLowerCase();
        }
        else if("formal".equals(format))
        {
            if(field.isEmpty()) return field;
            return field.substring(0,1).toUpperCase()+field.substring(1).toLowerCase();
        }
        return field;
    }
    public static ProcessResult processline(String line,String mode,String format)
    {
        ProcessResult result=new ProcessResult();
        String []splStrings=splitline(line);
        if(splStrings.length!=3)
        {
            result.isGood=false;
            result.errorReason="字符数不正确";
            return  result;
        }
        String name=cleanstr(splStrings[0]);
        String email=cleanstr(splStrings[1]);
        String city=cleanstr(splStrings[2]);
        if (name.isEmpty() || email.isEmpty() || city.isEmpty()) {
            result.isGood=false;
            result.errorReason="存在空字段";
            return result;
        }
        if(!judgment(email))
        {
            result.isGood=false;
            result.errorReason="邮箱不合法";
            return result;
        }
        result.isGood=true;
        result.emails=format.equals("lower")?email.toLowerCase():email;
        if("clean".equals(mode))
        {
            String formattedname=formatfield(name, format);
            String formattedcity=formatfield(city, format);
            result.formattedLine=formattedname+","+result.emails+","+formattedcity;
        }
        else if("emails".equals(mode))
        {
            result.formattedLine=result.emails;
        }
        return result;
    }
     private static void writeLinesToFile(List<String> lines,String fileName) {
        try (BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"))) 
        {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("写入文件失败:");
        }
    }
    private static void printStatistics(){
        System.out.println("\n========== 统计信息 ==========");
        System.out.println("总行数: " + totallines);
        System.out.println("合格行数: " + goodlines);
        System.out.println("不合格行数: " + badlines);
        System.out.println("合格率: " + (totallines > 0 ? String.format("%.2f%%", goodlines * 100.0 / totallines) : "N/A"));
        System.out.println("==============================\n");
    }
    private static void closeLog() {
        if (logwriter!=null) {
            logwriter.close();
        }
    }
}
