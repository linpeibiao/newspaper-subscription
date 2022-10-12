/*
 * Created by JFormDesigner on Wed Oct 12 11:06:23 CST 2022
 */

package com.zkxg.newspaper_subscription.view;

import com.zkxg.newspaper_subscription.common.BaseResponse;
import com.zkxg.newspaper_subscription.common.ErrorCode;
import com.zkxg.newspaper_subscription.controller.UserController;
import com.zkxg.newspaper_subscription.model.entity.User;
import com.zkxg.newspaper_subscription.model.vo.LoginInfo;
import com.zkxg.newspaper_subscription.service.UserService;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author unknown
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

        //---- systemTitle ----
        systemTitle.setText("\u62a5\u520a\u8ba2\u9605\u7cfb\u7edf");
        systemTitle.setFont(systemTitle.getFont().deriveFont(systemTitle.getFont().getSize() + 9f));
        contentPane.add(systemTitle);
        systemTitle.setBounds(new Rectangle(new Point(205, 20), systemTitle.getPreferredSize()));

        //---- accountLabel ----
        accountLabel.setText("\u8d26\u53f7");
        accountLabel.setFont(accountLabel.getFont().deriveFont(accountLabel.getFont().getSize() + 6f));
        contentPane.add(accountLabel);
        accountLabel.setBounds(new Rectangle(new Point(80, 155), accountLabel.getPreferredSize()));
        contentPane.add(accountField);
        accountField.setBounds(145, 150, 270, 30);

        //---- passLabel ----
        passLabel.setText("\u5bc6\u7801");
        passLabel.setFont(passLabel.getFont().deriveFont(passLabel.getFont().getSize() + 6f));
        contentPane.add(passLabel);
        passLabel.setBounds(new Rectangle(new Point(80, 215), passLabel.getPreferredSize()));

        //---- loginButton ----
        loginButton.setText("\u767b\u5f55");
        loginButton.setFont(loginButton.getFont().deriveFont(loginButton.getFont().getSize() + 3f));
        contentPane.add(loginButton);
        loginButton.setBounds(145, 315, 90, 40);

        //---- registerButton ----
        registerButton.setText("\u6ce8\u518c");
        registerButton.setFont(registerButton.getFont().deriveFont(registerButton.getFont().getSize() + 3f));
        contentPane.add(registerButton);
        registerButton.setBounds(320, 315, 90, 40);
        contentPane.add(passwordField);
        passwordField.setBounds(145, 220, 270, 30);

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
                        BaseResponse<User> userBaseResponse = userController.userLogin(accountInfo);
                        User use = userBaseResponse.getData();
                        System.out.println(use);
                        if (use != null) {
                            JOptionPane.showMessageDialog(null, "登录成功！");
                            accountField.setText("");
                            passwordField.setText("");
                            // 登录成功，关闭登录界面，进入主界面
                            dispose();
                            new subMgt();
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
    private JLabel systemTitle;
    private JLabel accountLabel;
    private JTextField accountField;
    private JLabel passLabel;
    private JButton loginButton;
    private JButton registerButton;
    private JPasswordField passwordField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

}
