package edu.eci.cvds.samples.services.client;


import java.util.List;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;

import edu.eci.cvds.samples.services.ExcepcionServicioAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquilerFactory;
import java.sql.Date;


public class Main {
	
    public static void main(String args []) throws ExcepcionServicioAlquiler {
        System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarItem(101));
        String fechafinal="2010-12-25";
        Date dat = Date.valueOf(fechafinal);
        TipoItem tip = new TipoItem(2,"Nuevo item");
        Item it = new Item(tip,101,"sdasd","sdad",dat,32432,"adas","sdada");
        //ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().registrarItem(it);
        
        
        //System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarCliente(1004119));
    	//System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarClientes());
    	//System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarTiposItem());

    	//ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().registrarCliente(new Cliente("Miguel",-1010,"8079373","saldskls","aksjhfkjsf"));
        //ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().registrarAlquilerCliente(dat,1004119 , it, 10);
        //System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarMultaAlquiler(1, dat));
    	//System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarTipoItem(2));
    	//System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarItemsCliente(3));
        //System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarItemsDisponibles());
        ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().registrarItemRentadoACliente(1321, 3, dat, dat);
    }
}
