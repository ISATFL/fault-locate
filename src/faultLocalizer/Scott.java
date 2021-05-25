package faultLocalizer;

import java.util.ArrayList;

public class Scott {
    ArrayList<Integer> EFArray=new ArrayList<>();
    ArrayList<Integer> EPArray=new ArrayList<>();
    ArrayList<Integer> NFArray=new ArrayList<>();//未执行到且不通过的数组nf
    ArrayList<Integer> NPArray=new ArrayList<>();//未执行到且通过的数组np
    public Scott( ArrayList<Integer> EFArray,ArrayList<Integer> EPArray,ArrayList<Integer> NFArray,ArrayList<Integer> NPArray){
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
            Sus=(4*ef*np-4*nf*ep-(nf-ep)*(nf-ep))/((2*ef+nf+ep)*(2*np+nf+ep));
            if(Double.isNaN(Sus)){
                Sus=0;
            }
            SuspicionArray.add(Sus);
        }
        return SuspicionArray;
    }

}
