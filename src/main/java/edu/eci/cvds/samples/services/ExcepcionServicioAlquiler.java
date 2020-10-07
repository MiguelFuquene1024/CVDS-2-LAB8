package edu.eci.cvds.samples.services;

import edu.eci.cvds.sampleprj.dao.PersistenceException;

public class ExcepcionServicioAlquiler extends Exception {
	
	public ExcepcionServicioAlquiler(String string) {
		super(string);
	}
	public ExcepcionServicioAlquiler(String string, PersistenceException e) {
        super(string);
    }

}
