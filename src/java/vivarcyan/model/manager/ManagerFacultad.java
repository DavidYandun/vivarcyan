/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vivarcyan.model.manager;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import vivarcyan.model.entities.Facultad;

/**
 *
 * @author David
 */
@Stateless
public class ManagerFacultad {

    @PersistenceContext(unitName = "carlitosDS")
    private EntityManager em;
    
    public void nuevaFacultad(int idfacultad, String nombrefacultad, String universidad) {
        Facultad f = new Facultad();
        f.setIdfacultad(idfacultad);
        f.setNombrefacultad(nombrefacultad);
        f.setUniversidad(universidad);
        em.persist(f);
    }
    
    public Facultad findFacultadById(int idfacultad) throws Exception {
        Query q = em.createNamedQuery("Facultad.findByIdfacultad", Facultad.class);
        q.setParameter("idfacultad", idfacultad);
        Facultad facultad = (Facultad) q.getSingleResult();
        return facultad;        
    }
}
