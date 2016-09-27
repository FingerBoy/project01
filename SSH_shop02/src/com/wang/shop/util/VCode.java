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
 * ����ͼƬ��֤��Ĺ�����
 * @author Administrator
 *
 */
public class VCode {

    private int w;// ͼƬ��
    private int h;// ͼƬ��
    private Color bgColor = new Color(240, 240, 240);// ����ɫ
    private Random random = new Random();// ���������
    // �������巶Χ
    private String[] fontNames = { "����", "���Ŀ���", "����", "������κ", "��������", "΢���ź�",
            "����" };
    //����������ʽ��Χ
    private int[] fontstyles = { 0, 1, 2, 3 };
    //�����ֺŷ�Χ
    private int[] fontSizes={24,25,26,27,28};
    //���������ַ�����Χ
    private String codes="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static String content="";
    
    //�޲ι��췽��
    public VCode() {
    }
    
    //����͸ߵĹ��캯�� 
    public VCode(int w, int h) {
        super();
        this.w = w;
        this.h = h;
    }


    // ����һ�ű���ͼƬ
    private BufferedImage createImage() {
        /**
         * 1:����ͼƬ 2:���ñ���ɫ
         */
        // 1:����ͼƬ
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        // 2:���ñ���ɫ
        Graphics g = img.getGraphics();
        g.setColor(bgColor);
        g.fillRect(0, 0, w, h);

        return img;
    }

    // �������������ɫ
    private Color randomColor() {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r, g, b);
    }

    // �������������ʽ
    private Font randomFont() {
        //������������±�,����Ӹ����ķ�Χ�ڻ�ȡһ������
        int index=random.nextInt(fontNames.length);
        String name=fontNames[index];

        //�������������ʽ�±�,����Ӹ����ķ����ڻ�ȡ��һ��������ʽ
        index=random.nextInt(fontstyles.length);
        int style = fontstyles[index];

        //������������С�±�,����Ӹ����ķ����ڻ�ȡ��һ�������С
        index=random.nextInt(fontSizes.length);
        int size = fontSizes[index];

        return new Font(name, style, size);
    }

    // ���������������
    public String randomChar() {
        int index=random.nextInt(codes.length());
        
        return codes.charAt(index)+"";
    }

    //�漴���ؼ���������
    private void getLine(BufferedImage img){
        //���ø����ߵĿ��Ϊ1.5����,���������
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
    // �û����ø÷�����ȡͼƬ
    public BufferedImage getImage() {
        /**
         * ��������ַ�,�ַ���Χ0-9A-Za-z, ��������,�ֺ�,�Ƿ���� ������� �ַ�����ɫ
         */
        BufferedImage img = createImage();

        this.getLine(img);
        // ��ȡ����
        Graphics g = img.getGraphics();
        // ������
        content="";
        for (int i = 0; i < 4; i++) {
            g.setColor(this.randomColor());// ��ȡ�����ɫ
            g.setFont(this.randomFont());// ��ȡ�������
            String s=this.randomChar();
            g.drawString(s, w / 4 * i, h - 5);// ��ȡ�ַ����������
            content+=s;
        }
        return img;
    }
  
    //�û����ø÷�������ͼƬ������
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