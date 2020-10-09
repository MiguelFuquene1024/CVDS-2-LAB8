package edu.eci.cvds.sampleprj.dao.mybatis;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.ItemRentadoDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemRentadoMapper;
import edu.eci.cvds.samples.entities.ItemRentado;


public class MyBATISItemRentadoDAO implements ItemRentadoDAO{

	@Inject
	private ItemRentadoMapper ItemRentadoMapper;

	@Override
	public void save(ItemRentado it) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ItemRentadoDAO load(int id) throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(ItemRentadoDAO it) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<ItemRentado> consultarItemsCliente(long idcliente) throws PersistenceException {
		try{
		      return ItemRentadoMapper.consultarItemsCliente(idcliente);
		  }
		  catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al consultar los clientes", null);
		  }
	}


	
}
