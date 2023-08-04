import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 이름 입력
        System.out.print("개발자의 이름을 입력하세요: ");
        String developerName = scanner.nextLine(); //개행 문자 제거.
        System.out.println("입력한 개발자의 이름은 " + developerName + " 입니다.");

        // 던전 생성
        Dungeon[] dungeons = {
                new Dungeon("학교", new String[]{"교수"}, new int[]{100}, new int[]{20}, new int[]{0}, new String[]{MonsterArt.MONSTER_PROFESSOR},"꼰대"),
                new Dungeon("백준", new String[]{"알고리즘"}, new int[]{80}, new int[]{30}, new int[]{10}, new String[]{MonsterArt.MONSTER_ALGORITHM},"머리 아픔"),
                new Dungeon("독서실1", new String[]{"백엔드"}, new int[]{120}, new int[]{25}, new int[]{8}, new String[]{MonsterArt.MONSTER_Backend},"안보여..."),
                new Dungeon("독서실2", new String[]{"포론트"}, new int[]{150}, new int[]{35}, new int[]{12}, new String[]{MonsterArt.MONSTER_FrontEnd},"디자인..."),
                new Dungeon("대기업", new String[]{"취업"}, new int[]{90}, new int[]{15}, new int[]{6}, new String[]{MonsterArt.MONSTER_Employment},"뚫어 보셈 ㅋㅋ")
        };


        // 개발자 생성
        String[] skills = {"q", "w", "e", "r"};
        Developer developer = new Developer(developerName, 100, 20, skills, dungeons);

        // 게임 진행
        int dungeonIndex = 0;
        while (dungeonIndex < dungeons.length) { //dungeons.length - 총 던전 개수.
            Dungeon dungeon = dungeons[dungeonIndex];
            System.out.println("\n" + developer.getName() + "님이 " + dungeon.getName() + " 던전에 입장합니다.");

            // 몬스터 생성
            int[] monsterHealths = dungeon.getMonsterHealths();
            int[] monsterDamages = dungeon.getMonsterDamages();
            int[] monsterAdditions = dungeon.getMonsterAdditions();
            String[] monsterArts = dungeon.getMonsterArts();

            Monster[] monsters = Monster.createMonsters(dungeon.getMonsters(), monsterHealths, monsterDamages, monsterAdditions, monsterArts);


            // 던전 클리어
            int monsterIndex = 0;
            while (monsterIndex < monsters.length && developer.getHealth() > 0) {
                Monster currentMonster = monsters[monsterIndex];
                System.out.println(currentMonster.getArt()); //몬스터 이미지 출력
                System.out.println(currentMonster.getName() + " 출현!!!"); // 몬스터 이름 출력
                System.out.println("체력: " + currentMonster.getHealth()); // 몬스터의 체력 출력
                System.out.println(dungeon.getName() + "의 " + dungeon.getAssociatedSkill() + " 효과로 추가 데미지: " + currentMonster.getAddition());



                // 개발자와 몬스터가 서로 번갈아가며 공격
                while (developer.getHealth() > 0 && currentMonster.getHealth() > 0) {
                    // 개발자 공격 선택 받기
                    System.out.println("----- 할 짓을 선택 하세요. -----");
                    System.out.println("1. 일반 공격");
                    System.out.println("2. 교수 어택 스킬 사용");
                    System.out.println("3. 알고리즘 스킬 사용");
                    System.out.println("4. 백엔드 스킬 사용");
                    System.out.println("5. 프론트 스킬 사용");
                    System.out.print("어떤 공격을 선택하시겠습니까? (1-5): ");
                    int attackChoice = scanner.nextInt();
                    scanner.nextLine(); // 개행 문자 제거

                    // 선택에 따라 공격 실행
                    switch (attackChoice) {
                        case 1 -> {
                            int damageToMonster = developer.attack();
                            currentMonster.takeDamage(damageToMonster);
                            System.out.println(currentMonster.getName() + "에게 " + damageToMonster + "의 데미지를 입혔습니다!");
                        }
                        case 2, 3, 4, 5 -> developer.useSkill(attackChoice - 2, currentMonster);
                        default -> {
                            System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                            continue;
                        }
                    }

                    if (currentMonster.getHealth() <= 0) {
                        System.out.println(currentMonster.getName() + " 처치 완료!!!");
                        monsterIndex++;
                    } else {
                        System.out.println(currentMonster.getName() + "의 남은 체력: " + currentMonster.getHealth());
                    }

                    // 개발자가 죽었는지 확인
                    if (developer.getHealth() <= 0) {
                        break;
                    }
                    // 몬스터가 죽었는지 확인
                    if (currentMonster.getHealth() <= 0) {
                        continue; // 다음 몬스터 공격으로 건너뛰기
                    }

                    // 몬스터 공격
                    int damageToDeveloper = currentMonster.attack();
                    developer.takeDamage(damageToDeveloper);
                    System.out.println(currentMonster.getName() + "에게 " + damageToDeveloper + "의 데미지를 받았습니다!");

                    // 개발자의 현재 체력 출력
                    System.out.println(developer.getName() + "의 남은 체력: " + developer.getHealth());
                    System.out.println("-----------------------------");
                }
            }

            // 게임 오버 처리
            if (developer.getHealth() <= 0) {
                System.out.println("게임 오버! 처음부터 다시 시작하세요.");
                // 게임 초기화
                developer = new Developer(developerName, 100, 20, skills, dungeons);
                dungeonIndex = 0;
            } else {
                // 개발자 체력 초기화
                System.out.println("던전을 클리어했습니다! 개발자의 체력을 초기화합니다.");
                developer.setHealth(100);
                // 스킬 봉인 해제
                developer.clearDungeon(dungeon.getName());
                dungeonIndex++;
            }
        }

        // 취업 성공 메시지 출력
        System.out.println("\n축하합니다! " + developer.getName() + "님이 취업에 성공했습니다!");

        scanner.close();
    }
}
