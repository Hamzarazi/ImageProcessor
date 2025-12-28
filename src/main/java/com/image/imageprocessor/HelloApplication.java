package com.image.imageprocessor;

import com.image.imageprocessor.filter.FilterImage;
import com.image.imageprocessor.filter.GreyScaleFilter;
import com.image.imageprocessor.image.DrawMultipleImagesOnCanvas;
import com.image.imageprocessor.io.FileImageIO;
import com.image.imageprocessor.io.imageIOInterface;
import com.image.imageprocessor.processor.ImageProcessor;
import javafx.application.Application;
import javafx.stage.Stage;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        imageIOInterface fileImage = new FileImageIO();
        BufferedImage image = fileImage.readImage("/home/hamza/IdeaProjects/imageProcessor/src/main/java/com/image/imageprocessor/image/landscape_1920x1080.png");

        DrawMultipleImagesOnCanvas DrawOnCanvas = DrawMultipleImagesOnCanvas.getInstance();
        DrawOnCanvas.initialize(stage);

        FilterImage GreyFilter = new GreyScaleFilter();

        ImageProcessor ImgProcessor = new ImageProcessor();
        ImgProcessor.processImage(image, 20, GreyFilter, DrawOnCanvas);

    }

    public static void main(String[] args) {launch();}
}
