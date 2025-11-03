package lotto.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidationTest {

    private InputValidation inputValidation;

    @BeforeEach
    void setUp() {
        inputValidation = new InputValidation();
    }

    @Test
    @DisplayName("구입 금액이 숫자가 아니면 예외 발생")
    void validatePurchasePrice_notNumber_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
                inputValidation.validatePurchasePrice("abc"));
    }

    @Test
    @DisplayName("구입 금액이 0 이하이면 예외 발생")
    void validatePurchasePrice_zeroOrNegative_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
                inputValidation.validatePurchasePrice("0"));
        assertThrows(IllegalArgumentException.class, () ->
                inputValidation.validatePurchasePrice("-1000"));
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아니면 예외 발생")
    void validatePurchasePrice_notDivisibleBy1000_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
                inputValidation.validatePurchasePrice("8500"));
    }

    @Test
    @DisplayName("구입 금액이 유효하면 예외가 발생하지 않는다")
    void validatePurchasePrice_validInput_passes() {
        assertDoesNotThrow(() ->
                inputValidation.validatePurchasePrice("8000"));
    }

    @Test
    @DisplayName("쉼표(,)가 없으면 예외 발생")
    void validateWinningNumbers_noComma_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
                inputValidation.validateWinningNumbers("123456"));
    }

    @Test
    @DisplayName("쉼표(,)가 연속으로 두 번 나오면 예외 발생")
    void validateWinningNumbers_doubleComma_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
                inputValidation.validateWinningNumbers("1,2,,3,4,5"));
    }

    @Test
    @DisplayName("쉼표로 구분된 숫자가 6개가 아니면 예외 발생")
    void validateWinningNumbers_wrongCount_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
                inputValidation.validateWinningNumbers("1,2,3,4,5"));
    }

    @Test
    @DisplayName("숫자가 아닌 값이 포함되면 예외 발생")
    void validateWinningNumbers_containsNonNumber_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
                inputValidation.validateWinningNumbers("1,2,a,4,5,6"));
    }

    @Test
    @DisplayName("숫자가 1~45 범위를 벗어나면 예외 발생")
    void validateWinningNumbers_outOfRange_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
                inputValidation.validateWinningNumbers("1,2,3,4,5,99"));
    }

    @Test
    @DisplayName("유효한 당첨 번호 입력이면 예외가 발생하지 않는다")
    void validateWinningNumbers_validInput_passes() {
        assertDoesNotThrow(() ->
                inputValidation.validateWinningNumbers("1,2,3,4,5,6"));
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아니면 예외 발생")
    void validateBonusNumber_notNumber_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
                inputValidation.validateBonusNumber("a"));
    }

    @Test
    @DisplayName("보너스 번호가 1 미만 또는 45 초과면 예외 발생")
    void validateBonusNumber_outOfRange_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
                inputValidation.validateBonusNumber("0"));
        assertThrows(IllegalArgumentException.class, () ->
                inputValidation.validateBonusNumber("46"));
    }

    @Test
    @DisplayName("유효한 보너스 번호 입력이면 예외가 발생하지 않는다")
    void validateBonusNumber_validInput_passes() {
        assertDoesNotThrow(() ->
                inputValidation.validateBonusNumber("7"));
    }
}