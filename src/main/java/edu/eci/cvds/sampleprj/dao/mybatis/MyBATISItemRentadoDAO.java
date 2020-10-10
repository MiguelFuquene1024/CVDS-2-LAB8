package edu.eci.cvds.sampleprj.dao.mybatis;

import java.sql.Date;
import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.ItemRentadoDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemRentadoMapper;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;


public class MyBATISItemRentadoDAO implements ItemRentadoDAO{

	@Inject
	private ItemRentadoMapper ItemRentadoMapper;

	

	@Override
	public ItemRentadoDAO load(int id) throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Date date, long docu, Item item, int numdias) throws PersistenceException {
		try{
			ItemRentadoMapper.registrarItemRentadoMapper(date,docu,item,numdias);
		  }
		  catch(org.apache.ibatis.exceptions.PersistenceException e){
		      throw new PersistenceException("Error al registrar alquiler", null);
		  }
		
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
	
	public void registrarItemRentadoMapper(Date date, long docu, Item item, int numdias) {
	}

	@Override
	public ItemRentado consultarItemRentado(int iditem) throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}






	
}
