package Gameyel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.sound.sampled.Clip;

public class PlayGames extends JFrame implements ActionListener{
    homegames hg = new homegames();
    state1 state1 = new state1();
    state2 state2 = new state2();
    state3 state3 = new state3();
    stateboss bs = new stateboss();
    howto hw = new howto(); 
    
    BufferedImage cd=new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
    Cursor blank=Toolkit.getDefaultToolkit().createCustomCursor(cd, new Point(0, 0), "blank cursor");
    public PlayGames() {
                    
        setIconImage(new ImageIcon(getClass().getResource("earth.png")).getImage());       
        this.add(hg);
        hg.BExitc.addActionListener(this);
        hg.BStartc.addActionListener(this);
        hg.BHowc.addActionListener(this);
        hw.Bbackc.addActionListener(this);
        state1.Bnextc.addActionListener(this);
        state2.Bnextc2.addActionListener(this);
        state3.Bnextc3.addActionListener(this);
        state1.Btryc.addActionListener(this);
        state2.Btryc2.addActionListener(this);
        state3.Btryc3.addActionListener(this);
        bs.Btryc4.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == hg.BStartc) {
            this.setLocationRelativeTo(null);
            this.remove(hg);
            this.add(state1);
           // getContentPane().setCursor(blank);              
            state1.requestFocusInWindow();
            state1.timestart = false;
            state1.scor = 0;
            state1.HP = 5;
            state1.times = 100;
            state1.startball = false;
        } else if ((e.getSource() == hg.BExitc)) {
            System.exit(0);
        } else if (e.getSource() == hg.BHowc) {
            this.setLocationRelativeTo(null);
            this.remove(hg);
            this.add(hw);
            hw.requestFocusInWindow();
        } else if (e.getSource() == hw.Bbackc) {
            this.setLocationRelativeTo(null);
            this.remove(hw);
            this.setSize(1200, 700);
            this.add(hg);
        } else if (e.getSource() == state1.Bnextc) {
            this.setLocationRelativeTo(null);
            this.remove(state1);
            this.add(state2);
            state1.ball1st1.stop();
            state1.ball2st1.stop();
            state1.t.stop();
            state1.time.stop();
            state2.requestFocusInWindow();
            state2.timestart2 = false;
            state2.scor = state1.getScore();
            state2.HP = 5;
            state2.times2 = 70;
            state2.startball2 = false;
        } else if (e.getSource() == state2.Bnextc2) {
            this.setLocationRelativeTo(null);
            this.remove(state2);
            this.add(state3);
            state2.ball1st2.stop();
            state2.ball2st2.stop();
            state2.ball3st2.stop();
            state2.t2.stop();
            state2.time2.stop();
            state3.requestFocusInWindow();
            state3.timestart3 = false;
            state3.scor = state2.getScore();
            state3.HP = 5;
            state3.times3 = 65;
            state3.startball3 = false;
        } else if (e.getSource() == state3.Bnextc3) {
            this.setLocationRelativeTo(null);
            this.remove(state3);
            this.add(bs);
            state3.ball1st3.stop();
            state3.ball2st3.stop();
            state3.ball3st3.stop();
            state3.t3.stop();
            state3.time3.stop();
            //getContentPane().setCursor(blank); 
            bs.requestFocusInWindow();
            bs.timestart4 = false;
            bs.scor = state3.getScore();
            bs.HP = 5;
            bs.times4 = 70;
            bs.startball4 = false;
        }
        else if(e.getSource()==state1.Btryc||e.getSource()==state2.Btryc2||e.getSource()==state3.Btryc3||e.getSource()==bs.Btryc4){
            System.exit(0);           
        }
        this.validate();
        this.repaint();
    }
}
