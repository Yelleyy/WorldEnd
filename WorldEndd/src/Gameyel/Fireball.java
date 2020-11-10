package Gameyel;

import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fireball extends JPanel {

    public ImageIcon fire = new ImageIcon(this.getClass().getResource("fire.gif"));
    public int y;
    public int x;
    Fireball(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void move() {
        this.x -= 5;
    }
    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x, y, 30, 30));
    }
}
