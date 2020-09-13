import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class SuperFood extends Food {
    
    private int growBy;
    
    public SuperFood(Color color, int growBy) {
        super(color);
        this.growBy = growBy;
    }
    
    public int getGrowBy() {
        return this.growBy;
    }
    
    public void setGrowBy(int growBy) {
        if(growBy > 0) {
            this.growBy = growBy;
        }
    }
}
