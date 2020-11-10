package Gameyel;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;

public class ball3 extends ball1 {

    Image  imgg = Toolkit.getDefaultToolkit().getImage( this.getClass().getResource("meteorbig.png"));
    ball3() {
        runner.start();
    }
    Thread runner = new Thread(new Runnable() {

        public void run() {
            while (true) {
                x += 3;
                if (x >= 1200) {
                    imgg = null;
                    runner = null;
                    x = -500;
                    y = -500;
                }
                try {
                    runner.sleep(80);
                } catch (InterruptedException e) {
                }
            }
        }
    });

    public Image getImage() {
        return imgg;
    }
}
