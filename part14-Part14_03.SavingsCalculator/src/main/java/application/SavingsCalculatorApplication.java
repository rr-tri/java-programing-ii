package application;

import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();

        /*-------------------Top Layout----------------------*/
        VBox top = new VBox();
        /*------------------first slider---------------------*/
        BorderPane first = new BorderPane();

        Label firstLeft = new Label("Monthly savings");

        Slider firstSlider = new Slider(25, 250, 25);
        firstSlider.setShowTickMarks(true);
        firstSlider.setShowTickLabels(true);
        firstSlider.setMajorTickUnit(25);
        firstSlider.setMinorTickCount(3);
        firstSlider.setSnapToTicks(true);

        Label firstRight = new Label(new DecimalFormat("#.##").format(firstSlider.getValue()));

        first.setLeft(firstLeft);
        first.setCenter(firstSlider);
        first.setRight(firstRight);
        first.setPadding(new Insets(20));

        /*--------------------------Second slider------------------------*/
        BorderPane second = new BorderPane();

        Label secondLeft = new Label("Yearly interest rate");

        Slider secondSlider = new Slider(0, 10, 0);
        secondSlider.setShowTickMarks(true);
        secondSlider.setShowTickLabels(true);
        secondSlider.setMinorTickCount(4);

        Label secondRight = new Label(new DecimalFormat("#.##").format(secondSlider.getValue()));

        second.setLeft(secondLeft);
        second.setCenter(secondSlider);
        second.setRight(secondRight);
        second.setPadding(new Insets(0, 20, 20, 20));

        top.getChildren().addAll(first, second);

        /*---------------------------------------------------------------*/
 /*--------------------Creating Line Chart---------------------------*/
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLowerBound(0);
        yAxis.setAutoRanging(true);

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings calculator");

        XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
        XYChart.Series<Number, Number> series2 = new XYChart.Series<>();

        lineChart.getData().addAll(series1, series2);
        /*----------------------------------------------------------------*/
 /*----------------handle change of values of savings---------------*/
        firstSlider.valueProperty().addListener((observable, oldValue, newValue)
                -> {
            firstRight.setText(new DecimalFormat("#.##").format(newValue));
            plotSavingsAndInterest(firstSlider.getValue(), secondSlider.getValue(), series2, series1);
        });
        /*--------------------------------------------------------------*/
 /*-----------handle change of values of interest rate------------*/
        secondSlider.valueProperty().addListener((observable, oldValue, newValue)
                -> {
            secondRight.setText(new DecimalFormat("#.##").format(newValue));
            plotSavingsAndInterest(firstSlider.getValue(), secondSlider.getValue(), series2, series1);

        });
        plotSavingsAndInterest(firstSlider.getValue(), secondSlider.getValue(), series2, series1);

        /*--------------------------------------------------------------*/
        root.setTop(top);
        root.setCenter(lineChart);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.show();
    }

    private void plotSavingsAndInterest(double savings, double rate, XYChart.Series series, XYChart.Series series1) {
        series1.getData().clear();
        series1.getData().add(new XYChart.Data(0, 0));
        double monthly_savings = 0.0;
        series.getData().clear();
        series.getData().add(new XYChart.Data(0, 0));
        double r = 1.0 + rate / 100.0;
        double total = 0.0;
        for (int i = 1; i <= 30; i++) {
            monthly_savings += savings * 12;
            series1.getData().add(new XYChart.Data(i, monthly_savings));
            total = (total + savings * 12) * r;
            series.getData().add(new XYChart.Data(i, total));
        }
    }
}
