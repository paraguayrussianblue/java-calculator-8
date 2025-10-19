package calculator.view;

public class OutputView {
    private static final String RESULT_MESSAGE = "결과 : ";

    public static void printResult(long sum){
        System.out.println(RESULT_MESSAGE + sum);
    }
}
