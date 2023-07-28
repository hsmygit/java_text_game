public class Developer extends Character {
    private String[] skills;
    private int unlockedSkillsCount;
    private Dungeon[] dungeons; // 던전 정보를 저장하는 배열

    public Developer(String name, int health, int damage, String[] skills, Dungeon[] dungeons) {
        super(name, health, damage);
        this.skills = skills;
        this.dungeons = dungeons;
        this.unlockedSkillsCount = 0;

    }

    // 던전 클리어 시 해당 던전 스킬 봉인 해제
    public void clearDungeon(String dungeonName) {
        for (Dungeon dungeon : dungeons) {
            if (dungeon.getName().equals(dungeonName)) {
                if (unlockedSkillsCount < skills.length) {
                    String skillToUnlock = skills[unlockedSkillsCount];
                    unlockedSkillsCount++;
                    System.out.println( "개발자 " +getName() + " 봉인 해제 스킬: " + skillToUnlock);
                    break;
                } else {
                    System.out.println("모든 스킬이 봉인 해제 되었습니다.");
                    break;
                }
            }
        }
    }

    // 스킬 사용
    public void useSkill(int skillIndex) {
        if (skillIndex >= 0 && skillIndex < skills.length) {
            String skill = skills[skillIndex];
            System.out.println("개발자 " + getName() + skill + " 스킬 사용!");
        } else {
            System.out.println("기술 번호를 다시 입력해 주세요.");
        }
    }
}
