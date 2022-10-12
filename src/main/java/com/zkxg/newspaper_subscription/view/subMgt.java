/*
 * Created by JFormDesigner on Wed Oct 12 15:39:19 CST 2022
 */

package com.zkxg.newspaper_subscription.view;

import java.awt.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class subMgt extends JFrame {
    public subMgt() {
        // 初始化
        initComponents();
        // 设置关闭按钮结束程序
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 窗口可见
        setVisible(true);
        // 监听事件
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(710, 535));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u62a5\u520a\u8ba2\u9605\u7ba1\u7406\u754c\u9762");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(190, 30), label1.getPreferredSize()));

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
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
