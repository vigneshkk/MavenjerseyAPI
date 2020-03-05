package com.jersey.jerseyapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	public List<Userpojo> getAllUserLis(){
		List<Userpojo> userList = new ArrayList<>();;
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mavenjersey", "postgres", "Vinivicky*321");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
            	userList.add(new Userpojo(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getInt(6),resultSet.getInt(7)));
            }
            connection.close();
            statement.close();
            resultSet.close();
            return userList;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
		return userList;	
	}
	
	public List<BookMappojo> getAllUserBookLis(String uname){
		List<BookMappojo> userBookList = new ArrayList<>();;
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mavenjersey", "postgres", "Vinivicky*321");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM bookmap WHERE user_name='"+uname+"'");
            while (resultSet.next()) {
            	userBookList.add(new BookMappojo(resultSet.getString(1),resultSet.getString(3),resultSet.getInt(2),resultSet.getTimestamp(4),resultSet.getTimestamp(5)));
            }
            connection.close();
            statement.close();
            resultSet.close();
            return userBookList;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
		return userBookList;	
	}
	public String bookActions(String uname,String action,int id){
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mavenjersey", "postgres", "Vinivicky*321");
            Statement statement = connection.createStatement();
            if(action.equals("return")){
            	statement.executeUpdate("UPDATE bookmap SET status='returned' where book_id="+id);
                statement.executeUpdate("UPDATE books SET status='available' WHERE id="+id+";");
            }else{
            statement.executeUpdate("INSERT INTO bookmap VALUES('"+uname+"',"+id+",'"+action+"ed',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP+ INTERVAL '7 day')");
            statement.executeUpdate("UPDATE books SET status='"+action+"ed' WHERE id="+id+";");
            }
            connection.close();
            statement.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
		return "Success";
		
	}
}
