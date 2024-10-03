import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    List<Creature> creatures;
    Random random;
    public Arena(List<Creature> creatures){
        this.random = new Random();
        this.creatures = creatures;




    }

    public List<Creature> getCreatures() {
        return new ArrayList<Creature>(creatures);
    }

    public void start() {





    }


}
