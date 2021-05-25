package Chart;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import sample.Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Date;

public class BarChartUtil {
    private BarChart barChart;
    public BarChartUtil(BarChart barChart){
        this.barChart=barChart;
    }
    public void operateBarChart(ArrayList<Double> results,String indicate){
        String methods[]={"Tarantula", "Ochiai", "Dstar","Goodman","Hamann","Kulczynski2","M2","Naish2","Scott"};

        //两条轴线
        final CategoryAxis xAxis = (CategoryAxis) barChart.getXAxis();
        final NumberAxis yAxis = (NumberAxis) barChart.getYAxis();
        //图表标题
        barChart.setTitle("评测结果");
        //轴名
        xAxis.setLabel("评测方法");
        yAxis.setLabel(indicate);
        final String Tarantula = "Tarantula";
        final String Ochiai = "Ochiai";
        final String Dstar = "Dstar";
        final String Goodman = "Goodman";
        final String Hamann = "融合后";
        final String Kulczynski2=" Kulczynski2";
        final String M2="M2";
        final String Naish2="Naish2";
        final String Scott="Scott";
        //系列1
        XYChart.Series<String, Double> series1 = new XYChart.Series<>();
        ArrayList<Double> examScore=new ArrayList<>();
        ArrayList<Integer> einspect=new ArrayList<>();
        series1.getData().add(new XYChart.Data<>(Tarantula, results.get(0)));
        series1.getData().add(new XYChart.Data<>(Ochiai, results.get(1)));
        series1.getData().add(new XYChart.Data<>(Dstar, results.get(2)));
        series1.getData().add(new XYChart.Data<>(Goodman, results.get(3)));
        series1.getData().add(new XYChart.Data<>(Hamann, results.get(4)));
        series1.getData().add(new XYChart.Data<>(Kulczynski2, results.get(5)));
        series1.getData().add(new XYChart.Data<>(M2, results.get(6)));
        series1.getData().add(new XYChart.Data<>(Naish2, results.get(7)));
        series1.getData().add(new XYChart.Data<>(Scott, results.get(8)));
        //系列2
//        XYChart.Series<String , Integer> series2 = new XYChart.Series<>();
//        series2.getData().add(new XYChart.Data<>(Tarantula, 3));
//        series2.getData().add(new XYChart.Data<>(Ochiai, 5));
//        series2.getData().add(new XYChart.Data<>(Dstar, 2));
//        series2.getData().add(new XYChart.Data<>(Goodman, 4));
//        series2.getData().add(new XYChart.Data<>(Hamann, 5));
//        series2.getData().add(new XYChart.Data<>(Kulczynski2, 1));
//        series2.getData().add(new XYChart.Data<>(M2, 3));
//        series2.getData().add(new XYChart.Data<>(Naish2, 2));
//        series2.getData().add(new XYChart.Data<>(Scott, 4));
//        //系列3
//        XYChart.Series<String, Double> series3 = new XYChart.Series<>();
//        series3.setName("2005");
//        series3.getData().add(new XYChart.Data<>(austria, 45000.65));
//        series3.getData().add(new XYChart.Data<>(brazil, 44835.76));
//        series3.getData().add(new XYChart.Data<>(france, 18722.18));
//        series3.getData().add(new XYChart.Data<>(italy, 17557.31));
//        series3.getData().add(new XYChart.Data<>(usa, 92633.68));


        //显示图表
        barChart.getData().addAll(series1);
    }
}
