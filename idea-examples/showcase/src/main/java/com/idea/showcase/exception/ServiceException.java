package com.idea.showcase.exception;

/**
 * @author andaicheng
 */
public class ServiceException extends BaseRuntimeException {

    private static final long serialVersionUID = -9217112187240173709L;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
