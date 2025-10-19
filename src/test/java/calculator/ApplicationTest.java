package calculator;

import calculator.service.CalculatorService;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    private final CalculatorService calculator = new CalculatorService();
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 구분자가_아닌_문자_사용_1(){
        assertThatThrownBy(() -> calculator.calculate("1,a,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구분자가_아닌_문자_사용_2(){
        assertThatThrownBy(() -> calculator.calculate("//;\\n1;4c4;4"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 연속된_구분자() {
        assertThatThrownBy(() -> calculator.calculate("1,,2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구분자로_끝나는_문자열() {
        assertThatThrownBy(() -> calculator.calculate("//;\n1;43;"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 잘못된_커스텀_구분자_형식() {
        assertThatThrownBy(() -> calculator.calculate("//;\n1:2;3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
