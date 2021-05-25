package sample;

import Chart.BarChartUtil;
import datasort.Sort;
import datasort.SortMethod;
import faultLocalizer.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import localization.*;
import sun.reflect.misc.FieldUtil;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.io.File;
import java.net.URL;
import java.nio.file.FileSystem;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Stack;
import java.util.logging.SimpleFormatter;

public class Controller implements Initializable {
    public RadioButton ochiai;
    public RadioButton dstar;
    public RadioButton tarantula;
    public AnchorPane root;
    public TextField matrix_Path;
    public TextField sp_Path;
    public TextArea message;
    public TextField method1;
    public TextField method2;
    public TextField method3;
    public TextField method4;
    public TextField method5;
    public TextField sus1;
    public TextField row1;
    public TextField row2;
    public TextField sus2;
    public TextField sus3;
    public TextField sus4;
    public TextField sus5;
    public TextField row3;
    public TextField row4;
    public TextField row5;
    public TextField fileName;
    public TextField fileTime;
    public TextField subjectName;
    public TextField subjectVersion;
    public RadioButton goodman;
    public RadioButton hamann;
    public RadioButton kulczynski2;
    public RadioButton m2;
    public RadioButton naish2;
    public RadioButton scott;
    public RadioButton exam;
    public RadioButton e1;
    public RadioButton e3;
    public RadioButton e5;
    public RadioButton e10;
    public Button evaluation;
    public TextField fileNum;
    public BarChart chart;
    public Label five;
    public Label four;
    public Label three;
    public Label two;
    public Label one;
    public Label fangfaming;
    public Label huaiyidu;
    public Label hanghao;
    public Label paiming;
    public Label yuju;
    private String matrix;
    private String spPath;
    private String method="Tarantula";
    private String indicator="EXAMScore";
    SimpleDateFormat df = new SimpleDateFormat("yyyy年-MM月-dd日 HH:mm:ss");

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void chooseMatrix(ActionEvent actionEvent) {
        FileChooser fileChooser=new FileChooser();
        Stage stage=(Stage)root.getScene().getWindow();
        File file=fileChooser.showOpenDialog(stage);
        matrix=file.getPath();
        System.out.println(matrix);
        matrix_Path.setText(matrix);
    }

    public void chooseSp(ActionEvent actionEvent) {
        FileChooser fileChooser=new FileChooser();
        Stage stage=(Stage)root.getScene().getWindow();
        File file=fileChooser.showOpenDialog(stage);
        spPath=file.getPath();
        System.out.println(spPath);
        sp_Path.setText(spPath);
    }

    public void checkTarnatula(ActionEvent actionEvent) {
        if(tarantula.isSelected()){
            dstar.setSelected(false);
            goodman.setSelected(false);
            kulczynski2.setSelected(false);
            m2.setSelected(false);
            naish2.setSelected(false);
            scott.setSelected(false);
            hamann.setSelected(false);
            ochiai.setSelected(false);
            method="Tarantula";
//            System.out.println("tarantula" );
        }
    }

    public void checkOchiai(ActionEvent actionEvent) {
        if(ochiai.isSelected()){
            tarantula.setSelected(false);
            dstar.setSelected(false);
            goodman.setSelected(false);
            kulczynski2.setSelected(false);
            m2.setSelected(false);
            naish2.setSelected(false);
            scott.setSelected(false);
            hamann.setSelected(false);
            method="Ochiai";
        }
    }

    public void checkDstar(ActionEvent actionEvent) {
        if(dstar.isSelected()){
            tarantula.setSelected(false);
            goodman.setSelected(false);
            kulczynski2.setSelected(false);
            m2.setSelected(false);
            naish2.setSelected(false);
            scott.setSelected(false);
            hamann.setSelected(false);
            method="Dstar";
            ochiai.setSelected(false);
        }
    }
    public void checkGoodman(ActionEvent actionEvent) {
        if(goodman.isSelected()){
            tarantula.setSelected(false);
            dstar.setSelected(false);
            kulczynski2.setSelected(false);
            m2.setSelected(false);
            naish2.setSelected(false);
            scott.setSelected(false);
            hamann.setSelected(false);
            method="Goodman";
            ochiai.setSelected(false);
        }
    }

