package com.image.imageprocessor.image;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class DrawMultipleImagesOnCanvas{

    private static DrawMultipleImagesOnCanvas instance;

    private Queue<ImageData> queue = new LinkedBlockingQueue<ImageData>();
    private Stage primaryStage;
    private Canvas canvas;
    private GraphicsContext gc;


    public static DrawMultipleImagesOnCanvas getInstance(){
        if(instance == null)
        {
            return new DrawMultipleImagesOnCanvas();
        }
        return instance;
    }

    public void addImageToQueue(ImageData image)
    {
        queue.offer(image);
    }

    public void initialize(Stage primaryStage){

        this.primaryStage = primaryStage;
        this.canvas = new Canvas(1920, 1080);
        this.gc = canvas.getGraphicsContext2D();
        gc.clearRect(0,0,1920,1080);

        new AnimationTimer(){
            @Override
            public void handle(long now){
                if(!queue.isEmpty()){
                    new Thread(() -> {
                       drawNextImage();
                    }).start();
                }
            }
        }.start();

        Group root = new Group();
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void drawNextImage() {
        ImageData image = queue.poll();
        Platform.runLater(() -> {
            if (image != null) {
                gc.drawImage(SwingFXUtils.toFXImage(image.getImage(), null), image.getI(), image.getJ(), image.getWidth(), image.getHeight());
                System.out.println("Drawn by " + Thread.currentThread().getName());
            }
        });
    }
}