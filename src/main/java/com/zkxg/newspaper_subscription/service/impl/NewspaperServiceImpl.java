package com.zkxg.newspaper_subscription.service.impl;

import com.zkxg.newspaper_subscription.common.ErrorCode;
import com.zkxg.newspaper_subscription.dao.BaseDao;
import com.zkxg.newspaper_subscription.dao.NewspaperDao;
import com.zkxg.newspaper_subscription.dao.impl.NewspaperDaoImpl;
import com.zkxg.newspaper_subscription.exception.BusinessException;
import com.zkxg.newspaper_subscription.model.entity.Newspaper;
import com.zkxg.newspaper_subscription.service.NewspaperService;
import org.apache.commons.lang3.StringUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author xiaohu
 * @date 2022/10/13/ 21:27
 * @description 报刊业务逻辑接口实现类
 */
public class NewspaperServiceImpl implements NewspaperService {
    // 引入dao层
    private NewspaperDao newspaperDao;
    public NewspaperServiceImpl(){
        newspaperDao = new NewspaperDaoImpl();
    }

    @Override
    public Newspaper getUserById(Long id) {
        if (id == null || id <= 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Connection conn = null;
        Newspaper newspaper = null;
        try {
            conn = BaseDao.getConnection();
            newspaper = newspaperDao.getUserById(conn, id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResource(conn, null, null);
        }
        return newspaper;
    }

    @Override
    public List<Newspaper> getNewspaperByName(String name) {
        if (name == null || name.length() <= 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Connection conn = null;
        List<Newspaper> newspaperList = null;
        try{
            conn = BaseDao.getConnection();
            newspaperList = newspaperDao.getNewspaperByName(conn, name);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(conn, null, null);
        }
        return newspaperList;
    }

    @Override
    public List<Newspaper> getNewspaperByType(String type) {

        return null;
    }

    @Override
    public List<Newspaper> getNewspaperPage(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public int update(Newspaper newspaper) {
        // 判空
        if (newspaper == null){
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }
        if (newspaper.getId() == null || newspaper.getId() <= 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String newspaperNumber = newspaper.getNewspaperNumber();
        String name = newspaper.getName();
        if (StringUtils.isAnyEmpty(newspaperNumber, name)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "有必要参数为空,请补全信息");
        }

        // 判断修改字段长度限制
        // 长度限制判断
        if (newspaperNumber.length() > 32){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "报刊号过长");
        }
        if (name.length() > 32){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "报刊名称过长");
        }

        Connection conn = null;
        int res = 0;
        try {
            conn = BaseDao.getConnection();
            conn.setAutoCommit(false);
            res = newspaperDao.update(conn, newspaper);
            // 要作为事务进行数据库操作
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            //出现异常，要对事务进行回滚
            try {
                System.out.println("rollback·····················");
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally{
            //关闭资源
            BaseDao.closeResource(conn,null,null);
        }
        return res;
    }

    @Override
    public int add(Newspaper newspaper) {
        // 判断空
        if (newspaper == null){
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }
        String newspaperNumber = newspaper.getNewspaperNumber();
        String name = newspaper.getName();
        if (StringUtils.isAnyEmpty(newspaperNumber, name)){
            throw new BusinessException(ErrorCode.NULL_ERROR, "报刊好和报刊名称不能为空");
        }
        // 长度限制
        if (newspaperNumber.length() > 32){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "报刊号过长");
        }
        if (name.length() > 32){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "报刊名称过长");
        }

        Connection conn = null;
        int res = 0;
        try{
            conn = BaseDao.getConnection();
            conn.setAutoCommit(false);
            res = newspaperDao.add(conn, newspaper);
            conn.commit();
        }catch (SQLException e){
            // 出现异常要进行回滚操作
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(conn, null, null);
        }
        return res;
    }

    @Override
    public int delete(Long id) {
        if (id == null || id <= 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Connection conn = null;
        int delete = 0;
        try{
            conn = BaseDao.getConnection();
            conn.setAutoCommit(false);
            delete = newspaperDao.delete(conn, id);
            conn.commit();
        }catch (SQLException e){
            // 出现异常，事务回滚
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(conn, null, null);
        }
        return delete;
    }
}
