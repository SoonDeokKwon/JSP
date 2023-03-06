package co.dev.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.controller.MainControl;
import co.dev.controller.MeberInsertControl;
import co.dev.controller.MemberDeleteControl;
import co.dev.controller.MemberDeleteFormControl;
import co.dev.controller.MemberInsertFormControl;
import co.dev.controller.MemberListControl;
import co.dev.controller.MemberSearchControl;
import co.dev.controller.MemberSearchFormControl;
import co.dev.controller.MemberUpdateFromConrol;
import co.dev.controller.MemberUpdateOutputControl;

public class FrontController extends HttpServlet {
	// url 패텅과 실행 컨ㅌ롤러 등록.
	// url - controller : map 등록.
	Map<String, Control> map = new HashMap<>();
	String enc;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		enc = config.getInitParameter("encoding");
		
		map.put("/main.do", new MainControl());
		map.put("/login.do", new LoginControl());
		// 회원목록.
		map.put("/memberList.do", new MemberListControl());
		
		// 회원등록화면
		map.put("/memberInsertForm.do", new MemberInsertFormControl());
		
		// 회원등록처리
		map.put("/memberInsert.do", new MeberInsertControl());
		
		// 회원조회 화면.
		map.put("/memberSearchForm.do", new MemberSearchFormControl());
		
		// 회원조회.
		map.put("/memberSearch.do", new MemberSearchControl());
		
		// 수정을 위한 화면.
		map.put("/memberUpdateForm.do", new MemberUpdateFromConrol());
		
		// 회원 수정.
		map.put("/memberUpdateOutput.do", new MemberUpdateOutputControl());
		
		// 삭제 조회 화면
		map.put("/memberDeleteForm.do", new MemberDeleteFormControl());
		
		// 삭제 처리
		map.put("/memberDelete.do", new MemberDeleteControl());
		
		
		// 사원목록.
//		map.put("/empList.do", new EmpListControl()); //결과페이지: member/empList.jsp
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(enc); // 인코딩 방식: UTF-8 
		
		// url - control 매칭.
		String uri = req.getRequestURI();  // http://localhost:8080/HelloWeb/main.do  -> URI는 로컬host 정보는 빼고 뒤에 HelloWeb/main.do 만 가져옴.
		String context = req.getContextPath();  //HelloWeb 어플리케이션 이름 자체를 리턴
		String path = uri.substring(context.length());   // /main.do 부분 읽어오기 용도
		
		System.out.println(path);
		
		Control sub = map.get(path);
		sub.execute(req, resp);
		
		
	}
	
	
}
