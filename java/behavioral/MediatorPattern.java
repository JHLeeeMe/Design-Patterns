/**
 * Mediator Pattern
 *   중재자를 통해 행동을 실행하므로, 객체간 결합도를 낮출 수 있다.
 */

import java.util.List;
import java.util.ArrayList;

abstract class Mediator {
    protected List<User> users = new ArrayList<>();

    public boolean addUser(User user) {
        if (users == null) {
            return false;
        }

        return users.add(user);
    }

    public abstract void mediate(String data);
}

abstract class User {
    private Mediator mediator;

    public boolean join(Mediator mediator) {
        if (mediator == null) {
            return false;
        }

        this.mediator = mediator;

        return this.mediator.addUser(this);
    }

    public void sendData(String data) {
        if (mediator != null) {
            mediator.mediate(data);
        }
    }

    protected abstract void handle(String data);
}

/* Concrete Mediator */
class ChatMediator extends Mediator {
    @Override
    public void mediate(String data) {
        for (User user: users) {
            user.handle(data);
        }
    }
}

/* Conncrete User */
class ChatUser extends User {
    @Override
    public void handle(String data) {
        System.out.println(this.hashCode() + "-" + data);
    }
}

public class MediatorPattern {
    public static void main(String[] args) {
        Mediator mediator = new ChatMediator();

        User user1 = new ChatUser();
        User user2 = new ChatUser();
        User user3 = new ChatUser();

        // 중재자와 연결
        user1.join(mediator);
        user2.join(mediator);
        user3.join(mediator);

        user1.sendData("AAA");
        System.out.println();
        user2.sendData("BBB");
        System.out.println();
        user3.sendData("CCC");
    }
}
