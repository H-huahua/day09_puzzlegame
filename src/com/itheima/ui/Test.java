package com.itheima.ui;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        //1.创建一个游戏主界面
        JFrame gameJFram = new JFrame();
        gameJFram.setSize(600,680);
        //单位是像素
        gameJFram.setVisible(true);

        //2.创建一个登陆界面
        JFrame loginJFram = new JFrame();
        loginJFram.setSize(480,430);
        loginJFram.setVisible(true);
        //3.创建一个注册界面
        JFrame registerJFram = new JFrame();
        registerJFram.setSize(480,430);
        registerJFram.setVisible(true);
    }
}
