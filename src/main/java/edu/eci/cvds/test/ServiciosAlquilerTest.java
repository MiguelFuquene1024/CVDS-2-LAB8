package edu.eci.cvds.test;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.ExcepcionServicioAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquilerFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class ServiciosAlquilerTest {

    
    @Inject
    private final ServiciosAlquiler serviciosAlquiler;

    public ServiciosAlquilerTest() throws ExcepcionServicioAlquiler {
        serviciosAlquiler = ServiciosAlquilerFactory.getInstance().getServiciosAlquilerTesting();
        TipoItem ti1=new TipoItem(1,"Video");
        TipoItem ti2=new TipoItem(2,"Juego");
        TipoItem ti3=new TipoItem(3,"Musica");
        //serviciosAlquiler.registrarItem();//tipositems.put(1,ti1);
        //tipositems.put(2,ti2);
        //tipositems.put(3,ti3);

        Item i1=new Item(ti1, 1, "Los 4 Fantasticos", "Los 4 Fantásticos  es una película de superhéroes  basada en la serie de cómic homónima de Marvel.", java.sql.Date.valueOf("2005-06-08"), 2000, "DVD", "Ciencia Ficcion");
        Item i2=new Item(ti2, 2, "Halo 3", "Halo 3 es un videojuego de disparos en primera persona desarrollado por Bungie Studios.", java.sql.Date.valueOf("2007-09-08"), 3000, "DVD", "Shooter");
        Item i3=new Item(ti3, 3, "Thriller", "Thriller es una canción interpretada por el cantante estadounidense Michael Jackson, compuesta por Rod Temperton y producida por Quincy Jones.", java.sql.Date.valueOf("1984-01-11"), 2000, "DVD", "Pop");
        Item i4=new Item(ti1, 4, "Los 4 Fantasticos", "Los 4 Fantásticos  es una película de superhéroes  basada en la serie de cómic homónima de Marvel.", java.sql.Date.valueOf("2005-06-08"), 2000, "DVD", "Ciencia Ficcion");
        Item i5=new Item(ti2, 5, "Halo 3", "Halo 3 es un videojuego de disparos en primera persona desarrollado por Bungie Studios.", java.sql.Date.valueOf("2007-09-08"), 3000, "DVD", "Shooter");
        Item i6=new Item(ti3, 6, "Thriller", "Thriller es una canción interpretada por el cantante estadounidense Michael Jackson, compuesta por Rod Temperton y producida por Quincy Jones.", java.sql.Date.valueOf("1984-01-11"), 2000, "DVD", "Pop");
        serviciosAlquiler.registrarItem(i1);//items.put(1, i1);
        serviciosAlquiler.registrarItem(i2);//items.put(2, i2);
        serviciosAlquiler.registrarItem(i3);//items.put(3, i3);
        serviciosAlquiler.registrarItem(i4);//itemsDisponibles.put(4, i4);
        serviciosAlquiler.registrarItem(i5);//itemsDisponibles.put(5, i5);
        serviciosAlquiler.registrarItem(i6);//itemsDisponibles.put(6, i6);

        ItemRentado ir1=new ItemRentado(0,i1, java.sql.Date.valueOf("2017-01-01"), java.sql.Date.valueOf("2017-03-12"));
        ItemRentado ir2=new ItemRentado(0,i2, java.sql.Date.valueOf("2017-01-04"), java.sql.Date.valueOf("2017-04-7"));
        ItemRentado ir3=new ItemRentado(0,i1, java.sql.Date.valueOf("2017-01-07"), java.sql.Date.valueOf("2017-07-12"));

        ArrayList<ItemRentado> list1 = new ArrayList<>();
        list1.add(ir1);
        ArrayList<ItemRentado> list2 = new ArrayList<>();
        list2.add(ir2);
        ArrayList<ItemRentado> list3 = new ArrayList<>();
        list3.add(ir3);

        Cliente c1=new Cliente("Oscar Alba", 1026585664, "6788952", "KRA 109#34-C30", "oscar@hotmail.com", false,list1);
        Cliente c2=new Cliente("Carlos Ramirez", 1026585663, "6584562", "KRA 59#27-a22", "carlos@hotmail.com", false,list2);
        Cliente c3=new Cliente("Ricardo Pinto", 1026585669, "4457863", "KRA 103#94-a77", "ricardo@hotmail.com", false,list3);
        serviciosAlquiler.registrarCliente(c1);//clientes.put(c1.getDocumento(), c1);
        serviciosAlquiler.registrarCliente(c2);//clientes.put(c2.getDocumento(), c2);
        serviciosAlquiler.registrarCliente(c3);//clientes.put(c3.getDocumento(), c3);

    }

    @Before
    public void setUp() {
    }

    @Test
    public void emptyDB() {
        for(int i = 0; i < 100; i += 10) {
            boolean r = false;
            try {
                Cliente cliente = serviciosAlquiler.consultarCliente(i);
            } catch(ExcepcionServicioAlquiler e) {
                r = true;
            } catch(IndexOutOfBoundsException e) {
                r = true;
            }
            // Validate no Client was found;
            Assert.assertTrue(!r);
        };
    }
    
    
    @Test
    public void consultarClienteExistente() throws ExcepcionServicioAlquiler {
    	
    	Cliente c=serviciosAlquiler.consultarCliente(1026585664);
    	
    	Assert.assertTrue(c.getDocumento()==1026585664 && c.getNombre().contentEquals("Oscar Alba"));
    }
    
    @Test
    public void consultarClienteNoExistente() throws ExcepcionServicioAlquiler {
    	
    	Cliente c=serviciosAlquiler.consultarCliente(1001);
    	
    	Assert.assertNull(c);
    }
    
    
    @Test
    public void ConsultarItemExistente() throws ExcepcionServicioAlquiler {
    	
    	Item i=serviciosAlquiler.consultarItem(1);
    	
    	Assert.assertTrue(i.getId()==1 && i.getGenero().contentEquals("Ciencia Ficcion"));
    }
    
    @Test
    public void ConsultarItemNoExistente() throws ExcepcionServicioAlquiler {
    	
    	Item i=serviciosAlquiler.consultarItem(100);
    	
    	Assert.assertNull(i);
    }
    
    
    @Test
    public void consultarItemsClientes() throws ExcepcionServicioAlquiler {
    	
    	List<ItemRentado> l=serviciosAlquiler.consultarItemsCliente(2);
    	Assert.assertTrue(l.size()==0);
    }
    
    
    
    @Test
    public void RegistrarCliente() throws ExcepcionServicioAlquiler {
    	Cliente c1=serviciosAlquiler.consultarCliente(12);
    	serviciosAlquiler.registrarCliente(new Cliente("Oscar Alba", 12, "6788952", "KRA 109#34-C30", "oscar@hotmail.com"));
    	Cliente c2=serviciosAlquiler.consultarCliente(11);
    	Assert.assertTrue(c1==null && c2!=null);
    }
    
    
    @Test
    public void RegistrarItem() throws ExcepcionServicioAlquiler {
    	
    	TipoItem ti3=new TipoItem(3,"Musica");
    	Item i1=serviciosAlquiler.consultarItem(23);
    	System.out.println();
    	serviciosAlquiler.registrarItem(new Item(ti3, 23, "Thriller", "Thriller es una canción interpretada por el cantante estadounidense Michael Jackson, compuesta por Rod Temperton y producida por Quincy Jones.", java.sql.Date.valueOf("1984-01-11"), 2000, "DVD", "Pop"));
    	Item i2=serviciosAlquiler.consultarItem(23);
    	Assert.assertTrue(i1==null && i2!=null);
    }
    
    
    
    
}