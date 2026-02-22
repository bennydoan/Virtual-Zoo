public class Hippo extends Animal {
    public Hippo(String name) {
        super(name, "Hippo");
    }

    @Override
    public void giveFood() {
        setHunger(Math.max(getHunger() - 25, 0));
        setThirst(getThirst() + 5);
        setBoredom(getBoredom() + 25);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 50);
        setLastItem("Food");
    }

    @Override
    public void giveWater() {
        setHunger(getHunger() + 5);
        setThirst(Math.max(getThirst() - 25, 0));
        setBoredom(getBoredom() + 25);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 50);
        setLastItem("Water");
    }

    @Override
    public void giveToy() {
        setHunger(getHunger() + 20);
        setThirst(getThirst() + 20);
        setBoredom(Math.max(getBoredom() - 50, 0));
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 20);
        setLastItem("Toy");
    }
}