public abstract class Animal
{

    // -*-*-*-*-*-*Create instance variable, Virtual zoo's characteristics -*-*-*-*-*-*
    private String name;
    private  String species;
    private int hunger = 50;
    private int thirst = 50;
    private  int boredom = 50;
    private boolean isDead;
    private String lastItem;



    public abstract void giveFood();

//        hunger = Math.max(0, hunger - 30);
//        thirst = Math.min(100, thirst + 15);
//        boredom = Math.min(100, boredom + 15);
//        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 30);
//        //checkStatus();


    public abstract void  giveWater();
//        hunger = Math.min(100, hunger + 15);
//        thirst = Math.max(0, thirst - 30);
//        boredom = Math.min(100, boredom + 15);
//        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 20);
//        //checkStatus();




    public abstract void giveToy();

//        hunger = Math.min(100, hunger + 15);
//        thirst = Math.min(100, thirst + 15);
//        boredom = Math.max(0, boredom - 30);
//        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 40);
//        checkStatus();


    public String getLastItem()
    {
        return lastItem;
    }

    public void setLastItem(String item)
    {
        this.lastItem = item;
    }

    // constructor for class that takes in two string parameters
    public Animal (String name , String species)
    {
        this.name = name;
        this.species =species;

    }

    // -*-*-*-*-*-*-*-*-* create setter and getter-*-*-*-*-*-*-*-*

    // setName and getName ***
    public void setName (String name)
    {
        this.name = name;
    }

    public String getName ()
    {
        return name;
    }

    // setSpecies and getSpecies ***
    public void setSpecies(String species)
    {
        this.species = species;
    }
    public String getSpecies ()
    {
        return species;
    }

    // getHunger and setHunger ***
    public void setHunger(int hunger)
    {
        this.hunger = hunger;
    }
    public int getHunger()
    {
        return hunger;
    }

    // getThirst and setThirst ***
    public void setThirst (int thirst)
    {
        this.thirst = thirst;
    }
    public int getThirst()
    {
        return thirst;
    }

    // setBoredome and getboredome ***
    public void setBoredom (int boredom)
    {
        this.boredom = boredom;
    }
    public int getBoredom()
    {
        return boredom;
    }


    // create isDead
    public boolean isDead()
    {
        return( hunger > 100 || thirst >100 || boredom > 100 );
    }



    public String toString()
    {
        String statusMessage = isDead() ? "Name = " + getName() + " (Dead)\n" : "Name = " + getName() + "\n";
        statusMessage += "Species = " + getSpecies() + "\n";
        statusMessage += "Hunger = " + getHunger() + "\n";
        statusMessage += "Thirst = " + getThirst() + "\n";
        statusMessage += "Boredom = " + getBoredom() + "\n";
        return statusMessage;
    }

}