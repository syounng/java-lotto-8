package lotto.view;

public class InputValidation {

    // 숫자, 문자 패턴
    private static final String REGEX_ONLY_NUMBER = "\\d+";
    private static final String DELIMITER_COMMA = ",";
    private static final String DOUBLE_COMMA = ",,";

    // 로또 번호 규칙
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    // 에러 메시지
    private static final String ERROR_NOT_NUMBER = "[ERROR] 숫자를 입력해주세요.";
    private static final String ERROR_NEGATIVE_AMOUNT = "[ERROR] 구입 금액은 0보다 커야 합니다.";
    private static final String ERROR_NOT_DIVISIBLE_BY_1000 = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";
    private static final String ERROR_NO_COMMA = "[ERROR] 쉼표(,)로 구분된 숫자를 입력해야 합니다.";
    private static final String ERROR_DOUBLE_COMMA = "[ERROR] 쉼표(,) 사이에 값이 없습니다.";
    private static final String ERROR_WRONG_COUNT = "[ERROR] 당첨 번호는 6개의 숫자를 입력해야 합니다.";
    private static final String ERROR_OUT_OF_RANGE = "[ERROR] 1~45 사이의 숫자여야 합니다.";

    public void validatePurchasePrice(String input) {
        isInteger(input);
        int amount = Integer.parseInt(input);

        if (amount <= 0)
            throw new IllegalArgumentException(ERROR_NEGATIVE_AMOUNT);

        if (amount % 1000 != 0)
            throw new IllegalArgumentException(ERROR_NOT_DIVISIBLE_BY_1000);
    }

    public void validateWinningNumbers(String input) {
        if (!input.contains(DELIMITER_COMMA))
            throw new IllegalArgumentException(ERROR_NO_COMMA);

        if (input.contains(DOUBLE_COMMA))
            throw new IllegalArgumentException(ERROR_DOUBLE_COMMA);

        String[] parts = input.split(DELIMITER_COMMA);
        if (parts.length != LOTTO_NUMBER_COUNT)
            throw new IllegalArgumentException(ERROR_WRONG_COUNT);

        for (String part : parts) {
            isInteger(part);
            int number = Integer.parseInt(part);
            isValidateNumber(number);
        }
    }

    public void validateBonusNumber(String input) {
        isInteger(input);
        int number = Integer.parseInt(input);
        isValidateNumber(number);
    }

    private void isInteger(String input) {
        if (!input.matches(REGEX_ONLY_NUMBER)) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER);
        }
    }

    private void isValidateNumber(int number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ERROR_OUT_OF_RANGE);
        }
    }
}