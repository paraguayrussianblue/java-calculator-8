package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;
import calculator.domain.StringCalculator;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;
    private final StringCalculator calculator;

    public CalculatorController(InputView inputview, OutputView outputview, StringCalculator calculator){
        this.inputView = inputview;
        this.outputView = outputview;
        this.calculator = calculator;
    }

    public void run(){
        try{
            String input = inputView.readExpression();
            int result = calculator.calculate(input);
            outputView.printResult(result);
        }
        catch(IllegalArgumentException e){
            outputView.printError(e.getMessage());
            throw e;
        }
    }
}
