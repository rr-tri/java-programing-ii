/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author rr
 */
public class UI extends Application {

    private char currentPlayer;
    private boolean status;
    private final Button[][] board;

    public UI() {
        this.currentPlayer = 'X';
        this.status = true;
        this.board = new Button[3][3];
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane mainLayout = new BorderPane();
        mainLayout.setPadding(new Insets(20));

        GridPane buttons = new GridPane();
        buttons.setAlignment(Pos.CENTER);
        buttons.setHgap(20);
        buttons.setVgap(20);

        Label turnInfo = new Label("Turn: X");
        turnInfo.setFont(Font.font("Monospaced", 40));

        mainLayout.setTop(turnInfo);
        mainLayout.setCenter(buttons);

        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                Button button = new Button();
                button.setPrefSize(100, 100);
                button.setPadding(new Insets(10));
                button.setFont(Font.font("Monospaced", 40));

                button.setOnAction(e -> {

                    if (button.getText().isEmpty() && this.status) {

                        button.setText(String.valueOf(this.currentPlayer));
                        this.currentPlayer = (this.currentPlayer == 'X') ? 'O' : 'X';
                        turnInfo.setText("Turn: " + this.currentPlayer);
                    }
                    if (WonOrNot()) {
                        turnInfo.setText("The end!");
                        this.status = false;
                    }

                });

                this.board[i][j] = button;
                buttons.add(button, i, j);
            }
        }
        Scene scene = new Scene(mainLayout);
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.setTitle("TicTacToe");
        stage.show();
    }

   

    private boolean WonOrNot() {
        String winx = "";
        String wino = "";
        for (Button[] btn : this.board) {
            winx += "X";
            wino += "O";
        }
        
        String lrd = "";
        String rld = "";
        for (int i = 0; i < this.board.length; i++) {
            String h = "";
            String v = "";
            for (int j = 0; j < this.board.length; j++) {
                h += this.board[i][j].getText();
                v += this.board[j][i].getText();
                if (i == j) {
                    lrd += this.board[j][i].getText();
                }
                if (i + j == this.board.length - 1) {
                    rld += this.board[i][j].getText();
                }
            }
            if (h.equals(winx) || h.equals(wino)) {
                return true;
            }
            if (v.equals(winx) || v.equals(wino)) {
                return true;
            }
        }
        if (lrd.equals(winx) || lrd.equals(wino)) {
            return true;
        }
        if (rld.equals(winx) || rld.equals(wino)) {
            return true;
        }

        return false;
    }
}
