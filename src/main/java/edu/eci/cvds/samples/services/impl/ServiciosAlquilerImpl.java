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
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.apache.ibatis.annotations.Param;

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
   public List<Item> consultarItemsDisponibles() throws ExcepcionServicioAlquiler{
	   try {
		   	return itemDAO.itemsDisponibles();
       }catch (PersistenceException e) {
    	   
           throw new ExcepcionServicioAlquiler("Error al consultar items disponibles");
       }
   }

   @Override
   public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws ExcepcionServicioAlquiler {
       //try{
         //  Item item=consultarItem(iditem);
          // ItemRentadoDAO
          // LocalDate fechaMinimaEntrega=item..toLocalDate();
           //LocalDate fechaEntrega=fechaDevolucion.toLocalDate();
           //long retraso = ChronoUnit.DAYS.between(fechaMinimaEntrega, fechaEntrega);
           //if(retraso<0){
            //   retraso=0;
           //}
           //return retraso*5000;

       //}catch (PersistenceException ex){
         //  throw new ExcepcionServicioAlquiler("Error a consultar la multa, "+iditem,ex);
       //}
	   return 5000;
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
	   try {
		   ItemRentadoDAO.save(date,docu,item,numdias);
       }catch (PersistenceException ex) {
           throw new ExcepcionServicioAlquiler("Error al registrar alquileres ",ex);
       }
   }
   
   @Override
   public void registrarItemRentadoACliente(int id, int idit,Date fechainicio, Date fechafin) throws ExcepcionServicioAlquiler {
	   try {
		   clienteDAO.registrarItemRentadoACliente(id,idit,fechainicio,fechafin);
       }catch (PersistenceException ex) {
           throw new ExcepcionServicioAlquiler("Error al registrar alquileres ",ex);
       }
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
       try {
           itemDAO.save(i);
       }catch (PersistenceException ex) {
           throw new ExcepcionServicioAlquiler("Error al registrar item ",ex);
       }
   }

   @Override
   public void vetarCliente(long docu, boolean estado) throws ExcepcionServicioAlquiler {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }
}

