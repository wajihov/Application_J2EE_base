package metier.dao;

import java.util.List;

import metier.entities.Produit;

public interface IProduitDAO {

	public Produit save(Produit p);

	public List<Produit> produitParMC(String mc);

	public Produit getProduit(Long id);

	public List<Produit> allProduit();

	public Produit updateProduit(Produit p);

	public void deleteProduit(Long id);

}
