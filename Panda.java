public class Panda extends Animal {
    public Panda(String name) {
        super(name, "Panda");
    }

    @Override
    public void giveFood() {
        setHunger(Math.max(getHunger() - 25, 0));
        setThirst(getThirst() + 15);
        setBoredom(Math.max(getBoredom() - 5, 0));
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 70);
        setLastItem("Food");
    }

    @Override
    public void giveWater() {
        setHunger(getHunger() + 40);
        setThirst(Math.max(getThirst() - 80, 0));
        setBoredom(getBoredom() + 10);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 5);
        setLastItem("Water");
    }

    @Override
    public void giveToy() {
        setHunger(getHunger() + 40);
        setThirst(getThirst() + 15);
        setBoredom(Math.max(getBoredom() - 40, 0));
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 20);
        setLastItem("Toy");
    }
}