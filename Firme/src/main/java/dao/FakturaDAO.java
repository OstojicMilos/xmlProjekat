package dao;

import java.sql.*;
import java.util.HashMap;

import model.Faktura;
import model.StavkaFakture;

public class FakturaDAO {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/xmlprojekat";
	private Connection conn;
	private PreparedStatement preparedStmt;

	public FakturaDAO() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void dodajNovuFakturu(Faktura faktura) {
		try{
			conn = DriverManager.getConnection(DB_URL);
			upisiZaglavljeUBazu(faktura);
			for(StavkaFakture stavka: faktura.getStavkeFakture().values()){
				upisiStavkuUBazu(stavka);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(preparedStmt != null){
					preparedStmt.close();
				}				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null){
					conn.close();
				}				
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
		
	}

	public HashMap<String, Faktura> nadjiSveFakture() {
		return null;
	}

	
	private void upisiZaglavljeUBazu(Faktura faktura) throws SQLException {
		String sql = "INSERT INTO faktura " +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		preparedStmt = conn.prepareStatement(sql);
		
		preparedStmt.executeUpdate();
	}

	private void upisiStavkuUBazu(StavkaFakture stavka) throws SQLException{
		String sql = "INSERT INTO stavka_fakture " +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		preparedStmt = conn.prepareStatement(sql);
		preparedStmt.setInt(0, stavka.getRedniBroj());
		preparedStmt.setString(1, stavka.getNazivRobeIliUsluge());
		preparedStmt.setDouble(2, stavka.getKolicina());
		preparedStmt.setString(3, stavka.getJedinicaMere());
		preparedStmt.setDouble(4, stavka.getJedinicnaCena());
		preparedStmt.setDouble(5, stavka.getVrednost());
		preparedStmt.setDouble(6, stavka.getProcenatRabata());
		preparedStmt.setDouble(7, stavka.getIznosRabata());
		preparedStmt.setDouble(8, stavka.getUmanjenoZaRabat());
		preparedStmt.setDouble(9, stavka.getUkupanPorez());
		preparedStmt.setString(10, stavka.getIdFakture());
		preparedStmt.executeUpdate();
	}
}
