package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.jdbc.EmpDAO;

@WebServlet("/getUserInfo")
public class JdbcServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmpDAO dao = new EmpDAO();
//		int empId = Integer.parseInt(req.getParameter("empId"));
//		Map<String, Object> result = dao.getEmpInfo(empId);
//		
//		//페이지 출력, 사번/ 이름(이름 + 성씨)/ 급여/ 부서
//		PrintWriter out = resp.getWriter(); 
//		
//		System.out.println(result.get("id"));
//		System.out.println(result.get("Name") );
//		System.out.println(result.get("salary"));
//		System.out.println(result.get("departmentId"));
//		
//		//get or post 요청을 구분해서 처리.
//		//get이면 조회, post이면 입력.
		String eid =  req.getParameter("empId");
		// get, post 방식 여부 상관없이 전부 처리됨
		// 공통적인 부분은 이렇게 처리하면 됨
		
		//get방식과 post 방식의 차이를 구별해서 하려면 아래와 같이 처리
		if(req.getMethod().equals("GET")) {
			//조회용으로 Get 방식 처리
			Map<String, Object> result = dao.getEmpInfo(Integer.parseInt(eid));
			Set<String> set = result.keySet(); //키 부분만 set 컬렉션
			for(String key : set) {
				System.out.println("key:" + key + ",val: "+ result.get(key));
			}
		}else if (req.getMethod().equals("POST")) {
			String first = req.getParameter("first");
			String last = req.getParameter("last");
			String hire = req.getParameter("hire");
			String job = req.getParameter("job");
			String email = req.getParameter("email");
			
			//영속계층의 기능. EmpDAO에.
			Map<String, Object> map = new HashMap<>();
			map.put("eid", eid);
			map.put("first", first);
			map.put("last", last);
			map.put("hire", hire);
			map.put("job", job);
			map.put("email", email);
			
			int result = dao.insertEmpInfo(map);
			System.out.println(result);
		}
		
		
		//페이지 작성
		// {키:값}, {키:값}, {키:값}, {키:값} => rsult.get('키') 값을 반환.
		
		
//		out.print("<a href='temp.html'>조회-등록으로 이동</a>");
	}
	
}
