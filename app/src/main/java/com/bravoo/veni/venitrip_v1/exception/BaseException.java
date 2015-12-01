package com.bravoo.veni.venitrip_v1.exception;

/**
 * Created by msi on 2015/12/1.
 */
public class BaseException extends RuntimeException{
    private static final long serialVersionUID=1L;
    public BaseException(){
        super();
    }

    public BaseException(String detailMessage,Throwable throwable){
        super(detailMessage,throwable);
    }

    public BaseException(String detailMessage){
        super(detailMessage);
    }

    public BaseException(Throwable throwable){
        super(throwable);
    }
}
