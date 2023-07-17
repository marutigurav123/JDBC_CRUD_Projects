package com.jdbc.second;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;
public class userCRUDOperation {
public static void saveUser(int id, String name, String email, String 
password)
{
String url="jdbc:mysql://localhost:3306?user=root&password=root";
try {
Driver d = new Driver();
DriverManager.registerDriver(d);
Connection con = DriverManager.getConnection(url);
String query = "insert into car_app_jdbc.user values(?,?,?,?)";
PreparedStatement pstmt =con.prepareStatement(query);
pstmt.setInt(1, id);
pstmt.setString(2, name);
pstmt.setString(3, email);
pstmt.setString(4, password);
pstmt.execute();
con.close();
System.out.println("Data Inserted");
} catch (SQLException e) {
e.printStackTrace();
}
}

public static void updateUser(String password, int id)
{
String url="jdbc:mysql://localhost:3306?user=root&password=root";
try {
Driver d = new Driver();
DriverManager.registerDriver(d);
Connection con = DriverManager.getConnection(url);
String query = "update car_app_jdbc.user set password=? where id=?";
PreparedStatement pstmt =con.prepareStatement(query);
pstmt.setString(1, password);
pstmt.setInt(2, id);
pstmt.execute();
con.close();
System.out.println("Data Updated");
} catch (SQLException e) {
e.printStackTrace();
}
}
public static void deleteUser(int id)
{
String url="jdbc:mysql://localhost:3306?user=root&password=root";
try {
Driver d = new Driver();
DriverManager.registerDriver(d);
Connection con = DriverManager.getConnection(url);
String query = "delete from car_app_jdbc.user where id=?";
PreparedStatement pstmt =con.prepareStatement(query);
pstmt.setInt(1, id);
pstmt.execute();
con.close();
} catch (SQLException e) {
e.printStackTrace();
}
}
public static void getUSerById(int id)
{
String url="jdbc:mysql://localhost:3306?user=root&password=root";
try {
Driver d = new Driver();
DriverManager.registerDriver(d);
Connection con = DriverManager.getConnection(url);
String query = "select * from car_app_jdbc.user where id=?";
PreparedStatement pstmt =con.prepareStatement(query);
pstmt.setInt(1, id);
ResultSet rs = pstmt.executeQuery();
if(rs.next()) {
System.out.println(rs.getInt(1));
System.out.println(rs.getString(2));
System.out.println(rs.getString(3));
System.out.println(rs.getString(4));
}
pstmt.execute();
con.close();
} catch (SQLException e) {
e.printStackTrace();
}
}
public static void validate(String email, String password)
{
String url="jdbc:mysql://localhost:3306?user=root&password=root";
try {
Driver d = new Driver();
DriverManager.registerDriver(d);
Connection con = DriverManager.getConnection(url);
String query = "select * from car_app_jdbc.user where email=? and password=?";
PreparedStatement pstmt =con.prepareStatement(query);
pstmt.setString(1, email);
pstmt.setString(2, password);
ResultSet rs=pstmt.executeQuery();
if(rs.next())
{
System.out.println("Details available in user table");
}
else
{
System.out.println("invalid email and password");
}
con.close();
} catch (SQLException e) {
e.printStackTrace();
}
}
}

