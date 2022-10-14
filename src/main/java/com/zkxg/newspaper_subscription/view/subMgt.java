/*
 * Created by JFormDesigner on Wed Oct 12 15:39:19 CST 2022
 */

package com.zkxg.newspaper_subscription.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

//import com.jgoodies.forms.factories.*;
import com.zkxg.newspaper_subscription.common.BaseResponse;
import com.zkxg.newspaper_subscription.controller.UserController;
import com.zkxg.newspaper_subscription.model.entity.User;
import com.zkxg.newspaper_subscription.model.vo.LoginInfo;

/**
 * @author unknown
 * 管理员登陆成功主界面
 */
public class subMgt extends JFrame {
    private UserController userController ;
    public subMgt() {
        userController = new UserController();
        // 初始化界面
        initComponents();
        // 设置关闭按钮结束程序
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 窗口可见
        setVisible(true);
        // 绑定事件
        listerner();
        // 初始化用户信息
        initUserInfo();
        // 初始化查询界面
        initQueryView();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - unknown
        panel1 = new JPanel();
        label1 = new JLabel();
        tabbedPane1 = new JTabbedPane();
        index = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        queryField = new JTextField();
        queryButton = new JButton();
        queryList = new JComboBox();
        scrollPane1 = new JScrollPane();
        queryTable = new JTable();
        panel7 = new JPanel();
        scrollPane2 = new JScrollPane();
        userList = new JTable();
        queryUserField = new JTextField();
        queryUserButton = new JButton();
        panel3 = new JPanel();
        changUser = new JLabel();
        changeSex = new JLabel();
        changeEmail = new JLabel();
        changePhone = new JLabel();
        changeUserField = new JTextField();
        changEmailField = new JTextField();
        changePhoneField = new JTextField();
        changeButton = new JButton();
        changeSexList = new JComboBox();
        panel2 = new JPanel();
        logoutButton = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(920, 650));
        setForeground(new Color(0x3c3f41));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0x4c5052));
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border.
            EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER, javax. swing
            . border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ),
            java. awt. Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( )
            { @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName () ))
            throw new RuntimeException( ); }} );
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("\u6b22\u8fce\u4f7f\u7528\u62a5\u520a\u8ba2\u9605\u7ba1\u7406\u7cfb\u7edf\uff01");
            label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 30));
            label1.setForeground(new Color(0xf2f2f2));
            panel1.add(label1);
            label1.setBounds(new Rectangle(new Point(15, 10), label1.getPreferredSize()));

            //======== tabbedPane1 ========
            {
                tabbedPane1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));

                //======== index ========
                {
                    index.setLayout(null);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < index.getComponentCount(); i++) {
                            Rectangle bounds = index.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = index.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        index.setMinimumSize(preferredSize);
                        index.setPreferredSize(preferredSize);
                    }
                }
                tabbedPane1.addTab("\u9996\u9875", index);

                //======== panel5 ========
                {
                    panel5.setLayout(null);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < panel5.getComponentCount(); i++) {
                            Rectangle bounds = panel5.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = panel5.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        panel5.setMinimumSize(preferredSize);
                        panel5.setPreferredSize(preferredSize);
                    }
                }
                tabbedPane1.addTab("\u8ba2\u9605\u7edf\u8ba1", panel5);

                //======== panel6 ========
                {
                    panel6.setLayout(null);

                    //---- queryField ----
                    queryField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    panel6.add(queryField);
                    queryField.setBounds(195, 25, 200, 40);

                    //---- queryButton ----
                    queryButton.setText("\u67e5\u8be2");
                    queryButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    panel6.add(queryButton);
                    queryButton.setBounds(410, 25, queryButton.getPreferredSize().width, 40);
                    panel6.add(queryList);
                    queryList.setBounds(20, 25, 160, 40);

                    //======== scrollPane1 ========
                    {
                        scrollPane1.setViewportView(queryTable);
                    }
                    panel6.add(scrollPane1);
                    scrollPane1.setBounds(15, 80, 885, 430);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < panel6.getComponentCount(); i++) {
                            Rectangle bounds = panel6.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = panel6.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        panel6.setMinimumSize(preferredSize);
                        panel6.setPreferredSize(preferredSize);
                    }
                }
                tabbedPane1.addTab("\u8ba2\u5355\u67e5\u8be2", panel6);

                //======== panel7 ========
                {
                    panel7.setLayout(null);

                    //======== scrollPane2 ========
                    {
                        scrollPane2.setViewportView(userList);
                    }
                    panel7.add(scrollPane2);
                    scrollPane2.setBounds(20, 70, 880, 435);

                    //---- queryUserField ----
                    queryUserField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    panel7.add(queryUserField);
                    queryUserField.setBounds(25, 15, 200, 40);

                    //---- queryUserButton ----
                    queryUserButton.setText("\u67e5\u8be2");
                    queryUserButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    panel7.add(queryUserButton);
                    queryUserButton.setBounds(245, 15, 78, 40);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < panel7.getComponentCount(); i++) {
                            Rectangle bounds = panel7.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = panel7.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        panel7.setMinimumSize(preferredSize);
                        panel7.setPreferredSize(preferredSize);
                    }
                }
                tabbedPane1.addTab("\u7528\u6237\u5217\u8868", panel7);

                //======== panel3 ========
                {
                    panel3.setLayout(null);

                    //---- changUser ----
                    changUser.setText("\u7528\u6237\u540d");
                    changUser.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    panel3.add(changUser);
                    changUser.setBounds(new Rectangle(new Point(170, 110), changUser.getPreferredSize()));

                    //---- changeSex ----
                    changeSex.setText("\u6027\u522b");
                    changeSex.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    panel3.add(changeSex);
                    changeSex.setBounds(175, 175, 60, 27);

                    //---- changeEmail ----
                    changeEmail.setText("\u90ae\u7bb1");
                    changeEmail.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    panel3.add(changeEmail);
                    changeEmail.setBounds(175, 245, 60, 27);

                    //---- changePhone ----
                    changePhone.setText("\u7535\u8bdd");
                    changePhone.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    panel3.add(changePhone);
                    changePhone.setBounds(175, 305, 60, 27);
                    panel3.add(changeUserField);
                    changeUserField.setBounds(260, 110, 205, 35);
                    panel3.add(changEmailField);
                    changEmailField.setBounds(260, 245, 205, 35);
                    panel3.add(changePhoneField);
                    changePhoneField.setBounds(260, 305, 205, 35);

                    //---- changeButton ----
                    changeButton.setText("\u786e\u8ba4\u4fee\u6539");
                    changeButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    panel3.add(changeButton);
                    changeButton.setBounds(175, 410, 295, 45);
                    panel3.add(changeSexList);
                    changeSexList.setBounds(260, 175, 205, 40);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < panel3.getComponentCount(); i++) {
                            Rectangle bounds = panel3.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = panel3.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        panel3.setMinimumSize(preferredSize);
                        panel3.setPreferredSize(preferredSize);
                    }
                }
                tabbedPane1.addTab("\u4e2a\u4eba\u4fe1\u606f\u4fee\u6539", panel3);

                //======== panel2 ========
                {
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
                tabbedPane1.addTab("\u9996\u9875", panel2);
            }
            panel1.add(tabbedPane1);
            tabbedPane1.setBounds(0, 70, 935, 565);

            //---- logoutButton ----
            logoutButton.setText("\u6ce8\u9500\u8d26\u53f7");
            logoutButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(logoutButton);
            logoutButton.setBounds(new Rectangle(new Point(785, 35), logoutButton.getPreferredSize()));

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
        panel1.setBounds(0, 0, 925, 635);

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
    private JLabel label1;
    private JTabbedPane tabbedPane1;
    private JPanel index;
    private JPanel panel5;
    private JPanel panel6;
    private JTextField queryField;
    private JButton queryButton;
    private JComboBox queryList;
    private JScrollPane scrollPane1;
    private JTable queryTable;
    private JPanel panel7;
    private JScrollPane scrollPane2;
    private JTable userList;
    private JTextField queryUserField;
    private JButton queryUserButton;
    private JPanel panel3;
    private JLabel changUser;
    private JLabel changeSex;
    private JLabel changeEmail;
    private JLabel changePhone;
    private JTextField changeUserField;
    private JTextField changEmailField;
    private JTextField changePhoneField;
    private JButton changeButton;
    private JComboBox changeSexList;
    private JPanel panel2;
    private JButton logoutButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    // 初始化用户信息
    public void initUserInfo() {
        // 请求接口获取当前登录用户的信息
        BaseResponse<User> userBaseResponse = userController.getCurrentLoginUser();
        User user = userBaseResponse.getData();
        System.out.println(user);
        // 将获取到的用户信息渲染到文本框上
        changeUserField.setText(user.getNackname());
        changEmailField.setText(user.getEmail());
        changePhoneField.setText(user.getPhone());
        changeSexList.addItem("男");
        changeSexList.addItem("女");
        changeSexList.setSelectedIndex(user.getGender());
    }
    // 初始化查询界面
    public void initQueryView() {
        queryList.addItem("按书名查询");
        queryList.addItem("按人员查询");
        queryList.addItem("按部门查询");
        // 查询表
        DefaultTableModel queryT = (DefaultTableModel) queryTable.getModel();
        // 设置订单列表表头名
        Object[] orderRowName = {"订单编号","报刊名称","部门","用户名称","订阅份数","订阅月数","订单总金额"};
        // 设置行与列
        queryT.setRowCount(6);
        queryT.setColumnCount(orderRowName.length);
        for (int i = 0; i < orderRowName.length; i++) {
            queryT.setValueAt(orderRowName[i],0,i);
        }
    }
    // 监听事件
    public void listerner() {
        // 触发修改账号信息事件
        changeButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // 获取用户输入的新用户名
                        String modUserName = changeUserField.getText();
                        // 获取用户输入的新邮箱
                        String modEmail = changEmailField.getText();
                        // 获取用户输入的新手机
                        String modPhone = changePhoneField.getText();
                        // 获取用户输入的新性别
                        Integer changeSex = changeSexList.getSelectedIndex();
                        // 将获取的数据存入即将提交给接口进行修改的对象中
                        BaseResponse<User> userBaseResponse = userController.getCurrentLoginUser();
                        User user = userBaseResponse.getData();
                        user.setNackname(modUserName);
                        user.setEmail(modEmail);
                        user.setPhone(modPhone);
                        user.setGender(changeSex);
                        // 表单预验证
                        if (modUserName.trim().length() == 0
                                || modEmail.trim().length() == 0
                                || modPhone.trim().length() == 0
                                ) {
                            JOptionPane.showMessageDialog(null, "请完善用户信息！");
                            return;
                        }
                        else if(modUserName.length() < 3 || modUserName.length() > 16) {
                            JOptionPane.showMessageDialog(null, "  用户昵称长度应为3-16位！");
                            return;
                        }
                        // 请求接口修改用户信息，将修改后的对象发送给接口请求修改
                        BaseResponse<String> StringBaseResponse = userController.userInfoUpdate(user);
                        String str = StringBaseResponse.getData();
                        System.out.println(str);
                            JOptionPane.showMessageDialog(null,"修改用户信息成功！");
                            // 将修改成功后的信息重新渲染到文本框上
                            changeUserField.setText(modUserName);
                            changEmailField.setText(modEmail);
                            changePhoneField.setText(modPhone);
                            changeSexList.setSelectedIndex(changeSex);
                    }
                }
        );
        // 触发注销账号事件
        logoutButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // 关闭主界面
                        dispose();
                        JOptionPane.showMessageDialog(null,"您已退出当前账号登录，即将返回登录界面！");
                        // 创建登录界面
                        new Login();
                    }
                }
        );
        // 触发订单查询事件
        queryButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("触发了订单查询按钮！");
                    }
                }
        );
        // 管理员按照不同方式查询信息
        queryList.addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            if (queryList.getSelectedIndex() == 0) {
                                System.out.println("按书名查询");
                            }
                            else if (queryList.getSelectedIndex() == 1) {
                                System.out.println("按人员查询");
                            }
                            else if (queryList.getSelectedIndex() == 2) {
                                System.out.println("按部门查询");
                            }
                        }
                    }
                }
        );
        // 管理员对用户列表进行查询
        queryUserButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("触发查询用户列表按钮！");
                        // 用户列表
                        DefaultTableModel userL = (DefaultTableModel) userList.getModel();
                        // 设置用户列表表头名
                        Object[] userRowName = {"账号","用户昵称","用户密码","性别","邮箱"};
                        Object Sex = "男";
                        userL.setRowCount(6);
                        userL.setColumnCount(userRowName.length);
                        for (int i = 0; i < userRowName.length; i++) {
                            userL.setValueAt(userRowName[i],0,i);
                        }
                        // 请求接口获取用户列表
                        BaseResponse<List<User>> userListBaseResponse = userController.getUserPage(60,7);
                        List<User> userList = userListBaseResponse.getData();
                        System.out.println(userList);
                        for (int i = 1; i < userList.size(); i++) {
                            User user = userList.get(i);
                            userL.setValueAt(user.getAccount(),i,0);
                            userL.setValueAt(user.getNackname(),i,1);
                            userL.setValueAt(user.getPassword(),i,2);
                            userL.setValueAt(Sex,i,3);
                            userL.setValueAt(user.getEmail(),i,4);
                        }
                    }
                }
        );
    }
}
