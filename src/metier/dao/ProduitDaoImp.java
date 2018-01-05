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
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Produit p = new Produit();
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
		Connection connection = SingletonConnetion.getConnecxion();
		Produit p = null;
		try {
			PreparedStatement ps = connection.prepareStatement("select * from produit where id_produit = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				p = new Produit();
				p.setId(rs.getLong("id_produit"));
				p.setDesignation(rs.getString("designation"));
				p.setPrix(rs.getDouble("prix"));
				p.setQuantite(rs.getInt(4));
			}
			ps.close();
		} catch (Exception e) {

		}
		return p;
	}

	@Override
	public List<Produit> allProduit() {

		return null;
	}

	@Override
	public Produit updateProduit(Produit p) {
		Connection connection = SingletonConnetion.getConnecxion();
		try {			
			PreparedStatement ps = connection.prepareStatement(
					"UPDATE produit set designation = ? ,prix = ?, quantite = ? where id_produit=?");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.setLong(4, p.getId());
			ps.executeUpdate();			
			ps.close();
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public void deleteProduit(Long id) {
		Connection connection = SingletonConnetion.getConnecxion();
		try {
			PreparedStatement ps = connection.prepareStatement("delete from produit where id_produit = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {

		}
	}

}
