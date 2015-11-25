package cn.chinajdt.sys;

/**
 * Created by Jacky on 15/11/24.
 */
public class ResponseBean {

    public static final int SUCCESS = 1 ;
    public static final int FAILURE = -1 ;
    public static final int WAITING = 0 ;

    public ResponseBean(){

    }

    public ResponseBean( int result ){
        this.result = result ;
    }

    public ResponseBean( int result, String info ){
        this.result = result ;
        this.info = info ;
    }

    public ResponseBean( int result, String info ,Object data ){
        this.result = result ;
        this.info = info ;
        this.data = data ;
    }

    private int result ;

    private String info ;

    private Object data ;

    public int getResult() {
        return result;
    }

    public String getInfo() {
        return info;
    }

    public Object getData() {
        return data;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
