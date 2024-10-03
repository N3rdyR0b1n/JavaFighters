import Util.FileUtil;

public class Creature {
    private String name;
    protected String fileName;
    private int hp;
    private int maxhp;

    public Creature(String name, int hp, String fileName) {
        this.name = name;
        this.hp = hp;
        this.maxhp = hp;
        this.fileName = fileName;
    }


    public void damage(int damage) {
        this.hp-=damage;
    }
    public boolean alive() {
        return hp>0;
    }
    public void rename(String nick) {
        this.name = nick;
    }
    public String status() {
        return name + " : " + hp + "/" + maxhp;
    }

    public String getImageSource() {
        return FileUtil.CHARACTERS+fileName;
    }
}
