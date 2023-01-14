package tic.tac.toe;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Medium {

    public static String side;
    BoardScreenBase boardScreenBase;
    public String PlayerName = "you";

    WinnerScreenBase winner;
    public static int player = 0;
    public static int computer = 0;

    int board[][] = {{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}};
    boolean win = false;
    ArrayList<Move> list;
    Timer timer;

    public Medium() {
        timer = new Timer();
        list = new ArrayList<>();
        boardScreenBase = new BoardScreenBase();
        boardScreenBase.levelText.setLayoutX(330);
        boardScreenBase.levelText.setWrappingWidth(100);
        if (LevelScreenBase.randomFlag) {
            boardScreenBase.levelText.setLayoutX(320.0);
            boardScreenBase.levelText.setText("Random");
        } else {
            boardScreenBase.levelText.setLayoutX(330.0);
            boardScreenBase.levelText.setText("Medium");
        }
        boardScreenBase.player1Text.setText(PlayerName);
        boardScreenBase.player2Text.setWrappingWidth(100);
        boardScreenBase.player2Text.setLayoutX(445);
        boardScreenBase.player2Text.setText("Computer");
        boardScreenBase.scorePlayer1.setText(String.valueOf(player));
        boardScreenBase.scorePlayer2.setText(String.valueOf(computer));
        winner = new WinnerScreenBase();
        click();

    }

    public void click() {
        boardScreenBase.box00.setOnMouseClicked(e -> {
            if (isEmpty(board[0][0]) && !win) {
                printSides(00);
                playSound();
                board[0][0] = 1;
                winner();
                if (isMovesLeft(board)) {
                    if (!win) {
                        computer();
                        winner();
                    }
                }
            }
        });

        boardScreenBase.box01.setOnMouseClicked(e -> {
            if (isEmpty(board[0][1]) && !win) {
                printSides(01);
                playSound();
                board[0][1] = 1;
                winner();
                if (isMovesLeft(board)) {
                    if (!win) {
                        computer();
                        winner();
                    }
                }
            }

        });

        boardScreenBase.box02.setOnMouseClicked(e -> {
            if (isEmpty(board[0][2]) && !win) {
                printSides(02);
                playSound();
                board[0][2] = 1;
                winner();
                if (isMovesLeft(board)) {
                    if (!win) {
                        computer();
                        winner();
                    }
                }

            }
        });

        boardScreenBase.box10.setOnMouseClicked(e -> {
            if (isEmpty(board[1][0]) && !win) {
                printSides(10);
                playSound();
                board[1][0] = 1;
                winner();
                if (isMovesLeft(board)) {
                    if (!win) {
                        computer();
                        winner();
                    }
                }

            }
        });
        boardScreenBase.box11.setOnMouseClicked(e -> {
            if (isEmpty(board[1][1]) && !win) {
                printSides(11);
                playSound();
                board[1][1] = 1;
                winner();
                if (isMovesLeft(board)) {
                    if (!win) {
                        computer();
                        winner();
                    }
                }
            }
        });

        boardScreenBase.box12.setOnMouseClicked(e -> {
            if (isEmpty(board[1][2]) && !win) {
                printSides(12);
                playSound();
                board[1][2] = 1;
                winner();
                if (isMovesLeft(board)) {
                    if (!win) {

                        computer();
                        winner();
                    }
                }

            }
        });

        boardScreenBase.box20.setOnMouseClicked(e -> {
            if (isEmpty(board[2][0]) && !win) {
                printSides(20);
                playSound();
                board[2][0] = 1;
                winner();
                if (isMovesLeft(board)) {
                    if (!win) {

                        computer();
                        winner();
                    }
                }

            }
        });

        boardScreenBase.box21.setOnMouseClicked(e -> {
            if (isEmpty(board[2][1]) && !win) {
                printSides(21);
                playSound();
                board[2][1] = 1;
                winner();
                if (isMovesLeft(board)) {
                    if (!win) {
                        computer();
                        winner();
                    }
                }
            }
        });

        boardScreenBase.box22.setOnMouseClicked(e -> {
            if (isEmpty(board[2][2]) && !win) {
                printSides(22);
                playSound();
                board[2][2] = 1;
                winner();
                if (isMovesLeft(board)) {
                    computer();
                    winner();
                }
            }
        });

        boardScreenBase.box12.setOnMouseClicked(e -> {
            if (isEmpty(board[1][2]) && !win) {
                printSides(12);
                board[1][2] = 1;
                winner();
                if (isMovesLeft(board)) {
                    if (!win) {
                        computer();
                        winner();
                    }
                }

            }
        });

        boardScreenBase.box20.setOnMouseClicked(e -> {
            if (isEmpty(board[2][0]) && !win) {
                printSides(20);
                board[2][0] = 1;
                winner();
                if (isMovesLeft(board)) {
                    if (!win) {
                        computer();
                        winner();
                    }
                }
            }
        });

        boardScreenBase.box21.setOnMouseClicked(e -> {
            if (isEmpty(board[2][1]) && !win) {
                printSides(21);
                board[2][1] = 1;
                winner();
                if (isMovesLeft(board)) {
                    if (!win) {
                        computer();
                        winner();
                    }
                }
            }
        });

        boardScreenBase.box22.setOnMouseClicked(e -> {
            if (isEmpty(board[2][2]) && !win) {
                printSides(22);
                board[2][2] = 1;
                winner();
                if (isMovesLeft(board)) {
                    computer();
                    winner();
                }
            }
        });

    }

    public void printSides(int number) {

        if (side == "x") {
            switch (number) {

                case 00:
                    boardScreenBase.box00.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    Move move = new Move(side, "0", "0");
                    list.add(move);
                    break;

                case 01:
                    boardScreenBase.box01.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    Move move1 = new Move(side, "0", "1");
                    list.add(move1);
                    break;

                case 02:
                    boardScreenBase.box02.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    Move move2 = new Move(side, "0", "2");
                    list.add(move2);
                    break;

                case 10:
                    boardScreenBase.box10.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    Move move3 = new Move(side, "1", "0");
                    list.add(move3);
                    break;

                case 11:
                    boardScreenBase.box11.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    Move move4 = new Move(side, "1", "1");
                    list.add(move4);
                    break;

                case 12:
                    boardScreenBase.box12.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    Move move5 = new Move(side, "1", "2");
                    list.add(move5);
                    break;

                case 20:
                    boardScreenBase.box20.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    Move move6 = new Move(side, "2", "0");
                    list.add(move6);
                    break;

                case 21:
                    boardScreenBase.box21.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    Move move7 = new Move(side, "2", "1");
                    list.add(move7);
                    break;
                case 22:
                    boardScreenBase.box22.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    Move move8 = new Move(side, "2", "2");
                    list.add(move8);
                    break;
                default:
                    break;
            }

        } else if (side == "o") {

            switch (number) {

                case 00:
                    boardScreenBase.box00.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    Move move = new Move(side, "0", "0");
                    list.add(move);
                    break;

                case 01:
                    boardScreenBase.box01.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    Move move1 = new Move(side, "0", "1");
                    list.add(move1);
                    break;

                case 02:
                    boardScreenBase.box02.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    Move move2 = new Move(side, "0", "2");
                    list.add(move2);
                    break;

                case 10:
                    boardScreenBase.box10.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    Move move3 = new Move(side, "1", "0");
                    list.add(move3);
                    break;

                case 11:
                    boardScreenBase.box11.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    Move move4 = new Move(side, "1", "1");
                    list.add(move4);
                    break;

                case 12:
                    boardScreenBase.box12.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    Move move5 = new Move(side, "1", "2");
                    list.add(move5);
                    break;

                case 20:
                    boardScreenBase.box20.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    Move move6 = new Move(side, "2", "0");
                    list.add(move6);
                    break;

                case 21:
                    boardScreenBase.box21.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    Move move7 = new Move(side, "2", "1");
                    list.add(move7);
                    break;

                case 22:
                    boardScreenBase.box22.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    Move move8 = new Move(side, "2", "2");
                    list.add(move8);
                    break;
                default:
                    break;
            }

        }

    }

    public void winner() {

        if (pridectWinner(board) == 1) {
            player += 1;
            colorRectangles(board);
             timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        winner.PrepareWinnerScreen("win", 1);
                        timer.cancel();
                    }
                }, 2000, 2000);
           
            recordGame("you");
            win = true;

        } else if (pridectWinner(board) == 0) {
            computer += 1;
            colorRectangles(board);
             timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                         winner.PrepareWinnerScreen("lose", -1);
                        timer.cancel();
                    }
                }, 2000, 2000);
            recordGame("Computer");
            if (side == "x") {
                side = "o";
            } else {
                side = "x";
            }
            win = true;

        } else if (!isMovesLeft(board)) {
            winner.PrepareWinnerScreen("draw", 0);
            recordGame("Draw");
            win = true;

        }
    }

    public boolean isEmpty(int place) {
        if (place >= 0) {
            return false;
        } else {
            return true;
        }
    }

    public void computer() {
        int counter = 0;
        playSound();
        int[] move = new int[2];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    counter++;
                }
            }
        }

        if (counter < 1) {
            random();
        } else {

            move = getbestMove(board, side == "x" ? 0 : 1);
            board[move[0]][move[1]] = 0;
            printSides(Integer.parseInt((Integer.toString(move[0]) + "" + Integer.toString(move[1]))));

            if (side == "x") {
                side = "o";
            } else {
                side = "x";
            }

        }
    }

    public void random() {
        String temp = side;
        int random = new Random().nextInt(9);

        switch (random) {
            case 0:
                if (isEmpty(board[0][0])) {
                    if (side == "x") {
                        side = "o";
                        printSides(00);
                        board[0][0] = 0;
                    } else {
                        side = "x";
                        printSides(00);
                        board[0][0] = 0;
                    }
                } else {
                    random();
                }
                break;
            case 1:
                if (isEmpty(board[0][1])) {
                    if (side == "x") {
                        side = "o";
                        printSides(01);
                        board[0][1] = 0;
                    } else {
                        side = "x";
                        printSides(01);
                        board[0][1] = 0;
                    }
                } else {
                    random();
                }
                break;

            case 2:
                if (isEmpty(board[0][2])) {
                    if (side == "x") {
                        side = "o";
                        printSides(02);
                        board[0][2] = 0;
                    } else {
                        side = "x";
                        printSides(02);
                        board[0][2] = 0;
                    }
                } else {
                    random();
                }
                break;

            case 3:
                if (isEmpty(board[1][0])) {
                    if (side == "x") {
                        side = "o";
                        printSides(10);
                        board[1][0] = 0;
                    } else {
                        side = "x";
                        printSides(10);
                        board[1][0] = 0;
                    }
                } else {
                    random();
                }
                break;

            case 4:
                if (isEmpty(board[1][1])) {
                    if (side == "x") {
                        side = "o";
                        printSides(11);
                        board[1][1] = 0;
                    } else {
                        side = "x";
                        printSides(11);
                        board[1][1] = 0;
                    }
                } else {
                    random();
                }
                break;

            case 5:
                if (isEmpty(board[1][2])) {
                    if (side == "x") {
                        side = "o";
                        printSides(12);
                        board[1][2] = 0;
                    } else {
                        side = "x";
                        printSides(12);
                        board[1][2] = 0;
                    }
                } else {
                    random();
                }
                break;

            case 6:
                if (isEmpty(board[2][0])) {
                    if (side == "x") {
                        side = "o";
                        printSides(20);
                        board[2][0] = 0;
                    } else {
                        side = "x";
                        printSides(20);
                        board[2][0] = 0;
                    }
                } else {
                    random();
                }
                break;

            case 7:
                if (isEmpty(board[2][1])) {
                    if (side == "x") {
                        side = "o";
                        printSides(21);
                        board[2][1] = 0;
                    } else {
                        side = "x";
                        printSides(21);
                        board[2][1] = 0;
                    }
                } else {
                    random();
                }
                break;

            case 8:
                if (isEmpty(board[2][2])) {
                    if (side == "x") {
                        side = "o";
                        printSides(22);
                        board[2][2] = 0;
                    } else {
                        side = "x";
                        printSides(22);
                        board[2][2] = 0;
                    }
                } else {
                    random();
                }
                break;
            default:

                break;
        }

        side = temp;

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

    private int[] getbestMove(int[][] board, int playerSide) {
        if (side == "x") {
            side = "o";
        } else {
            side = "x";
        }
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
        board[bestwin[0]][bestwin[1]] = playerSide == 0 ? 1 : 0;
        if (pridectWinner(board) == (playerSide == 0 ? 1 : 0)) {
            board[bestwin[0]][bestwin[1]] = -1;
            return bestwin;
        }
        board[bestwin[0]][bestwin[1]] = -1;
        board[bestStop[0]][bestStop[1]] = playerSide;
        if (pridectWinner(board) == (playerSide)) {
            board[bestStop[0]][bestStop[1]] = -1;
            return bestStop;
        }
        board[bestStop[0]][bestStop[1]] = -1;
        if (board[1][1] == -1) {
            return new int[]{1, 1};
        }
        return bestStop;
    }

    private int gominimax(int[][] board, int iside) {
        int h = pridectWinner(board);
        int depth = 1;
        if (h == (side == "x" ? 1 : 0)) {

            return depth;
        } else if (h == (side == "x" ? 0 : 1)) {
            return -depth;
        }
        boolean hasEmptyCells = isMovesLeft(board);
        if (!hasEmptyCells) {
            return depth;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == -1) {
                    board[j][i] = iside;
                    depth += gominimax(board, iside == 0 ? 1 : 0);
                    board[j][i] = -1;
                }
            }
        }
        return depth;
    }

    public int pridectWinner(int[][] board) {

        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[2][i] != -1) {
                return board[0][i];
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][2] != -1) {
                return board[i][0];
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] != -1) {
            return board[1][1];
        }
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[0][2] != -1) {
            return board[2][0];
        }

        return -1;
    }

     public int colorRectangles(int[][] board) {

        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[2][i] != -1) {
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
                return board[0][i];
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][2] != -1) {
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
                return board[i][0];
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] != -1) {
             boardScreenBase.rectangle.setFill(javafx.scene.paint.Color.AQUAMARINE);
            boardScreenBase.rectangle3.setFill(javafx.scene.paint.Color.AQUAMARINE);
            boardScreenBase.rectangle7.setFill(javafx.scene.paint.Color.AQUAMARINE);
            return board[1][1];
        }
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[0][2] != -1) {
            boardScreenBase.rectangle1.setFill(javafx.scene.paint.Color.AQUAMARINE);
            boardScreenBase.rectangle3.setFill(javafx.scene.paint.Color.AQUAMARINE);
            boardScreenBase.rectangle5.setFill(javafx.scene.paint.Color.AQUAMARINE);
            return board[2][0];
        }

        return -1;
    }

    private void playSound() {
        TicTacToe.player.stop();
        TicTacToe.player = new MediaPlayer(new Media(getClass().getResource("/sounds/x.mp3").toExternalForm()));
        TicTacToe.player.play();
    }

    public void recordGame(String winner) {
        if (BoardScreenBase.record == true) {
            Gson gson = new Gson();
            String timeStamp = new Timestamp(System.currentTimeMillis()).toString();
            String date = timeStamp.replace(":", "-");
            Record record = new Record(0, "Computer", winner, "Medium", list, new Date(), side);
            try {
                Writer writer = new FileWriter("Game//" + date.toString() + ".json");
                gson.toJson(record, writer);
                writer.close();

            } catch (IOException ex) {
                Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
