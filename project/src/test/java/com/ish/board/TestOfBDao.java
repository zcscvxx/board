package com.ish.board;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ish.board.dao.BDao;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
public class TestOfBDao {
	@Inject
	private SqlSession sqlSession;
	private BDao dao;
	
	@Before
	public void setup() {
		dao = sqlSession.getMapper(BDao.class);
	}
	
	@Test
	public void test() {
		int rows = dao.getRowNum();
		System.out.println(rows);
		int max = dao.getRowNum();
		System.out.println(max);
	}
}