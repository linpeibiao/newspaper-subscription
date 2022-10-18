/*
 * Created by JFormDesigner on Mon Oct 17 15:07:29 CST 2022
 */

package com.zkxg.newspaper_subscription.view;

import com.zkxg.newspaper_subscription.common.BaseResponse;
import com.zkxg.newspaper_subscription.controller.NewspaperController;
import com.zkxg.newspaper_subscription.controller.OrderController;
import com.zkxg.newspaper_subscription.model.dto.OrderDto;
import com.zkxg.newspaper_subscription.model.entity.Newspaper;
import com.zkxg.newspaper_subscription.model.entity.Order;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import javax.swing.*;

import static com.zkxg.newspaper_subscription.view.subMgt.currentUser;
import static com.zkxg.newspaper_subscription.view.subMgt.newspaperId;

/**
 * @author unknown
 */
public class newsDetail extends JFrame {
    private NewspaperController newspaperController;
    private OrderController orderController;
    private Long getNewspaperId;
    public newsDetail() {
        newspaperController = new NewspaperController();
        orderController = new OrderController();
        // 初始化
        initComponents();
        // 窗口可见
        setVisible(true);
        // 固定窗口大小
        setResizable(false);
        setTitle("报刊详情");
        // 初始化详情界面
        initView();
        // 监听事件
        listerner();
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
        subNewsButton = new JButton();
        subNewsCountField = new JTextField();
        label7 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder
            ( 0, 0 ,0 , 0) ,  "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border
            .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069al\u006fg", java .awt . Font. BOLD ,12 ) ,java . awt
            . Color .red ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void
            propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062or\u0064er" .equals ( e. getPropertyName () ) )throw new RuntimeException( )
            ;} } );
            panel1.setLayout(null);
            panel1.add(imageLabel);
            imageLabel.setBounds(10, 10, 290, 515);

            //---- label2 ----
            label2.setText("\u62a5\u520a\u540d\u79f0\uff1a");
            label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(label2);
            label2.setBounds(320, 25, 105, 40);

            //---- label3 ----
            label3.setText("\u51fa\u7248\u62a5\u793e\uff1a");
            label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(label3);
            label3.setBounds(320, 75, 105, 40);

            //---- label4 ----
            label4.setText("\u62a5\u520a\u7c7b\u578b\uff1a");
            label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(label4);
            label4.setBounds(320, 130, 105, 40);

            //---- label5 ----
            label5.setText("\u62a5\u520a\u5355\u4ef7\uff1a");
            label5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(label5);
            label5.setBounds(320, 185, 105, 40);

            //---- label6 ----
            label6.setText("\u5185\u5bb9\u4ecb\u7ecd\uff1a");
            label6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(label6);
            label6.setBounds(315, 245, 105, 40);

            //---- detailNameLabel ----
            detailNameLabel.setText("\u4ef2\u607a\u9e7f\u6657");
            detailNameLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(detailNameLabel);
            detailNameLabel.setBounds(450, 25, 200, 40);

            //---- detailPublishLabel ----
            detailPublishLabel.setText("\u4ef2\u607a\u9e7f\u6657");
            detailPublishLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(detailPublishLabel);
            detailPublishLabel.setBounds(450, 75, 200, 40);

            //---- detailTypeLabel ----
            detailTypeLabel.setText("\u4ef2\u607a\u9e7f\u6657");
            detailTypeLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(detailTypeLabel);
            detailTypeLabel.setBounds(450, 130, 200, 40);

            //---- detailPriceLabel ----
            detailPriceLabel.setText("\u4ef2\u607a\u9e7f\u6657");
            detailPriceLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(detailPriceLabel);
            detailPriceLabel.setBounds(450, 185, 200, 40);

            //---- detailBriefLabel ----
            detailBriefLabel.setText("\u4ef2\u607a\u9e7f\u6657");
            detailBriefLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
            panel1.add(detailBriefLabel);
            detailBriefLabel.setBounds(315, 255, 215, 95);

            //---- subNewsButton ----
            subNewsButton.setText("\u8ba2\u9605");
            subNewsButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(subNewsButton);
            subNewsButton.setBounds(315, 440, 240, 40);

            //---- subNewsCountField ----
            subNewsCountField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(subNewsCountField);
            subNewsCountField.setBounds(480, 370, 75, 40);

            //---- label7 ----
            label7.setText("\u8f93\u5165\u8ba2\u9605\u4efd\u6570\uff1a");
            label7.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(label7);
            label7.setBounds(315, 370, label7.getPreferredSize().width, 40);

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
    private JButton subNewsButton;
    private JTextField subNewsCountField;
    private JLabel label7;
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
        getNewspaperId = newspaperId;
        System.out.println("getNewspaperId"+getNewspaperId);
    }
    public void listerner() {
        subNewsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("触发订阅按钮");
                if (subNewsCountField.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null,"请输入订阅份数！");
                    return;
                }
                // 订阅单价
                BigDecimal singlePrice = new BigDecimal(detailPriceLabel.getText());
                BigDecimal count = new BigDecimal(subNewsCountField.getText());
                // 订阅总价
                BigDecimal subToalPrice = singlePrice.multiply(count);
                if (Integer.valueOf(subNewsCountField.getText()) <= 0 || !(Integer.valueOf(subNewsCountField.getText()) instanceof Integer) || subNewsCountField.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null,"订阅份数必须是大于0的整数");
                    return;
                }
                int option = JOptionPane.showConfirmDialog(null,"最终总价为" + subToalPrice + "元，是否确认提交订单？");
                if (option == JOptionPane.YES_OPTION) {
                    System.out.println("确认提交订单");
                    OrderDto subObj = new OrderDto(currentUser.getId(),currentUser.getNackname(),getNewspaperId,detailNameLabel.getText(),Integer.valueOf(1),Integer.valueOf(subNewsCountField.getText()),singlePrice,subToalPrice,"订阅成功！");
                    BaseResponse<Order> orderBaseResponse = orderController.orderNewspaper(subObj);
                    JOptionPane.showMessageDialog(null,"订阅成功！");
                    dispose();
                }
                else if (option == JOptionPane.CANCEL_OPTION) {
                    System.out.println("取消本次订单提交");
                }
                else if (option == JOptionPane.CLOSED_OPTION) {
                    System.out.println("关闭本次对话窗口");
                }
            }
        });
    }
}
