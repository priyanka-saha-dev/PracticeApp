package patterns.singleton;

public class MySingletonBean {

    public static MySingletonBean instance;

    private MySingletonBean() {}

    public static MySingletonBean getInstance() {

        if(instance == null) {
            synchronized (MySingletonBean.class) {
                instance = new MySingletonBean();
            }
        }

        return instance;
    }
}
