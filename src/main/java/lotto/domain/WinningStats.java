package lotto.domain;

import java.util.Map;
import lotto.view.OutputView;

public class WinningStats {

    private OutputView outputView;

    public WinningStats(OutputView outputView){
        this.outputView = outputView;
    }

    public void printStats(Lottos lottos){
        Map<Rank, Integer> results = lottos.calcRank(WinningNumber.INSTANCE);
        double profitRate = lottos.calcProfitRate(results);
        outputView.printWinningStats(results);
        outputView.printProfitRate(profitRate);
    }
}
