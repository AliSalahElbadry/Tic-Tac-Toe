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

public class Easy {

    BoardScreenBase boardScreen;
    WinnerScreenBase winnerScreen = new WinnerScreenBase();
    static int side = 0;
    static int playerScore = 0;
    static int computerScore = 0;
    boolean isWin;
    int board[][] = {{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}};
    ArrayList<Move> list;
    Timer timer ;
    public Easy() {
        timer = new Timer();
        list = new ArrayList<>();
        boardScreen = new BoardScreenBase();
        boardScreen.player2Text.setWrappingWidth(100);
        boardScreen.levelText.setLayoutX(330.0);
        boardScreen.player2Text.setLayoutX(435);
        boardScreen.player1Text.setText("You");
        if (LevelScreenBase.randomFlag) {
            boardScreen.levelText.setLayoutX(320.0);
            boardScreen.levelText.setText("Random");

        } else {
            boardScreen.levelText.setLayoutX(335.0);
            boardScreen.levelText.setText("Easy");
        }
        boardScreen.scorePlayer1.setText(String.valueOf(playerScore));
        boardScreen.scorePlayer2.setText(String.valueOf(computerScore));

        boardScreen.levelText.setText("Easy");
        isWin = false;
        if (side == 0) {
            computerMove();
        }

        boardScreen.box00.setOnMouseClicked(e -> {
            if (isPositionEmpty(board[0][0]) && !isWin) {

                playInPositionP("00");
                playSound();

                checkMove();

            }
        });

        boardScreen.box01.setOnMouseClicked(e -> {
            if (isPositionEmpty(board[0][1]) && !isWin) {
                playInPositionP("01");
                playSound();
                checkMove();
            }
        });

        boardScreen.box02.setOnMouseClicked(e -> {
            if (isPositionEmpty(board[0][2]) && !isWin) {
                playInPositionP("02");
                playSound();
                checkMove();
            }
        });

        boardScreen.box10.setOnMouseClicked(e -> {
            if (isPositionEmpty(board[1][0]) && !isWin) {
                playInPositionP("10");
                playSound();
                checkMove();
            }
        });

        boardScreen.box11.setOnMouseClicked(e -> {
            if (isPositionEmpty(board[1][1]) && !isWin) {
                playInPositionP("11");
                playSound();
                checkMove();
            }
        });

        boardScreen.box12.setOnMouseClicked(e -> {
            if (isPositionEmpty(board[1][2]) && !isWin) {
                playInPositionP("12");
                playSound();
                checkMove();
            }
        });

        boardScreen.box20.setOnMouseClicked(e -> {
            if (isPositionEmpty(board[2][0]) && !isWin) {
                playInPositionP("20");
                playSound();
                checkMove();
            }
        });

        boardScreen.box21.setOnMouseClicked(e -> {
            if (isPositionEmpty(board[2][1]) && !isWin) {
                playInPositionP("21");
                playSound();
                checkMove();
            }
        });

        boardScreen.box22.setOnMouseClicked(e -> {
            if (isPositionEmpty(board[2][2]) && !isWin) {
                playInPositionP("22");
                playSound();
                checkMove();
            }
        });

    }

    public boolean isPositionEmpty(int position) {
        return position == -1;
    }

