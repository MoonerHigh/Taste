package utils;

import lombok.Data;
/*
 * @description: 错误码
 * @author: zpLone
 * @date: 2023/3/23 15:00
 **/
@Data
public class ErrorCode {
    /**
     * 错误码
     */
    private final Integer code;
    /**
     * 错误提示
     */
    private final String msg;

    public ErrorCode(Integer code, String message) {
        this.code = code;
        this.msg = message;
    }
}
