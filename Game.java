import greenfoot.*;  // Import Greenfoot assets
import java.awt.Color; // Import Java assets
import java.util.List;

public class Game extends World {
    
    private Snake snake;
    private Food food;
    private SuperFood superfood;
    private PoisonFood poisonfood;
    private Counter counter;
    private List<Snake> snakes; 
    private int direction = 1;
    private static Game instance;
    
    public static Game getInstance() {
        return instance;
    }
    
    public Game() {
        super(20, 16, 30);
        this.instance = this;
        this.getBackground().setColor(Color.DARK_GRAY);
        this.getBackground().fill();
        snake = new Snake(true);
        food = new Food(Color.BLUE);
        superfood = new SuperFood(Color.GREEN, 2);
        poisonfood = new PoisonFood(Color.RED, true);
        counter = new Counter();
        this.addObject(snake, this.getWidth()/2, this.getHeight()/2);
        this.addObject(food, 0, 0);
        this.addObject(superfood, 0, 0);
        this.addObject(poisonfood, 0, 0);
        this.addObject(counter, 0, 0);
        food.setPosition();
        superfood.setPosition();
        poisonfood.setPosition();
    }
    
    public void act() {
        /* 
           Direction key codes:
           UP: 3
           DOWN: 4
           LEFT: 1
           RIGHT: 2
        */
       
        if(Greenfoot.isKeyDown("up")) {snake.setDirection(3);}
        if(Greenfoot.isKeyDown("down")) {snake.setDirection(4);}
        if(Greenfoot.isKeyDown("left")) {snake.setDirection(1);}
        if(Greenfoot.isKeyDown("right")) {snake.setDirection(2);}
                
        snake.move();
        
        snakes = this.getObjects(Snake.class);
        for(Snake s: snakes) {
            if(!s.isHead()) {
                s.follow();
            }
        }
        
        if(this.getObjectsAt(snake.getX(), snake.getY(), Snake.class).size() > 1) {
            endGame();
        }
        
        if(snake.getX() == food.getX() && snake.getY() == food.getY()) {
            snake.extend();
            counter.updateCounter();
            food.setPosition();
        }
        
        if(snake.getX() == superfood.getX() && snake.getY() == superfood.getY()) {
            superfood.setPosition();
            for(int i = 0; i < superfood.getGrowBy(); i = i + 1) {
                snake.extend();
            }
            counter.updateCounter();
            superfood.setGrowBy(superfood.getGrowBy() + 1);
            snakes = this.getObjects(Snake.class);
            setBackgroundColor(snake.calcRandomColor());
            Color color = snake.calcRandomColor();
            for(Snake s: snakes) {
                s.setColor(color);
            }
        }
        
        if(snake.getX() == poisonfood.getX() && snake.getY() == poisonfood.getY()) {
            if(poisonfood.isMortal()) {
                endGame();
            }
        }
        
    }
    
    public void endGame() {
        snake.resetLength();
        counter.updateCounter();
        Greenfoot.setWorld(new Game());
    }
   
    public void setBackgroundColor(Color color) {
        this.getBackground().setColor(color);
        this.getBackground().fill();
    }
}
