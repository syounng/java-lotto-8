package lotto.domain;

import static lotto.controller.LottoController.PURCHASED_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @BeforeEach
    void setUp() {
        WinningNumber.INSTANCE.initialize(List.of(1, 2, 3, 4, 5, 6), 7);
    }

    @DisplayName("로또 당첨 결과를 정확히 계산한다.")
    @Test
    void calcRank_정상작동_확인() {
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 6개 일치 → 1등
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7)); // 5개 + 보너스 → 2등
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 8)); // 5개 → 3등
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 9, 10)); // 4개 → 4등
        Lotto lotto5 = new Lotto(List.of(1, 2, 3, 11, 12, 13)); // 3개 → 5등
        Lotto lotto6 = new Lotto(List.of(14, 15, 16, 17, 18, 19)); // 꽝

        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6));

        // when
        Map<Rank, Integer> results = lottos.calcRank(WinningNumber.INSTANCE);

        // then
        assertThat(results.get(Rank.FIRST)).isEqualTo(1);
        assertThat(results.get(Rank.SECOND)).isEqualTo(1);
        assertThat(results.get(Rank.THIRD)).isEqualTo(1);
        assertThat(results.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(results.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(results.getOrDefault(Rank.NONE, 0)).isEqualTo(1);
    }

    @DisplayName("수익률 계산이 올바르게 수행된다.")
    @Test
    void calcProfitRate_정상작동_확인() {
        // given
        Lottos lottos = new Lottos(java.util.List.of());
        Map<Rank, Integer> results = new EnumMap<>(Rank.class);
        results.put(Rank.FIRST, 1);
        results.put(Rank.FIFTH, 2);

        // when
        double actual = lottos.calcProfitRate(results);

        // then
        long totalPrize = 2_000_000_000L + (5_000L * 2); // 1등 1개, 5등 2개
        double expected = Math.round(((double) totalPrize / PURCHASED_PRICE * 100) * 100) / 100.0;
        assertThat(actual).isEqualTo(expected);
    }
}