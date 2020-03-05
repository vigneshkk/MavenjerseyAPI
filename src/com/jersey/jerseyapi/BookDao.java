package com.jersey.jerseyapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
	public List<Bookpojo> getAllBookLis(){
		List<Bookpojo> bookList = new ArrayList<>();;
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mavenjersey", "postgres", "Vinivicky*321");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM books");
            while (resultSet.next()) {
            	bookList.add(new Bookpojo(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(7),resultSet.getTimestamp(6)));
            }
            connection.close();
            statement.close();
            resultSet.close();
            return bookList;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
		return bookList;	
	}
	
	public String addBook(String name, String description, String author, String genre, String status,
			String published_date){
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mavenjersey", "postgres", "Vinivicky*321");
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into books(name,description,author,genre,published_on,status)values('"+name+"','"+description+"','"+author+"','"+genre+"','"+published_date+"','"+status+"')");
            connection.close();
            statement.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
		
				return "Success";
		
	}
	
	public String updateBook(long id,String name, String description, String author, String genre, String status,
			String published_date){
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mavenjersey", "postgres", "Vinivicky*321");
            Statement statement = connection.createStatement();
            System.out.println("here");
            statement.executeUpdate("UPDATE books SET name='"+name+"',description='"+description+"',author='"+author+"',genre='"+genre+"',published_on='"+published_date+"',status='"+status+"' WHERE id="+id+";");
            connection.close();
            statement.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
		
				return "Success";
		
	}
	public String deleteBook(long id){
		try {
		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mavenjersey", "postgres", "Vinivicky*321");
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM books WHERE id="+id);
        connection.close();
        statement.close();
    } catch (SQLException | ClassNotFoundException e) {
        System.out.println("Connection failure.");
        e.printStackTrace();
    }
		return "success";
	}

}
