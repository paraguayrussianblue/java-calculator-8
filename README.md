# java-calculator-precourse
----
## 구현 기능 목록

### 1)입력 받기 및 빈 문자열 처리
- readline()을 이용하여 문자열을 입력받는다.
- 입력이 null이거나 공백만 있다면 합을 0으로 처리한다.
- 기본 구분자 ','와 ';'을 delimiter로 선언한다.
- 커스텀 구분자를 입력한 경우 이것을 처리하여 delimiter에 추가한다.
- 문자열이 "//"로 시작하지만 "\n"이 없는 경우 IllegalArgumentException을 발생시킨다.

### 2)문자열 처리 및 계산
- 구분자를 기준으로 입력된 문자열을 분리한다.
- 분리된 각 token이 유효한 경우 sum에 더하여 반환한다.
- 각 token 유효하지 않은 경우 IllegalArgumentException을 발생시킨다.
- 각 token이 유효하지 않은 경우\
1)token이 음수인 경우\
2)token이 정수가 아니거나, 공백이나 기호를 포함하는 경우

### 3)계산 결과 출력
- 계산 결과를 츌력한다.