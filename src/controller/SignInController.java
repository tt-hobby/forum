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
import model.UserLogic;

@WebServlet("/signIn")
public class SignInController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SignInController() {
        super();
    }

    /*
     * Handle access to sign in page.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher reqDispatcher;
		HttpSession session = request.getSession(false);
		
		if (session != null && session.getAttribute("user") != null) {
			response.sendRedirect("/forum/my");
		} else {
			reqDispatcher = request.getRequestDispatcher("/WEB-INF/view/signInPage.jsp");
			reqDispatcher.forward(request, response);
		}
	}

	/*
	 * Handle sign in action.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher reqDispatcher;
		HttpSession session;
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		try {
			UserLogic userLogic = new UserLogic();
			UserBean user = userLogic.authenticate(userId, password);
			if (user != null) {
				session = request.getSession(true);
				session.setAttribute("user", user);
				response.sendRedirect("/forum/my");
			} else {
				request.setAttribute("err", "Invalid username or password");
				reqDispatcher = request.getRequestDispatcher("/WEB-INF/view/signInPage.jsp");
				reqDispatcher.forward(request, response);
			}
		} catch (SQLException err) {
			request.setAttribute("err", "Database error. Please try again.");
			reqDispatcher = request.getRequestDispatcher("/WEB-INF/view/signInPage.jsp");
			reqDispatcher.forward(request, response);
		}
	}

}
