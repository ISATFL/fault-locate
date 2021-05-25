package localization;

public class Sentence1 {
    int sortrow;
    int row;
    String method;
    double sus;
    public Sentence1(){

    }
    public void setSortrow(int sortrow){
        this.sortrow=sortrow;
    }
    public int getSortrow(){
        return sortrow;
    }
    public void setRow(int row) {
        this.row = row;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setSus(double sus) {
        this.sus = sus;
    }

    public int getRow() {
        return row;
    }

    public String getMethod() {
        return method;
    }

    public double getSus() {
        return sus;
    }
}
