package badcode;

import java.util.List;

public class BadUmpire {
    public int doS(List<Integer> a, List<Integer> b) {
        int r = 0;
        for (int i = 0; i < 3; i++) {
            if (a.get(i).equals(b.get(i))) {
                r++;
            }
        }
        return r;
    }

    public int doB(List<Integer> a, List<Integer> b) {
        int r = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && a.get(i).equals(b.get(j))) {
                    r++;
                }
            }
        }
        return r;
    }
}
