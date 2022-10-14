package com.zkxg.newspaper_subscription.dao.impl;

import com.zkxg.newspaper_subscription.dao.BaseDao;
import com.zkxg.newspaper_subscription.dao.NewspaperDao;
import com.zkxg.newspaper_subscription.model.entity.Newspaper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xiaohu
 * @date 2022/10/11/ 11:01
 * @description
 */
public class NewspaperDaoImpl implements NewspaperDao {

    @Override
    public List<Newspaper> getNewspaperPage(Connection conn, int pageNum, int pageSize) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Newspaper> newspaperList = new ArrayList<>();
        if (null != conn){
            // 在mysql数据库中，分页使用 limit startIndex，pageSize ; 总数
            String sql = "select * from t_newspaper where is_deleted = 0 limit ?,?";

            Object[] params = new Object[]{
                    pageNum,
                    pageSize
            };
            //查询
            rs = BaseDao.execute(conn,pstm,rs,sql,params);
            // 信息要脱敏，密码就不能暴露出去了
            while (rs.next()){
                Newspaper _newspaper = new Newspaper();
                _newspaper.setId(rs.getLong("id"));
                _newspaper.setName(rs.getString("name"));
                _newspaper.setNewspaperNumber(rs.getString("newspaper_number"));
                _newspaper.setCover(rs.getString("cover"));
                _newspaper.setType(rs.getString("type"));
                _newspaper.setBrief(rs.getString("brief"));
                _newspaper.setPublisher(rs.getString("publisher"));
                _newspaper.setPublishTime(rs.getString("publish_time"));
                _newspaper.setPrice(rs.getBigDecimal("price"));
                _newspaper.setRemark(rs.getString("remark"));
                newspaperList.add(_newspaper);
            }
            //关闭资源
            BaseDao.closeResource(null,pstm,rs);
            System.out.println("dao方法获取用户表单成功");
        }
        return newspaperList;
    }

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
    public int delete(Connection conn, Long id) throws SQLException {
        PreparedStatement pstm = null;
        int updateRows = 0;
        if (conn != null) {
            //
            String sql = "update t_newspaper set is_deleted=1 where id=?";
            Object params[] = new Object[]{
                    id
            };
            //执行sql语句
            updateRows = BaseDao.execute(conn, pstm, sql, params);
            //关闭资源
            BaseDao.closeResource(null, pstm, null);
            System.out.println("newspaperDao 删除报刊信息成功");
        }
        return updateRows;
    }

    @Override
    public int update(Connection conn, Newspaper newspaper) throws SQLException {
        PreparedStatement pstm = null;
        int updateRows = 0;
        if (conn != null) {
            // 10个修改字段
            String sql = "update t_newspaper set name=?,newspaper_number=?," +
                    "cover=?,type=?,brief=?,publisher=?,publish_time=?,price=?," +
                    "remark=?,update_time=? where id=? and is_deleted=0";
            // 设置系统自动更新的值
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
                    newspaper.getUpdateTime(),
                    newspaper.getId()
            };
            //执行sql语句
            updateRows = BaseDao.execute(conn, pstm, sql, params);
            //关闭资源
            BaseDao.closeResource(null, pstm, null);
            System.out.println("NewspaperDao 修改报刊信息成功");
        }
        return updateRows;
    }

    @Override
    public Newspaper getUserById(Connection conn, Long id) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Newspaper newspaper = null;
        if (conn != null){
            String sql = "select * from t_newspaper where id = ? and is_deleted=0";
            Object[] params = new Object[]{id};
            rs = BaseDao.execute(conn,pstm,rs,sql,params);
            // 返回的信息一定要脱敏
            while(rs.next()){
                newspaper = new Newspaper();
                newspaper.setId(rs.getLong("id"));
                newspaper.setName(rs.getString("name"));
                newspaper.setNewspaperNumber(rs.getString("newspaper_number"));
                newspaper.setCover(rs.getString("cover"));
                newspaper.setType(rs.getString("type"));
                newspaper.setBrief(rs.getString("brief"));
                newspaper.setPublisher(rs.getString("publisher"));
                newspaper.setPublishTime(rs.getString("publish_time"));
                newspaper.setPrice(rs.getBigDecimal("price"));
                newspaper.setRemark(rs.getString("remark"));
            }
            System.out.println("newspaper 通过id获取报刊信息成功");
        }
        BaseDao.closeResource(null,pstm,rs);
        return newspaper;
    }

    @Override
    public List<Newspaper> getNewspaperByName(Connection conn, String name) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Newspaper> newspaperList = new ArrayList<>();
        if (null != conn){
            // 在mysql数据库中，分页使用 limit startIndex，pageSize ; 总数
            String sql = "select * from t_newspaper where name like ? and is_deleted = 0";
            name = "%" + name + "%";
            Object[] params = new Object[]{
                    name
            };
            System.out.println("getNewspaperByName()----->"+sql);
            //查询
            rs = BaseDao.execute(conn,pstm,rs,sql,params);
            //
            while (rs.next()){
                Newspaper _newspaper = new Newspaper();
                _newspaper.setId(rs.getLong("id"));
                _newspaper.setName(rs.getString("name"));
                _newspaper.setNewspaperNumber(rs.getString("newspaper_number"));
                _newspaper.setCover(rs.getString("cover"));
                _newspaper.setType(rs.getString("type"));
                _newspaper.setBrief(rs.getString("brief"));
                _newspaper.setPublisher(rs.getString("publisher"));
                _newspaper.setPublishTime(rs.getString("publish_time"));
                _newspaper.setPrice(rs.getBigDecimal("price"));
                _newspaper.setRemark(rs.getString("remark"));
                newspaperList.add(_newspaper);
            }
            //关闭资源
            BaseDao.closeResource(null,pstm,rs);
            System.out.println("newspaperDao 名称模糊查询报刊信息成功");
        }
        return newspaperList;
    }

    @Override
    public List<Newspaper> getNewspaperByType(Connection conn, String type) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Newspaper> newspaperList = new ArrayList<>();
        if (null != conn){
            // 在mysql数据库中，分页使用 limit startIndex，pageSize ; 总数
            String sql = "select * from t_newspaper where type = ? and is_deleted = 0";
            Object[] params = new Object[]{
                    type
            };
            System.out.println("getNewspaperByType()----->"+sql);
            //查询
            rs = BaseDao.execute(conn,pstm,rs,sql,params);
            //
            while (rs.next()){
                Newspaper _newspaper = new Newspaper();
                _newspaper.setId(rs.getLong("id"));
                _newspaper.setName(rs.getString("name"));
                _newspaper.setNewspaperNumber(rs.getString("newspaper_number"));
                _newspaper.setCover(rs.getString("cover"));
                _newspaper.setType(rs.getString("type"));
                _newspaper.setBrief(rs.getString("brief"));
                _newspaper.setPublisher(rs.getString("publisher"));
                _newspaper.setPublishTime(rs.getString("publish_time"));
                _newspaper.setPrice(rs.getBigDecimal("price"));
                _newspaper.setRemark(rs.getString("remark"));
                newspaperList.add(_newspaper);
            }
            //关闭资源
            BaseDao.closeResource(null,pstm,rs);
            System.out.println("newspaperDao 名称模糊查询报刊信息成功");
        }
        return newspaperList;
    }
}
