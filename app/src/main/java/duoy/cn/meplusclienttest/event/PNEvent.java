package duoy.cn.meplusclienttest.event;

/**
 * Created by dandanba on 3/3/16.
 */
public class PNEvent {//声明event
    private Object message;

    public PNEvent(Object message) {
        this.message = message;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}
