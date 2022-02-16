package org.example;

import org.example.entity.Pilot;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;

public class Connection {
    private static final Logger logger = LogManager.getLogger(Connection.class);

    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public List<String> connection() {
        final Session session = getSession();
        try {
            List<String> entityeNames = new ArrayList<String>();

            logger.info("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                logger.info("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    String name = ((Pilot) o).getName();
                    logger.info(name);
                    entityeNames.add(name);
                }
            }

            return entityeNames;
        } finally {
            session.close();
        }
    }
}
