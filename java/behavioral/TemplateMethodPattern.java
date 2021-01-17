/**
 * Template Method Pattern
 *   - 일련의 행위를 하는 메서드(template method)를 정의하는 패턴
 *   - 템플릿 메서드 변경 없이(구조 변경x),
 *     행위(메서드)들을 재정의 할 수 있다.
 * 
 *   1. 추상 클래스를 만들고
 *   2. 그 안에 추상 메서드로 행위들을 만든다.
 *   3. 템플릿 메서드를 만든다. (추상 x)
 *   4. 콘크리트 클래스를 만든다.
 * 
 * 예제 (출처: https://www.youtube.com/watch?v=qr7I18Lhsl8)
 *   1. 신작 게임의 접속을 구현해주세요.
 *     - requestConnection(String str): String
 *   2. 유저가 게임 접속시 다음을 고려해야 합니다.
 *     2-1. 보안 과정: 보안 관련 부분 처리
 *       - doSecurity(String str): String
 *     2-2. 인증 과정: userName, password가 일치하는지 확인합니다.
 *       - authentication(String userName, String password): boolean
 *     2-3. 권한 과정: 접속자가 유, 무료 회원인지 마스터인지 확인합니다.
 *       - authorization(String userName): int
 *     2-4. 접속 과정: 접속자에게 커넥션 정보를 넘겨줍니다.
 *       - connection(String info): String
 */

abstract class AbstGameConnectionHelper {
}

class GameConnectionHelper extends AbstGameConnectionHelper {
}

public class TemplateMethodPattern {
    public static void main(String[] args) {
    }
}