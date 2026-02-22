public class Monkey extends Animal {
    public Monkey(String name) {
        super(name, "Monkey");
    }

    @Override
    public void giveFood() {
        setHunger(Math.max(getHunger() - 30, 0));
        setThirst(getThirst() + 10);
        setBoredom(getBoredom() + 10);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 5);
        setLastItem("Food");
    }

    @Override
    public void giveWater() {
        setHunger(getHunger() + 10);
        setThirst(Math.max(getThirst() - 40, 0));
        setBoredom(getBoredom() + 10);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 5);
        setLastItem("Water");
    }

    @Override
    public void giveToy() {
        setHunger(getHunger() + 10);
        setThirst(getThirst() + 10);
        setBoredom(Math.max(getBoredom() - 15, 0));
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 15);
        setLastItem("Toy");
    }
}