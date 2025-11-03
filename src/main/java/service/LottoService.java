package service;

import lotto.domain.Lottos;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;

    public Lottos generateLottos(int purchasePrice) {
        validatePrice(purchasePrice);
        int count = purchasePrice / LOTTO_PRICE;
        return Lottos.fromCount(count);
    }

    private void validatePrice(int price) {
        if (price < LOTTO_PRICE || price % LOTTO_PRICE != 0)
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }
}