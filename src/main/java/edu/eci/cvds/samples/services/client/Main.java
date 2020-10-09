package edu.eci.cvds.samples.services.client;

import edu.eci.cvds.samples.services.ExcepcionServicioAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquilerFactory;

public class Main {
	
    public static void main(String args []) throws ExcepcionServicioAlquiler {
        System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarCliente(1000575071));
    }
}
