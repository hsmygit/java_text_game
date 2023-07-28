import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //이름 입력
        System.out.print("개발자의 이름을 입력하세요: ");
        String developerName = scanner.nextLine();
        System.out.println("입력한 개발자의 이름은 " + developerName + " 입니다.");
        scanner.close();

        // 던전 생성
        Dungeon[] dungeons = {
                new Dungeon("학교", new String[]{"교수"}, "q"),
                new Dungeon("백준", new String[]{"알고리즘"}, "w"),
                new Dungeon("독서실", new String[]{"백엔드", "포론트"}, "e"),
                new Dungeon("대기업", new String[]{"취업"}, "r")
        };
        // 개발자 생성
        String[] skills = {"q", "w", "e", "r"};
        Developer developer = new Developer(developerName, 90, 25, skills ,dungeons);



        // 던전 클리어, 스킬 봉인 해제
        developer.clearDungeon("학교");
        developer.clearDungeon("백준");
        developer.clearDungeon("독서실");
        developer.clearDungeon("대기업");

        // 스킬 사용
        developer.useSkill(0);
        developer.useSkill(2);
        developer.useSkill(3);


    }
}