    public void checkHamann(ActionEvent actionEvent) {
        tarantula.setSelected(false);
        dstar.setSelected(false);
        goodman.setSelected(false);
        kulczynski2.setSelected(false);
        m2.setSelected(false);
        naish2.setSelected(false);
        scott.setSelected(false);
        method="Hamann";
        ochiai.setSelected(false);
    }

    public void checkKulczynski2(ActionEvent actionEvent) {
        tarantula.setSelected(false);
        dstar.setSelected(false);
        goodman.setSelected(false);
        m2.setSelected(false);
        naish2.setSelected(false);
        scott.setSelected(false);
        hamann.setSelected(false);
        method="Kulczynski2";
        ochiai.setSelected(false);
    }

    public void checkM2(ActionEvent actionEvent) {
        tarantula.setSelected(false);
        dstar.setSelected(false);
        goodman.setSelected(false);
        kulczynski2.setSelected(false);
        naish2.setSelected(false);
        scott.setSelected(false);
        hamann.setSelected(false);
        method="M2";
        ochiai.setSelected(false);
    }

    public void checkNaish2(ActionEvent actionEvent) {
        tarantula.setSelected(false);
        dstar.setSelected(false);
        goodman.setSelected(false);
        kulczynski2.setSelected(false);
        m2.setSelected(false);
        scott.setSelected(false);
        hamann.setSelected(false);
        method="Naish2";
        ochiai.setSelected(false);
    }

