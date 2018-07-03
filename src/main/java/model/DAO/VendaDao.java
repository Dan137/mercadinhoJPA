/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import Util.HibernateUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.entidade.Venda;

/**
 *
 * @author Daniel
 */
public class VendaDao implements DaoGenerico<Venda> {

    private List<Venda> result = null;
    private static DaoGenerico instance = null;
    private EntityManager entityManager = null;

    private VendaDao() {
    }

    public static DaoGenerico getInstance() {
        if (instance == null) {
            instance = new VendaDao();
        }
        return instance;
    }

    @Override
    public void inserir(Venda t) {
        this.entityManager = HibernateUtil.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(t);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("erro!! venda não persistida");
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    @Override
    public void alterar(Venda t) {
        this.entityManager = HibernateUtil.getEntityManager();
        try {
            this.entityManager.getTransaction().begin();
            t = this.entityManager.merge(t);
            this.entityManager.flush();
            this.entityManager.getTransaction().commit();
       } catch (Exception e) {
            System.out.println("erro ao atualizar a venda"+e);
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        }
        finally{
            this.entityManager.close();
        }
    }

    @Override
    public Venda recuperar(int codigo) {
        Venda venda = new Venda();
        entityManager = HibernateUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            venda = entityManager.find(Venda.class, codigo);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("erro ao busca a venda selecionada" + e);
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return venda;
    }

    @Override
    public void deletar(Venda t) {
        this.entityManager=HibernateUtil.getEntityManager();
        try {
            this.entityManager.getTransaction().begin();
            t = this.entityManager.find(Venda.class, t.getCodVenda());
            this.entityManager.remove(t);
            this.entityManager.flush();
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("erro ao deletar"+e);
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        }
        finally{
            this.entityManager.close();
        }
    }

    @Override
    public List<Venda> recuperarTodos() {
        this.entityManager = HibernateUtil.getEntityManager();
        try {
            this.entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("select v from Venda v");
            this.result = query.getResultList();
            this.entityManager.flush();
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("erro ao listar todas as vendas");
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return this.result;
    }

}
