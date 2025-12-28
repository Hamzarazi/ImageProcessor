package com.image.imageprocessor.processor;

import com.image.imageprocessor.filter.FilterImage;
import com.image.imageprocessor.image.DrawMultipleImagesOnCanvas;
import com.image.imageprocessor.image.ImageData;

import java.awt.image.BufferedImage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImageProcessor {

    ExecutorService executorService;

    public ImageProcessor(){
        this.executorService = Executors.newFixedThreadPool(24);

    }

    public void processImage(BufferedImage image, int num, FilterImage filterImage, DrawMultipleImagesOnCanvas drawOnCanvas){
        int numHorizontalImages = image.getWidth()/num;
        int numVerticalImages = image.getHeight()/num;

        for(int i=0; i<numHorizontalImages; i++)
        {
            for(int j=0; j<numVerticalImages; j++)
            {
                BufferedImage subImage = image.getSubimage(i*num, j*num, num, num);

                int finalI = i;
                int finalJ = j;
                executorService.submit(new Runnable(){
                    @Override
                    public void run(){
                        BufferedImage result = filterImage.filter(subImage);
                        ImageData imageData = new ImageData(result, finalI *num, finalJ *num, num, num);
                        drawOnCanvas.addImageToQueue(imageData);
                    }
                });
            }
        }
    }
}
