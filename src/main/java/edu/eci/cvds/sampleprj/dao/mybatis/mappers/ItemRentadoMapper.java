package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;

public interface ItemRentadoMapper {
	
	
	public List<ItemRentado> consultarItemsCliente(@Param("docliente")long idcliente);

	public void registrarItemRentadoMapper(Date date, long docu, Item item, int numdias);



}
