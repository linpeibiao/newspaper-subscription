/*
 * Created by JFormDesigner on Wed Oct 12 15:39:19 CST 2022
 */

package com.zkxg.newspaper_subscription.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

//import com.jgoodies.forms.factories.*;
import com.zkxg.newspaper_subscription.common.BaseResponse;
import com.zkxg.newspaper_subscription.controller.NewspaperController;
import com.zkxg.newspaper_subscription.controller.OrderController;
import com.zkxg.newspaper_subscription.controller.UserController;
import com.zkxg.newspaper_subscription.model.entity.Newspaper;
import com.zkxg.newspaper_subscription.model.entity.Order;
import com.zkxg.newspaper_subscription.model.entity.User;
import com.zkxg.newspaper_subscription.model.vo.LoginInfo;
import info.clearthought.layout.*;

/**
 * @author unknown
 * 管理员登陆成功主界面
 */
public class subMgt extends JFrame {
    private UserController userController ;
    private NewspaperController newspaperController;
    private OrderController orderController;
    // 控制用户列表的分页
    public static int getPage = 1;
    // 待删除的订单的 id
    public static Long deleteOrderId;
    // 判断字符串是否为纯数字
    public static boolean isNumeric(String str){
        for (int i = 0; i < str.length(); i++){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
    public subMgt() {
        userController = new UserController();
        newspaperController = new NewspaperController();
        orderController = new OrderController();
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
        // 初始化首页界面
        initIndexView();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - unknown
        panel1 = new JPanel();
        label1 = new JLabel();
        tabbedPane1 = new JTabbedPane();
        index = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        queryField = new JTextField();
        queryButton = new JButton();
        queryList = new JComboBox();
        scrollPane1 = new JScrollPane();
        queryTable = new JTable();
        deleteOrderButton = new JButton();
        panel7 = new JPanel();
        scrollPane2 = new JScrollPane();
        userList = new JTable();
        queryUserButton = new JButton();
        prePageButton = new JButton();
        nextPageButton = new JButton();
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
        addNewsNameField = new JTextField();
        addNewsName = new JLabel();
        addNewsTypeFiled = new JTextField();
        addNewsType = new JLabel();
        addNewsBriefField = new JTextField();
        addNewsBrief = new JLabel();
        addNewsPublisherField = new JTextField();
        addNewsPublisher = new JLabel();
        addNewsPriceField = new JTextField();
        addNewsPrice = new JLabel();
        addNewsButton = new JButton();
        logoutButton = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(920, 650));
        setForeground(new Color(0x3c3f41));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0x4c5052));
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border
            .EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder. CENTER ,javax
            . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,
            12 ) ,java . awt. Color .red ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener( new java. beans
            .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "bord\u0065r" .equals ( e.
            getPropertyName () ) )throw new RuntimeException( ) ;} } );
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
                    index.add(label2);
                    label2.setBounds(60, 70, 100, 100);
                    index.add(label3);
                    label3.setBounds(200, 70, 100, 100);

                    //---- label4 ----
                    label4.setText("\u62a5\u520a\u540d\uff1a");
                    index.add(label4);
                    label4.setBounds(55, 180, 105, label4.getPreferredSize().height);

                    //---- label5 ----
                    label5.setText("\u62a5\u520a\u540d\uff1a");
                    index.add(label5);
                    label5.setBounds(200, 180, 105, 17);

                    //---- label6 ----
                    label6.setText("\u7c7b\u578b\uff1a");
                    index.add(label6);
                    label6.setBounds(55, 200, 105, 17);

                    //---- label7 ----
                    label7.setText("\u7c7b\u578b\uff1a");
                    index.add(label7);
                    label7.setBounds(200, 200, 105, 17);

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

                    //---- deleteOrderButton ----
                    deleteOrderButton.setText("\u5220\u9664\u8ba2\u5355");
                    deleteOrderButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    panel6.add(deleteOrderButton);
                    deleteOrderButton.setBounds(790, 25, deleteOrderButton.getPreferredSize().width, 40);

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
                    scrollPane2.setBounds(20, 70, 880, 275);

                    //---- queryUserButton ----
                    queryUserButton.setText("\u83b7\u53d6\u7528\u6237\u5217\u8868");
                    queryUserButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    panel7.add(queryUserButton);
                    queryUserButton.setBounds(20, 15, queryUserButton.getPreferredSize().width, 40);

                    //---- prePageButton ----
                    prePageButton.setText("\u4e0a\u4e00\u9875");
                    prePageButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    panel7.add(prePageButton);
                    prePageButton.setBounds(690, 360, prePageButton.getPreferredSize().width, 40);

                    //---- nextPageButton ----
                    nextPageButton.setText("\u4e0b\u4e00\u9875");
                    nextPageButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    panel7.add(nextPageButton);
                    nextPageButton.setBounds(805, 360, nextPageButton.getPreferredSize().width, 40);

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
                    panel2.add(addNewsNameField);
                    addNewsNameField.setBounds(265, 85, 205, 35);

                    //---- addNewsName ----
                    addNewsName.setText("\u62a5\u520a\u540d");
                    addNewsName.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    panel2.add(addNewsName);
                    addNewsName.setBounds(180, 85, 60, 27);
                    panel2.add(addNewsTypeFiled);
                    addNewsTypeFiled.setBounds(265, 145, 205, 35);

                    //---- addNewsType ----
                    addNewsType.setText("\u62a5\u520a\u7c7b\u578b");
                    addNewsType.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    panel2.add(addNewsType);
                    addNewsType.setBounds(170, 145, addNewsType.getPreferredSize().width, 27);
                    panel2.add(addNewsBriefField);
                    addNewsBriefField.setBounds(265, 205, 205, 35);

                    //---- addNewsBrief ----
                    addNewsBrief.setText("\u62a5\u520a\u7b80\u4ecb");
                    addNewsBrief.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    panel2.add(addNewsBrief);
                    addNewsBrief.setBounds(170, 205, addNewsBrief.getPreferredSize().width, 27);
                    panel2.add(addNewsPublisherField);
                    addNewsPublisherField.setBounds(265, 270, 205, 35);

                    //---- addNewsPublisher ----
                    addNewsPublisher.setText("\u51fa\u7248\u793e");
                    addNewsPublisher.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    panel2.add(addNewsPublisher);
                    addNewsPublisher.setBounds(180, 270, 60, 27);
                    panel2.add(addNewsPriceField);
                    addNewsPriceField.setBounds(265, 330, 205, 35);

                    //---- addNewsPrice ----
                    addNewsPrice.setText("\u4ef7\u683c");
                    addNewsPrice.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    panel2.add(addNewsPrice);
                    addNewsPrice.setBounds(185, 335, 60, 27);

                    //---- addNewsButton ----
                    addNewsButton.setText("\u6dfb\u52a0\u65b0\u62a5\u520a");
                    addNewsButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    panel2.add(addNewsButton);
                    addNewsButton.setBounds(175, 405, 295, 45);

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
                tabbedPane1.addTab("\u6dfb\u52a0\u62a5\u520a", panel2);
            }
            panel1.add(tabbedPane1);
            tabbedPane1.setBounds(0, 70, 935, 565);

            //---- logoutButton ----
            logoutButton.setText("\u9000\u51fa\u767b\u5f55");
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
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JPanel panel5;
    private JPanel panel6;
    private JTextField queryField;
    private JButton queryButton;
    private JComboBox queryList;
    private JScrollPane scrollPane1;
    private JTable queryTable;
    private JButton deleteOrderButton;
    private JPanel panel7;
    private JScrollPane scrollPane2;
    private JTable userList;
    private JButton queryUserButton;
    private JButton prePageButton;
    private JButton nextPageButton;
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
    private JTextField addNewsNameField;
    private JLabel addNewsName;
    private JTextField addNewsTypeFiled;
    private JLabel addNewsType;
    private JTextField addNewsBriefField;
    private JLabel addNewsBrief;
    private JTextField addNewsPublisherField;
    private JLabel addNewsPublisher;
    private JTextField addNewsPriceField;
    private JLabel addNewsPrice;
    private JButton addNewsButton;
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
        queryList.addItem("按订单号查询");
        queryList.addItem("按用户id查询");

    }
    // 初始化首页界面
    public void initIndexView() {
        // 请求接口获取报刊信息
        BaseResponse<List<Newspaper>> newsBaseResponse = newspaperController.getNewspaperByType("色情");
        List<Newspaper> newsList = newsBaseResponse.getData();
        Newspaper newspaper = newsList.get(0);
        System.out.println(newspaper);
        ImageIcon image = new ImageIcon("src/main/java/com/zkxg/newspaper_subscription/view/avatar.jpg");
        image.setImage(image.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
        label2.setIcon(image);
        label4.setText(label4.getText() + newspaper.getName());
        label3.setIcon(image);
        label5.setText(label4.getText() + newspaper.getName());
        label6.setText(label6.getText() + newspaper.getType());
        label7.setText(label7.getText() + newspaper.getType());
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
                        // 查询表
                        DefaultTableModel queryT = (DefaultTableModel) queryTable.getModel();
                        // 设置订单列表表头名
                        Object[] orderRowName = {"订单编号","订单Id","报刊名称","用户昵称","订阅份数","订单总金额"};
                        // 表单预验证
                        if (queryField.getText().length() == 0) {
                            JOptionPane.showMessageDialog(null, "查询内容不能为空");
                            queryT.getDataVector().clear(); // 清除表格数据
                            queryT.fireTableDataChanged(); // 通知模型更新
                            queryTable.updateUI(); // 更新表格
                            return;
                        }
                        // 按订单号分类查
                        if (queryList.getSelectedIndex() == 0) {
                            System.out.println("按订单号查");
                            queryT.getDataVector().clear(); // 清除表格数据
                            queryT.fireTableDataChanged(); // 通知模型更新
                            queryTable.updateUI(); // 更新表格
                            BaseResponse<Order> orderBaseResponse = orderController.getOrderInfoByOrderNumber(queryField.getText());
                            Order order = orderBaseResponse.getData();
                            System.out.println(order);
                            if(order == null) {
                                JOptionPane.showMessageDialog(null, "查无此订单！");
                                queryT.getDataVector().clear(); // 清除表格数据
                                queryT.fireTableDataChanged(); // 通知模型更新
                                queryTable.updateUI(); // 更新表格
                                return;
                            }
                            Object[] orderList = {order.getOrderNumber(),order.getId(),order.getNewspaperName(),order.getUserName(),order.getCount(),order.getTotalPrice()};
                            // 设置行与列
                            queryT.setRowCount(5);
                            queryT.setColumnCount(orderRowName.length);
                            for (int i = 0; i < orderRowName.length; i++) {
                                queryT.setValueAt(orderRowName[i],0,i);
                                queryT.setValueAt(orderList[i],1,i);
                            }
                            queryTable.getSelectionModel().addListSelectionListener(
                                    new ListSelectionListener() {
                                        @Override
                                        public void valueChanged(ListSelectionEvent e) {
                                            int row = queryTable.getSelectedRow(); // 选中行
                                            deleteOrderId = Long.valueOf(queryTable.getValueAt(row,1).toString());
                                            System.out.println(deleteOrderId);
                                            return;
                                        }
                                    }
                            );
                            return;
                        }
                        // 按用户id分类查
                        else if (queryList.getSelectedIndex() == 1) {
                            System.out.println("按用户id查");
                            queryT.getDataVector().clear(); // 清除表格数据
                            queryT.fireTableDataChanged(); // 通知模型更新
                            queryTable.updateUI(); // 更新表格
                            BaseResponse<List<Order>> orderBaseResponse = orderController.getOrderByUserId(Long.valueOf(queryField.getText()));
                            List<Order> order = orderBaseResponse.getData();
                            if(order == null) {
                                JOptionPane.showMessageDialog(null, "查无此订单！");
                                queryT.getDataVector().clear(); // 清除表格数据
                                queryT.fireTableDataChanged(); // 通知模型更新
                                queryTable.updateUI(); // 更新表格
                                return;
                            }
                            Object[] orderList = {};
                            // 设置行与列
                            queryT.setRowCount(5);
                            queryT.setColumnCount(orderRowName.length);
                            for (int i = 0; i < orderRowName.length; i++) {
                                queryT.setValueAt(orderRowName[i],0,i);
                                queryT.setValueAt(orderList[i],1,i);
                            }
                            for (int i = 1; i < order.size(); i++) {
                                Order orderL = order.get(i);
                                queryT.setValueAt(orderL.getOrderNumber(),i,0);
                                queryT.setValueAt(orderL.getNewspaperName(),i,1);
                                queryT.setValueAt(orderL.getUserName(),i,2);
                                queryT.setValueAt(orderL.getCount(),i,0);
                                queryT.setValueAt(orderL.getTotalPrice(),i,3);
                            }
                            System.out.println(order);
                        }
                    }
                }

        );
        // 删除选中的订单
        deleteOrderButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // 管理员无法删除订单
                        if (newspaperController.isAdmin()) {
                            JOptionPane.showMessageDialog(null,"管理员无法删除订单！");
                            return;
                        }
                        if (deleteOrderId == null) {
                            JOptionPane.showMessageDialog(null,"请选择需要删除的订单!");
                            return;
                        }
                        BaseResponse<String> deleteOrderBaseResponse = orderController.deleteOrder(deleteOrderId);
                        JOptionPane.showMessageDialog(null,"删除订单成功!");
                        deleteOrderId = null;
                        // 清除表格数据
                    }
                }
        );
        // 管理员对用户列表进行查询
        queryUserButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("触发查询用户列表按钮！");
                        if (!(newspaperController.isAdmin())) {
                            JOptionPane.showMessageDialog(null,"只有管理员才能获取用户列表！");
                            return;
                        }
                        // 用户列表
                        DefaultTableModel userL = (DefaultTableModel) userList.getModel();
                        // 设置用户列表表头名
                        Object[] userRowName = {"账号","用户昵称","性别","邮箱"};
                        Object Sex = "男";
                        userL.setRowCount(15);
                        userL.setColumnCount(userRowName.length);
                        for (int i = 0; i < userRowName.length; i++) {
                            userL.setValueAt(userRowName[i],0,i);
                        }
                        // 请求接口获取用户列表
                        getPage = 1;
                        BaseResponse<List<User>> userListBaseResponse = userController.getUserPage(getPage,15);
                        List<User> userList = userListBaseResponse.getData();
                        System.out.println(userList);
                        for (int i = 1; i < userList.size(); i++) {
                            User user = userList.get(i);
                            userL.setValueAt(user.getAccount(),i,0);
                            userL.setValueAt(user.getNackname(),i,1);
                            userL.setValueAt(Sex,i,2);
                            userL.setValueAt(user.getEmail(),i,3);
                        }
                    }
                }
        );
        // 获取上一页数据
        prePageButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("获取上一页数据");
                        // 用户列表
                        DefaultTableModel userL = (DefaultTableModel) userList.getModel();
                        // 设置用户列表表头名
                        Object[] userRowName = {"账号","用户昵称","性别","邮箱"};
                        Object Sex = "男";
                        userL.setRowCount(userList.getRowCount());
                        userL.setColumnCount(userRowName.length);
                        for (int i = 0; i < userRowName.length; i++) {
                            userL.setValueAt(userRowName[i],0,i);
                        }
                        if (getPage == 1) {
                            JOptionPane.showMessageDialog(null,"当前所处位置已是第一页！");
                            return;
                        }
                        // 请求接口获取用户列表
                        BaseResponse<List<User>> userListBaseResponse = userController.getUserPage(getPage-=13,15);
                        List<User> userList = userListBaseResponse.getData();
                        System.out.println(userList);
                        for (int i = 1; i < userList.size(); i++) {
                            User user = userList.get(i);
                            userL.setValueAt(user.getAccount(),i,0);
                            userL.setValueAt(user.getNackname(),i,1);
                            userL.setValueAt(Sex,i,2);
                            userL.setValueAt(user.getEmail(),i,3);
                        }
                    }
                }
        );
        // 获取下一页数据
        nextPageButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("获取下一页数据");
                        // 用户列表
                        DefaultTableModel userL = (DefaultTableModel) userList.getModel();
                        // 设置用户列表表头名
                        Object[] userRowName = {"账号","用户昵称","性别","邮箱"};
                        Object Sex = "男";
                        userL.setRowCount(userList.getRowCount());
                        userL.setColumnCount(userRowName.length);
                        for (int i = 0; i < userRowName.length; i++) {
                            userL.setValueAt(userRowName[i],0,i);
                        }
                        // 请求接口获取用户列表
                        BaseResponse<List<User>> userListBaseResponse = userController.getUserPage(getPage+=13,15);
                        List<User> userList = userListBaseResponse.getData();
                        System.out.println(userList);
                        for (int i = 1; i < userList.size(); i++) {
                            User user = userList.get(i);
                            userL.setValueAt(user.getAccount(),i,0);
                            userL.setValueAt(user.getNackname(),i,1);
                            userL.setValueAt(Sex,i,2);
                            userL.setValueAt(user.getEmail(),i,3);
                        }
                        if (userList.size() == 0) {
                            JOptionPane.showMessageDialog(null,"已经到最后一页啦！");
                        }
                    }
                }
        );
        // 添加新报刊
        addNewsButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!(newspaperController.isAdmin())) {
                            JOptionPane.showMessageDialog(null,"只有管理员才添加报刊！");
                            return;
                        }
                        // 获取新报刊名
                        String addNewspaperName = addNewsNameField.getText();
                        // 获取新报刊类型
                        String addNewspaperType = addNewsTypeFiled.getText();
                        // 获取新报刊简介
                        String addNewspaperBrief = addNewsBriefField.getText();
                        // 获取新报刊出版社
                        String addNewspaperPublisher = addNewsPublisherField.getText();
                        // 表单预验证
                        if (addNewspaperName.trim().length() == 0
                                || addNewspaperType.trim().length() == 0
                                || addNewspaperBrief.trim().length() == 0
                                || addNewspaperPublisher.trim().length() == 0
                                || addNewsPriceField.getText().trim().length() == 0
                        ) {
                            JOptionPane.showMessageDialog(null, "请完善报刊信息！");
                            return;
                        }
                        else if(addNewspaperName.length() < 1 || addNewspaperName.length() > 32) {
                            JOptionPane.showMessageDialog(null, "报刊名称长度限制1-32个字符");
                            return;
                        }
                        // 获取新报刊价格(先将价格从字符串转换成BIgDecimal类型)
                        BigDecimal bd = new BigDecimal(addNewsPriceField.getText());
                        bd = bd.setScale(3, BigDecimal.ROUND_HALF_UP);
                        if ((isNumeric(addNewsPriceField.getText())) || Integer.valueOf(addNewsPriceField.getText()) < 0) {
                            JOptionPane.showMessageDialog(null,"价格必须是大于0的数字");
                            return;
                        }
                        // 将获取的新报刊数据存入即将提交给接口进行修改的对象中
                        Newspaper addNewspaper = new Newspaper(0L,addNewspaperName, "2022-10-16 00:01:01",null,addNewspaperType,addNewspaperBrief,addNewspaperPublisher,"2022-10-16 00:00:00",bd,null,null,"好书",new Date(),new Date(),0);
                        BaseResponse<String> addNewsBaseResponse = newspaperController.add(addNewspaper);
                        JOptionPane.showMessageDialog(null, "添加新报刊成功");
                        addNewsNameField.setText("");
                        addNewsTypeFiled.setText("");
                        addNewsBriefField.setText("");
                        addNewsPublisherField.setText("");
                        addNewsPriceField.setText("");
                    }
                }
        );
    }
}
