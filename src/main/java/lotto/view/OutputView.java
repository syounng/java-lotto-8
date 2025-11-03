package lotto.view;

import java.util.Map;
import lotto.domain.Lottos;
import lotto.domain.Rank;

public class OutputView {

    public void printPurchasedLottos(Lottos lottos){
        System.out.println(lottos.getSize() + "개를 구매했습니다.");
        lottos.printLottos();
    }

    public void printWinningStats(Map<Rank, Integer> results){
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.printf("3개 일치 (5,000원) - %d개%n", results.getOrDefault(Rank.FIFTH, 0));
        System.out.printf("4개 일치 (50,000원) - %d개%n", results.getOrDefault(Rank.FOURTH, 0));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", results.getOrDefault(Rank.THIRD, 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", results.getOrDefault(Rank.SECOND, 0));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", results.getOrDefault(Rank.FIRST, 0));
    }
}
