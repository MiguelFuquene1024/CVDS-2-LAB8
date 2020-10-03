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
package edu.eci.cvds.sampleprj.jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hcadavid
 */
public class JDBCExample {
    
    public static void main(String args[]){
        try {
            String url="jdbc:mysql://desarrollo.is.escuelaing.edu.co:3306/bdprueba";
            String driver="com.mysql.jdbc.Driver";
            String user="bdprueba";
            String pwd="prueba2019";
            
                        
            Class.forName(driver);
            Connection con=DriverManager.getConnection(url,user,pwd);
            con.setAutoCommit(false);
                 
            
            System.out.println("Valor total pedido 1:"+valorTotalPedido(con, 1));
       
            List<String> prodsPedido=nombresProductosPedido(con, 1);
            
            
            System.out.println("Productos del pedido 1:");
            System.out.println("-----------------------");
            for (String nomprod:prodsPedido){
                System.out.println(nomprod);
            }
            System.out.println("-----------------------");
            
            
            int suCodigoECI=2158513;
            registrarNuevoProducto(con, suCodigoECI, "Miguel fuquene", 99999999);            
            con.commit();
                        
            
            con.close();
                                   
        } catch (ClassNotFoundException | SQLException ex) {
        	System.out.println("algo salio mal");
            Logger.getLogger(JDBCExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    /**
     * Agregar un nuevo producto con los parámetros dados
     * @param con la conexión JDBC
     * @param codigo
     * @param nombre
     * @param precio
     * @throws SQLException 
     */
    public static void registrarNuevoProducto(Connection con, int codigo, String nombre,int precio) throws SQLException{
    	PreparedStatement ps;//Crear preparedStatement
    	ps=con.prepareStatement("INSERT INTO ORD_PRODUCTOS (codigo,nombre,precio) VALUES (?,?,?)");
    	//ps=con.prepareStatement("DELETE FROM ORD_PRODUCTOS WHERE codigo = ? and nombre = ? and precio=?");
    	ps.setInt(1,codigo);//Asignar parámetros
    	ps.setString(2,nombre);
    	ps.setInt(3,precio);
        ps.execute(); //usar 'execute'

        
        con.commit();
        
    }
    
    /**
     * Consultar los nombres de los productos asociados a un pedido
     * @param con la conexión JDBC
     * @param codigoPedido el código del pedido
     * @return 
     * @throws SQLException 
     */
    public static List<String> nombresProductosPedido(Connection con, int codigoPedido) throws SQLException{
        List<String> np=new LinkedList<>();
		
        PreparedStatement ps; //Crear prepared statement
        ps=con.prepareStatement("SELECT pr.nombre " + 
        						"FROM ORD_PRODUCTOS AS pr " + 
        						"INNER JOIN ORD_DETALLE_PEDIDO AS pe " + 
        						"ON pr.codigo=pe.producto_fk " + 
        						"where pe.pedido_fk=?"); 

        ps.setInt(1,codigoPedido);//asignar parámetros
        ResultSet respuesta=ps.executeQuery();//usar executeQuery
        //Sacar resultados del ResultSet
        while(respuesta.next()) {

        	np.add(respuesta.getString("pr.nombre"));//Llenar la lista y retornarla
        }
        
        return np;
    }

    
    /**
     * Calcular el costo total de un pedido
     * @param con
     * @param codigoPedido código del pedido cuyo total se calculará
     * @return el costo total del pedido (suma de: cantidades*precios)
     * @throws SQLException 
     */
    public static int valorTotalPedido(Connection con, int codigoPedido) throws SQLException{
        
    	PreparedStatement ps;//Crear prepared statement
    	ps=con.prepareStatement("SELECT SUM(pr.precio * pe.cantidad) " + 
    							"FROM ORD_PRODUCTOS AS pr " + 
    							"INNER JOIN ORD_DETALLE_PEDIDO AS pe " + 
    							"ON pr.codigo=pe.producto_fk " + 
    							"where pe.pedido_fk=?");
  
    	ps.setInt(1,codigoPedido);//asignar parámetros//asignar parámetros
    	ResultSet respuesta=ps.executeQuery();//usar executeQuery
    	int rta=1;
    	while(respuesta.next()) {
    		rta = respuesta.getInt("SUM(pr.precio * pe.cantidad)");
    	}
    	
        return rta;
    }
    

    
    
    
}