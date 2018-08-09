package com.ish.board;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ish.board.dao.BDao;
import com.ish.board.dto.BDto;

/**
 * Servlet implementation class BoardFrontController
 */

@Controller
public class BController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "list";
	}

	@RequestMapping("/list")
	public String list(Model model) {
		BDao dao = sqlSession.getMapper(BDao.class);
		ArrayList<BDto> dtos = dao.list();
		model.addAttribute("list", dtos);
		//
		return "list";
	}

	@RequestMapping("/write_view")
	public String write_view(Model model) {

		return "write_view";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {

		model.addAttribute("request", request);
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		BDao dao = sqlSession.getMapper(BDao.class);
		dao.write(bName, bTitle, bContent);
		return "redirect:list";
	}

	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		String bId = request.getParameter("bId");
		BDao dao = sqlSession.getMapper(BDao.class);
		BDto dto = dao.contentView(bId);
		dao.upHit(bId);
		model.addAttribute("content_view", dto);

		return "content_view";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(HttpServletRequest request, Model model) {

		model.addAttribute("request", request);

		String bId = request.getParameter("bId");
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");

		BDao dao = sqlSession.getMapper(BDao.class);
		dao.modify(bId, bName, bTitle, bContent);
		return "redirect:list";
	}

	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {

		String bId = request.getParameter("bId");

		BDao dao = sqlSession.getMapper(BDao.class);
		BDto dto = dao.contentView(bId);

		model.addAttribute("reply_view", dto);

		return "reply_view";

	}

	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {

		model.addAttribute("request", request);
	
		String bId = request.getParameter("bId");
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String bGroup = request.getParameter("bGroup");
		String bStep = request.getParameter("bStep");
		String bIndent = request.getParameter("bIndent");

		BDao dao = sqlSession.getMapper(BDao.class);
		dao.reply(bId, bName, bTitle, bContent, bGroup, bStep, bIndent);
		return "redirect:list";
	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);

		String bId = request.getParameter("bId");
		BDao dao = sqlSession.getMapper(BDao.class);
		dao.delete(bId);

		return "redirect:list";
	}

}
