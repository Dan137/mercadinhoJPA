/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import Util.HibernateUtil;
import java.util.ArrayList;
import model.entidade.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Maycon
 */
public class ProdutoDAO implements DaoGenerico<Produto> {

//    private Session session;
//    private SessionFactory sessionFactory;
    private List<Produto> consulta = new ArrayList<Produto>();
    private static DaoGenerico instance;
    private EntityManager entityManager = null;

    private ProdutoDAO() {

    }

    public static DaoGenerico getInstance() {
        if (instance == null) {
            instance = new ProdutoDAO();
        }

        return instance;
    }

    @Override
    public void inserir(Produto t) {
        entityManager = HibernateUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(t);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("erro ao salvar" + e);
            e.printStackTrace();
            entityManager.getTransaction().rollback();

        } finally {

            entityManager.close();
        }
    }

    @Override
    public void alterar(Produto t) {
        entityManager = HibernateUtil.getEntityManager();
        try {

            entityManager.getTransaction().begin();
            t = entityManager.merge(t);

            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("errooo! alterar o produto selecionado");
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Produto recuperar(int codigo) {
        entityManager = HibernateUtil.getEntityManager();
        Produto result = null;
        try {
            entityManager.getTransaction().begin();
            result = entityManager.find(Produto.class, codigo);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("errooo! recuperar pelo id");
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return result;

    }

    @Override
    public void deletar(Produto t) {
        entityManager = HibernateUtil.getEntityManager();
        Produto p = new Produto();
        try {
            p = entityManager.find(Produto.class, t.getCodigo());
            entityManager.getTransaction().begin();
            entityManager.remove(p);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("errooo! deletar o produto selecionado");
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();

        }

    }

    @Override
    public List<Produto> recuperarTodos() {
        entityManager = HibernateUtil.getEntityManager();
        List<Produto> result = null;
        try {
            entityManager.getTransaction().begin();
            Query consulta = entityManager.createQuery("select p from Produto p");
            result = consulta.getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("errooo recuperar produtos!");
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return result;
    }

}
