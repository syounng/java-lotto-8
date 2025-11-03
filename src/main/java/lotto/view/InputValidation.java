package lotto.view;

public class InputValidation {

    public void validatePurchasePrice(String input){
        isInteger(input);
        int amount = Integer.parseInt(input);

        if (amount <= 0)
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.");

        if (amount % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }

    public void validateWinningNumbers(String input){
        if (!input.contains(","))
            throw new IllegalArgumentException("[ERROR] 쉼표(,)로 구분된 숫자를 입력해야 합니다.");

        if (input.contains(",,"))
            throw new IllegalArgumentException("[ERROR] 쉼표(,) 사이에 값이 없습니다.");

        String[] parts = input.split(",");
        if (parts.length != 6)
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 숫자를 입력해야 합니다.");

        for (String part : parts) {
            isInteger(part);
            int number = Integer.parseInt(part);
            isValidateNumber(number);
        }
    }

    public void validateBonusNumber(String input){
        isInteger(input);
        int number = Integer.parseInt(input);
        isValidateNumber(number);
    }

    private void isInteger(String input){
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private void isValidateNumber(int number){
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자여야 합니다.");
        }
    }
}
