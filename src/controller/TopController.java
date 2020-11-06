package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/top")
public class TopController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TopController() {
        super();
    }

    /*
     * Handle access to top page.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher reqDispatcher;
		HttpSession session = request.getSession(false);
		
		if (session != null && session.getAttribute("user") != null) {
			response.sendRedirect("/forum/my");
		} else {
			reqDispatcher = request.getRequestDispatcher("/WEB-INF/view/topPage.jsp");
			reqDispatcher.forward(request, response);
		}
	}

}
