package lotto.domain;

import java.util.Map;

public class WinningStats {

    public void printStats(Lottos lottos){
        Map<Rank, Integer> results = lottos.calcRank(WinningNumber.INSTANCE);
    }
}
