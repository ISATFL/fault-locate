package localization;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class TrueFault {
    String logPath;
    public TrueFault(String logPath){
        this.logPath=logPath;
    }
    public ArrayList<E> getFault(){
        ArrayList<E> eArr=new ArrayList<>();
        try{
            String line=null;
            BufferedReader br=new BufferedReader(new FileReader(logPath));
            while((line=br.readLine())!=null){
                System.out.println(line);
                String strs[]=line.split("#");
                E e=new E();
                e.setMethod(strs[0]);
                e.setRow(Integer.parseInt(strs[1]));
                eArr.add(e);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return eArr;
    }
}
