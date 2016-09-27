package com.wang.shop.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
/**
 * 生成图片验证码的工具类
 * @author Administrator
 *
 */
public class VCode {

    private int w;// 图片宽
    private int h;// 图片高
    private Color bgColor = new Color(240, 240, 240);// 背景色
    private Random random = new Random();// 随机数对象
    // 设置字体范围
    private String[] fontNames = { "宋体", "华文楷体", "黑体", "华文新魏", "华文隶书", "微软雅黑",
            "楷体" };
    //设置字体样式范围
    private int[] fontstyles = { 0, 1, 2, 3 };
    //设置字号范围
    private int[] fontSizes={24,25,26,27,28};
    //设置所有字符串范围
    private String codes="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static String content="";
    
    //无参构造方法
    public VCode() {
    }
    
    //带宽和高的构造函数 
    public VCode(int w, int h) {
        super();
        this.w = w;
        this.h = h;
    }


    // 返回一张背景图片
    private BufferedImage createImage() {
        /**
         * 1:创建图片 2:设置背景色
         */
        // 1:创建图片
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        // 2:设置背景色
        Graphics g = img.getGraphics();
        g.setColor(bgColor);
        g.fillRect(0, 0, w, h);

        return img;
    }

    // 随机返回字体颜色
    private Color randomColor() {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r, g, b);
    }

    // 随机返回字体样式
    private Font randomFont() {
        //随机生成字体下标,随机从给定的范围内获取一个字体
        int index=random.nextInt(fontNames.length);
        String name=fontNames[index];

        //随机生成字体样式下表,随机从给定的返回内获取到一个字体样式
        index=random.nextInt(fontstyles.length);
        int style = fontstyles[index];

        //随机生成字体大小下标,随机从给定的返回内获取到一个字体大小
        index=random.nextInt(fontSizes.length);
        int size = fontSizes[index];

        return new Font(name, style, size);
    }

    // 随机返回字体内容
    public String randomChar() {
        int index=random.nextInt(codes.length());
        
        return codes.charAt(index)+"";
    }

    //随即返回几条干扰线
    private void getLine(BufferedImage img){
        //设置干扰线的宽度为1.5倍宽,随机画五条
        Graphics2D g=(Graphics2D)img.getGraphics();
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(1.5f));
        for(int i=0;i<5;i++){
            int x1=random.nextInt(w);
            int y1=random.nextInt(h);
            int x2=random.nextInt(w);
            int y2=random.nextInt(h);
            g.drawLine(x1, y1, x2, y2);
            
        }
        
    }
    // 用户调用该方法获取图片
    public BufferedImage getImage() {
        /**
         * 随机生成字符,字符范围0-9A-Za-z, 设置字体,字号,是否粗体 都是随机 字符的颜色
         */
        BufferedImage img = createImage();

        this.getLine(img);
        // 获取画笔
        Graphics g = img.getGraphics();
        // 画内容
        content="";
        for (int i = 0; i < 4; i++) {
            g.setColor(this.randomColor());// 获取随机颜色
            g.setFont(this.randomFont());// 获取随机字体
            String s=this.randomChar();
            g.drawString(s, w / 4 * i, h - 5);// 获取字符串随机内容
            content+=s;
        }
        return img;
    }
  
    //用户调用该方法保存图片到本地
    public void saveImage(BufferedImage img,OutputStream ous){
        
        try {
            ImageIO.write(img, "JPEG", ous);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  
}