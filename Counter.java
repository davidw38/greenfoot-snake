import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class Counter extends Actor {
  
    public Counter() {
        updateCounter();
    }
    
    public void updateCounter() {
        setImage(new GreenfootImage(String.valueOf(Snake.getLength()), 20, Color.WHITE, Color.BLACK));
    }
    
}
