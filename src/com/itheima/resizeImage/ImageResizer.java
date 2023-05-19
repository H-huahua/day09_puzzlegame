package com.itheima.resizeImage;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageResizer {

    public static void main(String[] args) {
        String path = "day09_puzzlegame\\image\\cheyongli\\";
        // Load the original image
        BufferedImage originalImage;
        try {
            originalImage = ImageIO.read(new File(path+"allp.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Define the custom width and height in pixels
        int newWidth = 4200;
        int newHeight = 4200;

        // Create a new BufferedImage with the custom size
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());

        // Scale the original image to the new size
        Image tmp = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        // Save the resized image to a file
        try {
            ImageIO.write(resizedImage, "jpg", new File(path + "all_1.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Image resizing complete!");
    }
}
