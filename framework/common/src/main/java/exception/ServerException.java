package exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import utils.ErrorCode;

/*
 * @description: 业务逻辑异常 Exception
 * @author: zpLone
 * @date: 2023/3/23 19:41
 **/
@Data
@EqualsAndHashCode
public final class ServerException extends RuntimeException{

    /**
     * 全局错误码
     *
     */
    private Integer code;
    /**
     * 错误提示
     */
    private String message;

    /**
     * 空构造方法，避免反序列化问题
     */
    public ServerException() {
    }

    public ServerException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMsg();
    }

    public ServerException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public ServerException setCode(Integer code) {
        this.code = code;
        return this;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public ServerException setMessage(String message) {
        this.message = message;
        return this;
    }

}
