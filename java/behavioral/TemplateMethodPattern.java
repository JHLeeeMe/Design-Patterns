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
 *     - requestConnection(String encodedData): String
 * 
 *   2. 유저가 게임 접속시 다음을 고려해야 합니다.
 *     2-1. 복호화 과정: 받은 데이터를 복호화
 *       - decode(String encodedData): String
 * 
 *     2-2. 인증 과정: userName, password가 일치하는지 확인합니다.
 *       - authentication(String id, String password): boolean
 * 
 *     2-3. 권한 과정: 접속자가 유, 무료 회원인지 마스터인지 확인합니다.
 *       - authorization(String userName): int
 * 
 *     2-4. 접속 과정: 접속자에게 커넥션 정보를 넘겨줍니다.
 *       - connection(String info): String
 */

abstract class AbstGameConnectionHelper {
    protected abstract String decode(String encodedData);
    protected abstract boolean authentication(String id, String password);
    protected abstract int authorization(String userName);
    protected abstract String connection(String decodedData);

    /* Template Method */
    public String requestConnection(String encodedData) {
        // 복호화 과정
        String decodedData = decode(encodedData);
        
        // 복호화된 데이터를 활용해 id, password 할당 (메서드는 따로 정의 안함)
        String id = "aaa";
        String password = "1q2w3e4r";
        String userName;

        // 인증 과정: id, password 일치 여부 확인 & userName 할당
        if (!authentication(id, password)) {
            throw new Error("불일치");
        } else {
            userName = "JHLeeeMe";
        }

        // 권한 과정: 유, 무료 회원 or 마스터 권한 부여
        switch (authorization(userName)) {
            case 0:  // 마스터
                break;
            case 1:  // 유료 회원
                break;
            case 2:  // 무료 회원
                break;
            default:  // 기타
                throw new Error("???");
        }

        // 접속 과정
        String connectionInfo = connection(decodedData);

        return connectionInfo;
    }
}

class GameConnectionHelper extends AbstGameConnectionHelper {

    @Override
    protected String decode(String encodedData) {
        System.out.println("복호화 작업중...");
        String decodedData = encodedData;

        return decodedData;
    }

    @Override
    protected boolean authentication(String id, String password) {
        System.out.println("인증 작업중...");

        return true;
    }

    @Override
    protected int authorization(String userName) {
        System.out.println("권한 할당중...");

        return 0;
    }

    @Override
    protected String connection(String decodedData) {
        System.out.println("접속중...");
        String connectionInfo = "Connection Info";

        return connectionInfo + " >>> 접속 완료.";
    }
}

public class TemplateMethodPattern {
    public static void main(String[] args) {
        String encodedData = "abcde";

        AbstGameConnectionHelper connectionHelper = new GameConnectionHelper();

        String msg = connectionHelper.requestConnection(encodedData);

        System.out.println(msg);
    }
}