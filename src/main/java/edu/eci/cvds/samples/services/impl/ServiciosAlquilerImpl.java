package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.sampleprj.dao.ItemRentadoDAO;
import edu.eci.cvds.sampleprj.dao.TipoItemDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.ExcepcionServicioAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import java.sql.Date;
import java.util.List;

@Singleton
public class ServiciosAlquilerImpl implements ServiciosAlquiler {

   @Inject
   private ItemDAO itemDAO;
   
   @Inject
   private ClienteDAO clienteDAO;
   
   @Inject
   private TipoItemDAO TipoItemDAO;
   
   @Inject
   private ItemRentadoDAO ItemRentadoDAO;
   


   @Override
   public int valorMultaRetrasoxDia(int itemId) {
       throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public Cliente consultarCliente(long docu) throws ExcepcionServicioAlquiler {
	   try {
           return clienteDAO.load(docu);
       } catch (PersistenceException ex) {
           throw new ExcepcionServicioAlquiler("Error al consultar el Cliente "+docu,ex);
       }
   }

   @Override
   public List<ItemRentado> consultarItemsCliente(long idcliente) throws ExcepcionServicioAlquiler {

	   try {
		   return ItemRentadoDAO.consultarItemsCliente(idcliente);
	   }catch (PersistenceException ex) {
           throw new ExcepcionServicioAlquiler("Error al consultar items del cliente",ex);
       }
   }

   @Override
   public List<Cliente> consultarClientes() throws ExcepcionServicioAlquiler {
	   try {
		   return clienteDAO.consultarClientes();
	   }catch (PersistenceException ex) {
           throw new ExcepcionServicioAlquiler("Error al consultar el Clientes");
       }
   }
   
   
   @Override
   public Item consultarItem(int id) throws ExcepcionServicioAlquiler {
       try {
           return itemDAO.load(id);
       } catch (PersistenceException ex) {
           throw new ExcepcionServicioAlquiler("Error al consultar el item "+id,ex);
       }
   }
   


   @Override
   public List<Item> consultarItemsDisponibles() {
       throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws ExcepcionServicioAlquiler {
       throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public TipoItem consultarTipoItem(int id) throws ExcepcionServicioAlquiler {
	   try {
           return TipoItemDAO.load(id);
       }catch (PersistenceException ex) {
           throw new ExcepcionServicioAlquiler("Error al consultar los tipos items ",ex);
       }
   }

   @Override
   public List<TipoItem> consultarTiposItem() throws ExcepcionServicioAlquiler {
	   try {
           return TipoItemDAO.consultarTiposItem();
       }catch (PersistenceException ex) {
           throw new ExcepcionServicioAlquiler("Error al consultar los tipos items ",ex);
       }
   }

   @Override
   public void registrarAlquilerCliente(Date date, long docu, Item item, int numdias) throws ExcepcionServicioAlquiler {
       throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void registrarCliente(Cliente c) throws ExcepcionServicioAlquiler{
	
	   try {

		   clienteDAO.save(c);
       }catch (PersistenceException ex) {
           throw new ExcepcionServicioAlquiler("Error al registrar cliente ",ex);
       }
   }

   @Override
   public long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServicioAlquiler {
       throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServicioAlquiler {
       throw new UnsupportedOperationException("Not supported yet.");
   }
   @Override
   public void registrarItem(Item i) throws ExcepcionServicioAlquiler {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public void vetarCliente(long docu, boolean estado) throws ExcepcionServicioAlquiler {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }
}

