package program;

import enums.QuestionType;
import models.Question;
import models.QuestionItem;
import models.Role;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HiberContext;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

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

//        testRole();

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
