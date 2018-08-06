/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.impl;

import Util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import model.DAO.UsuarioDao;
import model.entidade.Usuario;

/**
 *0
 * @author Daniel
 */
public class UsuarioDaoImpl implements UsuarioDao {

    private EntityManager entityManager = null;
    private List<Usuario> usuarios = null;
    private static UsuarioDao instance;

    private UsuarioDaoImpl() {
        this.usuarios = new ArrayList<>();
    }

    public static UsuarioDao getInstance() {
        if (instance == null) {
            instance = new UsuarioDaoImpl();
        }
        return instance;
    }

    @Override
    public void inserir(Usuario t) {
        this.entityManager = HibernateUtil.getEntityManager();
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(t);
            this.entityManager.flush();
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("erro ao salvar o usuario" + e);
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    @Override
    public void alterar(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario recuperar(int codigo) {
        this.entityManager = HibernateUtil.getEntityManager();
        Usuario usuario = null;
        try {
            this.entityManager.getTransaction().begin();
            usuario = this.entityManager.find(Usuario.class, codigo);
            this.entityManager.flush();
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("erro listar usuario" + e);
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return usuario;
    }

    @Override
    public void deletar(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> recuperarTodos() {
        this.entityManager = HibernateUtil.getEntityManager();
        try {

            this.usuarios = this.entityManager.createQuery("SELECT usuario FROM Usuario usuario").getResultList();

        } catch (Exception e) {
            System.out.println("erro listar usuario" + e);

        } finally {
            this.entityManager.close();
        }
        return this.usuarios;
    }

    @Override
    public Usuario autenticar(String senha, String user) {
        this.entityManager = HibernateUtil.getEntityManager();
        List<Usuario> usuario = new ArrayList<>();
        try {

            Query query = this.entityManager.createNamedQuery("Usuario.autenticar");
//            Query query = this.entityManager.createQuery("SELECT usuario FROM Usuario usuario WHERE usuario.senha = :senha AND usuario.user = :user");
            query.setParameter("senha", senha);
            query.setParameter("user", user);

            usuario = query.getResultList();
            if (usuario.isEmpty()) {
                return null;
            }

        } catch (Exception e) {

            System.out.println("usuário ou senha não confere" + e);

        } finally {
            this.entityManager.close();
        }
        return usuario.get(0);
    }

}
