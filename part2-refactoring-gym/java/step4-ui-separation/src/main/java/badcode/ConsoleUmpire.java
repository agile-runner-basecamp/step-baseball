package badcode;

import java.util.List;

public class ConsoleUmpire {
    private final Umpire umpire;
    // 이렇게하는게 맞아요,,? 아닌거같은데,..
    public ConsoleUmpire() {
        this(new Umpire());
    }

    public ConsoleUmpire(Umpire umpire) {
        this.umpire = umpire;
    }

    public String play(List<Integer> answer, List<Integer> guess) {
        return umpire.judge(answer, guess);
    }
}
