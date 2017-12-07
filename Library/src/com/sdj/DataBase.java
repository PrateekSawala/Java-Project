package com.sdj;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase
{
	public static Connection getConnect()
    {
    	String driver="com.mysql.jdbc.Driver"; //1
    	String url ="jdbc:mysql://localhost:3306/database";
    	String user="root";
    	String pass="root";
    	Connection con =null;
    	try
    	{		Class.forName(driver);//2
    		con  = DriverManager.getConnection(url,user,pass);//3
    	}
    	catch(ClassNotFoundException ex)
    	{    		ex.printStackTrace();
    		
    	}
    	catch(SQLException ex)
    	{    		ex.printStackTrace();
    	}
    	return con;
    }
 
	/*@SuppressWarnings("null")
	public static void main(String[] args) 
     {
    	 	String driver="com.mysql.jdbc.Driver"; //1
    	 	String url = "jdbc:mysql://localhost:3306/databasedemo";
    	 	String user="root";
    	 	String pass ="root"; 
    	 	Connection con  =null;		
    	 	Statement stmt  =null;
    	 	//String sql  = "create table medicine(mbatch int(15),mtype varchar(30))"; 
    	 	//String sql1="insert into medicine values(104,'A')"; 
    	 	String sql2="select *from  medicine3";
    	 	ResultSet rs =null;
    	 	try
    	 	{
    	 		Class.forName(driver);  //2
    	 		con =DriverManager.getConnection(url,user,pass); //3
    	 		stmt   = con.createStatement();//4
    	 		//stmt.execute(sql); //5
    	 		//stmt.executeUpdate(sql1);
    	 		 rs  = stmt.executeQuery(sql2);
    	 	 while(rs.next())
    	 		 {
    	 		 int mbatch  = rs.getInt("mbatch");
    	 		 String mtype  = rs.getString("mtype");
    	 		 System.out.println(mbatch+" : "+mtype);
    	 		 }
    	 		
    	 	}
    	 	catch(ClassNotFoundException ex)
    	 	{
    	 		ex.printStackTrace();
    	 	}
    	 	catch(SQLException ex)
    	 	{
    	 		ex.printStackTrace();
    	 	}
    	 	finally   //6
    	 	{
    	 		try
    	 		{
    	 			  if(stmt!=null)
    	 			  {
    	 				  stmt.close();
    	 				  stmt =null;
    	 			  }
    	 		}
    	 		catch(SQLException ex)
    	 		{
    	 			ex.printStackTrace();
    	 		}
    	 		try
    	 		{
    	 			  if(con!=null)
    	 			  {
    	 				  con.close();
    	 				  con =null;
    	 			  }
    	 		}
    	 		catch(SQLException ex)
    	 		{
    	 			ex.printStackTrace();
    	 		}
    	 		 
    	 	}	 		
			
     }
	*/
	public static void closeResource(Connection con, Statement stmt) {
		
		try
 		{
 			  if(stmt!=null)
 			  {
 				  stmt.close();
 				  stmt =null;
 			  }
 		}
 		catch(SQLException ex)
 		{
 			ex.printStackTrace();
 		}
 		try
 		{
 			  if(con!=null)
 			  {
 				  con.close();
 				  con =null;
 			  }
 		}
 		catch(SQLException ex)
 		{
 			ex.printStackTrace();
 		}

    

	}
     
}
