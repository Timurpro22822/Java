package utils;

import models.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HiberContext {
    private static SessionFactory sessionFactory;

    private HiberContext() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            // Читаємо конфігурацію
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(Role.class);
            configuration.addAnnotatedClass(Question.class);
            configuration.addAnnotatedClass(QuestionItem.class);
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(UserRole.class);
            configuration.addAnnotatedClass(Category.class);
            configuration.addAnnotatedClass(Product.class);
            configuration.addAnnotatedClass(ProductImage.class);
            configuration.addAnnotatedClass(Orders.class);
            configuration.addAnnotatedClass(OrderStatuses.class);
            configuration.addAnnotatedClass(Baskets.class);
            configuration.addAnnotatedClass(OrderItems.class);
            configuration.addAnnotatedClass(FilterNames.class);
            configuration.addAnnotatedClass(FilterValues.class);
            configuration.addAnnotatedClass(FilterNameGroups.class);
            configuration.addAnnotatedClass(Filters.class);
            // Реєструємо сорвіс на сонові нашого конфіга
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());

            // Створюємо контекст до БД
            sessionFactory = configuration.buildSessionFactory(builder.build());
        }
        return sessionFactory;
    }
}
