package com.zkxg.newspaper_subscription.newspaper;
import java.math.BigDecimal;

import com.zkxg.newspaper_subscription.controller.NewspaperController;
import com.zkxg.newspaper_subscription.controller.UserController;
import com.zkxg.newspaper_subscription.model.entity.Newspaper;
import com.zkxg.newspaper_subscription.model.vo.LoginInfo;
import org.junit.Test;

/**
 * @author xiaohu
 * @date 2022/10/13/ 22:13
 * @description 报刊业务接口测试类
 */
public class NewspaperTests {
    private UserController userController;
    private NewspaperController newspaperController;

    public NewspaperTests(){
        userController = new UserController();
        newspaperController = new NewspaperController();
    }

    public void userLogin(){
        // 先登录
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setAccount("xiaohugege");
        loginInfo.setPhone("");
        loginInfo.setPassword("linxiaohu");
        // 首先要登陆
        userController.userLogin(loginInfo).getData();
    }

    @Test
    public void updateNewsTest(){
        userLogin();
        Newspaper newspaper = new Newspaper();
        newspaper.setId(2L);
        newspaper.setName("花花公子");
        newspaper.setNewspaperNumber("2022-10-15");
        String data = newspaperController.updateNewspaper(newspaper).getData();
        System.out.println(data);

    }

    @Test
    public void deleteNewsTest(){
        userLogin();
        System.out.println(newspaperController.deleteNewsPaper(2L));
    }

    @Test
    public void addNewsTest(){
//        this.userLogin();
        // 先登录
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setAccount("xiaohugege");
        loginInfo.setPhone("");
        loginInfo.setPassword("linxiaohu");
        // 首先要登陆
        userController.userLogin(loginInfo).getData();
        Newspaper newspaper = new Newspaper();
        newspaper.setName("playboy");
        newspaper.setNewspaperNumber("2022-10-15");
        newspaper.setCover("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fnimg.ws.126.net%2F%3Furl%3Dhttp%253A%252F%252Fdingyue.ws.126.net%252F2022%252F0917%252F64851b3aj00ricdjz0038c000hf00m8c.jpg%26thumbnail%3D660x2147483647%26quality%3D80%26type%3Djpg&refer=http%3A%2F%2Fnimg.ws.126.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1668262720&t=cb76759415a2c95399ba5c3e9b823d3b");
        newspaper.setType("色情");
        newspaper.setBrief("playboy,你懂的");
        newspaper.setPublisher("华夏出版社");
        newspaper.setPublishTime("2022-10-10");
        newspaper.setPrice(new BigDecimal("120"));
        newspaper.setRemark("非常好看的杂志");
        final String data = newspaperController.add(newspaper).getData();
        System.out.println(data);

    }
}
