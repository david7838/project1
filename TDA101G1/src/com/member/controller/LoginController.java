package com.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.MemberService;
import com.member.model.MemberVO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/member/login.controller")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		if (action.equals("login")) {
			Map<String, String> errorMsgs = new HashMap<String, String>();
			request.setAttribute("errorMsg", errorMsgs);
			String account = request.getParameter("account");
			String password = request.getParameter("password");
			request.setAttribute("account", account);
			try {

				if (account == null || account.trim().length() == 0) {
					errorMsgs.put("account", "Please input your account");
				}
				if (password == null || password.trim().length() == 0) {
					errorMsgs.put("password", "Please input your password");
				}
				if (!errorMsgs.isEmpty()) {
					request.getRequestDispatcher("/listAllMember.jsp").forward(request, response);
					return;
				}

//====================================呼叫ＭＯＤＥＬ======================================

				MemberService service = new MemberService();
				MemberVO member = service.login(account, password);
				if (member == null) {
					errorMsgs.put("login", "查無資料");
				}

				if (!errorMsgs.isEmpty()) {
					request.getRequestDispatcher("/listAllMember.jsp").forward(request, response);
					return;
				}

//=====================================查詢完成，準備轉交==================================

				request.setAttribute("member", member);
				request.getRequestDispatcher("/listAllMember.jsp").forward(request, response);

//=====================================其他錯誤=========================================

			} catch (Exception e) {
				errorMsgs.put("other", "cant get message" + e.getMessage());
				request.getRequestDispatcher("/listAllMember.jsp").forward(request, response);
			}
		}

//		String account = request.getParameter("account");
//		String password = request.getParameter("password");
//		if (action.equals("login")) {
//			MemberService service = new MemberService();
//			MemberVO member = service.login(account, password);
//			request.setAttribute("member", member);
//			request.getRequestDispatcher("/listAllMember.jsp").forward(request, response);
//
//		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
