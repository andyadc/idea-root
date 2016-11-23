package com.idea.showcase.exception;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * @author andaicheng
 */
public abstract class BaseRuntimeException extends RuntimeException {

    private static final long serialVersionUID = -6880390158961211369L;

    private String errorCode;

    public BaseRuntimeException(String message) {
        super(message);
    }

    public BaseRuntimeException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BaseRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getErrorCode() {
        return errorCode;
    }

    //生成一个异常流水号，追加到错误消息上显示到前端用户，用户反馈问题时给出此流水号给运维或开发人员快速定位对应具体异常细节
    public static String buildExceptionCode() {
        return "ERR" + DateFormatUtils.format(new java.util.Date(), "yyMMddHHmmss") + RandomStringUtils.randomNumeric(3);
    }
}
