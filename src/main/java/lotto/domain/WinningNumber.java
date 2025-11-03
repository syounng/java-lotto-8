package lotto.domain;

import java.util.List;

public enum WinningNumber {
    INSTANCE;

    private List<Integer> numbers;
    private int bonusNumber;

    public void initialize(List<Integer> numbers, int bonusNumber) {
        if (this.numbers != null) {
            throw new IllegalStateException("[ERROR] WinningNumber는 이미 초기화되었습니다.");
        }
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public int countMatch(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean hasBonusMatch(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}