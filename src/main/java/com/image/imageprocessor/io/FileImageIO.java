package com.image.imageprocessor.io;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class FileImageIO implements imageIOInterface{

    @Override
    public <T> BufferedImage readImage(T src){
        try{
            String filePath = (String)src;
            File file = new File(filePath);
            return ImageIO.read(file);
        }
        catch(Exception ex)
        {
            System.err.println("Could not read image");
            return null;
        }

    }

    @Override
    public void saveImage(BufferedImage image)
    {
        // implement later
    }
}

