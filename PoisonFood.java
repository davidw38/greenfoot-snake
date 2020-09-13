import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class PoisonFood extends Food {
    
    private boolean mortal;
    
    public PoisonFood(Color color, boolean mortal) {
        super(color);
        this.mortal = mortal;
    }
    
    public boolean isMortal() {
        return this.mortal;
    }
    
}
