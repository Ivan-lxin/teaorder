package com.caowei.service;

import com.caowei.domain.TeaOrder;
import com.caowei.mapper.TeaOrderMapper;
import com.caowei.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class TeaOrderService {

    private TeaOrderMapper teaOrderMapper;
    private SqlSession sqlSession;

    private void init(){
        sqlSession = SqlSessionUtil.getSqlSession();
        teaOrderMapper = sqlSession.getMapper(TeaOrderMapper.class);
    }

    public  int addOrder(TeaOrder teaOrder){
        init();
        int rows = teaOrderMapper.addOrder(teaOrder);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        return rows;
    }
}
