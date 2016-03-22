/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package rebound;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Timer;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

/**
 *
 * @author stimpy
 */
public class ReboundPanel extends JPanel {
    
    private final int WIDTH = 1000, HEIGHT = 800;
    private final int DELAY = 5;
    private final Timer timer;    

    private Place place;
    

    public ReboundPanel() {
        timer = new Timer(DELAY, new ReboundListener());
        addMouseListener(new RebountMouseListener());

        place = new Place(WIDTH, HEIGHT);
        
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.black);
        
        timer.start();
    }
    
    
    /**
     * 
     * @param page 
     */
    @Override
    protected void paintComponent(Graphics gr) {
        super.paintComponent(gr);

        // page.fillOval(x, y, IMAGE_SIZE, IMAGE_SIZE);
        place.paintPlace(gr);
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////
    
    private class ReboundListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {

            place.animateAll();
            
            // paintImmediately(0, 0, WIDTH, HEIGHT);
            repaint();
            // revalidate();
        }
    }
    
    private class RebountMouseListener extends MouseAdapter {
        boolean moving = true;

        @Override
        public void mouseClicked(MouseEvent event) {
            // super.mouseClicked(event);
            if (moving)
                timer.stop();
            else
                timer.start();
            moving = !moving;
        }
    }
    
    
    
}
