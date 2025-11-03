package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import java.io.*;
import lotto.domain.Lottos;
import org.junit.jupiter.api.*;

class OutputViewTest {

    private OutputView outputView;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
        outputView = new OutputView();
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @DisplayName("로또 3개 구매 시 출력 포맷이 올바르다.")
    @Test
    void printPurchasedLottos_정상출력_확인() {
        // given
        Lottos lottos = Lottos.fromCount(3);

        // when
        outputView.printPurchasedLottos(lottos);

        // then
        String output = outputStream.toString().trim();

        long lottoCount = output.lines()
                .filter(line -> line.matches("\\[\\d+(, \\d+){5}]"))
                .count();
        assertThat(lottoCount).isEqualTo(3);

        assertThat(output).contains("\n[");
    }

}