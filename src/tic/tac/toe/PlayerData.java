
package tic.tac.toe;


public class PlayerData {
    int playerID;
    String userName;
    String email;
    String password;
    String status;
    int wins;
    int countGames;
    
    public PlayerData()
    {
        
    }

    public PlayerData(int playerID, String userName, String email, String password, String status, int wins, int countGames) {
        this.playerID = playerID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.status = status;
        this.wins = wins;
        this.countGames = countGames;
    }
    
    

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getCountGames() {
        return countGames;
    }

    public void setCountGames(int countGames) {
        this.countGames = countGames;
    }
   
}
