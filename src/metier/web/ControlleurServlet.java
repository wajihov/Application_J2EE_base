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

@WebServlet(name = "ControlleurServlet", urlPatterns = { "*.do" })
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

		} else if (path.equals("/saisie.do")) {

			request.setAttribute("produit", new Produit());
			request.getRequestDispatcher("saisieProduit.jsp").forward(request, response);

		} else if (path.equals("/save.do") && request.getMethod().equals("POST")) {

			String design = request.getParameter("designation");
			double prix = Double.parseDouble(request.getParameter("prix"));
			int qte = Integer.parseInt(request.getParameter("quantite"));
			Produit p = metier.save(new Produit(design, prix, qte));
			request.setAttribute("produit", p);
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);

		} else if (path.equals("/updateProduit.do") && request.getMethod().equals("POST")) {

			Long id =Long.parseLong(request.getParameter("id_produit"));
			String design = request.getParameter("designation");
			double prix = Double.parseDouble(request.getParameter("prix"));
			int qte = Integer.parseInt(request.getParameter("quantite"));
			Produit p=new Produit(design, prix, qte);			
			p.setId(id);			
			metier.updateProduit(p);
			request.setAttribute("produit", p);
			//request.getRequestDispatcher("confirmation.jsp").forward(request, response);
			response.sendRedirect("chercher.do?motCle=");
			
		} else if (path.equals("/supprimer.do")) {

			Long id = Long.parseLong(request.getParameter("id"));
			metier.deleteProduit(id);
			// request.getRequestDispatcher("produits.jsp").forward(request,
			// response);
			response.sendRedirect("chercher.do?motCle=");
		} else if (path.equals("/editer.do")) {

			Long id = Long.parseLong(request.getParameter("id"));
			Produit p = metier.getProduit(id);
			request.setAttribute("produit", p);
			request.getRequestDispatcher("edit.jsp").forward(request, response);

		} else {
			response.sendError(response.SC_NOT_FOUND);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
