package com.itheima.ui;

import javax.swing.*;

public class RegisterJFrame1 extends JFrame {
    public RegisterJFrame1(){
        //设置界面的宽高
        this.setSize(480, 430);

        //设置界面的标题
        this.setTitle("拼图单机版 v1.0");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
