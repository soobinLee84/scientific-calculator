package com.celeb.site.content.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.celeb.site.board.service.BoardService;
import com.celeb.site.board.vo.BoardVo;
import com.celeb.site.common.util.PageHelper;
import com.celeb.site.common.util.RegexHelper;
import com.celeb.site.common.util.WebHelper;
import com.celeb.site.member.service.MemberService;
import com.celeb.site.member.vo.MemberVo;

@Controller
public class contentController {

	private static final Logger logger = LoggerFactory.getLogger(contentController.class);

	@Autowired
	WebHelper web;

	@Autowired
	MemberService memberService;

	@Autowired
	SqlSession sqlSession;

	@Autowired
	BoardVo board;

	@Autowired
	RegexHelper regex;

	@Autowired
	BoardService boardservice;
	
	@Autowired
	PageHelper pageHelper;

	@RequestMapping(value = "/guide.do", method = RequestMethod.GET)
	public String Guide(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		web.init();

		return "guide";
	}

	@RequestMapping(value = "/inquiries.do", method = RequestMethod.GET)
	public String Inquiries(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		web.init();

		return "Inquiries";
	}

	@RequestMapping(value = "/forsale.do", method = RequestMethod.GET)
	public String ForSale(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		web.init();

		return "forsale";
	}

	@RequestMapping(value = "/quest.do", method = RequestMethod.GET)
	public String Quest(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		web.init();

		return "quest";
	}

	@RequestMapping(value = "/customerCenter.do", method = RequestMethod.GET)
	public String customerCenter(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		web.init();
		/* 로그인 여부 검사 */
		MemberVo loginInfo = (MemberVo) web.getSession("loginInfo");
		if (loginInfo == null) {
			String movePage = web.getRootPath() + "/login.do";
			web.redirect(movePage, "로그인 후에 이용해 주세요.");
			return null;
		}

		String userId = loginInfo.getUserId();
		
		/* 뷰에서 넘어오는 파라미터 받기 */
		
		String title = web.getString("title");
		int boardIdx = web.getInt("boardIdx");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+boardIdx);

		int page = web.getInt("page", 1); // 현재 페이지
		
		logger.debug("list = " + page);
		
		model.addAttribute("page", page);
		
		int totalCount = 0; // 게시물 총 개수
		
		
		
		BoardVo board = new BoardVo();
		board.setBoardIdx(loginInfo.getUserIdx());
		board.setUserId(userId);
		board.setTitle(title);
		
		
		try {
			totalCount = boardservice.totalBoardPage(board);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}
		
		List<BoardVo> boardList = null;
	
		//pagination
		
		pageHelper.pageProcess(page, totalCount, 10, 5); // 페이징 10개씩 5그룹
		board.setLimitStart(pageHelper.getLimitStart());
		board.setListCount(pageHelper.getListCount());
	
		try {
			boardList = boardservice.getBoardList(board);
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int i = 0; i < boardList.size(); i++) {
			BoardVo temp = boardList.get(i);
			System.out.println(temp.toString());
		}
		
		
		model.addAttribute("boardList", boardList);

		model.addAttribute("pageHelper", pageHelper);
		model.addAttribute("totalCount", totalCount);

		/* 뷰 페이지에서 사용할 값 */
		/* model에서 addAttribute로 지정할 수 있다 */
		/* 없으면 request에서도 가능 */
		
		model.addAttribute("userId", userId);

