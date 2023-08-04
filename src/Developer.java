import java.util.Arrays;

public class Developer extends Character {
    private final String[] skills;
    private final boolean[] skillUnlocked;
    private int unlockedSkillsCount;
    private final Dungeon[] dungeons; // 던전 정보를 저장하는 배열

    public Developer(String name, int health, int damage, String[] skills, Dungeon[] dungeons) {
        super(name, health, damage);
        this.skills = skills;
        this.dungeons = dungeons;
        this.unlockedSkillsCount = 0;
        this.skillUnlocked = new boolean[skills.length];

        // 모든 스킬을 봉인해제되지 않은 상태로 초기화
        Arrays.fill(skillUnlocked, false);
    }
    // 던전 클리어 시 해당 던전 스킬 봉인 해제
    public void clearDungeon(String dungeonName) {
        for (Dungeon dungeon : dungeons) {
            if (dungeon.getName().equals(dungeonName)) {
                if (unlockedSkillsCount < skills.length) {
                    String skillToUnlock = skills[unlockedSkillsCount];
                    unlockedSkillsCount++;
                    skillUnlocked[unlockedSkillsCount - 1] = true; // 해당 스킬 봉인 해제
                    System.out.println("개발자 " + getName() + " 봉인 해제 스킬: " + skillToUnlock);
                } else {
                    System.out.println("모든 스킬이 봉인 해제 되었습니다.");
                }
                break;
            }
        }
    }

    // 스킬 사용
    public void useSkill(int skillIndex, Monster currentMonster) {
        if (skillIndex >= 0 && skillIndex < skills.length) {
            if (isSkillUnlocked(skillIndex)) {
                String skill = skills[skillIndex];
                System.out.println("개발자 " + getName() + " " + skill + " 스킬 사용!");
                // 스킬에 따른 공격 처리 코드 추가
                switch (skillIndex) {
                    case 0 -> { // 스킬 1
                        int damageQ = 30; // 스킬 q에 해당하는 데미지
                        System.out.println(skills[skillIndex] + " 스킬로 몬스터에게 " + damageQ + "의 데미지를 입힙니다.");
                        currentMonster.takeDamage(damageQ);
                    }
                    case 1 -> { // 스킬 2
                        int damageW = 40; // 스킬 w에 해당하는 데미지
                        System.out.println(skills[skillIndex] + " 스킬로 몬스터에게 " + damageW + "의 데미지를 입힙니다.");
                        currentMonster.takeDamage(damageW);
                    }
                    case 2 -> { // 스킬 3
                        int damageE = 50; // 스킬 e에 해당하는 데미지
                        System.out.println(skills[skillIndex] + " 스킬로 몬스터에게 " + damageE + "의 데미지를 입힙니다.");
                        currentMonster.takeDamage(damageE);
                    }
                    case 3 -> { // 스킬 4
                        int damageR = 60; // 스킬 r에 해당하는 데미지
                        System.out.println(skills[skillIndex] + " 스킬로 몬스터에게 " + damageR + "의 데미지를 입힙니다.");
                        currentMonster.takeDamage(damageR);
                    }
                    default -> System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                }
            } else {
                System.out.println("해당 스킬은 아직 봉인되어 사용할 수 없습니다.");
            }
        } else {
            System.out.println("기술 번호를 다시 입력해 주세요.");
        }
    }



    // 스킬 봉인 여부 확인
    public boolean isSkillUnlocked(int index) {
        if (index >= 0 && index < skills.length) {
            return skillUnlocked[index];
        }
        return false;
    }

    //개발자 체력 셋팅
    public void setHealth(int health) {
        this.health = health;
    }
}
