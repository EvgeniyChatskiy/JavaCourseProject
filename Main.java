package JavaCourseProject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main{
    private static final String FILENAME ="toys.csv";
    
    public static void main(String[] args){
        try {
            ToyShop shop = new ToyShop();
            File toyFile = new File(FILENAME);
            
            if (!toyFile.exists()){
                shop.add(new Toy(1, "Кукла Барби", 5, 10));
                shop.add(new Toy(2, "Машинка Хот Вилс", 8, 25));
                shop.add(new Toy(3, "Мишка Тедди", 15, 65));
            }
            else {
                shop.loadFromFile(FILENAME);
            }

            ArrayList<String> toyList = shop.getToyList();
            
            for (String toy : toyList){
                System.out.println(toy);
            }
            
            ArrayList<Toy> winners = shop.playGame(1);
            System.out.println("Выиграли следующие игрушки:");
            for (Toy t : winners){
                System.out.println(t.getName());
            }
            shop.saveToFile(FILENAME);
        }
        catch (IOException e) {
            System.out.println("Ошибка при работе с файлом" + e.getMessage());
        }
    }
}