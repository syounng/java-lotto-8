package lotto.controller;

import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;
import service.LottoService;

public class LottoController {

    public static int PURCHASED_PRICE;

    private InputView inputView;
    private OutputView outputView;
    private LottoService service;

    public LottoController(InputView inputView, OutputView outputView, LottoService service){
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    }

    public void run(){
        PURCHASED_PRICE = inputView.readPurchasePrice();
        Lottos lottos = service.generateLottos(PURCHASED_PRICE);
        outputView.printPurchasedLottos(lottos);

        String winningNumbers = inputView.readWinningNumbers();
        String bonusNumber = inputView.readBonusNumber();
        service.generateWinningNumber(winningNumbers, bonusNumber);
        service.generateStats(lottos);
    }
}
