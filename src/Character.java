public class Character {
    private String name;
    int health;
    int damage;

    public Character(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public int attack() {
        return damage;
    }
}


