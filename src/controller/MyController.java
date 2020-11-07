package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;
import error.UserUnfoundException;
import model.UserLogic;

@WebServlet("/my")
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MyController() {
        super();
    }

    /*
     * Handle access to my page.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher reqDispatcher;
		HttpSession session = request.getSession(false);
		
		if (session != null && session.getAttribute("user") != null) {
			reqDispatcher = request.getRequestDispatcher("/WEB-INF/view/myPage.jsp");
			reqDispatcher.forward(request, response);
		} else {
			response.sendRedirect("/forum/top");
		}
	}

	/*
	 * Handle unsubscribe action.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher reqDispatcher;
		HttpSession session = request.getSession(false);
		
		if (session != null && session.getAttribute("user") != null) {
			try {
				UserLogic userLogic = new UserLogic();
				UserBean user = (UserBean) session.getAttribute("user");
				userLogic.unsubscribe(user);
				response.sendRedirect("/forum/signOut");
			} catch (UserUnfoundException err) {
				request.setAttribute("msg", "Unsubscribe failed. User not found.");
				reqDispatcher = request.getRequestDispatcher("/WEB-INF/view/myPage.jsp");
				reqDispatcher.forward(request, response);
			} catch (SQLException err) {
				request.setAttribute("msg", "Database error. Please try again.");
				reqDispatcher = request.getRequestDispatcher("/WEB-INF/view/myPage.jsp");
				reqDispatcher.forward(request, response);
			}
		} else {
			response.sendRedirect("/forum/top");
		}
	}

}
