package com.DAO.Tienda_AgenciaViajes;

import java.sql.*;

public class conexion {
	
	//parametros de Conexion
	String bd = "DB_AgenciaViajes"; //Nombre que se le puso en MySql al crear la base de datos
	String Login = "root";
	String password = "Admin_2021";
	String url = "jdbc:mysql://localhost/"+bd;
	
	Connection con = null;
	
	//Constructor de Conexion
	public conexion()
	{
		try
		{
			//obtener el driver para mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Obtener la Conexion
			con=DriverManager.getConnection(url,Login,password);
			if(con != null)
				System.out.println("Conexion a la Base de Datos: " + bd + " " + "Exitosa");
		}
		catch(SQLException e)
		{
			System.out.println("Error de Conexion: " + e);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Error de Conexion: " + e);
		}
		catch(Exception e)
		{
			System.out.println("Error de Conexion: " + e);
		}
	
	}
	
	//Metodo para retornar la conexion 
	public Connection getCon()
	{
		return con;
	}
	
	//Metodo para desconectar BD
	public void desconectar()
	{
		con = null;
	}
			

}