    public void computerMove() {
        Random computerMove = new Random();
        int row = computerMove.nextInt(3);
        int column = computerMove.nextInt(3);
        while (board[row][column] != -1) {

            row = computerMove.nextInt(3);
            column = computerMove.nextInt(3);
            if (board[row][column] == -1) {
                break;
            }
        }
        String position = String.valueOf(row).concat(String.valueOf(column));
        playInPositionC(position);
        int isWinner = checkWinner();
        if (isWinner == -1) {
            if (checkDraw()) {
                 timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                         winnerScreen.PrepareWinnerScreen("", 0);
                        timer.cancel();
                    }
                }, 2000, 2000);
               
            }

        } else {
            timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        winnerScreen.PrepareWinnerScreen("", -1);
                        timer.cancel();
                    }
                }, 2000, 2000);
            
            computerScore += 1;

        }

    }

    public void playInPositionC(String position) {
        switch (position) {
            case "00":
                if (side == 0) {
                    boardScreen.box00.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    Move move = new Move("x", "0", "0");
                    list.add(move);
                    board[0][0] = 1;
                } else {
                    boardScreen.box00.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    Move move = new Move("o", "0", "0");
                    list.add(move);
                    board[0][0] = 0;
                }
                break;
            case "01":
                if (side == 0) {
                    boardScreen.box01.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    Move move1 = new Move("x", "0", "1");
                    list.add(move1);
                    board[0][1] = 1;
                } else {
                    boardScreen.box01.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    Move move1 = new Move("o", "0", "1");
                    list.add(move1);
                    board[0][1] = 0;
                }
                break;
            case "02":
                if (side == 0) {
                    boardScreen.box02.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    Move move2 = new Move("x", "0", "2");
                    list.add(move2);
                    board[0][2] = 1;
                } else {
                    boardScreen.box02.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    Move move2 = new Move("o", "0", "2");
                    list.add(move2);
                    board[0][2] = 0;
                }
                break;
            case "10":
                if (side == 0) {
                    boardScreen.box10.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    Move move3 = new Move("x", "1", "0");
                    list.add(move3);
                    board[1][0] = 1;
                } else {
                    boardScreen.box10.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    Move move3 = new Move("o", "1", "0");
                    list.add(move3);
                    board[1][0] = 0;
                }
                break;
            case "11":
                if (side == 0) {
                    boardScreen.box11.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    Move move4 = new Move("x", "1", "1");
                    list.add(move4);
                    board[1][1] = 1;
                } else {
                    boardScreen.box11.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    Move move4 = new Move("o", "1", "1");
                    list.add(move4);
                    board[1][1] = 0;
                }
                break;
            case "12":
                if (side == 0) {
                    boardScreen.box12.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    Move move5 = new Move("x", "1", "2");
                    list.add(move5);
                    board[1][2] = 1;
                } else {
                    boardScreen.box12.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    Move move5 = new Move("o", "1", "2");
                    list.add(move5);
                    board[1][2] = 0;
                }
                break;
            case "20":
                if (side == 0) {
                    boardScreen.box20.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    Move move6 = new Move("x", "2", "0");
                    list.add(move6);
                    board[2][0] = 1;
                } else {
                    boardScreen.box20.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    Move move6 = new Move("o", "2", "0");
                    list.add(move6);
                    board[2][0] = 0;
                }
                break;
            case "21":
                if (side == 0) {
                    boardScreen.box21.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    Move move7 = new Move("x", "2", "1");
                    list.add(move7);
                    board[2][1] = 1;
                } else {
                    boardScreen.box21.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    Move move7 = new Move("o", "2", "1");
                    list.add(move7);
                    board[2][1] = 0;
                }
                break;
            case "22":
                if (side == 0) {
                    boardScreen.box22.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    Move move8 = new Move("x", "2", "2");
                    list.add(move8);
                    board[2][2] = 1;
                } else {
                    boardScreen.box22.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    Move move8 = new Move("o", "2", "2");
                    list.add(move8);
                    board[2][2] = 0;
                }
                break;
        }
    }

    public void playInPositionP(String position) {
        switch (position) {
            case "00":
                if (side == 0) {
                    boardScreen.box00.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    Move move = new Move("o", "0", "0");
                    list.add(move);
                    board[0][0] = 0;
                } else {
                    boardScreen.box00.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    Move move = new Move("x", "0", "0");
                    list.add(move);
                    board[0][0] = 1;
                }
                break;
            case "01":
                if (side == 0) {
                    boardScreen.box01.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    Move move1 = new Move("o", "0", "1");
                    list.add(move1);
                    board[0][1] = 0;
                } else {
                    boardScreen.box01.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    Move move1 = new Move("x", "0", "1");
                    list.add(move1);
                    board[0][1] = 1;
                }
                break;
            case "02":
                if (side == 0) {
                    boardScreen.box02.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    Move move2 = new Move("o", "0", "2");
                    list.add(move2);
                    board[0][2] = 0;
                } else {
                    boardScreen.box02.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    Move move2 = new Move("x", "0", "2");
                    list.add(move2);
                    board[0][2] = 1;
                }
                break;
            case "10":
                if (side == 0) {
                    boardScreen.box10.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    Move move3 = new Move("o", "1", "0");
                    list.add(move3);
                    board[1][0] = 0;
                } else {
                    boardScreen.box10.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    Move move3 = new Move("x", "1", "0");
                    list.add(move3);
                    board[1][0] = 1;
                }
                break;
            case "11":
                if (side == 0) {
                    boardScreen.box11.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    Move move4 = new Move("o", "1", "1");
                    list.add(move4);
                    board[1][1] = 0;
                } else {
                    boardScreen.box11.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    Move move4 = new Move("x", "1", "1");
                    list.add(move4);
                    board[1][1] = 1;
                }
                break;
            case "12":
                if (side == 0) {
                    boardScreen.box12.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    Move move5 = new Move("o", "1", "2");
                    list.add(move5);
                    board[1][2] = 0;
                } else {
                    boardScreen.box12.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    Move move5 = new Move("x", "1", "2");
                    list.add(move5);
                    board[1][2] = 1;
                }
                break;
            case "20":
                if (side == 0) {
                    boardScreen.box20.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    Move move6 = new Move("o", "2", "0");
                    list.add(move6);
                    board[2][0] = 0;
                } else {
                    boardScreen.box20.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    Move move6 = new Move("x", "2", "0");
                    list.add(move6);
                    board[2][0] = 1;
                }
                break;
            case "21":
                if (side == 0) {
                    boardScreen.box21.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    Move move7 = new Move("o", "2", "1");
                    list.add(move7);
                    board[2][1] = 0;
                } else {
                    boardScreen.box21.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    Move move7 = new Move("x", "2", "1");
                    list.add(move7);
                    board[2][1] = 1;
                }
                break;
            case "22":
                if (side == 0) {
                    boardScreen.box22.setImage(new Image(getClass().getResource("Photos/O.png").toExternalForm()));
                    Move move8 = new Move("o", "2", "2");
                    list.add(move8);
                    board[2][2] = 0;
                } else {
                    boardScreen.box22.setImage(new Image(getClass().getResource("Photos/X.png").toExternalForm()));
                    Move move8 = new Move("x", "2", "2");
                    list.add(move8);
                    board[2][2] = 1;
                }
                break;
        }
    }

    public int checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[2][i] != -1) {
                isWin = true;
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
                isWin = true;
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
            isWin = true;
            boardScreen.rectangle.setFill(javafx.scene.paint.Color.AQUAMARINE);
            boardScreen.rectangle3.setFill(javafx.scene.paint.Color.AQUAMARINE);
            boardScreen.rectangle7.setFill(javafx.scene.paint.Color.AQUAMARINE);
            return board[1][1];
        }
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[0][2] != -1) {
            isWin = true;
            boardScreen.rectangle1.setFill(javafx.scene.paint.Color.AQUAMARINE);
            boardScreen.rectangle3.setFill(javafx.scene.paint.Color.AQUAMARINE);
            boardScreen.rectangle5.setFill(javafx.scene.paint.Color.AQUAMARINE);

            return board[2][0];
        }
        isWin = false;

        return -1;
    }

    public boolean checkDraw() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    public void checkMove() {
        int isWinner = checkWinner();
        if (isWinner == -1) {
            if (checkDraw()) {
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                       winnerScreen.PrepareWinnerScreen("", 0);
                        timer.cancel();
                    }
                }, 2000, 2000);
            } else {
                computerMove();
            }
        } else if (isWinner == side) {
           
            timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        winnerScreen.PrepareWinnerScreen("", 1);
                        timer.cancel();
                    }
                }, 2000, 2000);
            recordGame("You");
            playerScore += 1;
        } else {
            timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        winnerScreen.PrepareWinnerScreen("", -1);
                        timer.cancel();
                    }
                }, 2000, 2000);
            recordGame("Computer");
            computerScore += 1;
        }
    }

    private void playSound() {
        TicTacToe.player.stop();
        TicTacToe.player = new MediaPlayer(new Media(getClass().getResource("/sounds/x.mp3").toExternalForm()));
        TicTacToe.player.play();
    }

    public void recordGame(String winner) {

        String sidee;
        if (side == 0) {
            sidee = "o";
        } else {
            sidee = "x";
        }
        if (BoardScreenBase.record == true) {
            Gson gson = new Gson();
            String timeStamp = new Timestamp(System.currentTimeMillis()).toString();
            String date = timeStamp.replace(":", "-");
            Record record = new Record(0, "Computer", winner, "Easy", list, new Date(), sidee);
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
