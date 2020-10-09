package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.TipoItem;

public interface TipoItemDAO {
    public void save(TipoItem it) throws PersistenceException;

    public Item load(int id) throws PersistenceException;

}
