package com.serendipity.seckillsystem.exception;

import com.serendipity.seckillsystem.result.CodeMsg;
import lombok.Getter;
import lombok.Setter;

/**
 * @author serendipity
 */
@Getter
@Setter
public class GlobalException extends RuntimeException {
    private CodeMsg cm;
    public GlobalException(CodeMsg cm) {
        super(cm.toString());
        this.cm = cm;
    }
}
