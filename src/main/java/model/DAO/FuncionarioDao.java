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
import model.entidade.Funcionario;

/**
 *
 * @author Daniel
 */
public class FuncionarioDao implements DaoGenerico<Funcionario> {

    private EntityManager entityManager = null;
    private static DaoGenerico instance = null;
    private List<Funcionario> result = null;

    private FuncionarioDao() {
    }

    public static DaoGenerico getInstance() {
        if (instance == null) {
            instance = new FuncionarioDao();
        }
        return instance;
    }

    @Override
    public void inserir(Funcionario t) {
        this.entityManager = HibernateUtil.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(t);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("ocorreu um erro ao persistir o funcionario");
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    @Override
    public void alterar(Funcionario t) {
        this.entityManager = HibernateUtil.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            t = this.entityManager.merge(t);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("ocorreu um erro ao atualizar o funcionario");
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    @Override
    public Funcionario recuperar(int codigo) {
        Funcionario fun = new Funcionario();
        this.entityManager = HibernateUtil.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            fun = this.entityManager.find(Funcionario.class, codigo);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("ocorreu um erro procurar o funcionario");
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return fun;
    }

    public List<Funcionario> recuperarpeloemail(String email) {
        this.entityManager = HibernateUtil.getEntityManager();
        List<Funcionario> funcionarios=null;
        try {
            this.entityManager.getTransaction().begin();
            Query q = this.entityManager.createNamedQuery("Funcionario.findFuncionarioForEmail");
            q.setParameter("e_mail", email);
            funcionarios = q.getResultList();
            this.entityManager.flush();
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("erro ao recuperarFuncionarios pelo email" + e);
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return funcionarios;
    }

    @Override
    public void deletar(Funcionario t) {
        Funcionario fun = new Funcionario();
        this.entityManager = HibernateUtil.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();

            fun = this.entityManager.find(Funcionario.class, t.getId());
            this.entityManager.remove(fun);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("ocorreu um erro ao deletar um funcionario");
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }

    }

    @Override
    public List<Funcionario> recuperarTodos() {
        this.entityManager = HibernateUtil.getEntityManager();

        try {
            this.entityManager.getTransaction().begin();
            Query consulta = entityManager.createQuery("select f from Funcionario f");
            this.result = consulta.getResultList();
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("ocorreu um erro procurar ao listar funcionario");
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return this.result;
    }

}
