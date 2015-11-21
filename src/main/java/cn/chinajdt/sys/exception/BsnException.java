package cn.chinajdt.sys.exception;

/**
 * Created by Jacky on 15/11/8.
 */
public class BsnException extends Exception {

    public BsnException( String msg){
        this.msg = msg ;
    }

    private int errorType ;

    private String errorCode ;

    private String msg ;

    public int getErrorType() {
        return errorType;
    }

    public void setErrorType(int errorType) {
        this.errorType = errorType;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
