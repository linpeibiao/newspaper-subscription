/*
 * Created by JFormDesigner on Mon Oct 17 22:03:57 CST 2022
 */

package com.zkxg.newspaper_subscription.view;

import com.zkxg.newspaper_subscription.common.BaseResponse;
import com.zkxg.newspaper_subscription.controller.NewspaperController;
import com.zkxg.newspaper_subscription.model.entity.Newspaper;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Date;
import javax.swing.*;

import static com.zkxg.newspaper_subscription.view.subMgt.newspaperId;

/**
 * @author unknown
 */
public class modNewspaper extends JFrame {
    private NewspaperController newspaperController;
    public static int modTarget = 0;
    public modNewspaper() {
        newspaperController = new NewspaperController();
        // 初始化
        initComponents();
        // 窗口可见
        setVisible(true);
        // 固定窗口大小
        setResizable(false);
        setTitle("修改报刊");
        // 初始化界面
        initView();
        // 监听事件
        listener();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - unknown
        panel1 = new JPanel();
        imageLabel = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        modNewsButton = new JButton();
        modNewsNameField = new JTextField();
        modNewsPriceField = new JTextField();
        modNewsTypeField = new JTextField();
        modNewsPublishField = new JTextField();
        modNewsBriefField = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax
            .swing.border.EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing
            .border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.
            Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt.Color.red
            ),panel1. getBorder()));panel1. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override
            public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r".equals(e.getPropertyName(
            )))throw new RuntimeException();}});
            panel1.setLayout(null);
            panel1.add(imageLabel);
            imageLabel.setBounds(10, 10, 290, 515);

            //---- label2 ----
            label2.setText("\u62a5\u520a\u540d\u79f0\uff1a");
            label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(label2);
            label2.setBounds(320, 20, 105, 40);

            //---- label3 ----
            label3.setText("\u51fa\u7248\u62a5\u793e\uff1a");
            label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(label3);
            label3.setBounds(320, 80, 105, 40);

            //---- label4 ----
            label4.setText("\u62a5\u520a\u7c7b\u578b\uff1a");
            label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(label4);
            label4.setBounds(315, 150, 105, 40);

            //---- label5 ----
            label5.setText("\u62a5\u520a\u5355\u4ef7\uff1a");
            label5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(label5);
            label5.setBounds(315, 225, 105, 40);

            //---- label6 ----
            label6.setText("\u5185\u5bb9\u4ecb\u7ecd\uff1a");
            label6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(label6);
            label6.setBounds(315, 290, 105, 40);

            //---- modNewsButton ----
            modNewsButton.setText("\u4fee\u6539");
            modNewsButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(modNewsButton);
            modNewsButton.setBounds(315, 440, 295, 40);

            //---- modNewsNameField ----
            modNewsNameField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(modNewsNameField);
            modNewsNameField.setBounds(435, 20, 175, 40);

            //---- modNewsPriceField ----
            modNewsPriceField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(modNewsPriceField);
            modNewsPriceField.setBounds(435, 225, 175, 40);

            //---- modNewsTypeField ----
            modNewsTypeField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(modNewsTypeField);
            modNewsTypeField.setBounds(435, 155, 175, 40);

            //---- modNewsPublishField ----
            modNewsPublishField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(modNewsPublishField);
            modNewsPublishField.setBounds(435, 85, 175, 40);

            //---- modNewsBriefField ----
            modNewsBriefField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(modNewsBriefField);
            modNewsBriefField.setBounds(315, 335, 295, 85);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(5, 5, 715, 535);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel panel1;
    private JLabel imageLabel;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JButton modNewsButton;
    private JTextField modNewsNameField;
    private JTextField modNewsPriceField;
    private JTextField modNewsTypeField;
    private JTextField modNewsPublishField;
    private JTextField modNewsBriefField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public void initView() {
        System.out.println(newspaperId);
        ImageIcon image = new ImageIcon("src/main/java/com/zkxg/newspaper_subscription/view/poster.jpg");
        image.setImage(image.getImage().getScaledInstance(290,515,Image.SCALE_DEFAULT));
        imageLabel.setIcon(image);
        BaseResponse<Newspaper> newspaperBaseResponse = newspaperController.getNewspaperById(newspaperId);
        Newspaper detailNewspaper = newspaperBaseResponse.getData();
        System.out.println(detailNewspaper);
        // 渲染报刊信息
        modNewsNameField.setText(detailNewspaper.getName());
        modNewsPublishField.setText(detailNewspaper.getPublisher());
        modNewsTypeField.setText(detailNewspaper.getType());
        modNewsPriceField.setText(detailNewspaper.getPrice().toString());
        modNewsBriefField.setText(detailNewspaper.getBrief());
    }
    // 监听事件
    private void listener() {
        modNewsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("触发了修改报刊按钮！");
                // 表单验证
                if (modNewsNameField.getText().trim().length() == 0 ||
                    modNewsPublishField.getText().trim().length() == 0 ||
                    modNewsTypeField.getText().trim().length() == 0 ||
                    modNewsPriceField.getText().trim().length() == 0 ||
                    modNewsBriefField.getText().trim().length() == 0
                ) {
                    JOptionPane.showMessageDialog(null,"请完善需要修改的报刊信息！");
                    return;
                }
                BigDecimal newPrice = new BigDecimal( modNewsPriceField.getText());
                BigDecimal bd = new BigDecimal(0);
                if (newPrice.compareTo(bd) != 1) {
                    JOptionPane.showMessageDialog(null,"订阅份数必须是大于0的数");
                    return;
                }
                // 获取报刊号
                BaseResponse<Newspaper> newspaperBaseResponse = newspaperController.getNewspaperById(newspaperId);
                BigDecimal singlePrice = new BigDecimal(modNewsPriceField.getText());
                // 即将修改的报刊对象
                Newspaper modNewspaperObj = new Newspaper(newspaperId,modNewsNameField.getText(),newspaperBaseResponse.getData().getNewspaperNumber(),null,modNewsTypeField.getText(),modNewsBriefField.getText(),modNewsPublishField.getText(),"2022-10-16 00:00:00",singlePrice,null,null,"此报刊已修改",new Date(),new Date(),0);
                BaseResponse<String> stringBaseResponse = newspaperController.updateNewspaper(modNewspaperObj);
                JOptionPane.showMessageDialog(null,"修改报刊成功！");

                dispose();
                modTarget = 1;
            }
        });
    }
}
