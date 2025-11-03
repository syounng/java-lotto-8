package lotto.view;

import lotto.domain.Lottos;

public class OutputView {

    public void printPurchasedLottos(Lottos lottos){
        System.out.println(lottos.getSize() + "개를 구매했습니다.");
        lottos.printLottos();
    }

    public void printWinningStats(){

    }
}
