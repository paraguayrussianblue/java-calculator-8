package calculator.domain;

import java.util.regex.Pattern;

public class StringCalculator {
    public int calculate(String input) {
        if (input == null || input.strip().isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";
        String numbers = input;

        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\\n");
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 입력 형식이 유효하지 않습니다.");
            }
            String customDelimiter = input.substring(2, newlineIndex);
            delimiter += "|" + Pattern.quote(customDelimiter);
            numbers = input.substring(newlineIndex + 2);
        }

        if (numbers.strip().isEmpty()) {
            return 0;
        }

        return sumTokens(numbers.split(delimiter));
    }

    private int sumTokens(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            try {
                int number = Integer.parseInt(token);
                if (number < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                }
                sum += number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("입력 형식이 유효하지 않습니다.");
            }
        }
        return sum;
    }
}