
package heroesbattle;
public class Hero {
    private String name;
    private int health;
    private Armor armor;
    private Weapon weapon;

    public Hero() {
    }

    public Hero(String name, int health, Armor armor,Weapon weapon) {
        this.name = name;
        this.health = health;
        this.weapon = weapon;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }
    
    public void changeArmor(Armor armor){
        this.armor = armor;
    }
    
    public void changeWeapon(Weapon weapon){
        this.weapon = weapon;
    }
    
    public int getAttactPower(){
        return this.weapon.getPower();
    }
    
    public void attacted(int power){
       this.health = this.health - (power-this.armor.getArmor());
    }
    
    public void attacted(Hero enemy){
        this.health = this.health - (enemy.getAttactPower()-this.armor.getArmor());
    }
    
    
    
}
