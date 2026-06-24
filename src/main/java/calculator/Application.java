package calculator;
import java.util.regex.Pattern;

public class Application {
    public static int calculate(String input){
        //빈 입력이나 공백만 있는 문자열 처리
        if(input == null || input.strip().isEmpty()){
            return 0;
        }

        //기본 구분자 설정
        String delimiter = ",|:";
        String numbers = input;

        //커스텀 구분자 입력 처리
        if(input.startsWith("//")){
            int newlineIndex = input.indexOf("\\n");

            if(newlineIndex == -1){
                throw new IllegalArgumentException("커스텀 구분자 입력 형식이 유효하지 않습니다.");
            }
            String customDelimiter = input.substring(2, newlineIndex);
            //정규표현식 특수문자 충돌 방지 위해 Pattern.quote 사용
            delimiter += "|" + Pattern.quote(customDelimiter);
            numbers = input.substring(newlineIndex + 2);            
        }

        //커스텀 구분자 입력만 있는 경우 처리
        if(numbers.strip().isEmpty()){
            return 0;
        }

        String[] tokens = numbers.split(delimiter);        
        int sum = 0;

        for(String token : tokens){
            try {
                int number = Integer.parseInt(token);

                if(number < 0){
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                }
                sum += number;
            }
            catch(NumberFormatException e){
                throw new IllegalArgumentException("입력 형식이 유효하지 않습니다.");
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        //입력받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        //결과 계산 및 출력
        int result = calculate(input);
        System.out.println("결과 : " + result);
    }
}
