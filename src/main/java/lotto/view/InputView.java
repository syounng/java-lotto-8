package lotto.view;

public class InputView {

    private static final String MESSAGE_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private final ConsoleInput consoleInput;
    private final InputValidation inputValidation;

    public InputView(ConsoleInput consoleInput, InputValidation inputValidation){
        this.consoleInput = consoleInput;
        this.inputValidation = inputValidation;
    }

    public int readPurchasePrice(){
        System.out.println(MESSAGE_PURCHASE_PRICE);
        String input = consoleInput.read();
        inputValidation.validatePurchasePrice(input);
        return Integer.parseInt(input);
    }

    public String readWinningNumbers(){
        System.out.println(MESSAGE_WINNING_NUMBERS);
        String input = consoleInput.read();
        inputValidation.validateWinningNumbers(input);
        return input;
    }

    public String readBonusNumber(){
        System.out.println(MESSAGE_BONUS_NUMBER);
        return consoleInput.read();
    }
}
