package com.github.rxyor.common.core.exception;


import lombok.Getter;
import lombok.ToString;

/**
 *<p>
 *
 *</p>
 *
 * @author liuyang
 * @date 2019-05-15 Wed 17:13:00
 * @since 1.0.0
 */
@ToString(callSuper = true)
public class NewInstanceException extends ReflectException {

    static final long serialVersionUID = 3626215591603359027L;

    @Getter
    protected String msg;

    public NewInstanceException() {
        this("duplicate data exception");
    }

    public NewInstanceException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public NewInstanceException(Throwable e) {
        super(e.getMessage());
        this.msg = e.getMessage();
    }

}
