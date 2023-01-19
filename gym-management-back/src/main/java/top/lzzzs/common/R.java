package top.lzzzs.common;

import java.io.Serializable;

public class R implements Serializable {
    private int code;
    private String message;
    private Object data;

    public static R set(Rcode rcode) {
        R r = new R();

        r.setCode(rcode.code());
        r.setMessage(rcode.message());
        r.setData(null);

        return r;
    }

    public static R set(int code, String message) {
        R r = new R();

        r.setCode(code);
        r.setMessage(message);
        r.setData(null);

        return r;
    }

    public static R set(int code, String message, Object data) {
        R r = new R();

        r.setCode(code);
        r.setMessage(message);
        r.setData(data);

        return r;
    }


    public static R success(String message, Object data) {
        return R.set(Rcode.SUCCESS.code(), message, data);
    }

    public static R success(Object data) {
        return R.set(Rcode.SUCCESS.code(), Rcode.SUCCESS.message(), data);
    }

    public static R error() {
        return R.set(Rcode.SYSTEM_INNER_ERROR);
    }

    public static R error(Rcode rcode) {
        return R.set(rcode);
    }


    @Override
    public String toString() {
        return "R{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
