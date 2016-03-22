/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rebound;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author stimpy
 */
public class RigidBody extends Body {

    public RigidBody() {
        super();
        setLocationX(0.0);
        setLocationY(0.0);
    }

    public RigidBody(double locationX, double locationY) {
        super();
        setLocationX(locationX);
        setLocationY(locationY);
    }
    
    

    @Override
    public void paintBody(Graphics gr) {
        ArrayList<ImageIcon> images = getImages();
        for (ImageIcon img : images) {
            img.paintIcon(null, gr, (int)getLocationX(), (int)getLocationY());
        }
    }

    
}
