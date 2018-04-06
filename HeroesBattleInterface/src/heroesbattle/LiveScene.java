
package heroesbattle;


public class LiveScene extends BeAlive implements CanBeAttacked{
    private Armor armor;

    public LiveScene(String name, int health, Armor armor) {
        super(name, health);
        this.armor = armor;
    }
    
    public void beAttacked(CanAttack obj){
        super.changeHealth(obj.getAttackPower()-armor.useArmor());
    }
    
    public void changeArmor(Armor armor){
        this.armor = armor;
    }
}
