package service;

import java.util.*;
import lotto.domain.Lottos;
import lotto.domain.WinningNumber;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;

    private WinningNumber winningNumber;

    public LottoService(WinningNumber winningNumber){
        this.winningNumber = winningNumber;
    }

    public Lottos generateLottos(int purchasePrice) {
        validatePrice(purchasePrice);
        int count = purchasePrice / LOTTO_PRICE;
        return Lottos.fromCount(count);
    }

    public void generateWinningNumber(String winningNumbersInput, String bonusNumberInput){
        String[] numbers = winningNumbersInput.split(",");
        int bonusNumber = Integer.parseInt(bonusNumberInput);
        List<Integer> winningNumbers = Arrays.stream(numbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
        WinningNumber.INSTANCE.initialize(winningNumbers, bonusNumber);
    }
    
    private void validatePrice(int price) {
        if (price < LOTTO_PRICE || price % LOTTO_PRICE != 0)
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }
}