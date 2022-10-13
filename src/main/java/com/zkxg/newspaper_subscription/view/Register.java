/*
 * Created by JFormDesigner on Wed Oct 12 11:11:18 CST 2022
 */

package com.zkxg.newspaper_subscription.view;

import com.zkxg.newspaper_subscription.common.BaseResponse;
import com.zkxg.newspaper_subscription.controller.UserController;
import com.zkxg.newspaper_subscription.model.entity.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

/**
 * @author unknown
 * 注册界面
 */
public class Register extends JFrame {
    private UserController userController;
    public Register() {
        // 初始化
        initComponents();
        // 设置关闭按钮结束程序
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 窗口可见
        setVisible(true);
        // 事件监听
        listerner();
        userController = new UserController();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - unknown
        panel1 = new JPanel();
        registerTitle = new JLabel();
        newAccount = new JLabel();
        newAccountField = new JTextField();
        newPassword = new JLabel();
        registerButton = new JButton();
        backLoginButton = new JButton();
        newPasswordField = new JPasswordField();
        newUser = new JLabel();
        newUserField = new JTextField();
        panel2 = new JPanel();

        //======== this ========
        setMinimumSize(new Dimension(555, 470));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0x4c5052));
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (
            new javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn"
            , javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
            , new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 )
            , java. awt. Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (
            new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
            ; }} );
            panel1.setLayout(null);

            //---- registerTitle ----
            registerTitle.setText("\u6ce8\u518c\u65b0\u8d26\u53f7");
            registerTitle.setFont(registerTitle.getFont().deriveFont(registerTitle.getFont().getSize() + 9f));
            registerTitle.setForeground(new Color(0xf9f9f9));
            panel1.add(registerTitle);
            registerTitle.setBounds(225, 15, registerTitle.getPreferredSize().width, 28);

            //---- newAccount ----
            newAccount.setText("\u65b0\u8d26\u53f7");
            newAccount.setFont(newAccount.getFont().deriveFont(newAccount.getFont().getSize() + 6f));
            newAccount.setForeground(new Color(0xf9f9f9));
            panel1.add(newAccount);
            newAccount.setBounds(new Rectangle(new Point(85, 185), newAccount.getPreferredSize()));
            panel1.add(newAccountField);
            newAccountField.setBounds(150, 180, 270, 30);

            //---- newPassword ----
            newPassword.setText("\u65b0\u5bc6\u7801");
            newPassword.setFont(newPassword.getFont().deriveFont(newPassword.getFont().getSize() + 6f));
            newPassword.setForeground(new Color(0xf9f9f9));
            panel1.add(newPassword);
            newPassword.setBounds(85, 250, newPassword.getPreferredSize().width, 24);

            //---- registerButton ----
            registerButton.setText("\u6ce8\u518c\u8d26\u53f7");
            registerButton.setFont(registerButton.getFont().deriveFont(registerButton.getFont().getSize() + 3f));
            panel1.add(registerButton);
            registerButton.setBounds(150, 310, registerButton.getPreferredSize().width, 40);

            //---- backLoginButton ----
            backLoginButton.setText("\u8fd4\u56de\u767b\u5f55");
            backLoginButton.setFont(backLoginButton.getFont().deriveFont(backLoginButton.getFont().getSize() + 3f));
            panel1.add(backLoginButton);
            backLoginButton.setBounds(325, 310, backLoginButton.getPreferredSize().width, 40);
            panel1.add(newPasswordField);
            newPasswordField.setBounds(150, 245, 270, 30);

            //---- newUser ----
            newUser.setText("\u7528\u6237\u540d");
            newUser.setFont(newUser.getFont().deriveFont(newUser.getFont().getSize() + 6f));
            newUser.setForeground(new Color(0xf9f9f9));
            panel1.add(newUser);
            newUser.setBounds(85, 125, newUser.getPreferredSize().width, 24);
            panel1.add(newUserField);
            newUserField.setBounds(150, 120, 270, 30);

            //======== panel2 ========
            {
                panel2.setBackground(new Color(0x4c5052));
                panel2.setLayout(null);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel2.getComponentCount(); i++) {
                        Rectangle bounds = panel2.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel2.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel2.setMinimumSize(preferredSize);
                    panel2.setPreferredSize(preferredSize);
                }
            }
            panel1.add(panel2);
            panel2.setBounds(0, 0, 555, 435);

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
        panel1.setBounds(0, 0, 555, 430);

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
    public void listerner() {
        // 触发返回登录界面事件
        backLoginButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // 关闭注册界面
                        dispose();
                        // 重新创建新登录界面
                        new Login();
                    }
                }
        );
        // 触发注册事件
        registerButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    // 获取注册用户昵称
                        String newUsername = newUserField.getText();
                    // 获取注册新账号
                        String newAccount = newAccountField.getText();
                    // 获取注册新密码
                        String newPassword = String.valueOf(newPasswordField.getPassword());
                    // 将注册信息填充到 User 对象中
                    User registerInfo = new User(0L,newAccount,newPassword,newUsername,"avatar",0,"4396","666@qq.com","仲恺鹿晗","department","address","postcode",0,0,"backup1","backup1","backup1",new Date(),new Date(),0);
                        // 表单验证
                        if (newUsername == null
                                || newAccount.trim().length() == 0
                                || newPassword.trim().length() == 0) {
                            JOptionPane.showMessageDialog(null, "请将注册信息填写完整！");
                            return;
                        }
                        else if(newUsername.length() < 3 || newUsername.length() > 16) {
                            JOptionPane.showMessageDialog(null, "  用户昵称长度应为3-16位！");
                            return;
                        }
                        else if(newAccount.length() < 4 || newAccount.length() > 16) {
                            JOptionPane.showMessageDialog(null, "  用户账号长度应为4-16位！");
                            return;
                        }
                        else if (newPassword.length() < 8 || newPassword.length() > 16) {
                            JOptionPane.showMessageDialog(null, "  用户密码长度应为8-16位！");
                            return;
                        }
                        BaseResponse<String> userBaseResponse = userController.userRegister(registerInfo);
                        String str = userBaseResponse.getData();
                        System.out.println(str);
                        // 注册成功，返回登录界面
                        JOptionPane.showMessageDialog(null,"注册成功！返回登录界面");
                        dispose();
                        new Login();
                    }
                }
        );
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel panel1;
    private JLabel registerTitle;
    private JLabel newAccount;
    private JTextField newAccountField;
    private JLabel newPassword;
    private JButton registerButton;
    private JButton backLoginButton;
    private JPasswordField newPasswordField;
    private JLabel newUser;
    private JTextField newUserField;
    private JPanel panel2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
