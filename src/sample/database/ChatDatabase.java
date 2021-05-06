package sample.database;

import sample.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChatDatabase {
    private Connection connection;
    private Statement statement;
    private static final String USER = "user", FRIEND = "friend", CHAT = "chat";

    public ChatDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:chat.db");
            System.out.println("Opened database successfully");

            statement = connection.createStatement();
            String query;
            query = "CREATE TABLE IF NOT EXISTS " + USER + " (pk_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name TEXT NOT NULL,password TEXT NOT NULL, firstname TEXT NOT NULL,lastname TEXT NOT NULL,major TEXT ,date_of_birth TEXT ,mobile_number TEXT );";
            statement.execute(query);
            query = "CREATE TABLE IF NOT EXISTS " + FRIEND + " (pk_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, fk_user_id INTEGER NOT NULL, ip_address TEXT, port INTEGER);";
            statement.execute(query);
            query = "CREATE TABLE IF NOT EXISTS " + CHAT + " (pk_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,fk_user_id INTEGER NOT NULL,fk_friend_id  INTEGER NOT NULL, message TEXT, send_date TEXT);";
            statement.execute(query);

            statement.close();
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public List<User> findAllUser() {
        List<User> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM " + USER + ";";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                User item = new User();
                item.setPk_id(rs.getInt(1));
                item.setName(rs.getString(2));
                item.setPassword(rs.getString(3));
                item.setFirstName(rs.getString(4));
                item.setLastName(rs.getString(5));
                item.setMajor(rs.getString(6));
                item.setBirthday(rs.getString(7));
                item.setPhone(rs.getString(8));
                list.add(item);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return list;
        }
    }

    public boolean insertUser(User user) {
        int numRowsInserted = 0;
        try {
            String cols = "pk_id,name,password,firstname,lastname,major,date_of_birth,mobile_number";
            String query = insertRow(USER, cols, 7);
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, user.getPk_id());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getFirstName());
            ps.setString(5,user.getLastName());
            ps.setString(6, user.getMajor());
            ps.setString(7, user.getBirthday());
            ps.setString(8, user.getPhone());
            numRowsInserted = ps.executeUpdate();
            return numRowsInserted >= 1;
        } catch (Exception e) {
            return numRowsInserted >= 1;
        }
    }

    public boolean updateUser(User user) {
        int numRowsInserted = 0;
        try {
            String[] cols = {"pk_id,name,password,firstname,lastname,major,date_of_birth,mobile_number"};
            String query = updateRow(USER, user.getPk_id(), cols);
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, user.getPk_id());
            ps.setString(2, user.getName());
            ps.setString(4, user.getPassword());
            ps.setString(3,user.getFirstName());
            ps.setString(5,user.getLastName());
            ps.setString(6,user.getMajor());
            ps.setString(7,user.getBirthday());
            ps.setString(8, user.getPhone());
            numRowsInserted = ps.executeUpdate();
            return numRowsInserted >= 1;
        } catch (Exception e) {
            return numRowsInserted >= 1;
        }
    }

    public boolean deleteUser(int id) {
        return deleteRow(USER, id);
    }


    private String insertRow(String table, String tableColumn, int num) {
        String str = "INSERT INTO " + table + " (" + tableColumn + ") VALUES(";
        for(int i = 1; i <= num; i++) {
            if(i == num)
                str += "?";
            else
                str += "?, ";
        }
        str += ");";
        return str;
    }

    private String updateRow(String table, int id, String... items) {
        String str = "UPDATE " + table + " SET ";
        for (int i = 0; i < items.length; i++) {
            if(i == items.length - 1)
                str += items[i] + " = ?";
            else
                str += items[i] + " = ?, ";
        }
        str += " WHERE id = " + id + ";";
        return str;
    }

    private boolean deleteRow(String table, int id) {
        try {
            statement.executeUpdate("DELETE FROM " + table + " WHERE id = " + id + ";");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
