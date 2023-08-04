public class Monster extends Character {
    private final int addition;
    private final String art;

    public Monster(String name, int health, int damage, int addition, String art) {
        super(name, health, damage);
        this.addition = addition;
        this.art = art;
    }

    // 몬스터 생성
    public static Monster[] createMonsters(String[] monsterNames, int[] monsterHealths, int[] monsterDamages, int[] monsterAdditions, String[] monsterArts) {
        Monster[] monsters = new Monster[monsterNames.length];
        for (int i = 0; i < monsterNames.length; i++) {
            monsters[i] = new Monster(monsterNames[i], monsterHealths[i], monsterDamages[i], monsterAdditions[i], monsterArts[i]);
        }
        return monsters;
    }

    // 몬스터의 공격력 계산 (기본 공격력 + 추가 특성)
    public int attack() {
        return super.attack() + addition;
    }

    // 추가 특성 반환
    public int getAddition() {
        return addition;
    }

    // 몬스터 아트 반환
    public String getArt() {
        return art;
    }
}
