import greenfoot.*;  // Import Greenfoot assets
import java.awt.Color; // Import Java assets

public class Food extends Actor {
    
    public Food(Color color) {
        this.setImage(new GreenfootImage(30, 30));
        this.getImage().setColor(color);
        this.getImage().fill();
    }
    
    public void setPosition() {
        do{
            this.setLocation((int)(Math.random() * Game.getInstance().getWidth()), (int)(Math.random() * Game.getInstance().getHeight()));        
        } while(Game.getInstance().getObjectsAt(this.getX(), this.getY(), null).size() > 1);
    }
}
