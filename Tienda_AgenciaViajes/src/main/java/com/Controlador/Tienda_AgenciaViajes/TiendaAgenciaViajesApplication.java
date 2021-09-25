package com.Controlador.Tienda_AgenciaViajes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.DAO.Tienda_AgenciaViajes.conexion;

@SpringBootApplication
public class TiendaAgenciaViajesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaAgenciaViajesApplication.class, args);
		
		conexion conn = new conexion();
		conn.getCon();
	}

}
