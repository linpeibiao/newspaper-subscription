/*
 * Created by JFormDesigner on Mon Oct 17 15:07:29 CST 2022
 */

package com.zkxg.newspaper_subscription.view;

import com.zkxg.newspaper_subscription.common.BaseResponse;
import com.zkxg.newspaper_subscription.controller.NewspaperController;
import com.zkxg.newspaper_subscription.model.entity.Newspaper;

import java.awt.*;
import javax.swing.*;

import static com.zkxg.newspaper_subscription.view.subMgt.newspaperId;

/**
 * @author unknown
 */
public class newsDetail extends JFrame {
    private NewspaperController newspaperController;
    public newsDetail() {
        newspaperController = new NewspaperController();
        // 初始化
        initComponents();
        // 窗口可见
        setVisible(true);
        // 固定窗口大小
        setResizable(false);
        setTitle("报刊详情");
        // 初始化详情界面
        initView();
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
        detailNameLabel = new JLabel();
        detailPublishLabel = new JLabel();
        detailTypeLabel = new JLabel();
        detailPriceLabel = new JLabel();
        detailBriefLabel = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border.
            EmptyBorder( 0, 0, 0, 0) , "", javax. swing. border. TitledBorder. CENTER, javax. swing
            . border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ),
            java. awt. Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( )
            { @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName () ))
            throw new RuntimeException( ); }} );
            panel1.setLayout(null);
            panel1.add(imageLabel);
            imageLabel.setBounds(10, 10, 290, 515);

            //---- label2 ----
            label2.setText("\u62a5\u520a\u540d\u79f0\uff1a");
            label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(label2);
            label2.setBounds(320, 40, 105, 40);

            //---- label3 ----
            label3.setText("\u51fa\u7248\u62a5\u793e\uff1a");
            label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(label3);
            label3.setBounds(320, 115, 105, 40);

            //---- label4 ----
            label4.setText("\u62a5\u520a\u7c7b\u578b\uff1a");
            label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(label4);
            label4.setBounds(320, 190, 105, 40);

            //---- label5 ----
            label5.setText("\u62a5\u520a\u5355\u4ef7\uff1a");
            label5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(label5);
            label5.setBounds(320, 270, 105, 40);

            //---- label6 ----
            label6.setText("\u5185\u5bb9\u4ecb\u7ecd\uff1a");
            label6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(label6);
            label6.setBounds(320, 350, 105, 40);

            //---- detailNameLabel ----
            detailNameLabel.setText("\u4ef2\u607a\u9e7f\u6657");
            detailNameLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(detailNameLabel);
            detailNameLabel.setBounds(450, 40, 200, 40);

            //---- detailPublishLabel ----
            detailPublishLabel.setText("\u4ef2\u607a\u9e7f\u6657");
            detailPublishLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(detailPublishLabel);
            detailPublishLabel.setBounds(450, 115, 200, 40);

            //---- detailTypeLabel ----
            detailTypeLabel.setText("\u4ef2\u607a\u9e7f\u6657");
            detailTypeLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(detailTypeLabel);
            detailTypeLabel.setBounds(450, 190, 200, 40);

            //---- detailPriceLabel ----
            detailPriceLabel.setText("\u4ef2\u607a\u9e7f\u6657");
            detailPriceLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(detailPriceLabel);
            detailPriceLabel.setBounds(450, 270, 200, 40);

            //---- detailBriefLabel ----
            detailBriefLabel.setText("\u4ef2\u607a\u9e7f\u6657");
            detailBriefLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
            panel1.add(detailBriefLabel);
            detailBriefLabel.setBounds(320, 365, 215, 95);

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
    private JLabel detailNameLabel;
    private JLabel detailPublishLabel;
    private JLabel detailTypeLabel;
    private JLabel detailPriceLabel;
    private JLabel detailBriefLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public void initView() {
        System.out.println(newspaperId);
        ImageIcon image = new ImageIcon("src/main/java/com/zkxg/newspaper_subscription/view/poster.jpg");
        image.setImage(image.getImage().getScaledInstance(290,515,Image.SCALE_DEFAULT));
        imageLabel.setIcon(image);
        BaseResponse<Newspaper> newspaperBaseResponse = newspaperController.getNewspaperById(newspaperId);
        Newspaper detailNewspaper = newspaperBaseResponse.getData();
        // 渲染报刊信息
        detailNameLabel.setText(detailNewspaper.getName());
        detailPublishLabel.setText(detailNewspaper.getPublisher());
        detailTypeLabel.setText(detailNewspaper.getType());
        detailPriceLabel.setText(detailNewspaper.getPrice().toString());
        detailBriefLabel.setText("<html>"+ detailNewspaper.getBrief() +"</html>"); // 超过宽度自动换行
    }
}
