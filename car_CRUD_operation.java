package com.jdbc.second;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;
public class car_CRUD_operation {
public static void saveCar(int id,String name,String brand,long price)
{
String url="jdbc:mysql://localhost:3306?user=root&password=root";
try {
Driver d = new Driver();
DriverManager.registerDriver(d);
Connection con = DriverManager.getConnection(url);
String query = "insert into car_app_jdbc.car values(?,?,?,?)";
PreparedStatement pstmt =con.prepareStatement(query);
pstmt.setInt(1, id);
pstmt.setString(2, name);
pstmt.setString(3, brand);
pstmt.setLong(4, price);
pstmt.execute();
con.close();
System.out.println("Data Inserted");
} catch (SQLException e) {
e.printStackTrace();
}
}

public static void deleteCar(int id)
{
String url="jdbc:mysql://localhost:3306?user=root&password=root";
try {
Driver d = new Driver();
DriverManager.registerDriver(d);
Connection con = DriverManager.getConnection(url);
String query = "delete from car_app_jdbc.car where id=?";
PreparedStatement pstmt =con.prepareStatement(query);
pstmt.setInt(1, id);
pstmt.execute();
con.close();
System.out.println("Data Deleted");
} catch (SQLException e) {
e.printStackTrace();
}
}

public static void UpdateCar(long price, int id)
{
String url="jdbc:mysql://localhost:3306?user=root&password=root";
try {
Driver d = new Driver();
DriverManager.registerDriver(d);
Connection con = DriverManager.getConnection(url);
String query = "update car_app_jdbc.car set price=? where id =?";
PreparedStatement pstmt =con.prepareStatement(query);
pstmt.setLong(1, price);
pstmt.setInt(2, id);
pstmt.execute();
con.close();
System.out.println("Data Updated");
} catch (SQLException e) {
e.printStackTrace();
}
}

public static void getCarById(int id)
{
String url="jdbc:mysql://localhost:3306?user=root&password=root";
try {
Driver d = new Driver();
DriverManager.registerDriver(d);
Connection con = DriverManager.getConnection(url);
String query = "select * from car_app_jdbc.car where id=?";
PreparedStatement pstmt =con.prepareStatement(query);
pstmt.setInt(1, id);
ResultSet rs = pstmt.executeQuery();
if(rs.next()) {
System.out.println(rs.getInt(1));
System.out.println(rs.getString(2));
 System.out.println(rs.getString(3));
System.out.println(rs.getLong(4));
}
pstmt.execute();
con.close();
} catch (SQLException e) {
e.printStackTrace();
}
}

public static void getAllCar()
{
String url="jdbc:mysql://localhost:3306?user=root&password=root";
try {
Driver d = new Driver();
DriverManager.registerDriver(d);
Connection con = DriverManager.getConnection(url);
Statement stmt =con.createStatement();
String query = "Select * from car_app_jdbc.car";
ResultSet rs = stmt.executeQuery(query);
while(rs.next())
{
System.out.println(rs.getInt(1));
System.out.println(rs.getString(2));
System.out.println(rs.getString(3));
System.out.println(rs.getLong(4));
System.out.println("-------------");
System.out.println("Sucessfuly Copied");
}
con.close();
} catch (SQLException e) {
e.printStackTrace();
}
}
}


