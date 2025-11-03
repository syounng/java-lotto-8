package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public Lottos generateLottos(int purchasePrice) {
        int numberOfLotto = calcNumberOfLotto(purchasePrice);
        return issueLottos(numberOfLotto);
    }

    private int calcNumberOfLotto(int price) {
        isValidatePrice(price);
        return price / LOTTO_PRICE;
    }

    private Lottos issueLottos(int count) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(Lotto.createRandomLotto());
        }
        return new Lottos(lottoList);
    }

    private void isValidatePrice(int price){
        if (price < LOTTO_PRICE || price % LOTTO_PRICE != 0)
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }

}