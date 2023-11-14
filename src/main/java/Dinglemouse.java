import java.util.*;

public class Dinglemouse {

    String name;
    int age;
    char sex;

    private LinkedHashSet<String> setOrder = new LinkedHashSet<>();
    public Dinglemouse() {
    }

    public Dinglemouse setAge(int age) {
        this.age = age;
        add("age");
        return this;
    }

    private void add(String attr) {
        if (setOrder.stream().anyMatch(m -> m == attr)) {
            return;
        };
        setOrder.add(attr);
    }

    public Dinglemouse setSex(char sex) {
        this.sex = sex;
        add("sex");
        return this;
    }

    public Dinglemouse setName(String name) {
        this.name = name;
        add("name");
        return this;
    }

    public String hello() {
        final StringBuilder sb = new StringBuilder("Hello.");
        final Iterator iterator = setOrder.iterator();

        while (iterator.hasNext()) {
            final String param = (String) iterator.next();
            if (param.equals("name")) {
                sb.append(String.format(" My name is %s.", this.name));
            } else if (param.equals("age")) {
                sb.append(String.format(" I am %s.", age));
            } else {
                sb.append(String.format(" I am %s", sex=='M'? "male." : "female."));
            }
        }
        return sb.toString();
    }

}