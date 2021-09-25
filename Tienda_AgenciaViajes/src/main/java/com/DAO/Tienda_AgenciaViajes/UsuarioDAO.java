package com.DAO.Tienda_AgenciaViajes;

import java.sql.*;
import java.util.ArrayList;

import com.DTO.Tienda_AgenciaViajes.UsuarioVO;
//Esta clase permite el acceso ala Base de Datos

public class UsuarioDAO {
	
	//Metodo para consultar los usuarios
	
	public ArrayList<UsuarioVO> listaUsuarios()
	{
		ArrayList<UsuarioVO> miLista = new ArrayList<UsuarioVO>();
		conexion con = new conexion();
		
		try
		{
			PreparedStatement consulta = con.getCon().prepareStatement("SELECT * FROM T_Usuarios");
			ResultSet rs = consulta.executeQuery();
			while(rs.next())
			{
				UsuarioVO persona =new UsuarioVO();
				persona.setCedula(Integer.parseInt(rs.getString("Cedula_Usu")));
				persona.setNombre(rs.getString("Nombre_Usu"));
				persona.setCorreo(rs.getNString("Correo_Usu"));
				persona.setUsuario(rs.getString("Usuario"));
				persona.setClave(rs.getNString("Clave_Usu"));
				
				miLista.add(persona);
			}
			rs.close();
			consulta.close();
			con.desconectar();
		}
		catch(Exception e)
		{
			System.out.println("Error No se pudo Conectar" + e);
		}
		
		return miLista;
	}
	
	//Para consultar un usuario por Número de Documento
	public ArrayList<UsuarioVO> ConsultarUsuario(int documento)
	{
		ArrayList<UsuarioVO> miLista = new ArrayList<UsuarioVO>();
		conexion con = new conexion();
		try
		{
			PreparedStatement consulta = con.getCon().prepareStatement("SELECT * FROM T_USUARIOS WHERE Cedula_usu = ?");
			consulta.setInt(1, documento);
			ResultSet rs = consulta.executeQuery();
			
			if(rs.next())
			{
				UsuarioVO persona = new UsuarioVO();
				persona.setCedula(Integer.parseInt(rs.getString("Cedula_Usu")));
				persona.setNombre(rs.getString("Nombre_Usu"));
				persona.setCorreo(rs.getString("Usuario"));
				persona.setUsuario(rs.getString("Correo_usu"));
				persona.setClave(rs.getString("Clave_Usu"));
				
				miLista.add(persona);
			}
			rs.close();
			consulta.close();
			con.desconectar();
		}
		catch(Exception e)
		{
			System.out.println("Error Usuario No encontrado: " + e);
		}
		return miLista;
		
		
	}
	
	//Metodo para Registrar a un usuario
	public void registrarUsuario(UsuarioVO persona)
	{
		conexion con = new conexion();
		try
		{
			Statement stmt = con.getCon().createStatement();
			stmt.executeUpdate("INSERT INTO T_Usuarios Values('"+persona.getCedula()+"','" +
			     persona.getNombre()+"','" + persona.getCorreo()+"','" + persona.getUsuario() + "','" + 
				 persona.getClave()+"')");
			System.out.println("El usuario ha sido adicionado");
			con.desconectar();
		}	
		
		catch(Exception e)
		{
			System.out.println("Error de Conexión: Usuario NO Adicionado "+ e);
		}
	}
	
	//Para Eliminar un usuario por Número de Documento
		public void eliminarUsuario(int documento)
		{
			conexion con = new conexion();
			try
			{
				PreparedStatement consulta = con.getCon().prepareStatement("DELETE FROM T_USUARIOS WHERE Cedula_usu = ?");
				consulta.setInt(1, documento);
				consulta.executeUpdate();
				System.out.println("El Usuario ha sido Eliminado");
				
				consulta.close();
				con.desconectar();
			}
			catch(Exception e)
			{
				System.out.println("Error Usuario No encontrado: " + e);
			}

		}
		
		//Para Actualizar un usuario por Número de Documento
				public void actualizarUsuario(int documento , String nombre, String correo)
				{
					conexion con = new conexion();
					try
					{
						PreparedStatement consulta = con.getCon().prepareStatement("UPDATE T_USUARIOS SET Nombre_Usu = ?, Correo_Usu = ? WHERE Cedula_Usu = ? ");
						consulta.setString(1, nombre);
						consulta.setString(2, correo);
						consulta.setInt(3, documento);
						consulta.executeUpdate();
						System.out.println("El Usuario ha sido Actualizado");
						
						consulta.close();
						con.desconectar();
					}
					catch(Exception e)
					{
						System.out.println("Error Usuario No encontrado: " + e);
					}

				}
		


}
