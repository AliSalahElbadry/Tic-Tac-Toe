
package tic.tac.toe;


public class Move {
    String side;
    String x;
    String y;

    public Move(String side, String x, String y) {
        this.side = side;
        this.x = x;
        this.y = y;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public void setX(String x) {
        this.x = x;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getSide() {
        return side;
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }
    
    
}