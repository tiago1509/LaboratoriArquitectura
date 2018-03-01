/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoLabora;


import LaborModel.Estudiante;
import LaborModel.Matricula;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
        
         //Persistencia mala. Error en el create.
         
        Matricula matricula = new Matricula();
        EstudianteFacade ef = new EstudianteFacade();
        MateriaFacade mf = new MateriaFacade();
        
        matricula.setCodeSubject(mf.find(codeMate));
        matricula.setIdStudent(ef.find(id));
        
        em.getTransaction().begin();
        em.persist(matricula);
        em.getTransaction().commit();
        
        //Retorna nullpointer exception
//        Query q = em.createQuery("insert into Matricula (idEst,idMate) values (:codeMate,:id)  ");
//        q.setParameter("id", id);
//        q.setParameter("codeMate", codeMate);
//        q.executeUpdate();
       }
    
}
