package com.itheima.resizeImage;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class getImageSize {

    /**
     * 功能：获取图片像素
     * * @param filePath 图片路径
     */
    public static void getPixel(String filePath){
        File file = new File(filePath);
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int width = bi.getWidth(); // 像素
        int height = bi.getHeight(); // 像素
        System.out.println("width=" + width + ",height=" + height + ".");
    }

    public static void main(String []args){
        String path = "day09_puzzlegame\\image\\cheyongli\\";
        getPixel(path + "all.jpg");
    }



}
