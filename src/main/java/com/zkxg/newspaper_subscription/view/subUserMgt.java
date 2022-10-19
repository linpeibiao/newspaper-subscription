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

import static com.zkxg.newspaper_subscription.view.subMgt.newspaperId;


/*
 * @author unknown
 * 管理员登陆成功主界面
 */
public class subUserMgt extends JFrame {
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
    public static User currentUser2;
    // 判断对话框的关闭
    public static int modTarget = 0;
    // 报刊订阅数量
    public static Integer newsSubCount;
    // 判断是否为分类查询
    private static int chargeQueryType = 0;
    public subUserMgt() {
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
        queryNewsList = new JComboBox();
        queryNewsField = new JTextField();
        queryNewsButton = new JButton();
        panel6 = new JPanel();
        queryField = new JTextField();
        queryButton = new JButton();
        scrollPane1 = new JScrollPane();
        queryTable = new JTable();
        deleteOrderButton = new JButton();
        changUser2 = new JLabel();
        panel4 = new JPanel();
        currentOrderButton = new JButton();
        scrollPane3 = new JScrollPane();
        queryTable2 = new JTable();
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
            panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.
            border.EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border.TitledBorder.CENTER
            ,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font
            .BOLD,12),java.awt.Color.red),panel1. getBorder()));panel1. addPropertyChangeListener(
            new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r"
            .equals(e.getPropertyName()))throw new RuntimeException();}});
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("\u6b22\u8fce\u4f7f\u7528\u62a5\u520a\u8ba2\u9605\u7cfb\u7edf-user");
            label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 30));
            label1.setForeground(new Color(0xf2f2f2));
            panel1.add(label1);
            label1.setBounds(80, 15, 375, label1.getPreferredSize().height);

            //======== tabbedPane1 ========
            {
                tabbedPane1.setFont(new Font("\u5fae\u8edf\u6b63\u9ed1\u9ad4", Font.BOLD, 20));

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
                    newsNextPageButton.setFont(new Font("\u5fae\u8edf\u6b63\u9ed1\u9ad4", Font.BOLD, 20));
                    index.add(newsNextPageButton);
                    newsNextPageButton.setBounds(795, 460, 94, 40);

                    //---- newsPrePageButton ----
                    newsPrePageButton.setText("\u4e0a\u4e00\u9875");
                    newsPrePageButton.setFont(new Font("\u5fae\u8edf\u6b63\u9ed1\u9ad4", Font.BOLD, 20));
                    index.add(newsPrePageButton);
                    newsPrePageButton.setBounds(680, 460, 94, 40);

                    //---- detailButton ----
                    detailButton.setText("\u62a5\u520a\u8ba2\u9605");
                    detailButton.setFont(new Font("\u5fae\u8edf\u6b63\u9ed1\u9ad4", Font.BOLD, 20));
                    index.add(detailButton);
                    detailButton.setBounds(775, 25, detailButton.getPreferredSize().width, 40);

                    //---- queryNewsList ----
                    queryNewsList.setFont(new Font("\u5fae\u8edf\u6b63\u9ed1\u9ad4", Font.PLAIN, 16));
                    index.add(queryNewsList);
                    queryNewsList.setBounds(10, 25, 165, 40);

                    //---- queryNewsField ----
                    queryNewsField.setFont(new Font("\u5fae\u8edf\u6b63\u9ed1\u9ad4", Font.BOLD, 20));
                    index.add(queryNewsField);
                    queryNewsField.setBounds(200, 25, 200, 40);

                    //---- queryNewsButton ----
                    queryNewsButton.setText("\u67e5\u8be2");
                    queryNewsButton.setFont(new Font("\u5fae\u8edf\u6b63\u9ed1\u9ad4", Font.BOLD, 20));
                    index.add(queryNewsButton);
                    queryNewsButton.setBounds(415, 25, 78, 40);

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

                //======== panel6 ========
                {
                    panel6.setLayout(null);

                    //---- queryField ----
                    queryField.setFont(new Font("\u5fae\u8edf\u6b63\u9ed1\u9ad4", Font.BOLD, 20));
                    panel6.add(queryField);
                    queryField.setBounds(165, 20, 200, 40);

                    //---- queryButton ----
                    queryButton.setText("\u67e5\u8be2");
                    queryButton.setFont(new Font("\u5fae\u8edf\u6b63\u9ed1\u9ad4", Font.BOLD, 20));
                    panel6.add(queryButton);
                    queryButton.setBounds(380, 20, queryButton.getPreferredSize().width, 40);

                    //======== scrollPane1 ========
                    {

                        //---- queryTable ----
                        queryTable.setFont(new Font("\u5fae\u8edf\u6b63\u9ed1\u9ad4", Font.BOLD, 20));
                        scrollPane1.setViewportView(queryTable);
                    }
                    panel6.add(scrollPane1);
                    scrollPane1.setBounds(15, 80, 885, 430);

                    //---- deleteOrderButton ----
                    deleteOrderButton.setText("\u5220\u9664\u8ba2\u5355");
                    deleteOrderButton.setFont(new Font("\u5fae\u8edf\u6b63\u9ed1\u9ad4", Font.BOLD, 20));
                    panel6.add(deleteOrderButton);
                    deleteOrderButton.setBounds(785, 25, deleteOrderButton.getPreferredSize().width, 40);

                    //---- changUser2 ----
                    changUser2.setText("\u8f93\u5165\u8ba2\u5355\u7f16\u53f7\uff1a");
                    changUser2.setFont(new Font("\u5fae\u8edf\u6b63\u9ed1\u9ad4", Font.BOLD, 20));
                    panel6.add(changUser2);
                    changUser2.setBounds(20, 25, 140, 27);

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
                tabbedPane1.addTab("\u8ba2\u5355\u7ba1\u7406", panel6);

                //======== panel4 ========
                {
                    panel4.setLayout(null);

                    //---- currentOrderButton ----
                    currentOrderButton.setText("\u83b7\u53d6\u7528\u6237\u8ba2\u9605\u4fe1\u606f");
                    currentOrderButton.setFont(new Font("\u5fae\u8edf\u6b63\u9ed1\u9ad4", Font.BOLD, 20));
                    panel4.add(currentOrderButton);
                    currentOrderButton.setBounds(25, 20, currentOrderButton.getPreferredSize().width, 40);

                    //======== scrollPane3 ========
                    {

                        //---- queryTable2 ----
                        queryTable2.setFont(new Font("\u5fae\u8edf\u6b63\u9ed1\u9ad4", Font.BOLD, 20));
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
                tabbedPane1.addTab("\u6211\u7684\u8ba2\u9605", panel4);

                //======== panel3 ========
                {
                    panel3.setLayout(null);

                    //---- changUser ----
                    changUser.setText("\u7528\u6237\u540d");
                    changUser.setFont(new Font("\u5fae\u8edf\u6b63\u9ed1\u9ad4", Font.BOLD, 20));
                    panel3.add(changUser);
                    changUser.setBounds(new Rectangle(new Point(170, 110), changUser.getPreferredSize()));

                    //---- changeSex ----
                    changeSex.setText("\u6027\u522b");
                    changeSex.setFont(new Font("\u5fae\u8edf\u6b63\u9ed1\u9ad4", Font.BOLD, 20));
                    panel3.add(changeSex);
                    changeSex.setBounds(175, 175, 60, 27);

                    //---- changeEmail ----
                    changeEmail.setText("\u90ae\u7bb1");
                    changeEmail.setFont(new Font("\u5fae\u8edf\u6b63\u9ed1\u9ad4", Font.BOLD, 20));
                    panel3.add(changeEmail);
                    changeEmail.setBounds(175, 245, 60, 27);

                    //---- changePhone ----
                    changePhone.setText("\u7535\u8bdd");
                    changePhone.setFont(new Font("\u5fae\u8edf\u6b63\u9ed1\u9ad4", Font.BOLD, 20));
                    panel3.add(changePhone);
                    changePhone.setBounds(175, 305, 60, 27);

                    //---- changeUserField ----
                    changeUserField.setFont(new Font("\u5fae\u8edf\u6b63\u9ed1\u9ad4", Font.BOLD, 20));
                    panel3.add(changeUserField);
                    changeUserField.setBounds(260, 110, 255, 35);

                    //---- changEmailField ----
                    changEmailField.setFont(new Font("\u5fae\u8edf\u6b63\u9ed1\u9ad4", Font.BOLD, 20));
                    panel3.add(changEmailField);
                    changEmailField.setBounds(260, 245, 255, 35);

                    //---- changePhoneField ----
                    changePhoneField.setFont(new Font("\u5fae\u8edf\u6b63\u9ed1\u9ad4", Font.BOLD, 20));
                    panel3.add(changePhoneField);
                    changePhoneField.setBounds(260, 305, 255, 35);

                    //---- changeButton ----
                    changeButton.setText("\u786e\u8ba4\u4fee\u6539");
                    changeButton.setFont(new Font("\u5fae\u8edf\u6b63\u9ed1\u9ad4", Font.BOLD, 20));
                    panel3.add(changeButton);
                    changeButton.setBounds(175, 390, 335, 45);

                    //---- changeSexList ----
                    changeSexList.setFont(new Font("\u5fae\u8edf\u6b63\u9ed1\u9ad4", Font.BOLD, 20));
                    panel3.add(changeSexList);
                    changeSexList.setBounds(260, 175, 255, 40);

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
            }
            panel1.add(tabbedPane1);
            tabbedPane1.setBounds(10, 70, 925, 565);

            //---- logoutButton ----
            logoutButton.setText("\u9000\u51fa\u767b\u5f55");
            logoutButton.setFont(new Font("\u5fae\u8edf\u6b63\u9ed1\u9ad4", Font.BOLD, 20));
            panel1.add(logoutButton);
            logoutButton.setBounds(new Rectangle(new Point(795, 15), logoutButton.getPreferredSize()));

            //---- chargeUserLabel ----
            chargeUserLabel.setText("\u5f53\u524d\u7528\u6237\u8eab\u4efd\uff1a\u7ba1\u7406\u5458");
            chargeUserLabel.setFont(new Font("\u5fae\u8edf\u6b63\u9ed1\u9ad4", Font.BOLD, 20));
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
    private JComboBox queryNewsList;
    private JTextField queryNewsField;
    private JButton queryNewsButton;
    private JPanel panel6;
    private JTextField queryField;
    private JButton queryButton;
    private JScrollPane scrollPane1;
    private JTable queryTable;
    private JButton deleteOrderButton;
    private JLabel changUser2;
    private JPanel panel4;
    private JButton currentOrderButton;
    private JScrollPane scrollPane3;
    private JTable queryTable2;
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
    private JButton logoutButton;
    private JLabel chargeUserLabel;
    private JLabel iconLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    // 初始化用户信息
    public void initUserInfo() {
        // 请求接口获取当前登录用户的信息
        BaseResponse<User> userBaseResponse = userController.getCurrentLoginUser();
        User user = userBaseResponse.getData();
        currentUser2 = user;
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
        label1.setText("欢迎您—"+ user.getNackname());
    }
    // 初始化查询界面
    public void initQueryView() {
        queryNewsList.addItem("按报刊名称查询");
        queryNewsList.addItem("按报刊类型查询");
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
                                                     if (currentUser2.getId() == null) {
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
                                                     BaseResponse<List<Order>> orderBaseResponse = orderController.getOrderByUserId(Long.valueOf(currentUser2.getId()));
                                                     List<Order> order = orderBaseResponse.getData();
                                                     // 设置行与列
                                                     queryT2.setRowCount(order.size()+1);
                                                     System.out.println(order.size()+"几份单子");
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

    }
}
