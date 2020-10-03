package edu.eci.cvds.samples.services;

public class ExcepcionServicioAlquiler extends Exception {
	
	public ExcepcionServicioAlquiler() {
		super();
	}
	public ExcepcionServicioAlquiler(String string, org.apache.ibatis.exceptions.PersistenceException e) {
        super(string);
    }

}
