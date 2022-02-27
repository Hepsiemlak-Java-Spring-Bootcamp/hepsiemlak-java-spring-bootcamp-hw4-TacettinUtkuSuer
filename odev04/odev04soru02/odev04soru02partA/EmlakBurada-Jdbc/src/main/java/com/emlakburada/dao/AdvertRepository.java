package com.emlakburada.dao;

import com.emlakburada.entity.Advert;
import com.emlakburada.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdvertRepository extends JdbcConnectionRepository {

	private static final String INSERT_ADVERT = "INSERT INTO ADVERT (ID, TITLE, ADDRESS, PHOTO) VALUES (?,?,?,?);";
	private static final String SELECT_ALL_ADVERT = "SELECT * FROM ADVERT";
	private static final String FIND_ADVERT = "SELECT * FROM ADVERT WHERE id = ?";
	private static final String UPDATE_ADVERT = "UPDATE ADVERT SET ADDRESS=? WHERE ID=?";
	private static final String DELETE_ADVERT = "DELETE FROM ADVERT WHERE ID=?";

	public void save(Advert advert) {

		Connection connection = connect();

		if (connection != null) {

			PreparedStatement prepareStatement = null;
			try {

				prepareStatement = connection.prepareStatement(INSERT_ADVERT);
				prepareStatement.setInt(1, advert.id);
				prepareStatement.setString(2, advert.title);
				prepareStatement.setString(3, advert.address);
				prepareStatement.setString(4, advert.photo);

				int executeUpdate = prepareStatement.executeUpdate();

				System.out.println("result: " + executeUpdate);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					connection.close();
					prepareStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("Connection oluşturululamadı!");
		}

	}

	public List<Advert> findAll() {

		List<Advert> advertList = new ArrayList<>();

		Connection connection = connect();

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SELECT_ALL_ADVERT);

			ResultSet result = prepareStatement.executeQuery();

			while (result.next()) {

				int advertId = result.getInt("id");
				String title = result.getString("title");
				String address = result.getString("address");
				String photo = result.getString("photo");

				advertList.add(prepareAdvert(advertId, title, address, photo));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return advertList;

	}

	private Advert prepareAdvert(int id, String title, String address, String photo) {
		Advert advert = new Advert();

		advert.id = id;
		advert.title = title;
		advert.address = address;
		advert.photo = photo;

		return advert;
	}

	public Advert findOne(int id) {

		Advert advert = null;

		Connection connection = connect();

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(FIND_ADVERT);
			prepareStatement.setInt(1, id);

			ResultSet result = prepareStatement.executeQuery();
			if (result.next()) {
				int userId = result.getInt("id");
				String title = result.getString("title");
				String address = result.getString("address");
				String photo = result.getString("photo");

				advert = prepareAdvert(userId, title, address, photo);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return advert;

	}

	public void updateAddress(int id, String address) {

		Connection connection = connect();

		if (connection != null) {

			PreparedStatement prepareStatement = null;

			try {

				prepareStatement = connection.prepareStatement(UPDATE_ADVERT);
				prepareStatement.setString(1, address);
				prepareStatement.setInt(2, id);


				int executeUpdate = prepareStatement.executeUpdate();

				System.out.println("result: " + executeUpdate);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					connection.close();
					prepareStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("Connection oluşturulamadı!");
		}

	}

	public void delete(int id) {

		Connection connection = connect();

		if (connection != null) {

			PreparedStatement prepareStatement = null;
			try {

				prepareStatement = connection.prepareStatement(DELETE_ADVERT);
				prepareStatement.setInt(1, id);

				int executeUpdate = prepareStatement.executeUpdate();

				System.out.println("result: " + executeUpdate);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					connection.close();
					prepareStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("Connection oluşturulamadı!");
		}

	}

}
