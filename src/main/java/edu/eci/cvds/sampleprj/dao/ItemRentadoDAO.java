package edu.eci.cvds.sampleprj.dao;


import java.sql.Date;
import java.util.List;

import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;

public interface ItemRentadoDAO {


	public ItemRentadoDAO load(int id) throws PersistenceException;

	public List<ItemRentado> consultarItemsCliente(long idcliente) throws PersistenceException;



	public void save(Date date, long docu, Item item, int numdias) throws PersistenceException;

	public ItemRentado consultarItemRentado(int iditem) throws PersistenceException;



	

}
