/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.impl;

import Util.Erros;
import Util.HibernateUtil;
import Util.Messages;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.DAO.ClienteDao;
import model.entidade.Cliente;

/**
 *
 * @author Daniel
 */
public class ClienteDaoImpl implements ClienteDao {

    private EntityManager entityManager = null;
    private List<Cliente> clientes = null;
    private static ClienteDao instance = null;

    private ClienteDaoImpl() {
        this.clientes = new ArrayList<>();
    }

    public static ClienteDao getInstance() {
        if (instance == null) {
            instance = new ClienteDaoImpl();
        }
        return instance;
    }

    @Override
    public void inserir(Cliente t) throws Erros {
        this.entityManager = HibernateUtil.getEntityManager();
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(t);
            this.entityManager.flush();
            this.entityManager.getTransaction().commit();
    
            this.entityManager.close();
        
    }

    @Override
    public void alterar(Cliente t) {
        entityManager = HibernateUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            t = entityManager.merge(t);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("erro ao alterar o cliente" + e);
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Cliente recuperar(int codigo) {
        this.entityManager = HibernateUtil.getEntityManager();
        Cliente cliente = null;
        try {
            this.entityManager.getTransaction().begin();
            cliente = this.entityManager.find(Cliente.class, codigo);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {

            System.out.println("erro ao consultar um cliente" + e);
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();

        } finally {
            this.entityManager.close();
        }
        return cliente;
    }

    @Override
    public void deletar(Cliente t) {
        Cliente c = new Cliente();
        this.entityManager = HibernateUtil.getEntityManager();

        try {
            c = this.entityManager.find(Cliente.class, t.getCodigo());
            this.entityManager.getTransaction().begin();
            entityManager.remove(c);
            this.entityManager.flush();
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("ocorreu um erro ao deletar" + e);
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    @Override
    public List<Cliente> recuperarTodos() {
        entityManager = HibernateUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query consult = entityManager.createQuery("select c from Cliente c");
            clientes = consult.getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("erro do programador");
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return clientes;

    }

    @Override
    public Cliente recuperarPorCPF(String cpf) {
        this.entityManager = HibernateUtil.getEntityManager();

        Query consulta = this.entityManager.createNamedQuery("Cliente.buscaPorCPF");
        consulta.setParameter("cpf", cpf);
        
        List <Cliente> c = consulta.getResultList();

        if(!(c.isEmpty())){
            return  c.get(0);
        }
        return null;
    }

}
