public class Dungeon {
    private final String name;
    private final String[] monsters;
    private final int[] monsterHealths;
    private final int[] monsterDamages;
    private final int[] monsterAdditions;
    private final String[] monsterArts;
    private final String associatedSkill;

    public Dungeon(String name, String[] monsters, int[] monsterHealths, int[] monsterDamages, int[] monsterAdditions, String[] monsterArts, String associatedSkill) {
        this.name = name;
        this.monsters = monsters;
        this.monsterHealths = monsterHealths;
        this.monsterDamages = monsterDamages;
        this.monsterAdditions = monsterAdditions;
        this.monsterArts = monsterArts;
        this.associatedSkill = associatedSkill;
    }

    public String getName() {
        return name;
    }

    public String[] getMonsters() {
        return monsters;
    }

    public int[] getMonsterHealths() {
        return monsterHealths;
    }

    public int[] getMonsterDamages() {
        return monsterDamages;
    }

    public int[] getMonsterAdditions() {
        return monsterAdditions;
    }

    public String[] getMonsterArts() {
        return monsterArts;
    }

    public String getAssociatedSkill() {
        return associatedSkill;
    }
}
