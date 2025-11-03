package lotto.config;

import lotto.controller.LottoController;
import lotto.domain.WinningStats;
import lotto.view.ConsoleInput;
import lotto.view.InputValidation;
import lotto.view.InputView;
import lotto.view.OutputView;
import service.LottoService;

public class AppConfig {
    public LottoController lottoController() {
        InputValidation inputValidation = new InputValidation();
        ConsoleInput consoleInput = new ConsoleInput();
        InputView inputView = new InputView(consoleInput, inputValidation);
        OutputView outputView = new OutputView();
        WinningStats winningStats = new WinningStats(outputView);
        LottoService lottoService = new LottoService(winningStats);

        return new LottoController(inputView, outputView, lottoService);
    }
}
