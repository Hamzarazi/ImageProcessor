package com.image.imageprocessor.filter;

import java.awt.image.BufferedImage;

public class GreyScaleFilter implements FilterImage {

    @Override
    public BufferedImage filter(BufferedImage originalImage){

        int width = originalImage.getWidth();
        int height = originalImage.getHeight();

        BufferedImage grayscale = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = originalImage.getRGB(x, y);

                // Extract RGB components
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = rgb & 0xFF;

                // Calculate grayscale (luminosity method)
                int gray = (int)(0.299 * r + 0.587 * g + 0.114 * b);

                // Set grayscale value (same for R, G, B)
                int grayRGB = (gray << 16) | (gray << 8) | gray;
                grayscale.setRGB(x, y, grayRGB);
            }
        }

        return grayscale;
    }
}
