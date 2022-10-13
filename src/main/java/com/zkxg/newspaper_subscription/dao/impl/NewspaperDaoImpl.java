package com.zkxg.newspaper_subscription.dao.impl;

import com.zkxg.newspaper_subscription.dao.BaseDao;
import com.zkxg.newspaper_subscription.dao.NewspaperDao;
import com.zkxg.newspaper_subscription.model.entity.Newspaper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author xiaohu
 * @date 2022/10/11/ 11:01
 * @description
 */
public class NewspaperDaoImpl implements NewspaperDao {
    @Override
    public int add(Connection conn, Newspaper newspaper) throws SQLException {
        PreparedStatement pstm = null;
        int updateRows = 0;
        if (conn != null) {
            // 11个字段，id自增不用插入
            String sql = "insert into t_newspaper (name,newspaper_number,cover," +
                    "type,brief,publisher,publish_time,price,remark," +
                    "is_deleted,create_time,update_time) " +
                    "values(?,?,?,?,?,?,?,?,?,?,?,?)";
            // 设置系统插入的值
            newspaper.setDeleted(0);// 0 未删除
            newspaper.setCreateTime(new Date());
            newspaper.setUpdateTime(new Date());
            Object params[] = new Object[]{
                    newspaper.getName(),
                    newspaper.getNewspaperNumber(),
                    newspaper.getCover(),
                    newspaper.getType(),
                    newspaper.getBrief(),
                    newspaper.getPublisher(),
                    newspaper.getPublishTime(),
                    newspaper.getPrice(),
                    newspaper.getRemark(),
                    newspaper.getDeleted(),
                    newspaper.getCreateTime(),
                    newspaper.getUpdateTime()
            };
            //执行sql语句
            updateRows = BaseDao.execute(conn, pstm, sql, params);
            //关闭资源
            BaseDao.closeResource(null, pstm, null);
            System.out.println("newspaperDao 添加报刊信息成功");
        }
        return updateRows;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public int update(Long id) {
        return 0;
    }

    @Override
    public Newspaper getNewspaper(Long id) {
        return null;
    }
}
