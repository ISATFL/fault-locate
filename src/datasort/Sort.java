package datasort;

import localization.Sentence;

import java.util.ArrayList;

public class Sort {
    ArrayList<Sentence> sentences=new ArrayList<>();
    public Sort(ArrayList<Sentence> sentences){
        this.sentences=sentences;
    }
    public ArrayList<Sentence> BubbleSort(){
        for(int i=0;i<sentences.size()-1;i++){
            for(int j=0;j<sentences.size()-1;j++){
                if((sentences.get(j).getSus()<sentences.get(j+1).getSus())){
                    Sentence s=new Sentence();
                    s=sentences.get(j);
                    sentences.set(j,sentences.get(j+1));
                    sentences.set(j+1,s);
                }
            }
        }
        return sentences;
    }
}
