package duoy.cn.meplusclienttest.event;

/**
 * Created by Dream on 2016/3/8.
 */
public class ScannerEvent {
    private String content;

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public ScannerEvent(String content){
        this.content = content;
    }
}
