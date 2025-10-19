package calculator.service;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CalculatorService {

    private static final String BEGINNING_CUSTOM_DELIMITER = "//";
    private static final String END_CUSTOM_DELIMITER = "\\n";
    private static final String BASE_DELIMITER = "[,:]";

    public long calculate(String input) {
        List<String> numbers;

        // 입력이 없을 시 0으로 처리
        if (input == null || input.isBlank()) {
            return 0;
        }

        // 커스텀 구분자 존재시
        if (input.startsWith(BEGINNING_CUSTOM_DELIMITER)) {
            int idx = input.indexOf(END_CUSTOM_DELIMITER);
            if (idx < 0) {
                throw new IllegalArgumentException("커스텀 구분자 형식 오류");
            }

            String custom = input.substring(2, idx);
            if (custom.length() != 1) {
                throw new IllegalArgumentException("커스텀 구분자는 1글자일 것");
            }

            String changedInput = input.substring(idx + 2);
            numbers = Arrays.asList(changedInput.split(BASE_DELIMITER + "|" + Pattern.quote(custom)));

            return addNumbers(numbers);
        }

        numbers = Arrays.asList(input.split(BASE_DELIMITER));
        return addNumbers(numbers);
    }

    public long addNumbers(List<String> numbers) {
        long sum = 0;
        for (String num : numbers) {
            if (num.isEmpty()) throw new IllegalArgumentException("비어 있는 값");
            if (!num.matches("-?\\d+")) throw new IllegalArgumentException("잘못된 입력");
            long v = Long.parseLong(num);
            if (v <= 0) throw new IllegalArgumentException("양수만 가능");
            sum += v;
        }
        return sum;
    }

}
