/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rebound;

import java.util.ArrayList;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author stimpy
 */
public class Place {
    
    private ArrayList<Body> bodies;
    private double width, height;
    
    public Place(double width, double height) {

        setWidth(width);
        setHeight(height);
        
        Random rand = new Random();
        setBodies(new ArrayList<>());
        for (int i = 0; i < 20; ++i) {
            double x = rand.nextDouble() * width;
            double y = rand.nextDouble() * height;
            bodies.add(new RigidBody(x, y));
        }
        
    }

    
    public void paintPlace(Graphics gr) {
        for ( Body body : bodies)
            body.paintBody(gr);
    }


    public void animateAll() {
        int l = bodies.size();
        Body body, other;
        
        for (int i = 0; i < l; ++i) {
            body = bodies.get(i);
            body.tryMove();
        
            // check for collisions with all other (remaining) bodies
            for (int j = 0; j < l; ++j) {
                if ( i != j) {
                    other = bodies.get(j);
                    double bl = body.getWishfulX();
                    double br = body.getWishfulX() + body.getSizeX();
                    double bt = body.getWishfulY();
                    double bb = body.getWishfulY() + body.getSizeY();
                    double ol = other.getLocationX();
                    double or = other.getLocationX() + other.getSizeX();
                    double ot = other.getLocationY();
                    double ob = other.getLocationY() + other.getSizeY();
                    if (
                            (((bl > ol)  &&  (bl < or))  ||  ((br > ol)  &&  (br < or)))  &&
                            (((bt > ot)  &&  (bt < ob))  ||  ((bb > ot)  &&  (bb < ob)))
                            ) {
                        body.setWishfulX(body.getLocationX());
                        body.setWishfulY(body.getLocationY());
                        body.bounceOf(other);
                    }
                }
            }
            
            // check for collision with Place's borders
            if (body.getWishfulX() < 0.0) {
                body.setWishfulX(0.0);
                body.bounceX();
            }
            if (body.getWishfulY() < 0.0) {
                body.setWishfulY(0.0);
                body.bounceY();
            }

            if (body.getWishfulX() > (getWidth()- body.getSizeX())) {
                body.setWishfulX(getWidth()- body.getSizeX());
                body.bounceX();
            }
            if (body.getWishfulY() > (getHeight()- body.getSizeY())) {
                body.setWishfulY(getHeight()- body.getSizeY());
                body.bounceY();
            }

            
            
            body.move();
        }
    }

//    public void tick(Graphics gr) {
//        animateAll();
//        paintPlace(gr);
//    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public ArrayList<Body> getBodies() {
        return bodies;
    }

    public final void setBodies(ArrayList<Body> bodies) {
        this.bodies = bodies;
    }

    public double getWidth() {
        return width;
    }

    public final void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public final void setHeight(double height) {
        this.height = height;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
}
