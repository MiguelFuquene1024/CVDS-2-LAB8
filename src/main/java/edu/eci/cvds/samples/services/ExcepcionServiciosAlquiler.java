package edu.eci.cvds.samples.services;

public class ExcepcionServiciosAlquiler extends Exception{
	
	public ExcepcionServiciosAlquiler() {
		super();
	}
	public ExcepcionServiciosAlquiler(String string, org.apache.ibatis.exceptions.PersistenceException e) {
        super(string);
    }

}
