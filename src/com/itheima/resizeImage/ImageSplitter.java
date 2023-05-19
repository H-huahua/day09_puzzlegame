package com.itheima.resizeImage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageSplitter {
    public static void main(String[] args) {
        String path = "day09_puzzlegame\\image\\cheyongli\\";
        // Load the image
        BufferedImage originalImage;
        try {
            originalImage = ImageIO.read(new File(path+"all.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Define the number of rows and columns for splitting
        int rows = 4;
        int columns = 4;

        // Calculate the width and height of each image block
        int blockWidth = originalImage.getWidth() / columns;
        int blockHeight = originalImage.getHeight() / rows;

        // Split the image into small blocks
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // Create a new BufferedImage for each block
                BufferedImage block = new BufferedImage(blockWidth, blockHeight, originalImage.getType());

                // Copy the pixels from the original image to the block
                for (int x = 0; x < blockWidth; x++) {
                    for (int y = 0; y < blockHeight; y++) {
                        int pixel = originalImage.getRGB(j * blockWidth + x, i * blockHeight + y);
                        block.setRGB(x, y, pixel);
                    }
                }

                // Save the block as an image file
                int o = 1;
                String fileName =  o + ".jpg";// You can use a different file format if desired
                o++;
                try {
                    ImageIO.write(block, "jpg", new File(path + fileName));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Image splitting complete!");
    }
}
