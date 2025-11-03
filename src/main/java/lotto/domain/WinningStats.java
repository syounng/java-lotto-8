package lotto.domain;

import java.util.Map;

public class WinningStats {

    private final WinningNumber winningNumber;

    public WinningStats(WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
    }

    public void printStats(Lottos lottos){
        Map<Rank, Integer> results = lottos.calcRank(winningNumber);
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.printf("3개 일치 (5,000원) - %d개%n", results.getOrDefault(Rank.FIFTH, 0));
        System.out.printf("4개 일치 (50,000원) - %d개%n", results.getOrDefault(Rank.FOURTH, 0));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", results.getOrDefault(Rank.THIRD, 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", results.getOrDefault(Rank.SECOND, 0));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", results.getOrDefault(Rank.FIRST, 0));
    }
}
