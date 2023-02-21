package program;

import enums.QuestionType;
import models.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HiberContext;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //testRole();
        //addUserAndRoles();
        //addCategory("Laptop", "1.jpg");
        //addProduct();
        // ------
        // добавлення тестових данних щоб перевірити чи працюють зв'язки
        //addOrder();
        //addOrderStatuses();

        try(Session context = HiberContext.getSessionFactory().openSession()) {

        }

    }
    // добавлення тестових данних щоб перевірити чи працюють зв'язки
    private static void addOrderStatuses() {
        try(Session context = HiberContext.getSessionFactory().openSession()) {
            Transaction tx = context.beginTransaction();
            OrderStatuses oS =
                    new OrderStatuses(false, new Date(), "Delivered");
            context.save(oS);
            tx.commit();
        }
    }
    private static void addOrder() {
        try(Session context = HiberContext.getSessionFactory().openSession()) {
            Transaction tx = context.beginTransaction();
            var cat = context.get(OrderStatuses.class, 1);
            var cat2 = context.get(User.class, 1);
            Orders o =
                    new Orders(new Date(), false, cat, cat2);
            context.save(o);
            tx.commit();
        }
    }
    // Добавлення продукта
    private static void addProduct() {
        try(Session context = HiberContext.getSessionFactory().openSession()) {
            Transaction tx = context.beginTransaction();
            var cat = context.get(Category.class, 1);
            Product p =
                    new Product(new Date(), false, "Hammer", "Some hammer", cat);
            context.save(p);
            ProductImage pi = new ProductImage(new Date(), false, "1.jpg", 1, p);
            ProductImage pi2 = new ProductImage(new Date(), false, "2.jpg", 1, p);
            context.save(pi);
            context.save(pi2);
            tx.commit();
        }
    }
    // Метод на добавлення категорії, в параметри передаємо ім'я та "зображення"
    private static void addCategory(String name, String image) {
        try(Session context = HiberContext.getSessionFactory().openSession()) {
            Category category = new Category(name, image, new Date(), false);
            context.save(category);
        }
    }
    private static void addUserAndRoles() {
        // Робимо через try бо воно як начеб то має само закривато зв'язок з базою
        try(Session context = HiberContext.getSessionFactory().openSession()) {
            Transaction tx = context.beginTransaction();
            Role role = new Role();
            role.setName("testRole.1");
            context.save(role);
            User user = new User("Ivan", "Truskavec", "ivan@gmail.com",
                    "+380976543233", "098642");
            context.save(user);
            UserRole ur = new UserRole();
            ur.setRole(role);
            ur.setUser(user);
            context.save(ur);
            tx.commit();
        }
    }
    private static void addQuestionItem() {
        try {
            // Додаємо запитання
            //addQuestion("When I'll be 16 y.o.", QuestionType.RADIO_BUTTON);
            // Додаємо відповіді до запитань
            addQuestionItem(1, "17.02.23", true);
            addQuestionItem(1, "22.07.23", false);
            addQuestionItem(1, "10.01.23", false);
        }catch (Exception ex) {
            // Якшо вилітає еррор:
            System.out.println("Some error: " + ex.getMessage());
        }
    }

    private static void addQuestionItem(int questionId, String text,
                                        boolean isTrue ) throws SQLException {
        // Підключення до БД
        Session session = HiberContext.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Question question = new Question();
        // Встановлюємо ID для question(ID ми передаємо в параметри функції addQuestionItem)
        question.setId(questionId);
        // Передаємо саме запитання, текст варіантів і перевірку чи цей варіант є вірним
        QuestionItem qi = new QuestionItem(question, text, isTrue);
        session.save(qi);
        tx.commit();
        session.close();
    }

    private static void addQuestion(String text, QuestionType type) throws SQLException {
        // Підключення до БД
        Session context = HiberContext.getSessionFactory().openSession();

        Transaction tx = context.beginTransaction();
        Question question = new Question();
        // Створюємо запитання передаючи текст самого запитання
        question.setText(text);
        // Встановлюємо тип запитання(RADIO_BUTTON, CHECK_BOX, INPUT_TEXT)
        question.setQuestionType(type);
        context.save(question);
        tx.commit();

        context.close();
    }
    private static void testRole() {
        Scanner in = new Scanner(System.in);
        System.out.println("Hello Java");
//        System.out.println("Enter name of role: ");
//        Role role = new Role();
//        String name = in.nextLine();
//        role.setName(name);

        Session context = HiberContext.getSessionFactory().openSession();
//        context.save(role);
//        System.out.println("Role id = " + role.getId());
        Query query = context.createQuery("FROM Role");
        List<Role> roles = query.list();
        for (Role role : roles)
            System.out.println(role);
        context.close();
    }
}
