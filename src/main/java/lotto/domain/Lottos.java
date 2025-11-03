package lotto.domain;

import static lotto.controller.LottoController.PURCHASED_PRICE;

import java.util.*;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
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

        int totalPurchase = getSize() * PURCHASED_PRICE;
        double profitRate = (double) totalPrize / totalPurchase * 100;

        return Math.round(profitRate * 100);
    }
}