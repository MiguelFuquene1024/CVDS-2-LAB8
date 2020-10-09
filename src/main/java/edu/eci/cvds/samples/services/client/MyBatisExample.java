/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.cvds.samples.services.client;



import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.TipoItem;

/**
 *
 * @author hcadavid
 */
public class MyBatisExample {

    /**
     * Método que construye una fábrica de sesiones de MyBatis a partir del
     * archivo de configuración ubicado en src/main/resources
     *
     * @return instancia de SQLSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }

    /**
     * Programa principal de ejempo de uso de MyBATIS
     * @param args
     * @throws SQLException 
     */
    public static void main(String args[]) throws SQLException {
    	String fechainicial="2020-10-20";
    	String fechafinal="2020-12-25";
    	Date d2 = Date.valueOf(fechafinal);
    	Date d1 = Date.valueOf(fechainicial);
    	
        SqlSessionFactory sessionfact = getSqlSessionFactory();

        SqlSession sqlss = sessionfact.openSession();

        
        
        //ClienteMapper cm=sqlss.getMapper(ClienteMapper.class);
        
        //ItemMapper cm2=sqlss.getMapper(ItemMapper.class);
        
        //TipoItemMapper cm3=sqlss.getMapper(TipoItemMapper.class);
        
        //System.out.println(cm.consultarClientes());
        //System.out.println(cm.consultarCliente(-9));
        
       
        //cm.agregarItemRentadoACliente(-21521,3,d1,d2);
        
        //String fechaLanzamiento="2020-11-25";
        //Date d3 = Date.valueOf(fechaLanzamiento);
        
        
        //TipoItem ti=cm3.getTipoItem(5);
        
        //Item item=new Item(ti,3,"miguel","estudiante de ciclos",d3,11,"hola","m");
        
        //cm2.insertarItem(item);
        
        //cm2.consultarItems();
        
        //cm2.consultarItem(2);
        
        
        sqlss.commit();
        
        
        sqlss.close();

        
        
    }


}
