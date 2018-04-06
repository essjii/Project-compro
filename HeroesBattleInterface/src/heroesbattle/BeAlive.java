
package heroesbattle;


public class BeAlive {

    private String name;
    private int health;

    public BeAlive() {
    }

    public BeAlive(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public void changeHealth(int amount) {
        this.health-=amount;
    }
    

}
