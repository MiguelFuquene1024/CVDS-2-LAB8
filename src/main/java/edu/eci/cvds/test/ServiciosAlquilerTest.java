package edu.eci.cvds.test;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.ItemRentado;
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
        Cliente c1=new Cliente("Oscar Alba", 1026585664, "6788952", "KRA 109#34-C30", "oscar@hotmail.com");
        Cliente c2=new Cliente("Carlos Ramirez", 1026585663, "6584562", "KRA 59#27-a22", "carlos@hotmail.com");
        Cliente c3=new Cliente("Ricardo Pinto", 1026585669, "4457863", "KRA 103#94-a77", "ricardo@hotmail.com");
        serviciosAlquiler.registrarCliente(c1);
        serviciosAlquiler.registrarCliente(c2);
        serviciosAlquiler.registrarCliente(c3);

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
    	
    	Cliente c=serviciosAlquiler.consultarCliente(10);
    	
    	Assert.assertNull(c);
    }
    
    
    @Test
    public void consultarClienteNoExistenfte() throws ExcepcionServicioAlquiler {
    	
    	Cliente c=serviciosAlquiler.consultarCliente(10);
    	
    	Assert.assertNull(c);
    }
    
    
    
    
    
    
    
    
}