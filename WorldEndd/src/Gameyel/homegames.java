package Gameyel;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class homegames extends JPanel implements MouseListener {

    public ImageIcon bg = new ImageIcon(this.getClass().getResource("earth.gif"));
    public ImageIcon exit = new ImageIcon(this.getClass().getResource("exit1.png"));
    public ImageIcon start = new ImageIcon(this.getClass().getResource("start1.png"));
    public ImageIcon htp = new ImageIcon(this.getClass().getResource("htp1.png"));
    public ImageIcon newexit = new ImageIcon(this.getClass().getResource("exitclick.png"));
    public ImageIcon newstart = new ImageIcon(this.getClass().getResource("startclick.png"));
    public ImageIcon newhtp = new ImageIcon(this.getClass().getResource("htpclick.png"));
    public ImageIcon newnextstate = new ImageIcon(this.getClass().getResource("htpclick.png"));
    public JButton BStart = new JButton(start);
    public JButton BExit1 = new JButton(exit);
    public JButton BHow = new JButton(htp);
    public JButton BStartc = new JButton(newstart);
    public JButton BExitc = new JButton(newexit);
    public JButton BHowc = new JButton(newhtp);

    homegames() {
        setLayout(null);
        BStart.setBounds(450, 200, 355, 130);
        add(BStart);
        BHow.setBounds(450, 335, 355, 130);
        add(BHow);
        BExit1.setBounds(450, 480, 355, 130);
        add(BExit1);
        BStart.addMouseListener(this);
        BStartc.addMouseListener(this);
        BStart.setBorderPainted(false);
        BStart.setContentAreaFilled(false);
        BStartc.setBorderPainted(false);
        BStartc.setContentAreaFilled(false);
        BHow.addMouseListener(this);
        BHowc.addMouseListener(this);
        BHow.setBorderPainted(false);
        BHow.setContentAreaFilled(false);
        BHowc.setBorderPainted(false);
        BHowc.setContentAreaFilled(false);
        BExit1.addMouseListener(this);
        BExitc.addMouseListener(this);
        BExit1.setBorderPainted(false);
        BExit1.setContentAreaFilled(false);
        BExitc.setBorderPainted(false);
        BExitc.setContentAreaFilled(false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == BStart) {
            remove(BStart);
            add(BStartc);
            BStartc.setBounds(450, 200, 355, 130);
        } else if (e.getSource() == BHow) {
            remove(BHow);
            add(BHowc);
            BHowc.setBounds(450, 335, 355, 130);
        } else if (e.getSource() == BExit1) {
            remove(BExit1);
            add(BExitc);
            BExitc.setBounds(450, 480, 355, 130);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == BStartc) {
            remove(BStartc);
            add(BStart);
            BStart.setBounds(450, 200, 355, 130);
        } else if (e.getSource() == BHowc) {
            remove(BHowc);
            add(BHow);
            BHow.setBounds(450, 335, 355, 130);
        } else if (e.getSource() == BExitc) {
            remove(BExitc);
            add(BExit1);
            BExit1.setBounds(450, 480, 355, 130);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg.getImage(), 0, 0, 1200, 700, this);
        g.setColor(Color.WHITE);
        g.setFont(new Font("2005_iannnnnAMD", Font.BOLD, 250));
        g.drawString("World End", 300, 150);
    }
}
