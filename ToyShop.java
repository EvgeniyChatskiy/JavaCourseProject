package JavaCourseProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ToyShop {

    private ArrayList<Toy> toys;
    
    public ToyShop(){
        toys = new ArrayList<>();
    }
    
    public void add(Toy toy){
        boolean foundToy = false;
        for (Toy t: toys){
            if (t.getId() == toy.getId()){
                t.setQuantity(t.getQuantity() + toy.getQuantity());
                foundToy = true;
                break;
            }
        }
            
        if (!foundToy){
            toys.add(toy); 
        }
    }

    public ArrayList<String> getToyList(){
        ArrayList<String> toyList = new ArrayList<>();
        for (Toy t : toys){
            toyList.add("ID: " + t.getId() + ", Название: " + t.getName() + ", Количество: " + t.getQuantity() + ", Шанс выпадения: " + t.getChance() + "%");
        }
        return toyList;
    }
    
    public ArrayList<Toy> playGame(int count){
        ArrayList<Toy> winners = new ArrayList<>();
        
        Random random = new Random();
        for (int i = 0; i < count; i++){
            int randomNumber = random.nextInt(1, 100);
            for (Toy t : toys){
                if (randomNumber <= t.getChance()){
                    if (t.getQuantity() > 0){
                        winners.add(t);
                        t.setQuantity(t.getQuantity() - 1);
                    }
                    break;
                }
            }
        }
        return winners;
    }
    
    public void saveToFile(String filename) throws IOException{
        try (FileWriter writer = new FileWriter(new File(filename))){
            for (Toy t : toys){
                writer.write(t.getId() + ", " + t.getName() + ", " + t.getQuantity() + ", " + t.getChance() + "\n");
            }
        }
    }
    
    public void loadFromFile(String filename) throws IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(filename)))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] toyData = line.split(", ");
                Toy toy = new Toy(Integer.parseInt(toyData[0]), toyData[1], Integer.parseInt(toyData[2]), Integer.parseInt(toyData[3]));
                toys.add(toy);
            }
        }
    }
}

