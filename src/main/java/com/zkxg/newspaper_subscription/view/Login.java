/*
 * Created by JFormDesigner on Wed Oct 12 11:06:23 CST 2022
 */

package com.zkxg.newspaper_subscription.view;

import com.zkxg.newspaper_subscription.common.BaseResponse;
import com.zkxg.newspaper_subscription.common.ErrorCode;
import com.zkxg.newspaper_subscription.controller.NewspaperController;
import com.zkxg.newspaper_subscription.controller.UserController;
import com.zkxg.newspaper_subscription.model.entity.User;
import com.zkxg.newspaper_subscription.model.vo.LoginInfo;
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
    private NewspaperController newspaperController;
    public Login() {
        newspaperController = new NewspaperController();
        userController = new UserController();
        // 初始化
        initComponents();
        // 设置关闭按钮结束程序
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 窗口可见
        setVisible(true);
        // 窗口标题
        setTitle("报刊订阅系统");
        setResizable(false);
        // 监听事件
        listerner();
        initView();
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
        iconLabel = new JLabel();

        //======== this ========
        setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
        setMinimumSize(new Dimension(555, 470));
        setBackground(new Color(0x45494a));
        setForeground(SystemColor.windowText);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0x45494a));
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
            ( 0, 0, 0, 0) , "", javax. swing. border. TitledBorder. CENTER, javax. swing. border
            . TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
            propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
            ; }} );
            panel1.setLayout(null);

            //---- systemTitle ----
            systemTitle.setText("\u62a5\u520a\u8ba2\u9605\u7cfb\u7edf");
            systemTitle.setFont(new Font("\u5e7c\u5706", systemTitle.getFont().getStyle(), systemTitle.getFont().getSize() + 15));
            systemTitle.setForeground(new Color(0xfafafa));
            panel1.add(systemTitle);
            systemTitle.setBounds(205, 30, 245, 55);

            //---- accountLabel ----
            accountLabel.setText("\u8d26\u53f7");
            accountLabel.setFont(new Font("\u5e7c\u5706", accountLabel.getFont().getStyle(), accountLabel.getFont().getSize() + 8));
            accountLabel.setForeground(new Color(0xfafafa));
            panel1.add(accountLabel);
            accountLabel.setBounds(new Rectangle(new Point(100, 135), accountLabel.getPreferredSize()));

            //---- accountField ----
            accountField.setText("linxiaohu");
            panel1.add(accountField);
            accountField.setBounds(165, 130, 270, 30);

            //---- passLabel ----
            passLabel.setText("\u5bc6\u7801");
            passLabel.setFont(new Font("\u5e7c\u5706", passLabel.getFont().getStyle(), passLabel.getFont().getSize() + 8));
            passLabel.setForeground(new Color(0xfafafa));
            panel1.add(passLabel);
            passLabel.setBounds(new Rectangle(new Point(100, 205), passLabel.getPreferredSize()));

            //---- loginButton ----
            loginButton.setText("\u767b\u5f55");
            loginButton.setFont(new Font("\u5e7c\u5706", loginButton.getFont().getStyle(), loginButton.getFont().getSize() + 7));
            panel1.add(loginButton);
            loginButton.setBounds(165, 295, 90, 40);

            //---- registerButton ----
            registerButton.setText("\u6ce8\u518c");
            registerButton.setFont(new Font("\u5e7c\u5706", registerButton.getFont().getStyle(), registerButton.getFont().getSize() + 7));
            panel1.add(registerButton);
            registerButton.setBounds(340, 295, 90, 40);

            //---- passwordField ----
            passwordField.setText("linxiaohu");
            panel1.add(passwordField);
            passwordField.setBounds(165, 200, 270, 30);
            panel1.add(iconLabel);
            iconLabel.setBounds(120, 35, 45, 45);

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
    public void initView() {
        getContentPane().setBackground(new Color(69, 73, 74));
        ImageIcon image = new ImageIcon("src/main/java/com/zkxg/newspaper_subscription/view/icon.png");
        image.setImage(image.getImage().getScaledInstance(45,45,Image.SCALE_DEFAULT));
        iconLabel.setIcon(image);
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
                            JOptionPane.showMessageDialog(null, "用户名和密码不能为空");
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
                        User user = null;
                        if(userBaseResponse.getData() instanceof User) {
                            user = userBaseResponse.getData();
                        }
                        System.out.println(user);
                        if (user != null) {
                            JOptionPane.showMessageDialog(null, "登录成功！");
                            // 登录成功，关闭登录界面，进入主界面
                            dispose();
                            // 判断是管理员登录还是普通用户登录
                            if (newspaperController.isAdmin()) {
                                new subMgt();
                            }
                            else {
                                new subUserMgt();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null,"该账号不存在或密码，请重新输入！");
                            // 清空文本框内容
                            accountField.setText("");
                            passwordField.setText("");
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
    private JLabel iconLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

}
