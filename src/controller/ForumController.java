package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.PostBean;
import bean.UserBean;
import error.UserUnfoundException;
import model.PostLogic;

@WebServlet("/forum")
public class ForumController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ForumController() {
        super();
    }

    /*
     * Handle access to forum page.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher reqDispatcher;
		HttpSession session = request.getSession(false);
		
		if (session != null && session.getAttribute("user") != null) {
			try {
				PostLogic postLogic = new PostLogic();
				List<PostBean> posts = postLogic.getAll();
				request.setAttribute("posts", posts);
				reqDispatcher = request.getRequestDispatcher("/WEB-INF/view/forumPage.jsp");
				reqDispatcher.forward(request, response);
			} catch (SQLException err) {
				request.setAttribute("err", "Database error. Could not retrieve posts.");
				reqDispatcher = request.getRequestDispatcher("/WEB-INF/view/forumPage.jsp");
				reqDispatcher.forward(request, response);
			}
		} else {
			response.sendRedirect("/forum/top");
		}
	}

	/*
	 * Handle post action.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher reqDispatcher;
		HttpSession session = request.getSession(false);
		String content = request.getParameter("content");
		
		if (session != null && session.getAttribute("user") != null) {
			try {
				PostLogic postLogic = new PostLogic();
				UserBean user = (UserBean) session.getAttribute("user");
				postLogic.post(user.getUserId(), content);
				response.sendRedirect("/forum/forum");
			} catch (UserUnfoundException err) {
				request.setAttribute("err", "Post failed. User not found.");
				reqDispatcher = request.getRequestDispatcher("/WEB-INF/view/forumPage.jsp");
				reqDispatcher.forward(request, response);
			} catch (SQLException err) {
				request.setAttribute("err", "Database error. Please try again.");
				reqDispatcher = request.getRequestDispatcher("/WEB-INF/view/forumPage.jsp");
				reqDispatcher.forward(request, response);
			}
		} else {
			response.sendRedirect("/forum/top");
		}
	}

}
