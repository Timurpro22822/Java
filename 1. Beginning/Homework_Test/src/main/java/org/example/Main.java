package org.example;


import enums.QuestionType;
import models.Question;
import models.QuestionItem;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HiberContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Scanner;

import java.sql.SQLException;
import java.util.Date;

public class Main {

    // addQuestionItem
    int questionItemId;
    String text;
    boolean isTrue;

    // addQuestion
    String text2;
    QuestionType type;

    // Constructors
    public Main() { }

    public Main(int questionItemId, String text, boolean isTrue) {
        this.questionItemId = questionItemId;
        this.text = text;
        this.isTrue = isTrue;
    }
    public Main(String text2, QuestionType type) {
        this.text2 = text2;
        this.type = type;
    }
    public static void main(String[] args) {
        //userAddQuestionItem();
        userAddQuestion();
        try (Session context = HiberContext.getSessionFactory().openSession()) {

        }


//        try (Session context = HiberContext.getSessionFactory().openSession()) {
//            addQuestion("When I'll be 16 y.o.", QuestionType.RADIO_BUTTON);
//            addQuestionItem(1, "17.02.23", true);
//            addQuestionItem(1, "22.07.23", false);
//            addQuestionItem(1, "10.01.23", false);
//
//        } catch (Exception ex) {
//            System.out.println("Some error: " + ex.getMessage());
//        }
    }

    private static void userAddQuestion() {
        Scanner input = new Scanner(System.in);
        Scanner stringInput = new Scanner(System.in);
        int typeInt;
        QuestionType type = null;
        String text;

        System.out.println("Enter text for a question : ");
        text = stringInput.nextLine();

        System.out.println("Enter type of question");
        System.out.println("1 - Radio Button, 2 - Check Box, 3 - Input Text");
        typeInt = input.nextInt();
        if(typeInt == 1) {
            type = QuestionType.RADIO_BUTTON;
        }
        else if(typeInt == 2) {
            type = QuestionType.CHECK_BOX;
        }
        else if(typeInt == 3) {
            type = QuestionType.INPUT_TEXT;
        }
        else {
            System.out.println("Error, choose from 3");
        }
        Main m = new Main(text, type);
        try (Session context = HiberContext.getSessionFactory().openSession()) {
            addQuestion(m.text2, m.type);
        } catch (Exception ex) {
            System.out.println("Some error: " + ex.getMessage());
        }
    }

    private static void userAddQuestionItem() {
        Scanner input = new Scanner(System.in);
        Scanner stringInput = new Scanner(System.in);
        boolean isTrue = false;
        int forBoolean;
        int questionId;
        int countA;
        System.out.println("Enter number of answers: ");
        countA = input.nextInt();
        for (int i = 0; i < countA; i++) {
            System.out.println("Enter text for a question items: ");
            String text = stringInput.nextLine();

            System.out.println("Enter question ID: ");
            questionId = input.nextInt();

            System.out.println("Enter is this answer true or not 1 - true, 2 - not true: ");
            forBoolean = input.nextInt();

            if(forBoolean == 1) {
                isTrue = true;
            }
            else if(forBoolean == 2) {
                isTrue = false;
            }
            else {
                System.out.printf("Error choose from 1 and 2");
            }

            Main m = new Main(questionId, text, isTrue);
            try (Session context = HiberContext.getSessionFactory().openSession()) {
                addQuestionItem(m.questionItemId, m.text, m.isTrue);
            } catch (Exception ex) {
                System.out.println("Some error: " + ex.getMessage());
            }

        }
        input.close();
    }

    private static void addQuestionItem() {
        try {
            // Додаємо запитання
            //addQuestion("When I'll be 16 y.o.", QuestionType.RADIO_BUTTON);
            // Додаємо відповіді до запитань
            addQuestionItem(1, "17.02.23", true);
            addQuestionItem(1, "22.07.23", false);
            addQuestionItem(1, "10.01.23", false);
        } catch (Exception ex) {
            // Якшо вилітає еррор:
            System.out.println("Some error: " + ex.getMessage());
        }
    }

    private static void addQuestionItem(int questionId, String text,
                                        boolean isTrue) throws SQLException {
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
}

