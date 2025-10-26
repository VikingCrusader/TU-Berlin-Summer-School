import java.io.Serializable;
import java.util.List;

public class GameState implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<String> playerA;
    private List<String> playerB;

    public GameState(List<String> playerA, List<String> playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public List<String> getPlayerA() {
        return playerA;
    }

    public List<String> getPlayerB() {
        return playerB;
    }
}
