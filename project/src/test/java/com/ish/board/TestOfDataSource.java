package com.ish.board;

import static org.junit.Assert.*;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
public class TestOfDataSource {
	@Inject
	private DataSource ds;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		// 신형 try문
		// 반드시 닫아줘야하는 자원을 try 괄호속에 넣어주어
		// 굳이 닫는작업을 코딩하지 않아도 된다.
		try(Connection conn = ds.getConnection()){
			System.out.println(conn);
			assertTrue(conn!=null);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
