package lotto;

import lotto.controller.LottoController;
import lotto.domain.WinningNumber;
import lotto.domain.WinningStats;
import lotto.view.ConsoleInput;
import lotto.view.InputValidation;
import lotto.view.InputView;
import lotto.view.OutputView;
import service.LottoService;

public class Application {
    public static void main(String[] args) {
        try {
            InputValidation inputValidation = new InputValidation();
            ConsoleInput consoleInput = new ConsoleInput();
            InputView inputView = new InputView(consoleInput, inputValidation);
            OutputView outputView = new OutputView();
            WinningStats winningStats = new WinningStats(outputView);
            LottoService lottoService = new LottoService(winningStats);
            LottoController lottoController = new LottoController(inputView, outputView, lottoService);
            lottoController.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