    public void checkScott(ActionEvent actionEvent) {
        tarantula.setSelected(false);
        dstar.setSelected(false);
        goodman.setSelected(false);
        kulczynski2.setSelected(false);
        m2.setSelected(false);
        naish2.setSelected(false);
        hamann.setSelected(false);
        method="Scott";
        ochiai.setSelected(false);
    }
    public void startLocate(ActionEvent actionEvent) {

        Stack<String> stack1 = Version(matrix);
        String version1 = stack1.pop();
        String name1 = stack1.pop();
        String strs1[]=matrix.split("\\\\");
        int num=getFileNum(strs1[0]+"\\"+strs1[1]+"\\"+strs1[2]);

        for(int number=2;number<=num+1;number++) {

//        message.setText(df.format(new Date()));
            String process_message;
            process_message = "开始定位   " + df.format(new Date());
            message.setText(process_message);
            Stack<String> stack = Version(matrix);
            String version = stack.pop();
            String name = stack.pop();
            fileName.setText(method + "_" + name + "_" + version);
            fileTime.setText(df.format(new Date()));
            subjectName.setText(name);
            subjectVersion.setText(version);
            localization.File file = new localization.File(matrix);
            ArrayList<ArrayList<Integer>> MS = file.getMS();
            ArrayList<String> RE = file.getRE();
            Element element = new Element(MS, RE);
            ArrayList<Integer> EFArray = new ArrayList<>();
            ArrayList<Integer> EPArray = new ArrayList<>();
            ArrayList<Integer> NFArray = new ArrayList<>();//未执行到且不通过的数组nf
            ArrayList<Integer> NPArray = new ArrayList<>();//未执行到且通过的数组np
            EFArray = element.getA_ef();
            EPArray = element.getA_ep();
            NFArray = element.getA_nf();
            NPArray = element.getA_np();

            ArrayList<Double> SuspicionList = new ArrayList<>();////怀疑度列表
            if (method.equals("Tarantula")) {
                Tarantula tarantulaMethod = new Tarantula(EFArray, EPArray, NFArray, NPArray);
                SuspicionList = tarantulaMethod.getSuspicion();
            }
            if (method.equals("Ochiai")) {
                Ochiai ochiaiMethod = new Ochiai(EFArray, EPArray, NFArray, NPArray);
                SuspicionList = ochiaiMethod.getSuspicion();
            }
            if (method.equals("Dstar")) {
                Dstar dstarMethod = new Dstar(EFArray, EPArray, NFArray, NPArray);
                SuspicionList = dstarMethod.getSuspicion();
            }
            if (method.equals("Goodman")) {
                Goodman goodmanMethod = new Goodman(EFArray, EPArray, NFArray, NPArray);
                SuspicionList = goodmanMethod.getSuspicion();
            }
            if (method.equals("Hamann")) {
                Hamann hamannMethod = new Hamann(EFArray, EPArray, NFArray, NPArray);
                SuspicionList = hamannMethod.getSuspicion();
            }
            if (method.equals("Kulczynski2")) {
                Kulczynski2 kulczynski2Method = new Kulczynski2(EFArray, EPArray, NFArray, NPArray);
                SuspicionList = kulczynski2Method.getSuspicion();
            }
            if (method.equals("M2")) {
                M2 m2Method = new M2(EFArray, EPArray, NFArray, NPArray);
                SuspicionList = m2Method.getSuspicion();
            }
            if (method.equals("Naish2")) {
                Naish2 naish2Method = new Naish2(EFArray, EPArray, NFArray, NPArray);
                SuspicionList = naish2Method.getSuspicion();
            }
            if (method.equals("Scott")) {
                Scott scottMethod = new Scott(EFArray, EPArray, NFArray, NPArray);
                SuspicionList = scottMethod.getSuspicion();
            }
            SP sp = new SP(spPath);
            ArrayList<String> methodList = new ArrayList<>();
            ArrayList<Integer> rowList = new ArrayList<>();
            methodList = sp.getMethod();
            rowList = sp.getRow();
            ArrayList<Sentence> sentences = new ArrayList<>();
            for (int i = 0; i < rowList.size(); i++) {
                Sentence s = new Sentence();
                s.setRow(rowList.get(i));
                s.setMethod(methodList.get(i));
                s.setSus(SuspicionList.get(i));
                sentences.add(s);
            }
//            for (int i = 0; i < sentences.size(); i++) {
//                System.out.println(sentences.get(i).getMethod() + "  " + sentences.get(i).getRow());
//            }
            String out_path = "";
            String strs[] = matrix.split("\\\\");
            for (int i = 0; i < strs.length - 1; i++) {
                out_path = out_path + strs[i] + "\\\\";
            }
            System.out.println(out_path);
            TrueFault trueFault = new TrueFault("D:\\D4j\\buggy-lines\\"+name+"-"+version+".buggy.lines");
            ArrayList<E> eArr=trueFault.getFault();
            Sort s = new Sort(sentences);
            ArrayList<Sentence> sen = new ArrayList<>();
            sen = s.BubbleSort();
            process_message = process_message + "\n" + "定位完成    " + df.format(new Date());
            message.setText(process_message);
            row1.setText(sen.get(0).getRow() + "");
            row2.setText(sen.get(1).getRow() + "");
            row3.setText(sen.get(2).getRow() + "");
            row3.setText(sen.get(3).getRow() + "");
            row4.setText(sen.get(4).getRow() + "");
            row5.setText(sen.get(5).getRow() + "");

            sus1.setText(String.format("%.5f", sen.get(0).getSus()) + "");
            sus2.setText(String.format("%.5f", sen.get(1).getSus()) + "");
            sus3.setText(String.format("%.5f", sen.get(2).getSus()) + "");
            sus4.setText(String.format("%.5f", sen.get(3).getSus()) + "");
            sus5.setText(String.format("%.5f", sen.get(4).getSus()) + "");

            method1.setText(sen.get(0).getMethod());
            method2.setText(sen.get(1).getMethod());
            method3.setText(sen.get(2).getMethod());
            method4.setText(sen.get(3).getMethod());
            method5.setText(sen.get(4).getMethod());


            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(out_path + method + "_" + name + "_" + version + ".txt"));
                if(method.equals("Hamann")){
                    ArrayList<Sentence1> sentence1s=new ArrayList<>();
                    BufferedReader br=new BufferedReader(new FileReader(out_path+"Ochiai"+"_"+name+"_"+version+".txt"));
                    String line =null;
                    int lineNumber=0;
                    while((line=br.readLine())!=null){
                        String args[]=line.split("#");
                        BufferedReader br2=new BufferedReader(new FileReader(out_path+"Tarantula"+"_"+name+"_"+version+".txt"));
                        String line2=null;
                        while((line2=br2.readLine())!=null){
                            String args2[]=line2.split("#");
                            if((args[1].equals(args2[1]))&&(args[2].equals(args2[2]))){
                                Sentence1 sentence1=new Sentence1();
                                sentence1.setRow(Integer.parseInt(args[2]));
                                sentence1.setMethod(args[1]);
                                sentence1.setSus(Double.valueOf(args[3]));
                                sentence1.setSortrow(Integer.parseInt(args[0])+Integer.parseInt(args2[0]));
                                sentence1s.add(sentence1);
                                break;
                            }
                        }
                        br2.close();
                        BufferedReader br3=new BufferedReader(new FileReader(out_path+"Goodman"+"_"+name+"_"+version+".txt"));
                        String line3=null;
                        while((line3=br3.readLine())!=null){
                            String args3[]=line3.split("#");
                            if((args[1].equals(args3[1]))&&(args[2].equals(args3[2]))){
                                sentence1s.get(lineNumber).setSortrow(sentence1s.get(lineNumber).getSortrow()+Integer.parseInt(args3[0]));
                                break;
                            }
                        }
                        br3.close();
                        BufferedReader br4=new BufferedReader(new FileReader(out_path+"Naish2"+"_"+name+"_"+version+".txt"));
                        String line4=null;
                        while((line4=br4.readLine())!=null){
                            String args4[]=line4.split("#");
                            if((args[1].equals(args4[1]))&&(args[2].equals(args4[2]))){
                                sentence1s.get(lineNumber).setSortrow(sentence1s.get(lineNumber).getSortrow()+Integer.parseInt(args4[0]));
                                break;
                            }
                        }
                        br4.close();
                        lineNumber++;
                    }
                    br.close();
                    SortMethod sortMethod=new SortMethod(sentence1s);
                    ArrayList<Sentence1> sortSen1=sortMethod.BubbleSort();
                    for(int i=0;i<sortSen1.size();i++){
                        bw.write((i+1)+"#"+sortSen1.get(i).getMethod()+"#"+sortSen1.get(i).getRow()+"#"+sortSen1.get(i).getSus());
                        bw.newLine();
                    }
                }
                else{
                    for (int i = 0; i < sen.size(); i++) {
                        bw.write( (i + 1) + "#" +sen.get(i).getMethod()+ "#"+sen.get(i).getRow()+"#"+String.format("%.5f", sen.get(i).getSus())) ;
                        bw.newLine();
                    }
                }

                process_message = process_message + "\n" + "报告所在位置:" + out_path + method + "_" + name + "_" + version + ".txt";
                message.setText(process_message + " " + df.format(new Date()));
                bw.close();
                BufferedWriter blog=new BufferedWriter(new FileWriter(out_path+"fault.txt"));
                for(int i=0;i<eArr.size();i++){
                    String meth[]=eArr.get(i).getMethod().split("/");
                    String w="";
                    for(int j=0;j<meth.length;j++){
                        if(j==meth.length-1){
                            w=w+meth[j]+"#";
                        }else{
                            w=w+meth[j]+".";
                        }
                    }
                    w=w+eArr.get(i).getRow();
                    blog.write(w);
                    blog.newLine();
                }
                blog.close();
//            Runtime runtime=Runtime.getRuntime();
//            Process process=null;
//            String openPath="rundll32 url.dll FileProtocolHandler "+"file://"+out_path+method+"_"+name+"_"+version+".txt";
//            try{
//                process=runtime.exec(openPath);
//            }catch (Exception e){
//                System.out.println(e);
//            }
            } catch (IOException e) {
                e.printStackTrace();
            }
            matrix=strs[0]+"\\"+strs[1]+"\\"+strs[2]+"\\"+number+"\\"+strs[4]+"\\"+strs[5]+"\\"+number+"\\"+"matrix";
            spPath=strs[0]+"\\"+strs[1]+"\\"+strs[2]+"\\"+number+"\\"+strs[4]+"\\"+strs[5]+"\\"+number+"\\"+"spectra";
            System.out.println(matrix);
            matrix_Path.setText(matrix);
            sp_Path.setText(spPath);
        }
    }
    public Stack<String> Version(String path){
        Stack<String> stack=new Stack<>();
        String strs[]=path.split("\\\\");
        for(int i=0;i<strs.length-1;i++){
            stack.push(strs[i]);
        }
        return stack;
    }

    public void collectMessage(ActionEvent actionEvent) {

        Stack<String> stack = Version(matrix);
        String version = stack.pop();
        String name = stack.pop();
        String strs[]=matrix.split("\\\\");
        int num=getFileNum(strs[0]+"\\"+strs[1]+"\\"+strs[2]);
        for(int i=1;i<=num;i++){
            message.setText("开始收集..."+df.format(new Date()));
            String method_Path=strs[0]+"\\"+strs[1]+"\\"+strs[2]+"\\"+i+"\\"+strs[4]+"\\"+strs[5]+"\\"+i+"\\"+method+"_"+name+"_"+i+".txt";
            String fault_Path=strs[0]+"\\"+strs[1]+"\\"+strs[2]+"\\"+i+"\\"+strs[4]+"\\"+strs[5]+"\\"+i+"\\"+"fault"+".txt";
            String result_Path=strs[0]+"\\"+strs[1]+"\\"+strs[2]+"\\"+i+"\\"+strs[4]+"\\"+strs[5]+"\\"+i+"\\"+method+"_"+"result"+".txt";
            try{
                BufferedReader faultBR=new BufferedReader(new FileReader(fault_Path));
                BufferedWriter resultBW=new BufferedWriter(new FileWriter(result_Path));
                String methodLLine="";
                String faultLine="";
                int locateLine=0;
                while((faultLine=faultBR.readLine())!=null){
                    String faultStrs[]=faultLine.split("#");
                    BufferedReader methodBR=new BufferedReader(new FileReader(method_Path));
                    while((methodLLine=methodBR.readLine())!=null){
                        String methodStrs[]=methodLLine.split("#");
                        String methodSplite[]=methodStrs[1].split("\\$" );

                        if((faultStrs[0].equals(methodSplite[0]+".java"))&&(faultStrs[1].equals(methodStrs[2]))){
                            if(locateLine==0){
                                locateLine=Integer.parseInt(methodStrs[0]);
                            }else{
                                if((Integer.parseInt(methodStrs[0]))<locateLine){
                                    locateLine=Integer.parseInt(methodStrs[0]);
                                }
                            }
                            break;
                        }
                    }
                    methodBR.close();
                }
                System.out.println(locateLine);
                resultBW.write(String.valueOf(locateLine));
                faultBR.close();
                resultBW.close();
                message.setText("开始收集..."+df.format(new Date())+"\n"+"收集完成..."+df.format(new Date())+"\n"+"结果所在位置："+result_Path);
                fileName.setText(method + "_" +"result");
                fileTime.setText(df.format(new Date()));
                subjectName.setText(name);
                subjectVersion.setText(String.valueOf(i));
                System.out.println("收集完成");
                row1.setText("");
                row2.setText("");
                row3.setText("");
                row4.setText("");
                row5.setText("");
                method1.setText("");
                method2.setText("");
                method3.setText("");
                method4.setText("");
                method5.setText("");
                sus1.setText("");
                sus2.setText("");
                sus3.setText("");
                sus4.setText("");
                sus5.setText("");

            }catch (IOException e){
                System.out.println(e);
            }

        }

    }

    public void checkExam(ActionEvent actionEvent) {
        e1.setSelected(false);
        e3.setSelected(false);
        e5.setSelected(false);
        e10.setSelected(false);
        indicator="EXAMScore";

    }

    public void checkE1(ActionEvent actionEvent) {
        exam.setSelected(false);
        e3.setSelected(false);
        e5.setSelected(false);
        e10.setSelected(false);
        indicator="Einspect@1";
    }

    public void checkE3(ActionEvent actionEvent) {
        exam.setSelected(false);
        e1.setSelected(false);
        e5.setSelected(false);
        e10.setSelected(false);
        indicator="Einspect@3";

    }

    public void checkE5(ActionEvent actionEvent) {
        exam.setSelected(false);
        e1.setSelected(false);
        e3.setSelected(false);
        e10.setSelected(false);
        indicator="Einspect@5";
    }

    public void checkE10(ActionEvent actionEvent) {
        exam.setSelected(false);
        e1.setSelected(false);
        e3.setSelected(false);
        e5.setSelected(false);
        indicator="Einspect@10";
    }

    public void Evaluation(ActionEvent actionEvent) {
//        int num=Integer.parseInt(fileNum.getText());
        Stack<String> stack = Version(matrix);
        String version = stack.pop();
        String name = stack.pop();
        String strs[]=matrix.split("\\\\");
        int Einspect=0;
        double exam=0;
        double AveEXAM=0;
        int num=getFileNum(strs[0]+"\\"+strs[1]+"\\"+strs[2]);
        System.out.println("shu"+num);
        double fNum=getFileNum(strs[0]+"\\"+strs[1]+"\\"+strs[2]);
        for(int i=1;i<=num;i++) {
            message.setText("开始评测..."+df.format(new Date()));
            String result_Path=strs[0]+"\\"+strs[1]+"\\"+strs[2]+"\\"+i+"\\"+strs[4]+"\\"+strs[5]+"\\"+i+"\\"+method+"_"+"result"+".txt";
            if (indicator.equals("EXAMScore")) {
                String method_Path=strs[0]+"\\"+strs[1]+"\\"+strs[2]+"\\"+i+"\\"+strs[4]+"\\"+strs[5]+"\\"+i+"\\"+method+"_"+name+"_"+i+".txt";
                try {
                    BufferedReader resultBR=new BufferedReader(new FileReader(result_Path));
                    FileReader fileReader=new FileReader(method_Path);
                    double fault=Double.valueOf(resultBR.readLine());
                    System.out.println(fault+"");
                    LineNumberReader reader=new LineNumberReader(fileReader);
                    reader.skip(Long.MAX_VALUE);
                    double sum=reader.getLineNumber();
                    System.out.println(sum+"");
                    exam=exam+(fault/sum);
                    System.out.println(exam);
                    resultBR.close();
                    fileReader.close();
                    reader.close();
                    fileName.setText(method+"_"+indicator+".txt");
                    fileTime.setText(df.format(new Date()));
                    subjectName.setText(name);
                    subjectVersion.setText(String.valueOf(i));
                    message.setText("开始评测..."+df.format(new Date())+"\n"+"评测完成..."+df.format(new Date()));
                }catch (IOException e){
                    System.out.println(e);
                }

            }
            if (indicator.equals("Einspect@1")) {
               try {
                   BufferedReader resultBR=new BufferedReader(new FileReader(result_Path));
                   int fault=Integer.parseInt(resultBR.readLine());
                   System.out.println(fault);
                   if(fault==1){
                       Einspect++;
                   }
                   resultBR.close();
                   fileName.setText(method+"_"+indicator+".txt");
                   fileTime.setText(df.format(new Date()));
                   subjectName.setText(name);
                   subjectVersion.setText(String.valueOf(i));
                   message.setText("开始评测..."+df.format(new Date())+"\n"+"评测完成..."+df.format(new Date()));


               }catch (IOException e){
                   System.out.println(e);
               }
            }
            if (indicator.equals("Einspect@3")) {
                try {
                    BufferedReader resultBR=new BufferedReader(new FileReader(result_Path));
                    int fault=Integer.parseInt(resultBR.readLine());
                    System.out.println(fault);
                    if((fault>=1)&&(fault<=3)){
                        Einspect++;
                    }
                    resultBR.close();
                    fileName.setText(method+"_"+indicator+".txt");
                    fileTime.setText(df.format(new Date()));
                    subjectName.setText(name);
                    subjectVersion.setText(String.valueOf(i));
                    message.setText("开始评测..."+df.format(new Date())+"\n"+"评测完成..."+df.format(new Date()));


                }catch (IOException e){
                    System.out.println(e);
                }

            }
            if (indicator.equals("Einspect@5")) {
                try {
                    BufferedReader resultBR=new BufferedReader(new FileReader(result_Path));
                    int fault=Integer.parseInt(resultBR.readLine());
                    System.out.println(fault);
                    if((fault>=1)&&(fault<=5)){
                        Einspect++;
                    }
                    resultBR.close();
                    fileName.setText(method+"_"+indicator+".txt");
                    fileTime.setText(df.format(new Date()));
                    subjectName.setText(name);
                    subjectVersion.setText(String.valueOf(i));
                    message.setText("开始评测..."+df.format(new Date())+"\n"+"评测完成..."+df.format(new Date()));


                }catch (IOException e){
                    System.out.println(e);
                }

            }
            if (indicator.equals("Einspect@10")) {
                try {
                    BufferedReader resultBR=new BufferedReader(new FileReader(result_Path));
                    int fault=Integer.parseInt(resultBR.readLine());
                    System.out.println(fault);
                    if((fault>=1)&&(fault<=10)){
                        Einspect++;
                    }
                    resultBR.close();
                    fileName.setText(method+"_"+indicator+".txt");
                    fileTime.setText(df.format(new Date()));
                    subjectName.setText(name);
                    subjectVersion.setText(String.valueOf(i));
                    message.setText("开始评测..."+df.format(new Date())+"\n"+"评测完成..."+df.format(new Date()));


                }catch (IOException e){
                    System.out.println(e);
                }

            }
        }
        if(indicator.equals("EXAMScore")){
            AveEXAM=exam/fNum;
            System.out.println(num);
            String exampath="";
            try {
                exampath = strs[0] + "\\" + strs[1] + "\\" + strs[2] + "\\" +method+"_"+ "EXAMScore.txt";
                BufferedWriter bw = new BufferedWriter(new FileWriter(exampath));
                bw.write(String.valueOf(AveEXAM));
                bw.close();
            }catch (IOException e){

            }
            message.setText("开始评测..."+df.format(new Date())+"\n"+"评测完成..."+df.format(new Date())+"\n"+"EXAMScore"+"("+name+")："+String.format("%.8f",AveEXAM)
                    +"\n"+"文件所在位置："+exampath);


        }
        if (indicator.equals("Einspect@1")) {
            String exampath="";
            try {
                exampath = strs[0] + "\\" + strs[1] + "\\" + strs[2] + "\\" +method+"_"+"Einspect@1.txt";
                BufferedWriter bw = new BufferedWriter(new FileWriter(exampath));
                bw.write(String.valueOf(Einspect));
                bw.close();
            }catch (IOException e){

            }
            message.setText("开始评测..."+df.format(new Date())+"\n"+"评测完成..."+df.format(new Date())+"\n"+"Einspect@1"+"("+name+")："+Einspect
                    +"\n"+"文件所在位置："+exampath);

        }
        if (indicator.equals("Einspect@3")) {
            String exampath="";
            try {
                exampath = strs[0] + "\\" + strs[1] + "\\" + strs[2] + "\\" +method+"_"+ "Einspect@3.txt";
                BufferedWriter bw = new BufferedWriter(new FileWriter(exampath));
                bw.write(String.valueOf(Einspect));
                bw.close();
            }catch (IOException e){

            }
            message.setText("开始评测..."+df.format(new Date())+"\n"+"评测完成..."+df.format(new Date())+"\n"+"Einspect@3"+"("+name+")："+Einspect
                    +"\n"+"文件所在位置："+exampath);

        }
        if (indicator.equals("Einspect@5")) {
            String exampath="";
            try {
                exampath = strs[0] + "\\" + strs[1] + "\\" + strs[2] + "\\" +method+"_"+ "Einspect@5.txt";
                BufferedWriter bw = new BufferedWriter(new FileWriter(exampath));
                bw.write(String.valueOf(Einspect));
                bw.close();
            }catch (IOException e){

            }
            message.setText("开始评测..."+df.format(new Date())+"\n"+"评测完成..."+df.format(new Date())+"\n"+"Einspect@5"+"("+name+")："+Einspect
                    +"\n"+"文件所在位置："+exampath);

        }
        if (indicator.equals("Einspect@10")) {
            String exampath="";
            try {
                exampath = strs[0] + "\\" + strs[1] + "\\" + strs[2] + "\\" +method+"_"+ "Einspect@10.txt";
                BufferedWriter bw = new BufferedWriter(new FileWriter(exampath));
                bw.write(String.valueOf(Einspect));
                bw.close();
            }catch (IOException e){

            }
            message.setText("开始评测..."+df.format(new Date())+"\n"+"评测完成..."+df.format(new Date())+"\n"+"Einspect@10"+"("+name+")："+Einspect
                    +"\n"+"文件所在位置："+exampath);

        }
//

    }

    public static int getFileNum(String path){
        int num=0;
        File file=new File(path);
        if(file.isDirectory()){
            String []str=file.list();
            for(String i:str){
                File file1=new File(path+"\\"+i);
                if(file1.isDirectory()){
                    num++;
                }
            }
        }
        return num;
    }

    public void CreatePaper(ActionEvent actionEvent) {
        String strs[]=matrix.split("\\\\");
        String methods[]={"Tarantula","Ochiai","Dstar","Goodman","Hamann","Kulczynski2","M2","Naish2","Scott"};
        ArrayList<Double> results=new ArrayList<>();
        for(int i=0;i<9;i++){
            try {
                BufferedReader br=new BufferedReader(new FileReader(strs[0] + "\\" + strs[1] + "\\" + strs[2] + "\\" +methods[i]+"_"+ indicator+".txt"));
                results.add(Double.valueOf(br.readLine()));

            }catch (IOException e){
                System.out.println(e);

            }
        }
        row1.setVisible(false);
        row1.setManaged(false);
        row2.setVisible(false);
        row2.setManaged(false);
        row3.setVisible(false);
        row3.setManaged(false);
        row4.setVisible(false);
        row4.setManaged(false);
        row5.setVisible(false);
        row5.setManaged(false);

        sus1.setVisible(false);
        sus1.setManaged(false);
        sus2.setVisible(false);
        sus2.setManaged(false);
        sus3.setVisible(false);
        sus3.setManaged(false);
        sus4.setVisible(false);
        sus4.setManaged(false);
        sus5.setVisible(false);
        sus5.setManaged(false);

        method1.setVisible(false);
        method1.setManaged(false);
        method2.setVisible(false);
        method2.setManaged(false);
        method3.setVisible(false);
        method3.setManaged(false);
        method4.setVisible(false);
        method4.setManaged(false);
        method5.setVisible(false);
        method5.setManaged(false);

        paiming.setVisible(false);
        paiming.setManaged(false);
        hanghao.setVisible(false);
        hanghao.setManaged(false);
        huaiyidu.setVisible(false);
        huaiyidu.setManaged(false);
        fangfaming.setVisible(false);
        fangfaming.setManaged(false);
        one.setVisible(false);
        one.setManaged(false);
        two.setVisible(false);
        two.setManaged(false);
        three.setVisible(false);
        three.setManaged(false);
        four.setVisible(false);
        four.setManaged(false);
        five.setVisible(false);
        five.setManaged(false);
        chart.getData().setAll();

        BarChartUtil barChartUtil=new BarChartUtil(chart);
        barChartUtil.operateBarChart(results,indicator);
        chart.setVisible(true);
        chart.setManaged(true);
    }
}
