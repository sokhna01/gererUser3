package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.Userdao;

/**
 * Servlet implementation class updateUser
 */
@WebServlet("/updateUser")
public class updateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		if (id != null && id.matches("[0-9]+"))
		{
			User utilisateur = Userdao.get(Integer.parseInt(id));
			
			if(utilisateur != null) 
			{
				request.setAttribute("utilisateur", utilisateur);
				getServletContext().getRequestDispatcher("/WEB-INF/modifierUser.jsp").forward(request, response);
				return;
			}
		}
		response.sendRedirect("list");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		User utilisateur = new User(Integer.parseInt(id), nom, prenom, login, password);
		//response.sendRedirect(request.getContextPath(+"/list");
		//ou
		Userdao.modifier(utilisateur);
		response.sendRedirect("list");
	}

}
