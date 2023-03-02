package co.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

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
		int empId = Integer.parseInt(req.getParameter("empId"));
		Map<String, Object> result = dao.getEmpInfo(empId);
		
		//페이지 출력, 사번/ 이름(이름 + 성씨)/ 급여/ 부서
		PrintWriter out = resp.getWriter(); 
		
		System.out.println(result.get("id"));
		System.out.println(result.get("Name") );
		System.out.println(result.get("salary"));
		System.out.println(result.get("departmentId"));
		
		//get or post 요청을 구분해서 처리.
		//get이면 조회, post이면 입력.

		
		
		//페이지 작성
		// {키:값}, {키:값}, {키:값}, {키:값} => rsult.get('키') 값을 반환.
		
		
		out.print("<a href='temp.html'>조회-등록으로 이동</a>");
	}
	
}
