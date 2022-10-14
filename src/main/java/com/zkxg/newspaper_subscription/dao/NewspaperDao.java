package com.zkxg.newspaper_subscription.dao;

import com.zkxg.newspaper_subscription.model.entity.Newspaper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author xiaohu
 * @date 2022/10/11/ 10:58
 * @description 报刊dao层接口
 */
public interface NewspaperDao {
    // 增
    int add(Connection conn, Newspaper newspaper) throws SQLException;
    // 删
    // 根据id
    int delete(Connection conn, Long id) throws SQLException;
    // 改
    // 根据id
    int update(Connection conn, Newspaper newspaper) throws SQLException;
    // 查
    // 根据id
    Newspaper getUserById(Connection conn, Long id) throws SQLException;
    // 名称模糊查询
    List<Newspaper> getNewspaperByName(Connection conn, String name) throws SQLException;

    List<Newspaper> getNewspaperByType(Connection conn, String type) throws SQLException;

    List<Newspaper> getNewspaperPage(Connection conn, int pageNum, int pageSize) throws SQLException;
}
