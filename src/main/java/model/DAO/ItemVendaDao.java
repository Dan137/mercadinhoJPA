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
import model.entidade.ItemVenda;

/**
 *
 * @author Daniel
 */
public class ItemVendaDao implements DaoGenerico<ItemVenda> {

    private EntityManager entityManager = null;
    private static DaoGenerico instance = null;
    private List<ItemVenda> itensVendas = null;

    private ItemVendaDao() {
    }

    public static DaoGenerico getInstance() {
        if (instance == null) {
            instance = new ItemVendaDao();
        }
        return instance;
    }

    @Override
    public void inserir(ItemVenda t) {
        this.entityManager = HibernateUtil.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(t);
            this.entityManager.flush();
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("ocorreu um erro ao salvar o item");
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    @Override
    public void alterar(ItemVenda t) {
        this.entityManager = HibernateUtil.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            t = this.entityManager.merge(t);
            this.entityManager.flush();
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("erro ao alterar um item");
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    @Override
    public ItemVenda recuperar(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(ItemVenda t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ItemVenda> recuperarTodos() {
        this.entityManager = HibernateUtil.getEntityManager();
        try {
            this.entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("select iv from ItemVenda iv");
            this.itensVendas = query.getResultList();
            this.entityManager.flush();
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("erro ao recuperar todos os itens"+e);
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        }
        finally{
            this.entityManager.close();
        }
        return this.itensVendas;
    }

}
