/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heroesbattle;

/**
 *
 * @author Dell
 */
public class Armor {
    private String name;
    private int armor;

    public Armor() {
    }

    public Armor(String name, int armor) {
        this.name = name;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public String toString() {
        return "Armor{" + "name=" + name + ", armor=" + armor + '}';
    }
    
    
}
