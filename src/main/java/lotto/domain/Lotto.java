package lotto.domain;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto createRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_COUNT);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
}
