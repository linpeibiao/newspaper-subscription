/*
 * Created by JFormDesigner on Wed Oct 12 15:39:19 CST 2022
 */

package com.zkxg.newspaper_subscription.view;

import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

//import com.jgoodies.forms.factories.*;
import com.zkxg.newspaper_subscription.common.BaseResponse;
import com.zkxg.newspaper_subscription.controller.AdminController;
import com.zkxg.newspaper_subscription.controller.NewspaperController;
import com.zkxg.newspaper_subscription.controller.OrderController;
import com.zkxg.newspaper_subscription.controller.UserController;
import com.zkxg.newspaper_subscription.model.entity.Newspaper;
import com.zkxg.newspaper_subscription.model.entity.Order;
import com.zkxg.newspaper_subscription.model.entity.User;
import com.zkxg.newspaper_subscription.model.vo.NewspaperInfo;
import com.zkxg.newspaper_subscription.model.vo.UserInfo;
import lombok.SneakyThrows;


/*
 * @author unknown
 * 管理员登陆成功主界面
 */
public class subMgt extends JFrame {
    private UserController userController ;
    private NewspaperController newspaperController;
    private OrderController orderController;
    private AdminController adminController;
    // 控制用户列表的分页
    public static int getPage = 1;
    // 控制报刊列表的分页
    public static int getNewsPage = 1;
    // 待删除的订单的 id
    public static Long deleteOrderId;
    // 当前登录用户
    public static User currentUser;
    // 获取表格选中报刊的Id
    public static Long newspaperId;
    // 判断对话框的关闭
    public static int modTarget = 0;
    // 报刊订阅数量
    public static Integer newsSubCount;
    // 判断是否为分类查询
    private static int chargeQueryType = 0;
    public subMgt() {
        userController = new UserController();
        newspaperController = new NewspaperController();
        orderController = new OrderController();
        adminController = new AdminController();
        // 初始化界面
        initComponents();
        // 设置关闭按钮结束程序
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 窗口可见
        setVisible(true);
        // 窗口标题
        setTitle("报刊订阅管理系统");
        setResizable(false);
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
        scrollPane4 = new JScrollPane();
        newsOrderList = new JTable();
        newsNextPageButton = new JButton();
        newsPrePageButton = new JButton();
        detailButton = new JButton();
        modNewsButton = new JButton();
        queryNewsList = new JComboBox();
        queryNewsField = new JTextField();
        queryNewsButton = new JButton();
        delNewsButton = new JButton();
        subCountButton = new JButton();
        panel5 = new JPanel();
        getStatsButton = new JButton();
        MostPopularNewspaperLabel = new JLabel();
        pNewsTop10List = new JTable();
        statsLabelTOP10 = new JLabel();
        statsQueryList = new JComboBox();
        panel6 = new JPanel();
        queryField = new JTextField();
        queryButton = new JButton();
        queryList = new JComboBox();
        scrollPane1 = new JScrollPane();
        queryTable = new JTable();
        deleteOrderButton = new JButton();
        panel4 = new JPanel();
        currentOrderButton = new JButton();
        scrollPane3 = new JScrollPane();
        queryTable2 = new JTable();
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
        chargeUserLabel = new JLabel();
        iconLabel = new JLabel();

        //======== this ========
        setForeground(new Color(0x3c3f41));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0x4c5052));
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
            javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax
            . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
            .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (new java. beans.
            PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .
            equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("\u6b22\u8fce\u4f7f\u7528\u62a5\u520a\u8ba2\u9605\u7cfb\u7edf");
            label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 30));
            label1.setForeground(new Color(0xf2f2f2));
            panel1.add(label1);
            label1.setBounds(80, 15, 375, label1.getPreferredSize().height);

            //======== tabbedPane1 ========
            {
                tabbedPane1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));

                //======== index ========
                {
                    index.setLayout(null);

                    //======== scrollPane4 ========
                    {
                        scrollPane4.setViewportView(newsOrderList);
                    }
                    index.add(scrollPane4);
                    scrollPane4.setBounds(10, 115, 880, 328);

                    //---- newsNextPageButton ----
                    newsNextPageButton.setText("\u4e0b\u4e00\u9875");
                    newsNextPageButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    index.add(newsNextPageButton);
                    newsNextPageButton.setBounds(800, 460, 94, 40);

                    //---- newsPrePageButton ----
                    newsPrePageButton.setText("\u4e0a\u4e00\u9875");
                    newsPrePageButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    index.add(newsPrePageButton);
                    newsPrePageButton.setBounds(685, 460, 94, 40);

                    //---- detailButton ----
                    detailButton.setText("\u62a5\u520a\u8ba2\u9605");
                    detailButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    index.add(detailButton);
                    detailButton.setBounds(775, 25, detailButton.getPreferredSize().width, 40);

                    //---- modNewsButton ----
                    modNewsButton.setText("\u4fee\u6539");
                    modNewsButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    index.add(modNewsButton);
                    modNewsButton.setBounds(680, 25, 78, 40);
                    index.add(queryNewsList);
                    queryNewsList.setBounds(10, 25, 135, 40);

                    //---- queryNewsField ----
                    queryNewsField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    index.add(queryNewsField);
                    queryNewsField.setBounds(165, 25, 200, 40);

                    //---- queryNewsButton ----
                    queryNewsButton.setText("\u67e5\u8be2");
                    queryNewsButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    index.add(queryNewsButton);
                    queryNewsButton.setBounds(380, 25, 78, 40);

                    //---- delNewsButton ----
                    delNewsButton.setText("\u5220\u9664");
                    delNewsButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    index.add(delNewsButton);
                    delNewsButton.setBounds(580, 25, 78, 40);

                    //---- subCountButton ----
                    subCountButton.setText("\u8ba2\u9605\u6570\u91cf");
                    subCountButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    index.add(subCountButton);
                    subCountButton.setBounds(775, 70, 115, 40);

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

                    //---- getStatsButton ----
                    getStatsButton.setText("\u83b7\u53d6\u6570\u636e\u7edf\u8ba1");
                    getStatsButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    panel5.add(getStatsButton);
                    getStatsButton.setBounds(225, 25, getStatsButton.getPreferredSize().width, 40);

                    //---- MostPopularNewspaperLabel ----
                    MostPopularNewspaperLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    panel5.add(MostPopularNewspaperLabel);
                    MostPopularNewspaperLabel.setBounds(20, 80, 335, 27);
                    panel5.add(pNewsTop10List);
                    pNewsTop10List.setBounds(20, 170, 880, 328);

                    //---- statsLabelTOP10 ----
                    statsLabelTOP10.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    panel5.add(statsLabelTOP10);
                    statsLabelTOP10.setBounds(20, 130, 335, 27);
                    panel5.add(statsQueryList);
                    statsQueryList.setBounds(20, 25, 180, 40);

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
                    queryField.setBounds(145, 25, 200, 40);

                    //---- queryButton ----
                    queryButton.setText("\u67e5\u8be2");
                    queryButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    panel6.add(queryButton);
                    queryButton.setBounds(365, 25, queryButton.getPreferredSize().width, 40);
                    panel6.add(queryList);
                    queryList.setBounds(20, 25, 110, 40);

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

                //======== panel4 ========
                {
                    panel4.setLayout(null);

                    //---- currentOrderButton ----
                    currentOrderButton.setText("\u83b7\u53d6\u5f53\u524d\u7528\u6237\u8ba2\u5355");
                    currentOrderButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    panel4.add(currentOrderButton);
                    currentOrderButton.setBounds(25, 20, 194, 40);

                    //======== scrollPane3 ========
                    {
                        scrollPane3.setViewportView(queryTable2);
                    }
                    panel4.add(scrollPane3);
                    scrollPane3.setBounds(25, 85, 860, 410);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < panel4.getComponentCount(); i++) {
                            Rectangle bounds = panel4.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = panel4.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        panel4.setMinimumSize(preferredSize);
                        panel4.setPreferredSize(preferredSize);
                    }
                }
                tabbedPane1.addTab("\u6211\u7684\u8ba2\u5355", panel4);

                //======== panel7 ========
                {
                    panel7.setLayout(null);

                    //======== scrollPane2 ========
                    {
                        scrollPane2.setViewportView(userList);
                    }
                    panel7.add(scrollPane2);
                    scrollPane2.setBounds(20, 70, 880, 375);

                    //---- queryUserButton ----
                    queryUserButton.setText("\u83b7\u53d6\u7528\u6237\u5217\u8868");
                    queryUserButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    panel7.add(queryUserButton);
                    queryUserButton.setBounds(20, 15, queryUserButton.getPreferredSize().width, 40);

                    //---- prePageButton ----
                    prePageButton.setText("\u4e0a\u4e00\u9875");
                    prePageButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    panel7.add(prePageButton);
                    prePageButton.setBounds(690, 455, prePageButton.getPreferredSize().width, 40);

                    //---- nextPageButton ----
                    nextPageButton.setText("\u4e0b\u4e00\u9875");
                    nextPageButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
                    panel7.add(nextPageButton);
                    nextPageButton.setBounds(805, 455, nextPageButton.getPreferredSize().width, 40);

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
            tabbedPane1.setBounds(10, 70, 925, 565);

            //---- logoutButton ----
            logoutButton.setText("\u9000\u51fa\u767b\u5f55");
            logoutButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            panel1.add(logoutButton);
            logoutButton.setBounds(new Rectangle(new Point(795, 15), logoutButton.getPreferredSize()));

            //---- chargeUserLabel ----
            chargeUserLabel.setText("\u5f53\u524d\u7528\u6237\u8eab\u4efd\uff1a\u7ba1\u7406\u5458");
            chargeUserLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            chargeUserLabel.setForeground(new Color(0xeeeeee));
            panel1.add(chargeUserLabel);
            chargeUserLabel.setBounds(525, 17, 255, 27);
            panel1.add(iconLabel);
            iconLabel.setBounds(15, 10, 45, 45);

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
        panel1.setBounds(0, 0, 925, 640);

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
    private JScrollPane scrollPane4;
    private JTable newsOrderList;
    private JButton newsNextPageButton;
    private JButton newsPrePageButton;
    private JButton detailButton;
    private JButton modNewsButton;
    private JComboBox queryNewsList;
    private JTextField queryNewsField;
    private JButton queryNewsButton;
    private JButton delNewsButton;
    private JButton subCountButton;
    private JPanel panel5;
    private JButton getStatsButton;
    private JLabel MostPopularNewspaperLabel;
    private JTable pNewsTop10List;
    private JLabel statsLabelTOP10;
    private JComboBox statsQueryList;
    private JPanel panel6;
    private JTextField queryField;
    private JButton queryButton;
    private JComboBox queryList;
    private JScrollPane scrollPane1;
    private JTable queryTable;
    private JButton deleteOrderButton;
    private JPanel panel4;
    private JButton currentOrderButton;
    private JScrollPane scrollPane3;
    private JTable queryTable2;
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
    private JLabel chargeUserLabel;
    private JLabel iconLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    // 初始化用户信息
    public void initUserInfo() {
        // 请求接口获取当前登录用户的信息
        BaseResponse<User> userBaseResponse = userController.getCurrentLoginUser();
        User user = userBaseResponse.getData();
        currentUser = user;
        // 将获取到的用户信息渲染到文本框上
        changeUserField.setText(user.getNackname());
        changEmailField.setText(user.getEmail());
        changePhoneField.setText(user.getPhone());
        changeSexList.addItem("男");
        changeSexList.addItem("女");
        changeSexList.setSelectedIndex(user.getGender());
        if (newspaperController.isAdmin()) {
            chargeUserLabel.setText("当前用户身份：管理员");
        }
        else {
            chargeUserLabel.setText("当前用户身份：普通用户");
        }
        getContentPane().setBackground(new Color(76, 80, 82));
        label1.setText("欢迎您，"+ user.getNackname());
    }
    // 初始化查询界面
    public void initQueryView() {
        queryList.addItem("按订单号查询");
        queryList.addItem("按用户id查询");
        queryNewsList.addItem("按报刊名称查询");
        queryNewsList.addItem("按报刊类型查询");
        statsQueryList.addItem("上线至今最受欢迎报刊TOP10");
        statsQueryList.addItem("消费金额最多用户TOP10");
        statsQueryList.addItem("下单最多用户TOP10");
        ImageIcon image = new ImageIcon("src/main/java/com/zkxg/newspaper_subscription/view/icon.png");
        image.setImage(image.getImage().getScaledInstance(45,45,Image.SCALE_DEFAULT));
        iconLabel.setIcon(image);
    }
    // 初始化订阅首页界面
    public void initIndexView() {
        newsPrePageButton.setVisible(true);
        newsNextPageButton.setVisible(true);
        // 报刊表
        getNewsPage = 1;
        DefaultTableModel newsOrderL = (DefaultTableModel) newsOrderList.getModel();
        Object[] newsRowName = {"报刊编号","报刊名称","出版社","报刊类型","报刊单价"};
        newsOrderL.setRowCount(19);
        newsOrderL.setColumnCount(newsRowName.length);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(JLabel.CENTER);
        newsOrderList.setDefaultRenderer(Object.class,tcr);
        newsOrderList.setFont(new Font("微软雅黑",Font.PLAIN,16));
        newsOrderList.setRowHeight(30);
        // 设置表头名
        for (int i =0; i< newsRowName.length; i++) {
            newsOrderL.setValueAt(newsRowName[i],0,i);
        }
        // 请求接口获取报刊信息
        BaseResponse<List<Newspaper>> newsBaseResponse = newspaperController.getNewspaperPage(getNewsPage,19);
        List<Newspaper> newsList = newsBaseResponse.getData();
        for (int i = 1; i < newsList.size(); i++) {
            Newspaper newspaper = newsList.get(i-1);
            newsOrderL.setValueAt(newspaper.getId(),i,0);
            newsOrderL.setValueAt(newspaper.getName(),i,1);
            newsOrderL.setValueAt(newspaper.getPublisher(),i,2);
            newsOrderL.setValueAt(newspaper.getType(),i,3);
            newsOrderL.setValueAt(newspaper.getPrice(),i,4);
            System.out.println(newspaper);
        }
    }
    // 监听事件
    public void listerner() {
        // 分类查询报刊
        queryNewsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("点击查询按钮！");
                if (queryNewsField.getText().trim().length() == 0) {
                    JOptionPane.showMessageDialog(null,"请输入查询内容！");
                    return;
                }
                newsPrePageButton.setVisible(false);
                newsNextPageButton.setVisible(false);
                DefaultTableModel newsOrderL = (DefaultTableModel)newsOrderList.getModel();
                // 清除所有表格
                newsOrderL.getDataVector().clear();
                newsOrderL.fireTableDataChanged();
                newsOrderList.updateUI();
                Object[] newsRowName = {"报刊编号","报刊名称","出版社","报刊类型","报刊单价"};
                newsOrderL.setRowCount(20);
                newsOrderL.setColumnCount(newsRowName.length);
                // 设置表头名
                for (int i =0; i< newsRowName.length; i++) {
                    newsOrderL.setValueAt(newsRowName[i],0,i);
                }
                if (queryNewsList.getSelectedIndex() == 0) {
                    System.out.println("按报刊名称查询!");
                    BaseResponse<List<Newspaper>> listBaseResponse = newspaperController.getNewspaperByName(queryNewsField.getText());
                    List<Newspaper> selectNewspaper1 = listBaseResponse.getData();
                    newsOrderL.setRowCount(selectNewspaper1.size() + 1);
                    if (selectNewspaper1.size() == 0) {
                        JOptionPane.showMessageDialog(null,"查无此内容!");
                        initIndexView();
                        chargeQueryType = 0;
                        return;
                    }
                    for (int i = 0; i <selectNewspaper1.size(); i++) {
                        Newspaper newspaper = selectNewspaper1.get(i);
                        newsOrderL.setValueAt(newspaper.getId(),i+1,0);
                        newsOrderL.setValueAt(newspaper.getName(),i+1,1);
                        newsOrderL.setValueAt(newspaper.getPublisher(),i+1,2);
                        newsOrderL.setValueAt(newspaper.getType(),i+1,3);
                        newsOrderL.setValueAt(newspaper.getPrice(),i+1,4);
                        System.out.println(newspaper);
                    }
                    chargeQueryType = 0;
                }
                if (queryNewsList.getSelectedIndex() == 1) {
                    System.out.println("按分类称查询！");
                    BaseResponse<List<Newspaper>> listBaseResponse = newspaperController.getNewspaperByType(queryNewsField.getText());
                    List<Newspaper> selectNewspaper2 = listBaseResponse.getData();
                    newsOrderL.setRowCount(selectNewspaper2.size() + 1);
                    System.out.println(selectNewspaper2.size());
                    if (selectNewspaper2.size() == 0) {
                        JOptionPane.showMessageDialog(null,"查无此内容!");
                        initIndexView();
                        chargeQueryType = 0;
                        return;
                    }
                    for (int i = 0; i <selectNewspaper2.size(); i++) {
                        Newspaper newspaper = selectNewspaper2.get(i);
                        newsOrderL.setValueAt(newspaper.getId(),i+1,0);
                        newsOrderL.setValueAt(newspaper.getName(),i+1,1);
                        newsOrderL.setValueAt(newspaper.getPublisher(),i+1,2);
                        newsOrderL.setValueAt(newspaper.getType(),i+1,3);
                        newsOrderL.setValueAt(newspaper.getPrice(),i+1,4);
                        System.out.println(newspaper);
                    }
                    chargeQueryType = 0;
                }
            }
        });
        // 修改报刊功能
        modNewsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("触发修改报刊功能");
                if (!newspaperController.isAdmin()) {
                    JOptionPane.showMessageDialog(null,"只有管理员才能对报刊进行修改！");
                    return;
                }
                if(newspaperId == null) {
                    JOptionPane.showMessageDialog(null,"请选择需要修改的报刊！");
                    return;
                }
                new modNewspaper();
                // 重新刷新表格
                if (modTarget == 1) {
                    initIndexView();
                    modTarget = 0;
                }
            }
        });
        // 删除报刊
        delNewsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("触发删除报刊按钮！");
                if (!(newspaperController.isAdmin())) {
                    JOptionPane.showMessageDialog(null,"只有管理员才能进行删除！");
                    return;
                }
                if (newspaperId == null) {
                    JOptionPane.showMessageDialog(null,"请选择需要删除的报刊！");
                    return;
                }
                // 请求接口删除报刊
                BaseResponse<String> stringBaseResponse = newspaperController.deleteNewsPaper(newspaperId);
                JOptionPane.showMessageDialog(null,"删除成功！");
                newspaperId = null;
                // 重新刷新页面
                initIndexView();
            }
        });
        // 获取上一页报刊
        newsPrePageButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("获取上一页报刊");
                        // 重新渲染表格
                        DefaultTableModel newsOrderL = (DefaultTableModel) newsOrderList.getModel();
                        Object[] newsRowName = {"报刊编号","报刊名称","出版社","报刊类型","报刊单价"};
                        newsOrderL.setRowCount(19);
                        newsOrderL.setColumnCount(newsRowName.length);
                        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
                        tcr.setHorizontalAlignment(JLabel.CENTER);
                        newsOrderList.setDefaultRenderer(Object.class,tcr);
                        for (int i =0; i< newsRowName.length; i++) {
                            newsOrderL.setValueAt(newsRowName[i],0,i);
                        }
                        if (getNewsPage == 1) {
                            JOptionPane.showMessageDialog(null,"当前所处位置已是第一页！");
                            return;
                        }
                        // 请求接口获取报刊信息
                        BaseResponse<List<Newspaper>> newsBaseResponse = newspaperController.getNewspaperPage(getNewsPage-=17,19);
                        List<Newspaper> newsList = newsBaseResponse.getData();
                        for (int i = 1; i < newsList.size(); i++) {
                            Newspaper newspaper = newsList.get(i-1);
                            newsOrderL.setValueAt(newspaper.getId(),i,0);
                            newsOrderL.setValueAt(newspaper.getName(),i,1);
                            newsOrderL.setValueAt(newspaper.getPublisher(),i,2);
                            newsOrderL.setValueAt(newspaper.getType(),i,3);
                            newsOrderL.setValueAt(newspaper.getPrice(),i,4);
                        }
                    }
                }
        );
        // 获取下一页报刊
        newsNextPageButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("获取下一页报刊");
                        // 重新渲染表格
                        DefaultTableModel newsOrderL = (DefaultTableModel) newsOrderList.getModel();
                        Object[] newsRowName = {"报刊编号","报刊名称","出版社","报刊类型","报刊单价"};
                        newsOrderL.setRowCount(19);
                        newsOrderL.setColumnCount(newsRowName.length);
                        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
                        tcr.setHorizontalAlignment(JLabel.CENTER);
                        newsOrderList.setDefaultRenderer(Object.class,tcr);
                        for (int i =0; i< newsRowName.length; i++) {
                            newsOrderL.setValueAt(newsRowName[i],0,i);
                        }
                        // 请求接口获取报刊信息
                        BaseResponse<List<Newspaper>> newsBaseResponse = newspaperController.getNewspaperPage(getNewsPage+=17,19);
                        List<Newspaper> newsList = newsBaseResponse.getData();
                        if (newsList.size() == 0) {
                            JOptionPane.showMessageDialog(null,"已经到最后一页啦！");
                            return;
                        }
                        for (int i = 1; i < newsList.size(); i++) {
                            Newspaper newspaper = newsList.get(i-1);
                            newsOrderL.setValueAt(newspaper.getId(),i,0);
                            newsOrderL.setValueAt(newspaper.getName(),i,1);
                            newsOrderL.setValueAt(newspaper.getPublisher(),i,2);
                            newsOrderL.setValueAt(newspaper.getType(),i,3);
                            newsOrderL.setValueAt(newspaper.getPrice(),i,4);
                        }
                    }
                }
        );
        // 查看报刊详情并订阅
        detailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("触发查看报刊详情按钮");
                if (newspaperController.isAdmin()) {
                    JOptionPane.showMessageDialog(null,"管理员无法进行报刊订阅！");
                    return;
                }
                if (newspaperId == null) {
                    JOptionPane.showMessageDialog(null,"请选择需要订阅的报刊！");
                    return;
                }
                new newsDetail();
                newspaperId = null;
            }
        });
        // 点击获取报刊Id
        newsOrderList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == e.BUTTON1) {
                    int row = newsOrderList.getSelectedRow(); // 获取选中行的报刊id
                    newspaperId = Long.valueOf(newsOrderList.getValueAt(row,0).toString());
                    System.out.println(newspaperId);
                }
            }
        });
        // 获取统计数据
        getStatsButton.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel pNewsList = (DefaultTableModel)pNewsTop10List.getModel();
                // 清除所有表格
                pNewsList.getDataVector().clear(); // 清除表格数据
                pNewsList.fireTableDataChanged(); // 通知模型更新
                pNewsTop10List.updateUI(); // 更新表格
                DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
                tcr.setHorizontalAlignment(JLabel.CENTER);
                pNewsTop10List.setDefaultRenderer(Object.class,tcr);
                pNewsTop10List.setFont(new Font("微软雅黑",Font.PLAIN,16));
                pNewsTop10List.setRowHeight(30);
                if (!(newspaperController.isAdmin())) {
                    JOptionPane.showMessageDialog(null,"该模块仅供管理员使用！");
                    return;
                }
                // 统计最受欢迎的报刊
                BaseResponse<List<String>> listBaseResponse = adminController.getMostPopularNewspaperType();
                List<String> MostPopularNewspaper = listBaseResponse.getData();
                String mostPopularNews = MostPopularNewspaper.get(0);
                MostPopularNewspaperLabel.setText("年度最受欢迎的报刊类型是："+ mostPopularNews);
                if (statsQueryList.getSelectedIndex() == 1) {
                    // 统计最土豪用户TOP10
                    statsLabelTOP10.setText("消费金额最多用户TOP10");
                    Object[] pNewsRowName = {"排名","用户id","用户账号","用户名","消费总金额"};
                    pNewsList.setRowCount(11);
                    pNewsList.setColumnCount(pNewsRowName.length);
                    for (int i = 0; i < pNewsRowName.length; i++) {
                        pNewsList.setValueAt(pNewsRowName[i],0,i);
                    }
                    BaseResponse<List<UserInfo>> listBaseResponse1 = adminController.getCostMostUser(10);
                    List<UserInfo> getCostMostUserList = listBaseResponse1.getData();
                    for (int i = 1; i < getCostMostUserList.size(); i++) {
                        UserInfo getCostMostUserListName = getCostMostUserList.get(i-1);
                        pNewsList.setValueAt(i,i,0);
                        pNewsList.setValueAt(getCostMostUserListName.getUserId(),i,1);
                        pNewsList.setValueAt(getCostMostUserListName.getAccount(),i,2);
                        pNewsList.setValueAt(getCostMostUserListName.getNackname(),i,3);
                        pNewsList.setValueAt(getCostMostUserListName.getTotalCost(),i,4);
                        System.out.println("统计最土豪用户___"+getCostMostUserListName.getNackname());
                    }
                }
               if (statsQueryList.getSelectedIndex() == 2) {
                   // 统计订单最多的用户TOP10
                   statsLabelTOP10.setText("下单最多用户TOP10");
                   Object[] pNewsRowName = {"排名","用户id","用户账号","用户名","当前用户订单总数"};
                   pNewsList.setRowCount(11);
                   pNewsList.setColumnCount(pNewsRowName.length);
                   for (int i = 0; i < pNewsRowName.length; i++) {
                       pNewsList.setValueAt(pNewsRowName[i],0,i);
                   }
                   BaseResponse<List<UserInfo>> listBaseResponse2 = adminController.getOrderMostUser(10);
                   List<UserInfo> getOrderMostUserList = listBaseResponse2.getData();
                   for (int i = 1; i < getOrderMostUserList.size(); i++) {
                       UserInfo getOrderMostUserListName = getOrderMostUserList.get(i-1);
                       pNewsList.setValueAt(i,i,0);
                       pNewsList.setValueAt(getOrderMostUserListName.getUserId(),i,1);
                       pNewsList.setValueAt(getOrderMostUserListName.getUserId(),i,2);
                       pNewsList.setValueAt(getOrderMostUserListName.getNackname(),i,3);
                       pNewsList.setValueAt(getOrderMostUserListName.getOrderQuantity(),i,4);
                   }
               }
                // 获取报刊信息按照某阶段内受欢迎程度
                if(statsQueryList.getSelectedIndex() == 0) {
                    statsLabelTOP10.setText("上线至今最受欢迎的报刊TOP10");
                    Object[] pNewsRowName = {"排名","报刊编号","报刊名称","报刊类型","出版社","订阅用户数量"};
                    pNewsList.setRowCount(11);
                    pNewsList.setColumnCount(pNewsRowName.length);
                    for (int i = 0; i < pNewsRowName.length; i++) {
                        pNewsList.setValueAt(pNewsRowName[i],0,i);
                    }
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    // 起始时间
                    Date start = formatter.parse("2022-10-15 00:00:00");
                    // 最新时间
                    Date currentTime = new Date();
                    String dateString = formatter.format(currentTime);
                    ParsePosition pos = new ParsePosition(8);
                    Date end = formatter.parse(dateString,pos);
                    BaseResponse<List<NewspaperInfo>> listBaseResponse3 = adminController.getPopularNewspaper(start,end,11);
                    List<NewspaperInfo> newspaperInfoList = listBaseResponse3.getData();
                    for (int i = 1; i < newspaperInfoList.size(); i++) {
                        NewspaperInfo newspaperInfo = newspaperInfoList.get(i-1);
                        pNewsList.setValueAt(i,i,0);
                        pNewsList.setValueAt(newspaperInfo.getNewspaperId(),i,1);
                        pNewsList.setValueAt(newspaperInfo.getNewspaperName(),i,2);
                        pNewsList.setValueAt(newspaperInfo.getType(),i,3);
                        pNewsList.setValueAt(newspaperInfo.getPublisher(),i,4);
                        pNewsList.setValueAt(newspaperInfo.getOrderQuantity(),i,5);
//                    System.out.println(newspaperInfo);
                    }
                }
            }
        });
        // 查看订阅数量
        subCountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(newspaperController.isAdmin())) {
                    JOptionPane.showMessageDialog(null,"非管理员用户无法查看！");
                    return;
                }
                if (newspaperId == null) {
                    JOptionPane.showMessageDialog(null,"请选择需要查看的报刊！");
                    return;
                }
                // 通过报刊id获取该报刊被订阅的总数量
                BaseResponse<Integer> integerBaseResponse = adminController.getCountByNewspaperId(newspaperId);
                Integer subCount = integerBaseResponse.getData();
                System.out.println("订阅数量："+ subCount);
                newspaperId = null;
                newsSubCount = subCount;
                new subCount();
            }
        });
        // 触发修改账号信息事件
        changeButton.addActionListener(new ActionListener() {
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
        logoutButton.addActionListener(new ActionListener() {
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
        queryButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // 查询表
                        DefaultTableModel queryT = (DefaultTableModel) queryTable.getModel();
                        // 设置订单列表表头名
                        Object[] orderRowName = {"订单编号","订单Id","报刊名称","用户昵称","订阅份数","订单总金额"};
                        queryT.getDataVector().clear(); // 清除表格数据
                        queryT.fireTableDataChanged(); // 通知模型更新
                        queryTable.updateUI(); // 更新表格
                        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
                        tcr.setHorizontalAlignment(JLabel.CENTER);
                        queryTable.setDefaultRenderer(Object.class,tcr);
                        queryTable.setFont(new Font("微软雅黑",Font.PLAIN,16));
                        queryTable.setRowHeight(30);
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
                            queryT.setRowCount(2);
                            queryT.setColumnCount(orderRowName.length);
                            for (int i = 0; i < orderRowName.length; i++) {
                                queryT.setValueAt(orderRowName[i],0,i);
                                queryT.setValueAt(orderList[i],1,i);
                            }
                        }
                        // 按用户id分类查
                        else if (queryList.getSelectedIndex() == 1) {
                            System.out.println("按用户id查");
                        }
                    }
                }

        );
        // 点击获取选中行的订单id
        queryTable.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getButton() == e.BUTTON1) {
                            int row = queryTable.getSelectedRow();
                            deleteOrderId = Long.valueOf(queryTable.getValueAt(row,1).toString());
                            System.out.println(deleteOrderId);
                        }
                    }
                }
        );
        // 删除选中的订单
        deleteOrderButton.addActionListener(new ActionListener() {
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
                        queryField.setText("");
                        deleteOrderId = null;
                        JOptionPane.showMessageDialog(null,"删除订单成功!");
                        // 建空表代替原表
                        DefaultTableModel queryT = (DefaultTableModel) queryTable.getModel();
                        queryT.getDataVector().clear(); // 清除表格数据
                        queryT.fireTableDataChanged(); // 通知模型更新
                        queryTable.updateUI(); // 更新表格
                    }
                }
        );
        // 获取当前用户订单
        currentOrderButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // 查询表
                        DefaultTableModel queryT2 = (DefaultTableModel) queryTable2.getModel();
                        // 设置订单列表表头名
                        Object[] orderRowName = {"订单编号","订单Id","报刊名称","用户昵称","订阅份数","订单总金额"};
                        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
                        tcr.setHorizontalAlignment(JLabel.CENTER);
                        queryTable2.setDefaultRenderer(Object.class,tcr);
                        queryTable2.setFont(new Font("微软雅黑",Font.PLAIN,16));
                        queryTable2.setRowHeight(30);
                        if (currentUser.getId() == null) {
                            JOptionPane.showMessageDialog(null,"登录后才能查看用户订单！");
                            return;
                        }
                        if(newspaperController.isAdmin()) {
                            JOptionPane.showMessageDialog(null,"该模块仅对普通用户开放！");
                            return;
                        }
                        queryT2.getDataVector().clear(); // 清除表格数据
                        queryT2.fireTableDataChanged(); // 通知模型更新
                        queryTable.updateUI(); // 更新表格
                        BaseResponse<List<Order>> orderBaseResponse = orderController.getOrderByUserId(Long.valueOf(currentUser.getId()));
                        List<Order> order = orderBaseResponse.getData();
                        // 设置行与列
                        queryT2.setRowCount(order.size()+1);
                        queryT2.setColumnCount(orderRowName.length);
                        if(order == null) {
                            JOptionPane.showMessageDialog(null, "暂无订单！");
                            queryT2.getDataVector().clear(); // 清除表格数据
                            queryT2.fireTableDataChanged(); // 通知模型更新
                            queryTable.updateUI(); // 更新表格
                            return;
                        }
                        for (int i = 0; i < orderRowName.length; i++) {
                            queryT2.setValueAt(orderRowName[i],0,i);
                        }
                        for (int i = 0; i < order.size(); i++) {
                            Order orderL = order.get(i);
                            queryT2.setValueAt(orderL.getOrderNumber(),i+1,0);
                            queryT2.setValueAt(orderL.getId(),i+1,1);
                            queryT2.setValueAt(orderL.getNewspaperName(),i+1,2);
                            queryT2.setValueAt(orderL.getUserName(),i+1,3);
                            queryT2.setValueAt(orderL.getCount(),i+1,4);
                            queryT2.setValueAt(orderL.getTotalPrice(),i+1,5);

                        }
                        System.out.println(order);
                    }
                }
        );

        // 管理员对用户列表进行查询
        queryUserButton.addActionListener(new ActionListener() {
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
                        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
                        tcr.setHorizontalAlignment(JLabel.CENTER);
                        userList.setDefaultRenderer(Object.class,tcr);
                        userList.setFont(new Font("微软雅黑",Font.PLAIN,16));
                        userList.setRowHeight(30);
                        // 请求接口获取用户列表
                        getPage = 1;
                        BaseResponse<List<User>> userListBaseResponse = userController.getUserPage(getPage,15);
                        List<User> userList = userListBaseResponse.getData();
                        System.out.println(userList);
                        for (int i = 1; i < userList.size(); i++) {
                            User user = userList.get(i-1);
                            userL.setValueAt(user.getAccount(),i,0);
                            userL.setValueAt(user.getNackname(),i,1);
                            userL.setValueAt(Sex,i,2);
                            userL.setValueAt(user.getEmail(),i,3);
                        }
                    }
                }
        );
        // 获取上一页数据
        prePageButton.addActionListener(new ActionListener() {
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
        nextPageButton.addActionListener(new ActionListener() {
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
        addNewsButton.addActionListener(new ActionListener() {
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
                        BigDecimal bd2 = new BigDecimal(0);
                        bd = bd.setScale(3, BigDecimal.ROUND_HALF_UP);
                        if (bd.compareTo(bd2) != 1) {
                            JOptionPane.showMessageDialog(null,"价格必须是大于0的数字");
                            return;
                        }
                        Date currentTime = new Date();
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String dateString = formatter.format(currentTime);
                        ParsePosition pos = new ParsePosition(8);
                        Date currentTime2 = formatter.parse(dateString, pos);
                        // 将获取的新报刊数据存入即将提交给接口进行修改的对象中
                        Newspaper addNewspaper = new Newspaper(0L,addNewspaperName, "2022-10-16",null,addNewspaperType,addNewspaperBrief,addNewspaperPublisher,"2022-10-15 00:00:00",bd,null,null,"好书",currentTime2,currentTime2,0);
                        BaseResponse<String> addNewsBaseResponse = newspaperController.add(addNewspaper);
                        JOptionPane.showMessageDialog(null, "添加新报刊成功");
                        addNewsNameField.setText("");
                        addNewsTypeFiled.setText("");
                        addNewsBriefField.setText("");
                        addNewsPublisherField.setText("");
                        addNewsPriceField.setText("");
                        initIndexView();
                    }
                }
        );
    }
}
