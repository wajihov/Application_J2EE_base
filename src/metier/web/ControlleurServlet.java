package metier.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.dao.IProduitDAO;
import metier.dao.ProduitDaoImp;
import metier.entities.Produit;

@WebServlet("/ControlleurServlet")
public class ControlleurServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private IProduitDAO metier;

	public ControlleurServlet() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		metier = new ProduitDaoImp();
	}

	@SuppressWarnings("static-access")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println(path);
		if (path.equals("/index.do")) {
			request.getRequestDispatcher("produits.jsp").forward(request, response);
		} else if (path.equals("/chercher.do")) {
			String motCle = request.getParameter("motCle");
			ProduitModel model = new ProduitModel();
			model.setMotCle(motCle);
			List<Produit> produits = metier.produitParMC(motCle);
			model.setProduits(produits);
			request.setAttribute("model", model);
			request.getRequestDispatcher("produits.jsp").forward(request, response);
		}else{
			response.sendError(response.SC_NOT_FOUND);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
