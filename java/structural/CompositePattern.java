/**
 * Composite Pattern
 *   - 객체를 트리 구조로 구성해 계층을 표현하는 패턴
 * 
 * Folder Architecture
 *   root
 *     |
 *     |-- home
 *     |     `-- jhleeeme
 *     |           |-- music
 *     |           |     |-- track1
 *     |           |     `-- track2
 *     |           |-- picture
 *     |           |     `-- pic1 
 *     |           `-- doc
 *     |                 `-- doc1
 *     `-- usr
 *           `-- java
 */

import java.util.ArrayList;
import java.util.List;

abstract class Component {
    private String name;

    public Component(String name) {
        setName(name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class File extends Component {
    private Object data;

    public File(String name) {
        super(name);
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

/* Composite class */
class Folder extends Component {
    private List<Component> children = new ArrayList<>();

    public Folder(String name) {
        super(name);
    }

    public boolean addComponent(Component component) {
        return children.add(component);
    }

    public boolean removeComponent(Component component) {
        return children.remove(component);
    }

    public List<Component> getChildren() {
        return this.children;
    }
}

public class CompositePattern {
    public static void main(String[] args) {
        File 
            track1 = new File("track1"),
            track2 = new File("track2"),
            pic1 = new File("pic1"),
            doc1 = new File("doc1"),
            java = new File("java");

        Folder
            root = new Folder("root"),
            home = new Folder("home"),
            jhleeeme = new Folder("jhleeeme"),
            music = new Folder("music"),
            picture = new Folder("picture"),
            doc = new Folder("doc"),
            usr = new Folder("usr");

        root.addComponent(home);
            home.addComponent(jhleeeme);
                jhleeeme.addComponent(music);
                    music.addComponent(track1);
                    music.addComponent(track2);
                jhleeeme.addComponent(picture);
                    picture.addComponent(pic1);
                jhleeeme.addComponent(doc);
                    doc.addComponent(doc1);
        root.addComponent(usr);
            usr.addComponent(java);

        tree(root);
    }

    public static void tree(Component component) {
        System.out.println(component.getClass().getName() + "|" + component.getName());

        if (component instanceof Folder) {
            for (Component c : ((Folder)component).getChildren()) {
                tree(c);
            }
        }
    }
}