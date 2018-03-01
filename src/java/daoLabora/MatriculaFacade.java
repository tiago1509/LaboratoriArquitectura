/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoLabora;


import LaborModel.Estudiante;
import LaborModel.Materia;
import LaborModel.Matricula;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Santiago
 */
@Stateless
public class MatriculaFacade extends AbstractFacade<Matricula> implements MatriculaFacadeLocal {

    @PersistenceContext(unitName = "Laboratorio1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MatriculaFacade() {
        super(Matricula.class);
    }

    @Override
     public void matricula(int codeMate, int id) {
        
        Matricula matricula = new Matricula();
        Estudiante ef = new Estudiante();
        Materia mf = new Materia();
        MatriculaFacade maf = new MatriculaFacade();

        //Envio código de estudiante a un objeto del mismo tipo
        ef.setId(id);
          
        //Envio código de materia a un objeto del mismo tipo
        mf.setCode(codeMate);
  
        matricula.setId(2); //Hay que generar un id para la matricula(Random num)
        
        matricula.setCodeSubject(mf); //Introduzco en la matricula la info de la materia
        matricula.setIdStudent(ef);  //Introduzco en la matricula la info del estudiante

        em.persist(matricula); //Inserción en base de datos
       }
    
}
