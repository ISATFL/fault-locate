package datasort;

import localization.Sentence;
import localization.Sentence1;

import java.util.ArrayList;

public class SortMethod {
    ArrayList<Sentence1> sentences=new ArrayList<>();
    public SortMethod(ArrayList<Sentence1> sentences){
        this.sentences=sentences;
    }
    public ArrayList<Sentence1> BubbleSort(){
        for(int i=0;i<sentences.size()-1;i++){
            for(int j=0;j<sentences.size()-1;j++){
                if((sentences.get(j).getSortrow()>sentences.get(j+1).getSortrow())){
                    Sentence1 s=new Sentence1();
                    s=sentences.get(j);
                    sentences.set(j,sentences.get(j+1));
                    sentences.set(j+1,s);
                }
            }
        }
        return sentences;
    }
}
