package edu.eci.cvds.sampleprj.dao;


import java.util.List;

import edu.eci.cvds.samples.entities.ItemRentado;

public interface ItemRentadoDAO {

	public void save(ItemRentadoDAO it) throws PersistenceException;

	public ItemRentadoDAO load(int id) throws PersistenceException;

	public List<ItemRentado> consultarItemsCliente(long idcliente) throws PersistenceException;

	void save(ItemRentado it) throws PersistenceException;

}
