package com.itheima.ui;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.BevelBorder;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


public class GameJFrame1 extends JFrame implements KeyListener {
    //创建一个二维数组
    int[][] data = new int[4][4];
    //记录空白方块在二维数组的位置
    int x = 0;
    int y = 0;
    //定义图片路径
    String path = "day09_puzzlegame\\image\\cheyongli\\";
    public GameJFrame1(){
        //初始化界面
        initJFrame();
        //初始化菜单
        initJMenuBar();
        //初始化数据
        initDate();
        //初始化图片，图片加载到界面中
        initImage();
    }
    //初始化数据（打乱图片）
    private void initDate() {
        //1.定义一个一维数组
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //2.打乱数组中的数据的顺序
        //遍历数组，得到每一个元素，拿着每一个元素跟随机索引上的数据进行交换
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            //获取到随机索引
            int index = r.nextInt(tempArr.length);
            //拿着遍历到的每一个数据，跟随机索引上的数据进行交换
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }
        //3.遍历数组
        for (int i = 0; i < tempArr.length; i++) {
            System.out.print(tempArr[i] + " ");
        }
        System.out.println();
        //5.给二维数组添加数据
        //解法一：
        //遍历一维数组tempArr得到每一个元素，把每一个元素依次添加到二维数组当中
        for (int i = 0; i < tempArr.length; i++) {
            if(tempArr[i]==0){
                x = i / 4;
                y = i % 4;
            }else{
                data[i / 4][i % 4] = tempArr[i];
            }
        }
    }
    //初始化图片，图片加载到界面中
    private void initImage() {
        this.getContentPane().removeAll();


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = data[i][j];
                JLabel jLabel = new JLabel(new ImageIcon(path+num+".jpg"));
                //指定位置：
                jLabel.setBounds(105*j+83,105*i+134,105,105);
                //添加边框：
                jLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
                //this.add(jLabel);
                this.getContentPane().add(jLabel);
            }
        }


        //加载背景图片：
        ImageIcon bg = new ImageIcon("day09_puzzlegame\\image\\background.png");
        JLabel background = new JLabel(bg);
        background.setBounds(40,40,500,560);
        this.getContentPane().add(background);

        //刷新
        this.getContentPane().repaint();


    }
    //初始化菜单
    private void initJMenuBar() {
        //创建整个菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单上的两个选项的对象“功能”“关于我们”
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        //创建选项下面的条目对象
        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem reLoginItem = new JMenuItem("重新登陆");
        JMenuItem closeItem = new JMenuItem("关闭游戏");

        JMenuItem accountItem = new JMenuItem("公众号");

        //将每一个选项下面的条目添加到选项之中
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        //将菜单里面的两个选项添加到菜单当中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
        //展示界面
        this.setVisible(true);
    }
    private void initJFrame() {
        //设置界面的宽高
        this.setSize(600, 680);

        //设置界面的标题
        this.setTitle("拼图单机版 v1.0");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认位置：
        this.setLayout(null);
        //给整个界面添加键盘监听事件
        this.addKeyListener(this);
    }
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == 65){
            this.getContentPane().removeAll();
            JLabel all = new JLabel(new ImageIcon(path+"all.jpg"));
            all.setBounds(83,134,420,420);
            this.getContentPane().add(all);
            //添加背景图片
            ImageIcon bg = new ImageIcon("day09_puzzlegame\\image\\background.png");
            JLabel background = new JLabel(bg);
            background.setBounds(40,40,500,560);
            this.getContentPane().add(background);
            //刷新界面
            this.getContentPane().repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //对上、下、左、右进行判断
        //左：37；上：38；右：39；下：40
        int code = e.getKeyCode();
        if(code == 37){
            System.out.println("向左移动");
            if(y==3){
                return;
            }
            data[x][y] = data[x][y+1];
            data[x][y+1] = 0;
            y++;
            initImage();
        } else if (code==38) {
            System.out.println("向上移动");
            if(x ==3){
                return;
            }
            //空白方块下方的数字往上移动
            //x,y空白方块
            //x+1，y表示空白方块下方数字
            data[x][y] = data[x+1][y];
            data[x+1][y] = 0;
            x++;
            //调用新的方法按照最新的数字加载图片
            initImage();
        }else if (code==39) {
            System.out.println("向右移动");
            if(y==0){
                return;
            }
            data[x][y] = data[x][y-1];
            data[x][y-1] = 0;
            y--;
            initImage();
        }else if (code==40) {
            System.out.println("向下移动");
            if(x ==0){
                return;
            }
            data[x][y] = data[x-1][y];
            data[x-1][y] = 0;
            x--;
            initImage();
        } else if (code == 65) {
            initImage();
        } else if (code == 87) {
            data = new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
            };
            initImage();
        }

    }
}
