package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Login
 */
@WebServlet({"/login", "/logout"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_LOGIN_UTILISATEUR = "/WEB-INF/connexion.jsp";
	private static final String VUE_LIST_UTILISATEUR = "/WEB-INF/listUsers.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		switch(request.getServletPath()){
		case "/logout":
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("login");
			break;
			
		case "/login":
			getServletContext().getRequestDispatcher(VUE_LOGIN_UTILISATEUR).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = request.getParameter("login");
		String mdp = request.getParameter("password");
		 
		if(login.equals("admin") && mdp.equals("passer")) {
			HttpSession session = request.getSession();
			session.setAttribute("isConnected", true);
			getServletContext().getRequestDispatcher(VUE_LIST_UTILISATEUR).forward(request, response);
		}
		else {
			request.setAttribute("connexionFailed", true);
			request.setAttribute("login", login);
			getServletContext().getRequestDispatcher(VUE_LOGIN_UTILISATEUR).forward(request, response);
		}
		
}
	}



