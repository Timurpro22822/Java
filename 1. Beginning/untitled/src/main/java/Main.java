import java.sql.*;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        testArray();
        SortArray();

        String connectionStr = "jdbc:mariadb://localhost:3306/java_spu013";
        try(Connection con = DriverManager.getConnection(connectionStr, "root", "")) {
            System.out.println("Successful Connection!");
            String query = "SELECT * FROM categories";
            PreparedStatement command = con.prepareStatement(query);
            ResultSet resultSet = command.executeQuery();
            while(resultSet.next())
            {
                System.out.println("Id: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
            }

        }
        catch(Exception ex) {
            System.out.println("Connection Error!" + ex.getMessage());
        }

        //switch, if, ||, &&, ==, !=, >, <, >=, <= - аналогічно як в С#
        //String str ="Гарно погода сьогодні";
        //System.out.println(str);
        //str = input.nextLine();
        //System.out.println(str);
        //System.out.println("Вкажіть значеня a:");
        // a = input.nextInt();
        //float, double, short, boolean, byte, char,
        //System.out.println("Привіт комнада a = "+ a);
    }
    public static void testArray()
    {
        Scanner input = new Scanner(System.in);
        int n = 10;
        int[] mas = new int[n];
        for (int i = 0; i < n; i++)
            mas[i] = getRandomNumber(-10, 20);

        for (int item : mas)
            System.out.printf("%d\t", item);
        System.out.println();
        int count = 0;
        for (int item : mas) {
            if(item>=0)
                count++;
        }
        System.out.println("Кількість додатніх чисел "+ count);
    }

    public static void SortArray()
    {
        Person[] list = {
                new Person("Іван", "Музичко"),
                new Person("Оксана", "Марко"),
                new Person("Василь", "Шлунок"),
                new Person("Вікторія", "Закуска"),
                new Person("Олег", "Закуска"),
                new Person("Артур", "Закуска")
        };

        for (Person p : list)
            System.out.println(p);

        Arrays.sort(list /*, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        }*/);

        System.out.println("------Сортований список-------");
        for (Person p : list)
            System.out.println(p);
    }
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
