package calculator;

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
            int newlineIndex = input.indexOf("\n");

            if(newlineIndex == -1){
                throw new IllegalArgumentException("커스텀 구분자 입력 형식 오류");
            }

            delimiter += "|" + input.substring(2, newlineIndex);
            numbers = input.substring(newlineIndex + 1);
            
        }

        //커스텀 구분자 입력만 있는 경우 처리
        if(numbers.strip().isEmpty()){
            return 0;
        }

        
        int sum = 0;
        return sum;
    }

    public static void main(String[] args) {
        //입력받기
        String input = camp.nextstep.edu.missionutils.Console.readLine();

    }
}
