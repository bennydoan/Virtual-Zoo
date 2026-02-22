public class Tiger extends Animal {
    public Tiger(String name) {
        super(name, "Tiger");
    }

    @Override
    public void giveFood() {
        setHunger(Math.max(getHunger() - 30, 0));
        setThirst(getThirst() + 15);
        setBoredom(getBoredom() + 15);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 30);
        setLastItem("Food");
    }

    @Override
    public void giveWater() {
        setHunger(getHunger() + 15);
        setThirst(Math.max(getThirst() - 30, 0));
        setBoredom(getBoredom() + 15);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 20);
        setLastItem("Water");
    }

    @Override
    public void giveToy() {
        setHunger(getHunger() + 15);
        setThirst(getThirst() + 15);
        setBoredom(Math.max(getBoredom() - 30, 0));
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 40);
        setLastItem("Toy");
    }
}