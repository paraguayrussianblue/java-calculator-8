package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final CalculatorService calculatorService = new CalculatorService();

    public void run(){
        String userInput = InputView.getInput();
        long sum = calculatorService.calculate(userInput);
        OutputView.printResult(sum);
    }
}
