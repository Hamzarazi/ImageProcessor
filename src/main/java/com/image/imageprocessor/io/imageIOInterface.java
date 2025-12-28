package com.image.imageprocessor.io;

import java.awt.image.BufferedImage;

public interface imageIOInterface {

    <T> BufferedImage readImage(T src);

    void saveImage(BufferedImage image);

}