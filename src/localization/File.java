package localization;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class File {
    String file;
    ArrayList<String> RE=new ArrayList<>();
    public File(String file){
        this.file=file;
    }
    public void setFile(String file){
        this.file=file;
    }
    public String getFile(){
        return file;
    }
    public ArrayList<ArrayList<Integer>> getMS(){//频谱矩阵
        ArrayList<ArrayList<Integer>> MS=new ArrayList<>();
        ArrayList<String> RE=new ArrayList<>();//测试结果
        try{
            String line=null;
            BufferedReader matrix=new BufferedReader(new FileReader(file));
            while((line=matrix.readLine())!=null){
                ArrayList<Integer> TS=new ArrayList<>();//测试用例覆盖集合
                String strs[]=line.split(" ");
                for(int i=0;i<strs.length;i++){
                    if((strs[i].equals("+"))||(strs[i].equals("-"))){
                        RE.add(strs[i]);
                    }else {
                        int pg=Integer.parseInt(strs[i]);
                        TS.add(pg);
                    }
                }
                MS.add(TS);
            }

        }catch (IOException e){
            System.out.println(e);
        }
        setRE(RE);
        return MS;
    }
    public void setRE(ArrayList<String> RE){
        this.RE=RE;
    }
    public ArrayList<String> getRE(){
        return RE;
    }
}
