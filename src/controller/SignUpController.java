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

import error.IdUnavailableException;
import model.UserLogic;

@WebServlet("/signUp")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SignUpController() {
        super();
    }

    /*
     * Handle access to sign up page.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher reqDispatcher;
		HttpSession session = request.getSession(false);
		
		if (session != null && session.getAttribute("user") != null) {
			response.sendRedirect("/forum/my");
		} else {
			reqDispatcher = request.getRequestDispatcher("/WEB-INF/view/signUpPage.jsp");
			reqDispatcher.forward(request, response);
		}
	}

	/*
	 * Handle sign up action.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher reqDispatcher;
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		try {
			UserLogic userLogic = new UserLogic();
			userLogic.subscribe(userId, password);
			reqDispatcher = request.getRequestDispatcher("/WEB-INF/view/signUpSuccessPage.jsp");
			reqDispatcher.forward(request, response);
		} catch (IdUnavailableException err) {
			request.setAttribute("err", "User ID already used by another user.");
			reqDispatcher = request.getRequestDispatcher("/WEB-INF/view/signUpPage.jsp");
			reqDispatcher.forward(request, response);
		} catch (SQLException err) {
			request.setAttribute("err", "Database error. Please try again.");
			reqDispatcher = request.getRequestDispatcher("/WEB-INF/view/signUpPage.jsp");
			reqDispatcher.forward(request, response);
		}
	}

}
