package br.com.yukio.util;

import br.com.yukio.model.Carro;
import br.com.yukio.model.Cliente;
import br.com.yukio.model.Oficina;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author Vinicius Yukio Vatanabi
 * @version 1.2
 * @since 12/11/2021 - 22:29
 **/
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration().configure();
            configuration.addPackage("br.com.prog3.aula9.model");
            configuration.addAnnotatedClass(Carro.class);
            configuration.addAnnotatedClass(Cliente.class);
            configuration.addAnnotatedClass(Oficina.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
}