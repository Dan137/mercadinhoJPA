/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//import static org.eclipse.persistence.sessions.SessionProfiler.Transaction;

/**
 *
 * @author Daniel
 */
public class HibernateUtil {

    private static EntityManagerFactory factory;
//    private EntityManager entityManager;

    public static EntityManager getEntityManager() {

        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("projetoJPAHibernate");

        }

        return factory.createEntityManager();
    }

//   public  void fecharTransacoes(){
//       factory.close();
//       
//   }
}
