/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vivarcyan.controller;

import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import vivarcyan.model.entities.Facultad;
import vivarcyan.model.manager.ManagerFacultad;

/**
 *
 * @author David
 */
@ManagedBean
@SessionScoped
public class ControllerFacultad {
    
    private String nombrefacultad;
    private int idfacultad;
    private String universidad;
    private Facultad facultad;
    @EJB
    ManagerFacultad facultadManager;
   
    public void crearFacultad()throws Exception{
        try{
    facultadManager.nuevaFacultad(idfacultad,nombrefacultad, universidad);
            System.out.println("registro "+nombrefacultad +" exitoso...");
        }catch(Exception e){
            System.out.println("no hubo registro");
        }
    
    }
    public void buscarFacultad() throws Exception{
        facultad=facultadManager.findFacultadById(idfacultad);
    }

    public String getNombrefacultad() {
        return nombrefacultad;
    }

    public void setNombrefacultad(String nombrefacultad) {
        this.nombrefacultad = nombrefacultad;
    }

    public int getIdfacultad() {
        return idfacultad;
    }

    public void setIdfacultad(int idfacultad) {
        this.idfacultad = idfacultad;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }
}
