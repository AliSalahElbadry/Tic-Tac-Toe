package tic.tac.toe;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

public class ShowGame implements Runnable {

    BoardScreenBase boardScreenBase;
    ArrayList<Move> move;
    int board[][] = {{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}};

    public ShowGame(Record record) {
        boardScreenBase = new BoardScreenBase();
        move = new ArrayList<>();
        this.move = record.recordList;
        boardScreenBase.levelText.setText(record.level);
        boardScreenBase.player1Text.setText(LoginFXMLBase.playerData.getUserName());
        boardScreenBase.player2Text.setText(record.player2Name);
        boardScreenBase.scorePlayer1.setText(record.getPlayer1_side());

        if (record.getPlayer1_side().equals("x")) {
            boardScreenBase.scorePlayer2.setText("o");
        } else {
            boardScreenBase.scorePlayer2.setText("x");
        }

    }

    @Override
    public void run() {
        for (int i = 0; i < move.size(); i++) {
            setMoveOnScreen(move.get(i).getX() + move.get(i).getY(), move.get(i).getSide());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ShowGame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void setMoveOnScreen(String location, String side) {
        side = side.toUpperCase();
        switch (location) {
            case "00":
                boardScreenBase.box00.setImage(new Image(getClass().getResource("Photos/" + side + ".png").toExternalForm()));
                if (side.equals("X")) {
                    board[0][0] = 1;
                } else {
                    board[0][0] = 0;
                }
                break;
            case "10":
                boardScreenBase.box10.setImage(new Image(getClass().getResource("Photos/" + side + ".png").toExternalForm()));
                if (side.equals("X")) {
                    board[1][0] = 1;
                } else {
                    board[1][0] = 0;
                }
                break;
            case "20":
                boardScreenBase.box20.setImage(new Image(getClass().getResource("Photos/" + side + ".png").toExternalForm()));
                if (side.equals("X")) {
                    board[2][0] = 1;
                } else {
                    board[2][0] = 0;
                }
                break;
            case "01":
                boardScreenBase.box01.setImage(new Image(getClass().getResource("Photos/" + side + ".png").toExternalForm()));
                if (side.equals("X")) {
                    board[0][1] = 1;
                } else {
                    board[0][1] = 0;
                }
                break;
            case "11":
                boardScreenBase.box11.setImage(new Image(getClass().getResource("Photos/" + side + ".png").toExternalForm()));
                if (side.equals("X")) {
                    board[1][1] = 1;
                } else {
                    board[1][1] = 0;
                }
                break;
            case "21":
                boardScreenBase.box21.setImage(new Image(getClass().getResource("Photos/" + side + ".png").toExternalForm()));
                if (side.equals("X")) {
                    board[2][1] = 1;
                } else {
                    board[2][1] = 0;
                }
                break;
            case "02":
                boardScreenBase.box02.setImage(new Image(getClass().getResource("Photos/" + side + ".png").toExternalForm()));
                if (side.equals("X")) {
                    board[0][2] = 1;
                } else {
                    board[0][2] = 0;
                }
                break;
            case "12":
                boardScreenBase.box12.setImage(new Image(getClass().getResource("Photos/" + side + ".png").toExternalForm()));
                if (side.equals("X")) {
                    board[1][2] = 1;
                } else {
                    board[1][2] = 0;
                }
                break;
            case "22":
                boardScreenBase.box22.setImage(new Image(getClass().getResource("Photos/" + side + ".png").toExternalForm()));
                if (side.equals("X")) {
                    board[2][2] = 1;
                } else {
                    board[2][2] = 0;
                }
                break;
        }
        checkDiagonal();
        checkHorizontal();
        checkVertical();

    }

    void checkVertical() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != -1) {
                if (i == 0) {
                    boardScreenBase.rectangle.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreenBase.rectangle2.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreenBase.rectangle5.setFill(javafx.scene.paint.Color.AQUAMARINE);
                } else if (i == 1) {
                    boardScreenBase.rectangle0.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreenBase.rectangle3.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreenBase.rectangle6.setFill(javafx.scene.paint.Color.AQUAMARINE);
                } else if (i == 2) {
                    boardScreenBase.rectangle1.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreenBase.rectangle4.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreenBase.rectangle7.setFill(javafx.scene.paint.Color.AQUAMARINE);
                }
                return;
            }
        }

    }

    void checkHorizontal() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != -1) {
                if (i == 0) {
                    boardScreenBase.rectangle.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreenBase.rectangle0.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreenBase.rectangle1.setFill(javafx.scene.paint.Color.AQUAMARINE);
                } else if (i == 1) {
                    boardScreenBase.rectangle2.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreenBase.rectangle3.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreenBase.rectangle4.setFill(javafx.scene.paint.Color.AQUAMARINE);
                } else if (i == 2) {
                    boardScreenBase.rectangle5.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreenBase.rectangle6.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreenBase.rectangle7.setFill(javafx.scene.paint.Color.AQUAMARINE);
                }
                return;
            }
        }
    }

    void checkDiagonal() {
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != -1) {
            boardScreenBase.rectangle.setFill(javafx.scene.paint.Color.AQUAMARINE);
            boardScreenBase.rectangle3.setFill(javafx.scene.paint.Color.AQUAMARINE);
            boardScreenBase.rectangle7.setFill(javafx.scene.paint.Color.AQUAMARINE);

        } else if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != -1) {
            boardScreenBase.rectangle1.setFill(javafx.scene.paint.Color.AQUAMARINE);
            boardScreenBase.rectangle3.setFill(javafx.scene.paint.Color.AQUAMARINE);
            boardScreenBase.rectangle5.setFill(javafx.scene.paint.Color.AQUAMARINE);
        }

    }

}
