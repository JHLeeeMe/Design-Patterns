/**
 * LedFrameworkAdapter pattern
 *  - 이미 제공되는 기능을 변경하여 사용해야 할 때
 * 
 * 예제
 *  - LED 프레임워크가 제공됨.
 *    LED를 끄고 RGB 색상으로 켜고 하는 메서드들을 제공받음.
 * 
 *  - but, 우리 하드웨어는 켜있는 상태에서 다른 색상을 켜면 색이 섞이는 현상이 생겨서,
 *    무조건 한 번 끄고 색상을 켜는 기능을 추가로 하고싶다.
 * 
 *  - 프레임워크를 수정해 버리면, 
 *    하드웨어가 바뀌면 또다시 프레임워크를 되돌려야 하는 부담이 있다.
 */

/* Adaptee */
class LedFramework {
    public int status = 0;
    public String currentColor;

    void ledOn(String color) {
        if (status == 0) {
            System.out.println("LED " + color + " ON");
            this.currentColor = color;
            this.status = 1;
        } else {
            if (this.currentColor.equals(color)) {
                System.out.println("LED " + color + " ON");
                return;
            }

            // 색이 섞이는 경우 발생
            switch (color) {
                case "RED":
                    this.currentColor += " RED";
                    System.out.println("LED " + this.currentColor + " ON");
                    break;
                case "GREEN":
                    this.currentColor += " GREEN";
                    System.out.println("LED " + this.currentColor + " ON");
                    break;
                case "BLUE":
                    this.currentColor += " BLUE";
                    System.out.println("LED " + this.currentColor + " ON");
                    break;
            }
        }
    }

    void ledOff() {
        System.out.println("LED OFF");
        this.status = 0;
        this.currentColor = null;
    }
}

/* Adapter Interface */
interface ILedFramework {
    void ledOff();

    // 기능 수정
    void ledOn(String color);

    // 기능 추가
    void ledBlink(String color);
}

/* Adapter Concrete */
class LedFrameworkAdapter implements ILedFramework {
    private LedFramework led = new LedFramework();

    @Override
    public void ledOff() {
        this.led.ledOff();
    }

    @Override
    public void ledOn(String color) {
        ledOff();
        this.led.ledOn(color);
    }

    @Override
    public void ledBlink(String color) {
        for (int i=0; i<5; i++) {
            // ledOff();
            // this.led.ledOn(color);

            ledOn(color);
        }
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        // 기존 프레임워크 사용
        /*
        LedFramework led = new LedFramework();

        led.ledOn("RED");  // prints "LED RED ON"
        led.ledOn("RED");  // prints "LED RED ON"

        led.ledOff();  // prints "LED OFF"

        led.ledOn("GREEN"); // prints "LED GREEN ON"
        led.ledOn("BLUE");  // prints "LED GREEN BLUE ON"

        led.ledOff();  // prints "LED OFF"

        led.ledOn("RED");  // prints "LED RED ON"
        */

        // LedFrameworkAdapter Pattern 으로 수정, 확장된 프레임워크
        ILedFramework led = new LedFrameworkAdapter();

        led.ledOn("RED");  // prints "LED OFF\n LED RED ON"
        led.ledOn("RED");  // prints "LED OFF\n LED RED ON"

        led.ledOff();  // prints "LED OFF"

        led.ledOn("GREEN"); // prints "LED OFF\n LED GREEN ON"
        led.ledOn("BLUE");  // prints "LED OFF\n LED BLUE ON"

        led.ledOff();  // prints "LED OFF"

        led.ledOn("RED");  // prints "LED OFF\n LED RED ON"

        led.ledBlink("BLUE");
    }
}