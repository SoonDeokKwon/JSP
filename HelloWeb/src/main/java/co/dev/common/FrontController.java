package co.dev.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	// url 패텅과 실행 컨ㅌ롤러 등록.
	// url - controller : map 등록.
	Map<String, Control> map = new HashMap<>();
	
	
	@Override
	public void init() throws ServletException {
		map.put("/main.do", new MainControl());
		map.put("/login.do", new LoginControl());
		// 회원목록.
		map.put("/memberlist.do", new MemberListControl());
		
		//사원목록.
		map.put("/empList.do", newListControl()); //결과페이지 : member/empList
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// url - control 매칭.
		String uri = req.getRequestURI();  // http://localhost:8080/HelloWeb/main.do  -> URI는 로컬host 정보는 빼고 뒤에 HelloWeb/main.do 만 가져옴.
		String context = req.getContextPath();  //HelloWeb 어플리케이션 이름 자체를 리턴
		String path = uri.substring(context.length());   // /main.do 부분 읽어오기 용도
		
		System.out.println(path);
		
		Control sub = map.get(path);
		sub.execute(req, resp);
		
		
	}
	
	
}
