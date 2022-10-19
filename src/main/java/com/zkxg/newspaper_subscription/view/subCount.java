/*
 * Created by JFormDesigner on Tue Oct 18 20:34:08 CST 2022
 */

package com.zkxg.newspaper_subscription.view;

import com.zkxg.newspaper_subscription.controller.NewspaperController;
import com.zkxg.newspaper_subscription.controller.OrderController;

import java.awt.*;
import javax.swing.*;

import static com.zkxg.newspaper_subscription.view.subMgt.newsSubCount;

/**
 * @author unknown
 */
public class subCount extends JFrame {
    private NewspaperController newspaperController;
    private OrderController orderController;
    public subCount() {
        newspaperController = new NewspaperController();
        orderController = new OrderController();
        // 初始化
        initComponents();
        // 窗口可见
        setVisible(true);
        // 固定窗口大小
        setResizable(false);
        setTitle("订阅数量");
        // 初始化详情界面
        initView();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - unknown
        panel1 = new JPanel();
        subCountLabel = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder( 0
            , 0, 0, 0) , "", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
            , new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,
            panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
            panel1.setLayout(null);

            //---- subCountLabel ----
            subCountLabel.setText("\u8ba2\u9605\u6570\u91cf\uff1a22\u4efd");
            subCountLabel.setFont(new Font("\u5fae\u8edf\u6b63\u9ed1\u9ad4", Font.BOLD, 20));
            panel1.add(subCountLabel);
            subCountLabel.setBounds(100, 30, 190, 100);

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
        panel1.setBounds(5, 5, 360, 170);

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
    private JLabel subCountLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public void initView() {
        subCountLabel.setText("订阅数量："+ newsSubCount + "份");
    }
}
