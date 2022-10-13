/*
 * Created by JFormDesigner on Wed Oct 12 11:06:23 CST 2022
 */

package com.zkxg.newspaper_subscription.view;

import com.zkxg.newspaper_subscription.common.BaseResponse;
import com.zkxg.newspaper_subscription.common.ErrorCode;
import com.zkxg.newspaper_subscription.common.ResultUtils;
import com.zkxg.newspaper_subscription.controller.UserController;
import com.zkxg.newspaper_subscription.dao.UserDao;
import com.zkxg.newspaper_subscription.model.entity.User;
import com.zkxg.newspaper_subscription.model.vo.LoginInfo;
import com.zkxg.newspaper_subscription.service.UserService;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author unknown
 * 登录界面
 */
public class Login extends JFrame {
    private UserController userController;
    public Login() {
        // 初始化
        initComponents();
        // 设置关闭按钮结束程序
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 窗口可见
        setVisible(true);
        // 监听事件
        listerner();
        userController = new UserController();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - unknown
        panel1 = new JPanel();
        systemTitle = new JLabel();
        accountLabel = new JLabel();
        accountField = new JTextField();
        passLabel = new JLabel();
        loginButton = new JButton();
        registerButton = new JButton();
        passwordField = new JPasswordField();

        //======== this ========
        setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
        setMinimumSize(new Dimension(555, 470));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0x45494a));
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
            ( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing. border
            . TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
            propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
            ; }} );
            panel1.setLayout(null);

            //---- systemTitle ----
            systemTitle.setText("\u62a5\u520a\u8ba2\u9605\u7cfb\u7edf");
            systemTitle.setFont(systemTitle.getFont().deriveFont(systemTitle.getFont().getSize() + 9f));
            systemTitle.setForeground(new Color(0xfafafa));
            panel1.add(systemTitle);
            systemTitle.setBounds(new Rectangle(new Point(215, 25), systemTitle.getPreferredSize()));

            //---- accountLabel ----
            accountLabel.setText("\u8d26\u53f7");
            accountLabel.setFont(accountLabel.getFont().deriveFont(accountLabel.getFont().getSize() + 6f));
            accountLabel.setForeground(new Color(0xfafafa));
            panel1.add(accountLabel);
            accountLabel.setBounds(new Rectangle(new Point(100, 135), accountLabel.getPreferredSize()));
            panel1.add(accountField);
            accountField.setBounds(165, 130, 270, 30);

            //---- passLabel ----
            passLabel.setText("\u5bc6\u7801");
            passLabel.setFont(passLabel.getFont().deriveFont(passLabel.getFont().getSize() + 6f));
            passLabel.setForeground(new Color(0xfafafa));
            panel1.add(passLabel);
            passLabel.setBounds(new Rectangle(new Point(100, 200), passLabel.getPreferredSize()));

            //---- loginButton ----
            loginButton.setText("\u767b\u5f55");
            loginButton.setFont(loginButton.getFont().deriveFont(loginButton.getFont().getSize() + 3f));
            panel1.add(loginButton);
            loginButton.setBounds(165, 295, 90, 40);

            //---- registerButton ----
            registerButton.setText("\u6ce8\u518c");
            registerButton.setFont(registerButton.getFont().deriveFont(registerButton.getFont().getSize() + 3f));
            panel1.add(registerButton);
            registerButton.setBounds(340, 295, 90, 40);
            panel1.add(passwordField);
            passwordField.setBounds(165, 200, 270, 30);

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
        panel1.setBounds(0, 0, 560, 440);

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
        // 触发登录事件
        loginButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // 获取账号文本框内容
                        String account = accountField.getText();
                        // 获取密码框内容
                        String password = String.valueOf(passwordField.getPassword());
                        // 将获取到的账号密码填充到 LoginInfo 对象中
                        LoginInfo accountInfo = new LoginInfo(account,"123",password);
                        // 表单预验证
                        if (null == account
                                || password == null
                                || account.trim().length() == 0
                                || password.trim().length() == 0) {
                            JOptionPane.showMessageDialog(null, "用户名或密码不能为空");
                            return;
                        }
                        else if(account.length() < 4 || account.length() > 16) {
                            JOptionPane.showMessageDialog(null, "  用户账号长度应为4-16位！");
                            return;
                        }
                        else if (password.length() < 8 || password.length() > 16) {
                            JOptionPane.showMessageDialog(null, "  用户密码长度应为8-16位！");
                            return;
                        }
                        // 请求接口判断账号是否存在
                        BaseResponse<User> userBaseResponse = userController.userLogin(accountInfo);
                        User use = userBaseResponse.getData();
                        System.out.println(use);
                        if (use != null) {
                            JOptionPane.showMessageDialog(null, "登录成功！");
                            accountField.setText("");
                            passwordField.setText("");
                            // 登录成功，关闭登录界面，进入主界面
                            dispose();
                            // 判断是管理员登录还是普通用户登录
                            new subMgt();
                        } else {
                            JOptionPane.showMessageDialog(null,"登录失败，该账号不存在或密码错误！");
                        }
                    }
                }
        );
        // 触发跳转到注册界面事件
        registerButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // 关闭登录界面
                        dispose();
                        new Register();
                    }
                }
        );
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel panel1;
    private JLabel systemTitle;
    private JLabel accountLabel;
    private JTextField accountField;
    private JLabel passLabel;
    private JButton loginButton;
    private JButton registerButton;
    private JPasswordField passwordField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

}
