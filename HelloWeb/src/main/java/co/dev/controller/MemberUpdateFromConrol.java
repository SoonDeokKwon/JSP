package co.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.common.Control;

public class MemberUpdateFromConrol implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
	try {
		req.getRequestDispatcher("WEB-INF/member/memberUpdateForm.jsp").forward(req, resp)
		;
	} catch (ServletException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}

	}

}
