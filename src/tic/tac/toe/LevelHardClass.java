package tic.tac.toe;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class LevelHardClass {

    BoardScreenBase boardScreen;
    int[][] board;
    public static int playerSide = 0;
    private boolean win = false;

    public static boolean isRecording = false;

    public static String PlayerName = "YOU";
    public static int computerRes = 0, playerRes = 0;
    private ArrayList<Move> recordMoveList;
    Timer timer;

    public LevelHardClass() {
        timer = new Timer();
        boardScreen = new BoardScreenBase();
        board = new int[][]{{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}};

        recordMoveList = new ArrayList<>();

        if (LevelScreenBase.randomFlag) {
            boardScreen.levelText.setLayoutX(320.0);
            boardScreen.levelText.setText("Random");
        } else {
            boardScreen.levelText.setLayoutX(345.0);
            boardScreen.levelText.setText("Hard");
        }
        boardScreen.player1Text.setText("Computer");

        boardScreen.player1Text.setText(PlayerName);
        boardScreen.player2Text.setText("Computer");
        boardScreen.scorePlayer1.setText("" + playerRes);
        boardScreen.scorePlayer2.setText("" + computerRes);
        boardScreen.box00.setOnMouseClicked(e -> {
            if (board[0][0] == -1 && win == false && isMovesLeft(board)) {
                board[0][0] = playerSide;
                playSound();

                recordMoveList.add(new Move(playerSide == 0 ? "x" : "o", "0", "0"));

                setMoveOnScreen("00", "" + (playerSide == 0 ? 'X' : 'O'));
                int ev = pridectWinner(board);
                ShowWinner(ev);
                if (ev == -1) {
                    moveComputer();
                }
            }

        });
        boardScreen.box10.setOnMouseClicked(e -> {
            if (board[1][0] == -1 && win == false && isMovesLeft(board)) {
                board[1][0] = playerSide;
                playSound();

                recordMoveList.add(new Move(playerSide == 0 ? "x" : "o", "1", "0"));
                setMoveOnScreen("10", "" + (playerSide == 0 ? 'X' : 'O'));
                int ev = pridectWinner(board);
                ShowWinner(ev);
                if (ev == -1) {
                    moveComputer();
                }
            }
        });
        boardScreen.box20.setOnMouseClicked(e -> {
            if (board[2][0] == -1 && win == false && isMovesLeft(board)) {
                board[2][0] = playerSide;
                playSound();

                recordMoveList.add(new Move(playerSide == 0 ? "x" : "o", "2", "0"));
                setMoveOnScreen("20", "" + (playerSide == 0 ? 'X' : 'O'));
                int ev = pridectWinner(board);
                ShowWinner(ev);
                if (ev == -1) {
                    moveComputer();
                }
            }
        });
        boardScreen.box01.setOnMouseClicked(e -> {
            if (board[0][1] == -1 && win == false && isMovesLeft(board)) {
                board[0][1] = playerSide;
                playSound();

                recordMoveList.add(new Move(playerSide == 0 ? "x" : "o", "0", "1"));
                setMoveOnScreen("01", "" + (playerSide == 0 ? 'X' : 'O'));
                int ev = pridectWinner(board);
                ShowWinner(ev);
                if (ev == -1) {
                    moveComputer();
                }
            }
        });
        boardScreen.box11.setOnMouseClicked(e -> {
            if (board[1][1] == -1 && win == false && isMovesLeft(board)) {
                board[1][1] = playerSide;
                playSound();

                recordMoveList.add(new Move(playerSide == 0 ? "x" : "o", "1", "1"));
                setMoveOnScreen("11", "" + (playerSide == 0 ? 'X' : 'O'));
                int ev = pridectWinner(board);
                ShowWinner(ev);
                if (ev == -1) {
                    moveComputer();
                }
            }
        });
        boardScreen.box21.setOnMouseClicked(e -> {

            if (board[2][1] == -1 && win == false && isMovesLeft(board)) {
                board[2][1] = playerSide;
                playSound();

                recordMoveList.add(new Move(playerSide == 0 ? "x" : "o", "2", "1"));

                setMoveOnScreen("21", "" + (playerSide == 0 ? 'X' : 'O'));
                int ev = pridectWinner(board);
                ShowWinner(ev);
                if (ev == -1) {
                    moveComputer();
                }
            }
        });
        boardScreen.box02.setOnMouseClicked(e -> {

            if (board[0][2] == -1 && win == false && isMovesLeft(board)) {
                board[0][2] = playerSide;
                playSound();

                recordMoveList.add(new Move(playerSide == 0 ? "x" : "o", "0", "2"));

                setMoveOnScreen("02", "" + (playerSide == 0 ? 'X' : 'O'));
                int ev = pridectWinner(board);
                ShowWinner(ev);
                if (ev == -1) {
                    moveComputer();
                }
            }

        });
        boardScreen.box12.setOnMouseClicked(e -> {

            if (board[1][2] == -1 && win == false && isMovesLeft(board)) {
                board[1][2] = playerSide;
                playSound();

                recordMoveList.add(new Move(playerSide == 0 ? "x" : "o", "1", "2"));

                setMoveOnScreen("12", "" + (playerSide == 0 ? 'X' : 'O'));
                int ev = pridectWinner(board);
                ShowWinner(ev);
                if (ev == -1) {
                    moveComputer();
                }
            }
        });
        boardScreen.box22.setOnMouseClicked(e -> {
            if (board[2][2] == -1 && win == false && isMovesLeft(board)) {
                board[2][2] = playerSide;
                playSound();

                recordMoveList.add(new Move(playerSide == 0 ? "x" : "o", "2", "2"));
                setMoveOnScreen("22", "" + (playerSide == 0 ? 'X' : 'O'));
                int ev = pridectWinner(board);
                ShowWinner(ev);
                if (ev == -1) {
                    moveComputer();
                }
            }
        });
    }

    private void moveComputer() {
        int[] best = getbestMove();
        if (best[0] != -1 && best[1] != -1) {
            board[best[0]][best[1]] = playerSide == 0 ? 1 : 0;
            recordMoveList.add(new Move(playerSide == 0 ? "o" : "x", "" + best[0], "" + best[1]));
            int winner = pridectWinner(board);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(LevelHardClass.class.getName()).log(Level.SEVERE, null, ex);
            }
            setMoveOnScreen("" + best[0] + "" + best[1], playerSide == 0 ? "O" : "X");

            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(LevelHardClass.class.getName()).log(Level.SEVERE, null, ex);
            }
            ShowWinner(winner);
        }
    }

    private int pridectWinner(int[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[2][i] != -1) {
                return board[0][i];
            }
        }
        //coloms
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][2] != -1) {
                return board[i][0];
            }
        }
        //diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] != -1) {
            return board[1][1];
        }
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[0][2] != -1) {
            return board[2][0];
        }

        return -1;
    }

    private void setMoveOnScreen(String location, String side) {
        side = side.toUpperCase();
        switch (location) {
            case "00":
                boardScreen.box00.setImage(new Image(getClass().getResource("Photos/" + side + ".png").toExternalForm()));
                break;
            case "10":
                boardScreen.box10.setImage(new Image(getClass().getResource("Photos/" + side + ".png").toExternalForm()));

                break;
            case "20":
                boardScreen.box20.setImage(new Image(getClass().getResource("Photos/" + side + ".png").toExternalForm()));

                break;
            case "01":
                boardScreen.box01.setImage(new Image(getClass().getResource("Photos/" + side + ".png").toExternalForm()));

                break;
            case "11":
                boardScreen.box11.setImage(new Image(getClass().getResource("Photos/" + side + ".png").toExternalForm()));

                break;
            case "21":
                boardScreen.box21.setImage(new Image(getClass().getResource("Photos/" + side + ".png").toExternalForm()));

                break;
            case "02":
                boardScreen.box02.setImage(new Image(getClass().getResource("Photos/" + side + ".png").toExternalForm()));

                break;
            case "12":
                boardScreen.box12.setImage(new Image(getClass().getResource("Photos/" + side + ".png").toExternalForm()));

                break;
            case "22":
                boardScreen.box22.setImage(new Image(getClass().getResource("Photos/" + side + ".png").toExternalForm()));

                break;
        }

    }

    private Boolean isMovesLeft(int board[][]) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == -1) {
                    return true;
                }
            }
        }
        return false;
    }

    private int[] getbestMove() {
        int depth = 10000;
        int depthStop = -10000;
        int[] bestwin = new int[]{-1, -1};
        int[] bestStop = new int[]{-1, -1};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == -1) {
                    board[j][i] = playerSide == 0 ? 1 : 0;
                    int h = gominimax(board, playerSide);
                    if (h <= depth) {
                        bestwin[0] = j;
                        bestwin[1] = i;
                        depth = h;
                    }
                    if (h >= depthStop) {
                        bestStop[0] = j;
                        bestStop[1] = i;
                        depthStop = h;
                    }
                    board[j][i] = -1;
                }
            }
        }
        if (bestwin[0] != -1) {
            board[bestwin[0]][bestwin[1]] = playerSide == 0 ? 1 : 0;
            if (pridectWinner(board) == (playerSide == 0 ? 1 : 0)) {
                board[bestwin[0]][bestwin[1]] = -1;
                return bestwin;
            }
            board[bestwin[0]][bestwin[1]] = -1;
        }
        if (bestStop[0] != -1) {
            board[bestStop[0]][bestStop[1]] = playerSide;
            if (pridectWinner(board) == (playerSide)) {
                board[bestStop[0]][bestStop[1]] = -1;
                return bestStop;
            }
            board[bestStop[0]][bestStop[1]] = -1;
        }
        if (board[1][1] == -1) {
            return new int[]{1, 1};
        }
        return bestStop;
    }

    private int gominimax(int[][] board, int side) {
        int res = pridectWinner(board);
        int depth = 1;
        if (res == (playerSide == 0 ? 1 : 0)) {
            return depth;
        } else if (res == playerSide) {
            return -depth;
        }
        boolean hasEmptyCells = isMovesLeft(board);
        if (!hasEmptyCells) {
            return depth;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == -1) {
                    board[j][i] = side;
                    depth += gominimax(board, side == 0 ? 1 : 0);
                    board[j][i] = -1;
                }
            }
        }
        return depth;
    }

    private void ShowWinner(int ev) {
        if (ev == 0 || ev == 1) {
            if (BoardScreenBase.record) {
                recordGame(ev);
            }
            if (playerSide == ev) {
                playerRes++;
            } else {
                computerRes++;
            }

            win = true;
            colorRectangles(board);
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    WinnerScreenBase winner = new WinnerScreenBase();
                    winner.PrepareWinnerScreen(ev == playerSide ? PlayerName : "Computer", ev == playerSide ? 1 : -1);
                    timer.cancel();
                }
            }, 2000, 2000);

        } else if (ev == -1 && !isMovesLeft(board)) {
            win = true;
            if (BoardScreenBase.record) {
                recordGame(ev);
            }
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    WinnerScreenBase winner = new WinnerScreenBase();
                    winner.PrepareWinnerScreen("Draw", 0);
                    timer.cancel();
                }
            }, 2000, 2000);
        }
    }

    private void playSound() {
        TicTacToe.player.stop();
        TicTacToe.player = new MediaPlayer(new Media(getClass().getResource("/sounds/x.mp3").toExternalForm()));
        TicTacToe.player.play();
    }

     public void recordGame(int winner){
    
        File file = new File("Game.//"+LoginFXMLBase.playerData.getPlayerID());
        if (!file.exists()){
            file.mkdirs();
            Gson gson = new Gson();
            String timeStamp = new Timestamp(System.currentTimeMillis()).toString();
            String date = timeStamp.replace(":", "-");
            Record record = new Record(2, "YOU", winner==-1?"Draw":(winner==playerSide?PlayerName:"Computer"),"Hard", recordMoveList, new Date(),playerSide==0?"x":"o");
            try {
                Writer writer = new FileWriter("Game//"+LoginFXMLBase.playerData.getPlayerID()+"//"+date.toString()+".json");
                gson.toJson(record,writer);
                writer.close();

            } catch (IOException ex) {
                Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
             Gson gson = new Gson();
            String timeStamp = new Timestamp(System.currentTimeMillis()).toString();
            String date = timeStamp.replace(":", "-");
            Record record = new Record(2, "YOU", winner==-1?"Draw":(winner==playerSide?PlayerName:"Computer"),"Hard", recordMoveList, new Date(),playerSide==0?"x":"o");
            try {
                Writer writer = new FileWriter("Game//"+LoginFXMLBase.playerData.getPlayerID()+"//"+date.toString()+".json");
                gson.toJson(record,writer);
                writer.close();

            } catch (IOException ex) {
                Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public int colorRectangles(int[][] board) {

        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[2][i] != -1) {
                if (i == 0) {
                    boardScreen.rectangle.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreen.rectangle2.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreen.rectangle5.setFill(javafx.scene.paint.Color.AQUAMARINE);
                } else if (i == 1) {
                    boardScreen.rectangle0.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreen.rectangle3.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreen.rectangle6.setFill(javafx.scene.paint.Color.AQUAMARINE);
                } else if (i == 2) {
                    boardScreen.rectangle1.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreen.rectangle4.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreen.rectangle7.setFill(javafx.scene.paint.Color.AQUAMARINE);
                }
                return board[0][i];
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][2] != -1) {
                if (i == 0) {
                    boardScreen.rectangle.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreen.rectangle0.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreen.rectangle1.setFill(javafx.scene.paint.Color.AQUAMARINE);
                } else if (i == 1) {
                    boardScreen.rectangle2.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreen.rectangle3.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreen.rectangle4.setFill(javafx.scene.paint.Color.AQUAMARINE);
                } else if (i == 2) {
                    boardScreen.rectangle5.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreen.rectangle6.setFill(javafx.scene.paint.Color.AQUAMARINE);
                    boardScreen.rectangle7.setFill(javafx.scene.paint.Color.AQUAMARINE);
                }
                return board[i][0];
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] != -1) {
            boardScreen.rectangle.setFill(javafx.scene.paint.Color.AQUAMARINE);
            boardScreen.rectangle3.setFill(javafx.scene.paint.Color.AQUAMARINE);
            boardScreen.rectangle7.setFill(javafx.scene.paint.Color.AQUAMARINE);
            return board[1][1];
        }
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[0][2] != -1) {
            boardScreen.rectangle1.setFill(javafx.scene.paint.Color.AQUAMARINE);
            boardScreen.rectangle3.setFill(javafx.scene.paint.Color.AQUAMARINE);
            boardScreen.rectangle5.setFill(javafx.scene.paint.Color.AQUAMARINE);
            return board[2][0];
        }

        return -1;
    }

}
