package edu.eci.cvds.sampleprj.dao;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> 29281098a7b2dd3bcc8961d8038fccc41a4c1040
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.TipoItem;

public interface TipoItemDAO {
    public void save(TipoItem it) throws PersistenceException;

<<<<<<< HEAD
    public TipoItem load(int id) throws PersistenceException;

	public List<TipoItem> consultarTiposItem() throws PersistenceException;
=======
    public Item load(int id) throws PersistenceException;
>>>>>>> 29281098a7b2dd3bcc8961d8038fccc41a4c1040

}
