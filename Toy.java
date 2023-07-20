package JavaCourseProject;

class Toy {
    private int id;
    private String name;
    private int quantity;
    private int chance;
    
    public Toy(int id, String name, int quantity, int chance){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.chance = chance;
    }
    
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    public int getChance(){
        return chance;
    }
    
    public void setChance(int chance){
        this.chance = chance;
    }
}
