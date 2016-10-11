import java.awt.*;
import java.awt.event.KeyEvent;

public class Racket {

    private static final int WIDTH = 70;
    private static final int HEIGHT = 7;
    private int x = 350;
    private static final int Y = 450;
    private int moveX = 0;
    private Game game;

    public Racket(Game game) {
        this.game = game;
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.black);
        g.fillRect(x, Y, WIDTH, HEIGHT);
    }

    void move() {
        if(x + moveX > 0 && x + moveX < game.getWidth() - 70) {
            x += moveX;
        }
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
            moveX = -2;
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            moveX = 2;
    }

    public void keyReleased(KeyEvent e) {
            moveX = 0;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, Y, WIDTH, HEIGHT);
    }

    public int getY() {
        return Y;
    }
}
