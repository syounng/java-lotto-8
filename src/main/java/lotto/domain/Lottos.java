package lotto.domain;

import static lotto.controller.LottoController.PURCHASED_PRICE;

import java.util.*;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos fromCount(int count) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(Lotto.createRandomLotto());
        }
        return new Lottos(lottoList);
    }

    public int getSize(){
        return lottos.size();
    }

    public void printLottos(){
        lottos.forEach(Lotto::printNumbers);
    }

    public Map<Rank, Integer> calcRank(WinningNumber winningNumber) {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        for (Lotto lotto : lottos) {
            int matchCount = winningNumber.countMatch(lotto);
            boolean hasBonus = winningNumber.hasBonusMatch(lotto);
            Rank rank = Rank.of(matchCount, hasBonus);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }

    public double calcProfitRate(Map<Rank, Integer> results) {
        long totalPrize = results.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();

        // 구매한 금액 대비 당첨금이 몇 퍼센트인지 계산 -> 소수점 둘째 자리까지 반올림
        double profitRate = ((double) totalPrize /  PURCHASED_PRICE) * 100;
        return Math.round(profitRate * 100) / 100.0;
    }
}