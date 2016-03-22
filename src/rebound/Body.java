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
public abstract class Body {

    // Movement
    private double g;
    private double frictionX, frictionY;
    private double speedX, speedY;
    
    // Location
    private double wishfulX, wishfulY;
    private double locationX, locationY;

    private double sizeX, sizeY;

    
    // Display
    private ArrayList<ImageIcon> images;
    // possibly add a Shape property



    
    /**
     * default constructor
     */
    public Body() {
        setImages(new ArrayList<>());
        getImages().add(new ImageIcon("images/football.png"));

        setSizeX(32.0);
        setSizeY(32.0);
        
        setFrictionX(0.02);
        setFrictionY(0.09);
        setG(0.01);

        setSpeedX(1.0);
        setSpeedY(1.0);

        setLocationX(0.0);
        setLocationY(0.0);
    }



    public void tryMove() {
        setWishfulX(getLocationX() + getSpeedX());
        setWishfulY(getLocationY() + getSpeedY());
    }
    
    public void move() {
        setLocationX(getWishfulX());
        setLocationY(getWishfulY());
        addG();
    }

    public void bounceOf(Body other) {
        // self calculate new speed and direction upon collision with other Body
        setSpeedX(getSpeedX() * -1.0);
        setSpeedY(getSpeedY() * -1.0);    
        addFrictionX();
        addFrictionY();

        other.setSpeedX(getSpeedX() * -1.0);
        other.setSpeedY(getSpeedY() * -1.0);    
        other.addFrictionX();
        other.addFrictionY();
    }
    
    public abstract void paintBody(Graphics gr);


    
    //////////////////////////////////////////////////////////////////////////////////////////////////


    public double getFrictionX() {
        return frictionX;
    }
    public final void setFrictionX(double frictionX) {
        this.frictionX = frictionX;
    }
    
    public double getFrictionY() {
        return frictionY;
    }
    public final void setFrictionY(double frictionY) {
        this.frictionY = frictionY;
    }

    public double getG() {
        return g;
    }
    public final void setG(double g) {
        this.g = g;
    }
    
    public double getSpeedX() {
        return speedX;
    }
    public final void setSpeedX(double speedX) {
        this.speedX = speedX;
    }
    public final void addFrictionX() {
        double fx = getFrictionX();
        double sx = getSpeedX();

        if (sx >= -fx  &&  sx <= fx)
            setSpeedX(0.0);
        else if (sx < 0.0)
            setSpeedX(sx + fx);
        else if (sx > 0.0)
            setSpeedX(sx - fx);
    }
    public final void bounceX() {
        setSpeedX(getSpeedX() * -1.0);
        addFrictionX();
        addFrictionY();
    }
    
    public double getSpeedY() {
        return speedY;
    }
    public final void setSpeedY(double speedY) {
        this.speedY = speedY;
    }
    public final void addG() {
        setSpeedY(getSpeedY()+getG());
    }
    public final void bounceY() {
        setSpeedY(getSpeedY() * -1.0);
        addFrictionX();
        addFrictionY();
    }
    public final void addFrictionY() {
        double fy = getFrictionY();
        double sy = getSpeedY();
        if (sy >= -fy  &&  sy <= fy)
            setSpeedY(0.0);
        else if (sy < 0.0)
            setSpeedY(sy + fy);
        else if (sy > 0.0)
            setSpeedY(sy - fy);
    }

    public double getWishfulX() {
        return wishfulX;
    }
    public void setWishfulX(double wishfulX) {
        this.wishfulX = wishfulX;
    }

    public double getWishfulY() {
        return wishfulY;
    }
    public void setWishfulY(double wishfulY) {
        this.wishfulY = wishfulY;
    }
    
    public double getLocationX() {
        return locationX;
    }
    public final void setLocationX(double locationX) {
        this.locationX = locationX;
    }
    
    public double getLocationY() {
        return locationY;
    }
    public final void setLocationY(double locationY) {
        this.locationY = locationY;
    }
    
    public final ArrayList<ImageIcon> getImages() {
        return images;
    }
    public final void setImages(ArrayList<ImageIcon> images) {
        this.images = images;
    }

    public double getSizeX() {
        return sizeX;
    }
    public void setSizeX(double sizeX) {
        this.sizeX = sizeX;
    }

    public double getSizeY() {
        return sizeY;
    }
    public void setSizeY(double sizeY) {
        this.sizeY = sizeY;
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    
    
}
