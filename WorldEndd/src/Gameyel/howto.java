package Gameyel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class howto extends JPanel implements MouseListener {

    public ImageIcon how = new ImageIcon(this.getClass().getResource("howtoplay.png"));
    public ImageIcon back = new ImageIcon(this.getClass().getResource("back1.png"));
    public ImageIcon backc = new ImageIcon(this.getClass().getResource("backclick.png"));
    public ImageIcon fire = new ImageIcon(this.getClass().getResource("fire.gif"));
    public JButton Bback = new JButton(back);
    public JButton Bbackc = new JButton(backc);
    howto() {
        setLayout(null);
        Bback.setBounds(80, 450, 355, 130);
        add(Bback);
        Bbackc.setBorderPainted(false);
        Bbackc.setContentAreaFilled(false);
        Bbackc.addMouseListener(this);
        Bback.setBorderPainted(false);
        Bback.setContentAreaFilled(false);
        Bback.addMouseListener(this);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(how.getImage(), 0, 0, 1200, 700, this);
        g.drawImage(fire.getImage(), 850, 400, 300, 150, this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == Bback) {
            remove(Bback);
            add(Bbackc);
            Bbackc.setBounds(80, 450, 355, 130);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == Bbackc) {
            remove(Bbackc);
            add(Bback);
            Bback.setBounds(80, 450, 355, 130);
        }
    }
}
