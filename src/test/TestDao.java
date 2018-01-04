package test;

import java.util.List;

import metier.dao.ProduitDaoImp;
import metier.entities.Produit;

public class TestDao {

	public static void main(String[] args) {
		System.out.println("Hello");
		ProduitDaoImp dao = new ProduitDaoImp();
		//Produit p1 = dao.save(new Produit("ECRON LG", 90, 8));
		System.out.println("Chercher des produits");
		List<Produit> produits=	dao.produitParMC("a");		
		for(Produit p : produits){
			System.out.println(p.toString());	
		}

	}

}