		return "customerCenter";
	}

	@RequestMapping(value = "/customerWrite.do", method = RequestMethod.GET)
	public String customerWrite(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		web.init();

		/* 로그인 여부 검사 */
		MemberVo loginInfo = (MemberVo) web.getSession("loginInfo");
		if (loginInfo == null) {
			String movePage = web.getRootPath() + "/login.do";
			web.redirect(movePage, "로그인 후에 이용해 주세요.");
			return null;
		}

		return "customerWrite";
	}

	@RequestMapping(value = "/customerWriteOk.do", method = RequestMethod.POST)
	public String customerWriteOk(Locale locale, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		web.init();

		/* 로그인 여부 검사 */
		MemberVo loginInfo = (MemberVo) web.getSession("loginInfo");
		if (loginInfo == null) {
			String movePage = web.getRootPath() + "/login.do";
			web.redirect(movePage, "로그인 후에 이용해 주세요.");
			return null;
		}

		/* 뷰에서 넘어오는 파라미터 받기 */
		String board = web.getString("board");
		String title = web.getString("title");

		/* log 찍어보기 */
		logger.info("board = " + board);
		logger.info("title = " + title);

		/* 입력된 값의 유효성 검사 */

		if (!regex.isValue(board)) {
			web.redirect(null, "메모의 내용 입력하세요");
			return null;
		}
		if (!regex.isValue(title)) {
			web.redirect(null, "제목의 내용 입력하세요");
			return null;
		}

		if (board.length() > 21844) {
			web.redirect(null, "입력 할 수 있는 텍스트길이를 초과 했습니다.");
			return null;
		}

		/* 전달받은 파라미터 Beans 객체에 담는다 */
		BoardVo boardVo = new BoardVo();
		boardVo.setContent(board);
		boardVo.setTitle(title);
		boardVo.setUserId(loginInfo.getUserId());

		/* Service를 통한 데이터 베이스 저장처리 */
		try {
			boardservice.addBoard(boardVo);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			// 예외가 발생한 경우이므로, 더이상 진행하지 않는다.
			return null;
		}

		/* 저장 되었으므로 조회 페이지로 이동 */
		web.redirect(web.getRootPath() + "/customerCenter.do", "저장 완료 되었습니다.");

		return null;
	}

	@RequestMapping(value = "/detail.do", method = RequestMethod.GET)
	public String boardDetail(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		web.init();

		/* 로그인 여부 검사 */
		MemberVo loginInfo = (MemberVo) web.getSession("loginInfo");
		if (loginInfo == null) {
			String movePage = web.getRootPath() + "/login.do";
			web.redirect(movePage, "로그인 후에 이용해 주세요.");
			return null;
		}

		int boardIdx = web.getInt("boardIdx");


		BoardVo boardItem = null;

	
		
		int count = 0;
		
		
		
		BoardVo board = new BoardVo();
		board.setCount(count);
		board.setBoardIdx(boardIdx);
		
		try {
			boardItem = boardservice.getBoardItem(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			boardservice.updateCount(board);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		/**
		 * 뷰 페이지에서 사용할 값 model에서 setAttribute 로 지정할 수 있다. 없으면 request에서도 가능
		 */

		request.setAttribute("boardItem", boardItem);
		request.setAttribute("count",count);



		return "boardDetail";
	}

	@ResponseBody
	@RequestMapping(value = "/editOk.do", method = RequestMethod.POST)
	public int modifyBoard(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {

		int result = 0;

		MemberVo member = (MemberVo) web.getSession("loginInfo");
		String userId = web.getString("userId");
		String content = web.getString("content");
		String boardIdx = web.getString("boardIdx");

		BoardVo board = new BoardVo();
		board.setUserId(member.getUserId());
		board.setContent(content);
		board.setBoardIdx(Integer.parseInt(boardIdx));

		if (member.getUserId().equals(userId)) {

			try {
				boardservice.modifyBoard(board);
				result = 1;
			} catch (Exception e) {

				e.printStackTrace();
			}

		}

		return result;

	}

	@RequestMapping(value = "/deleteOk.do", method = RequestMethod.POST)
	public void boardDelete(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		web.init();

		/* 로그인 여부 검사 */
		MemberVo loginInfo = (MemberVo) web.getSession("loginInfo");

		if (loginInfo == null) {
			String movePage = web.getRootPath() + "/detail.do";
			web.redirect(movePage, "삭제 권한이 없습니다. 로그인 후에 이용해 주세요.");
		}
		// 파라미터 받기
		MemberVo member = (MemberVo) web.getSession("loginInfo");
		String userId = web.getString("userId");
		String boardIdx = web.getString("boardIdx");

		BoardVo board = new BoardVo();
		board.setUserId(member.getUserId());
		board.setBoardIdx(Integer.parseInt(boardIdx));

//		if (boardIdx == null) {
//			String movePage = web.getRootPath() + "/customerCenter.do";
//			web.redirect(movePage, "삭제할 게시글이 없습니다.");
//		}
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>삭제번호??????" + boardIdx);
		System.out.println("userId1 >>> " + userId);
		System.out.println("userId2 >>> " + member.getUserId());
		if (member.getUserId().equals(userId)) {
			try {
				boardservice.deleteBoard(board);

			} catch (Exception e) {

				e.printStackTrace();
			}
			/* 삭제 되었으므로 조회 페이지로 이동 */
			web.redirect(web.getRootPath() + "/customerCenter.do", "삭제 완료 되었습니다.");
		}else {
			web.redirect(web.getRootPath() + "/customerCenter.do", "삭제 권한이 없습니다.");

		}

	}

}