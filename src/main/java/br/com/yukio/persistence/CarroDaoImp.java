package br.com.yukio.persistence;

import br.com.yukio.model.Carro;
import br.com.yukio.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * @author Vinicius Yukio Vatanabi
 * @version 1.2
 * @since 12/11/2021 - 22:29
 **/
public class CarroDaoImp implements CarroDao {

    @Override
    public void incluir(Carro veiculo) {
        Session session = null;
        try {
            SessionFactory sessionFactory =
                    HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(veiculo);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void alterar(Carro veiculo) {
        Session session = null;
        try {
            SessionFactory sessionFactory =
                    HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(veiculo);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void excluir(Carro veiculo) {
        Session session = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(veiculo);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Carro> listarTodos() {
        Session session = null;
        List<Carro> lista = null;
        try {
            SessionFactory sessionFactory =
                    HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            lista = (List<Carro>) session.createQuery("from Carro").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            return lista;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return lista;
    }

    @Override
    public Carro buscarPelaPlaca(String placa) {
        Session session = null;
        Carro veiculo = new Carro();
        try {
            SessionFactory sessionFactory =
                    HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            veiculo = session.load(Carro.class, placa);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return veiculo;
    }
}
