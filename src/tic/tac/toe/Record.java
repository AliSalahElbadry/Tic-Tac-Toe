
package tic.tac.toe;


import java.util.ArrayList;
import java.util.Date;


public class Record {
    
    int playerId;
    String player2Name;
    String Winner;
    ArrayList<Move> recordList;
    String level;
    Date date;
    String player1_side;

    public Record() {
    }
    
    
    public Record(int playerId ,String player2Name ,String Winner ,String level, 
            ArrayList<Move> recordList,Date date,String player1_side){
        
        this.playerId = playerId;
        this.player2Name = player2Name;
        this.Winner = Winner;
        this.recordList = recordList;
        this.date = date;
        this.level = level;
        this.player1_side = player1_side;
    }

    public void setWinner(String Winner) {
        this.Winner = Winner;
    }

    public void setPlayer2Name(String player2Name) {
        this.player2Name = player2Name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setRecordList(ArrayList<Move> recordList) {
        this.recordList = recordList;
    }

    public String getPlayer1_side() {
        return player1_side;
    }

    public void setPlayer1_side(String player1_side) {
        this.player1_side = player1_side;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public int getPlayerId() {
        return playerId;
    }

    public ArrayList<Move> getRecordList() {
        return recordList;
    }

    public String getWinner() {
        return Winner;
    }
    
    
     public Date getDate() {
        return date;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
     
     

}
