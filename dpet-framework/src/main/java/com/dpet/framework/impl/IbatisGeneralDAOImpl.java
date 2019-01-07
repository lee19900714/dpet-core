package com.dpet.framework.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Repository;

import com.dpet.commons.utils.ActionUtil;
import com.dpet.framework.BusinessException;
import com.dpet.framework.GeneralDAO;
import com.dpet.framework.MsgService;


  
@Repository("GeneralDAO")   
public class IbatisGeneralDAOImpl implements GeneralDAO {

	private static Logger _logger = LoggerFactory.getLogger(IbatisGeneralDAOImpl.class);

	private SqlSessionTemplate sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSessionTemplate sqlMapClient) {
		this.sqlSession = sqlMapClient;
		_logger.debug("Mybatis数据库连接对象注入GeneralDAO完成");
	}

	public <T> T queryObject(String sqlId, Object param) {
		try {
			return sqlSession.selectOne(sqlId, param);
		} catch (Exception e) {
			throw handException(e);
		}
	}

	public <T> List<T> queryForList(String sqlId, Object param) {
		List<T> list = null;
		if (ActionUtil.isPage() && !ActionUtil.isInside()) {
			List<T> list2 = null;
			//分页
			int pageNo = ActionUtil.getPageNo();
			int pageSize = ActionUtil.getPageSize();
			if(param != null){
				list = sqlSession.selectList(sqlId, param, new RowBounds((pageNo - 1) * pageSize, pageSize));
				list2 = sqlSession.selectList(sqlId, param);
			}else{
				list = sqlSession.selectList(sqlId, new RowBounds((pageNo - 1) * pageSize, pageSize));
				list2 = sqlSession.selectList(sqlId);
			}
			Integer total = list2.size();
			Integer pageNum = (total%pageSize == 0)?(total/pageSize):(total/pageSize+1);
			ActionUtil.setTotal(total);
			ActionUtil.setPageNum(pageNum);
		}else{
			//不分页
			if(param != null){
				list = sqlSession.selectList(sqlId, param);
			}else{
				list = sqlSession.selectList(sqlId);
			}
		}
		return list;
	}

	public <T> List<T> queryForList(String sqlId) {
		return queryForList(sqlId, null);
	}


	public <T> T queryObject(String sqlId) {
		try {
			sqlId = sqlSelector(sqlId);
			return sqlSession.selectOne(sqlId);
		} catch (Exception e) {
			throw handException(e);
		}
	}

	
	public void insertObject(String sqlId) {
		try {
			sqlId = sqlSelector(sqlId);
			sqlSession.insert(sqlId);
		} catch (BadSqlGrammarException e) {
			throw handException(e);
		}
	}

	
	public void insertObject(String sqlId, Object param) {
		try {	
			sqlId = sqlSelector(sqlId);
			sqlSession.insert(sqlId, param);
		} catch (Exception e) {
			throw handException(e);
		}
	}

	
	public Integer insertObjectReturnID(String sqlId, Object param) {
		try {
			sqlId = sqlSelector(sqlId);
			sqlSession.insert(sqlId, param);
			return sqlSession.selectOne("systemMap.getAutoIncrementID");
		} catch (Exception e) {
			throw handException(e);
		}
	}
	
	public int deleteObject(String sqlId) {
		try {
			sqlId = sqlSelector(sqlId);
			return sqlSession.delete(sqlId);
		} catch (BadSqlGrammarException e) {
			throw handException(e);
		}
	}

	
	public int deleteObject(String sqlId, Object param) {
		try {
			sqlId = sqlSelector(sqlId);
			return sqlSession.delete(sqlId, param);
		} catch (Exception e) {
			throw handException(e);
		}
	}

	
	public int updateObject(String sqlId) {
		try {
			sqlId = sqlSelector(sqlId);
			return sqlSession.update(sqlId);
		} catch (BadSqlGrammarException e) {
			throw handException(e);
		}
	}

	
	public int updateObject(String sqlId, Object param) {
		try {
			sqlId = sqlSelector(sqlId);
			return sqlSession.update(sqlId, param);
		} catch (Exception e) {
			throw handException(e);
		}
	}


	private BusinessException handException(Exception e) {
		if (e.getClass().toString().contains("DuplicateKeyException"))
		{
			String cause = e.getCause().toString();
			int index = cause.lastIndexOf("for key '");
			String indexName = cause.substring(index+9, cause.length()-1);
			return new BusinessException(MsgService.getMsg("DB_"+indexName));
		}
		if (e.getClass().toString().contains("BadSqlGrammarException"))
			{
				_logger.error(((BadSqlGrammarException)e).getSQLException().getErrorCode()+"");
				_logger.error(((BadSqlGrammarException)e).getSQLException().getMessage());
			}
		_logger.error(e.getMessage());
		e.printStackTrace();
		return new BusinessException("数据异常，请刷新后重试...");
	}
	

	private String sqlSelector(String sqlId) {
		return sqlId;
	}

	public <T> void batchInsert(String sqlId, List<T> param) {

		
	}

	public <T> void batchDelete(String sqlId, List<T> param) {
		// TODO Auto-generated method stub
		
	}

	public <T> void batchUpdate(String sqlId, List<T> param) {
		// TODO Auto-generated method stub
		
	}

	public void executeSql(String sql, Object... params) {
		// TODO Auto-generated method stub
		
	}

	public List<Map<String, Object>> executeQuery(String sql, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object executeObject(String sql, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}
}