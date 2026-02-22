public class Giraffe extends Animal {
    public Giraffe(String name) {
        super(name, "Giraffe");
    }

    @Override
    public void giveFood() {
        setHunger(Math.max(getHunger() - 50, 0));
        setThirst(getThirst() + 30);
        setBoredom(getBoredom() + 20);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 100);
        setLastItem("Food");
    }

    @Override
    public void giveWater() {
        setHunger(getHunger() + 20);
        setThirst(Math.max(getThirst() - 50, 0));
        setBoredom(getBoredom() + 30);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 40);
        setLastItem("Water");
    }

    @Override
    public void giveToy() {
        setHunger(getHunger() + 30);
        setThirst(getThirst() + 10);
        setBoredom(Math.max(getBoredom() - 40, 0));
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 75);
        setLastItem("Toy");
    }
}