public class Monster extends Character {
    int addition;
    public Monster(String name, int health, int damage) {
        super(name, health, damage);
    }
    //몬스터 추가 특성
    public int Add_prop() {
        return addition;
    }
}


