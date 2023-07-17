package com.jdbc.second;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;
public class showRoom_CRUD_Operation {
public static void saveShowRoom(int id,String name,String address)
{
String url="jdbc:mysql://localhost:3306?user=root&password=root";
try {
Driver d = new Driver();
DriverManager.registerDriver(d);
Connection con = DriverManager.getConnection(url);
String query = "insert into car_app_jdbc.showroom values(?,?,?)";
PreparedStatement pstmt =con.prepareStatement(query);
pstmt.setInt(1, id);
pstmt.setString(2, name);
pstmt.setString(3, address);
pstmt.execute();
con.close();
System.out.println("Data Inserted");
} catch (SQLException e) {
e.printStackTrace();
}
}
public static void deleteShowRoom(int id)
{
String url="jdbc:mysql://localhost:3306?user=root&password=root";
try {
Driver d = new Driver();
DriverManager.registerDriver(d);
Connection con = DriverManager.getConnection(url);
String query = "delete from car_app_jdbc.showroom where id=?";
PreparedStatement pstmt =con.prepareStatement(query);
pstmt.setInt(1, id);
pstmt.execute();
con.close();
System.out.println("Data Deleted");
} catch (SQLException e) {
e.printStackTrace();
}
}

public static void updateShowRoom(String name,int id)
{
String url="jdbc:mysql://localhost:3306?user=root&password=root";
try {
Driver d = new Driver();
DriverManager.registerDriver(d);
Connection con = DriverManager.getConnection(url);
String query = "update car_app_jdbc.showroom set name=? where id=?";
PreparedStatement pstmt =con.prepareStatement(query);
pstmt.setString(1, name);
pstmt.setInt(2, id);
pstmt.execute();
con.close();
System.out.println("Data Updated");
} catch (SQLException e) {
e.printStackTrace();
}
}

public static void getAllShowRoom()
{
String url="jdbc:mysql://localhost:3306?user=root&password=root";
try {
Driver d = new Driver();
DriverManager.registerDriver(d);
Connection con = DriverManager.getConnection(url);
Statement stmt =con.createStatement();
String query = "Select * from car_app_jdbc.showroom";
ResultSet rs = stmt.executeQuery(query);
while(rs.next())
{
System.out.println(rs.getInt(1));
System.out.println(rs.getString(2));
System.out.println(rs.getString(3));
System.out.println("-------------");
}
con.close();
System.out.println("Data Inserted");
} catch (SQLException e) {
e.printStackTrace();
}
}
}