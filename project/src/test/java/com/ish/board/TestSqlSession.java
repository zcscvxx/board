package com.ish.board;

import java.util.ArrayList;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ish.board.dao.BDao;
import com.ish.board.dto.BDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})

// 스프링 관련 버전을 맞춰야 한다. pom.xml 에서 

public class TestSqlSession {
	
	@Inject
	private SqlSession sqlSession;
	//private static final Logger logger = LoggerFactory.getLogger(TestBDao.class);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void 모든자료가져오기() {
		//System.out.println("안뇽");
		try {
			BDao dao = sqlSession.getMapper(BDao.class);
			//logger.info("Welcome home! TestDao is {}.", dao);
			ArrayList<BDto> list = dao.list();
			for(BDto x:list) {
				//logger.info("Welcome home! BDTO is {}.",x);
				System.out.println(x);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	


}
