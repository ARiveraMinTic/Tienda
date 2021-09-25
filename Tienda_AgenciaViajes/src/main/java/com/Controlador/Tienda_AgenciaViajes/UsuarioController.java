package com.Controlador.Tienda_AgenciaViajes;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.Tienda_AgenciaViajes.UsuarioDAO;
import com.DTO.Tienda_AgenciaViajes.UsuarioVO;

@RestController
public class UsuarioController {
	
	@RequestMapping("/listarUsuarios")
	public ArrayList<UsuarioVO> listarUsuarios()
	{
		UsuarioDAO Dao = new UsuarioDAO();
				
		return Dao.listaUsuarios();
				
	}
	
	@RequestMapping("/consultarUsuario")
	public ArrayList<UsuarioVO> consultarUsuario(int documento)
	{
		UsuarioDAO Dao = new UsuarioDAO();
		return Dao.ConsultarUsuario(documento);
	}
	
	@RequestMapping("/registrarUsuario")
	public void registrarUsuario(UsuarioVO persona)
	{
		UsuarioDAO Dao = new UsuarioDAO();
		Dao.registrarUsuario(persona);
	}
	
	@RequestMapping("/eliminarUsuario")
	public void eliminarUsuario(int documento)
	{
		UsuarioDAO Dao = new UsuarioDAO();
		Dao.eliminarUsuario(documento);
	}
	
	@RequestMapping("/actualizarUsuario")
	public void actualizarUsuario(int documento, String Nombre, String Correo)
	{
		UsuarioDAO Dao = new UsuarioDAO();
		Dao.actualizarUsuario(documento, Nombre, Correo);
	}



	
}
