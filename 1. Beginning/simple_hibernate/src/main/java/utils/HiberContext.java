package utils;

import models.Question;
import models.QuestionItem;
import models.Role;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HiberContext {
    private static SessionFactory sessionFactory;

    private HiberContext() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(Role.class);
            configuration.addAnnotatedClass(Question.class);
            configuration.addAnnotatedClass(QuestionItem.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());

            sessionFactory = configuration.buildSessionFactory(builder.build());
        }
        return sessionFactory;
    }
}
