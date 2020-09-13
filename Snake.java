import greenfoot.*;  // Import Greenfoot assets
import java.awt.Color; // Import Java assets

public class Snake extends Actor {
    
    private boolean isHead;
    private int direction;
    private int lastX;
    private int lastY;
    private static int length = 1;
    private Snake before;
    private Snake end;
    
    // Default constructor of Snake
    public Snake(boolean isHead) {
        this.isHead = isHead;
        this.end = this;
        this.setImage(new GreenfootImage(30, 30));
        this.getImage().setColor(calcRandomColor());
        this.getImage().fill();
        this.direction = 1;
    }
    
    public void extend() {
        this.length = this.length + 1;
        Snake newsnake = new Snake(false);
        this.getWorld().addObject(newsnake, this.end.lastX, this.end.lastY);
        newsnake.lastX = newsnake.getX();
        newsnake.lastY = newsnake.getY();
        newsnake.before = this.end;
        this.end = newsnake;
    }
    
    public void follow() {
        this.lastX = this.getX();
        this.lastY = this.getY();
        this.setLocation(this.before.lastX , this.before.lastY);
    }
    
    public void move() {
        this.lastX = this.getX();
        this.lastY = this.getY();
        switch (direction) {
            case 1: 
                this.setLocation(this.getX()-1, this.getY());
                break;
            case 2: 
                this.setLocation(this.getX()+1, this.getY());
                break;
            case 3: 
                this.setLocation(this.getX(), this.getY()-1);
                break;
            case 4:
                this.setLocation(this.getX(), this.getY()+1);
                break;
        }
    }
    
    public Color calcRandomColor() {
        int red = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        Color randomCol = new Color(red, green, blue);
        return randomCol;
    }
    
    public boolean isHead() {
        return this.isHead;
    }
    
    public static int getLength() {
        return Snake.length;
    }
    
    public void resetLength() {
        this.length = 1;
    }
    
    public void setDirection(int direction) {
        if( 4 >= direction && direction >= 1) {
            this.direction = direction;
        }
    }
    
    public void setColor(Color color) {
        this.getImage().setColor(color);
        this.getImage().fill();
    }
    
}
