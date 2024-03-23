package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

    @Override
    public void start(Stage stage) {

        File file = new File("partiesdata.tsv");
        try (Scanner scan = new Scanner(file)) {
            scan.nextLine();

            // create the x and y axes that the chart is going to use
            NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
            NumberAxis yAxis = new NumberAxis(0,30,5);

            // create the line chart. The values of the chart are given as numbers
            // and it uses the axes we created earlier
            LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
            lineChart.setTitle("Relative support of the parties");

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] parts = line.split("\t");
                String partyName = parts[0];

                // create the data set that is going to be added to the line chart
                XYChart.Series series = new XYChart.Series();
                series.setName(partyName);
                int startDate = 1968;
                for (int i = 1; i < parts.length; i++) {
                    if (parts[i].equals("-")) {
                        startDate += 4;
                        continue;
                    }
                    series.getData().add(new XYChart.Data<>(startDate, Double.parseDouble(parts[i])));
                    startDate += 4;
                }
                lineChart.getData().add(series);
            }

            Scene scene = new Scene(lineChart, 640, 480);
            stage.setScene(scene);
            stage.show();
            scan.close();

        } catch (FileNotFoundException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

    }

}
