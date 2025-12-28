package com.image.imageprocessor.image;

import java.awt.image.BufferedImage;

public class ImageData {

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    private BufferedImage image;
    private int i;
    private int j;
    private int width;
    private int height;

    public ImageData(BufferedImage image, int i, int j, int width, int height){
        this.image = image;
        this.i = i;
        this.j = j;
        this.width = width;
        this.height = height;
    }

}
