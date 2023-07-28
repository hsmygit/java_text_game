import java.util.Random; // -> 랜덤 나중에 사용.

public class Dungeon {
    private String name;
    private String[] monsters;
    private String associatedSkill;

    public Dungeon(String name, String[] monsters, String associatedSkill) {
        this.name = name;
        this.monsters = monsters;
        this.associatedSkill = associatedSkill;
    }

    public String getName() {
        return name;
    }

    public String[] getMonsters() {
        return monsters;
    }
    //던전과 연관되어 있는 스킬
    public String getAssociatedSkill() {
        return associatedSkill;
    }
}

