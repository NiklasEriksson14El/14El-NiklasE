import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel {

    Ball ball = new Ball(this);
    Racket racket = new Racket(this);

    public int points = 0;

    public Game() {
        addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
                racket.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                racket.keyReleased(e);
            }

            @Override
            public void keyTyped(KeyEvent e) {

            }
        });
        setFocusable(true);
    }

    private void move() {
        ball.moveBall();
        racket.move();
    }

    private int width = 100;
    private int height = 100;

    public void gameOver() {
        JOptionPane.showMessageDialog(this, "Game over, you got " + points + " points", "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Game game = new Game();

        frame.setSize(700, 500); // x, y
        frame.setLocation(300, 200);
        frame.setDefaultCloseOperation(3);
        frame.add(game);
        frame.setTitle("Ball Game");
        frame.setResizable(false);
        frame.setVisible(true);

        while (true) {
            game.move();
            game.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2d);
        racket.paint(g2d);
        g.drawString(points + " points", 25, 25);
    }
}
