package metier.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import metier.connection.SingletonConnetion;
import metier.entities.Produit;

public class ProduitDaoImp implements IProduitDAO {

	@Override
	public Produit save(Produit p) {
		Connection connection = SingletonConnetion.getConnecxion();
		try {
			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO `produit`( `Designation`, `Prix`, `Quantite`) VALUES (?,?,?)");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.executeUpdate();
			PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(Id_Produit) AS MAX_ID FROM `produit`");
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				p.setId(rs.getLong("MAX_ID"));
			}
			ps.close();
		} catch (Exception e) {

		}
		return p;
	}

	@Override
	public List<Produit> produitParMC(String mc) {
		List<Produit> produits = new ArrayList<Produit>();
		Connection connection = SingletonConnetion.getConnecxion();
		try {
			PreparedStatement ps = connection.prepareStatement("Select * from produit where Designation like ?");
			ps.setString(1, "%" + mc + "%");
			ResultSet rs =ps.executeQuery();
			while (rs.next()) {
				Produit p=new Produit();
				p.setId(rs.getLong(1));
				p.setDesignation(rs.getString(2));
				p.setPrix(rs.getDouble("prix"));
				p.setQuantite(rs.getInt("Quantite"));
				produits.add(p);				
			}
			ps.close();
		} catch (Exception e) {

		}

		return produits;
	}

	@Override
	public Produit getProduit(Long id) {

		return null;
	}

	@Override
	public List<Produit> allProduit() {

		return null;
	}

	@Override
	public Produit updateProduit(Produit p) {

		return null;
	}

	@Override
	public void deleteProduit(Long id) {

	}

}
