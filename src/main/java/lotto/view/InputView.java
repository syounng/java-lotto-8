package lotto.view;

public class InputView {

    private final ConsoleInput consoleInput;
    private final InputValidation inputValidation;

    public InputView(ConsoleInput consoleInput, InputValidation inputValidation){
        this.consoleInput = consoleInput;
        this.inputValidation = inputValidation;
    }

    public String readPurchasePrice(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = consoleInput.read();
        inputValidation.validatePurchasePrice(input);
        return input;
    }

    public String readWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = consoleInput.read();
        inputValidation.validateWinningNumbers(input);
        return input;
    }

    public String readBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return consoleInput.read();
    }
}
