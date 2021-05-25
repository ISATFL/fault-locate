package faultLocalizer;

import java.util.ArrayList;

/**
 * 不同等价公式
 * ER1 Naish2
 * ER2 Goodman
 * ER3 Tarantula
 * ER6 Ochiai，Scott.Kulczynski2,M2
 */

public class Hamann {
    ArrayList<Integer> EFArray=new ArrayList<>();
    ArrayList<Integer> EPArray=new ArrayList<>();
    ArrayList<Integer> NFArray=new ArrayList<>();//未执行到且不通过的数组nf
    ArrayList<Integer> NPArray=new ArrayList<>();//未执行到且通过的数组np
    public Hamann( ArrayList<Integer> EFArray,ArrayList<Integer> EPArray,ArrayList<Integer> NFArray,ArrayList<Integer> NPArray){
        this.EFArray=EFArray;
        this.EPArray=EPArray;
        this.NFArray=NFArray;
        this.NPArray=NPArray;
    }
    public ArrayList<Double> getSuspicion(){
        ArrayList<Double> SuspicionArray=new ArrayList<>();
        double Sus=0;
        for(int i=0;i<EFArray.size();i++){
            double ef=EFArray.get(i);
            double ep=EPArray.get(i);
            double nf=NFArray.get(i);
            double np=NPArray.get(i);
//            Sus=(ef+np)/(ef+nf+ep+np);
            Sus=(ef*ef)/(ep+nf)+ef/(Math.sqrt((ef+nf)*(ef+ep)));
            if(Double.isNaN(Sus)){
                Sus=0;
            }
            SuspicionArray.add(Sus);
        }
        return SuspicionArray;
    }
}
