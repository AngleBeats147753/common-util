package com.eggcampus.util.result;

import lombok.Data;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;

import static com.eggcampus.dada.backend.util.result.AliErrorCode.SUCCESS;
import static com.eggcampus.dada.backend.util.result.AliErrorCode.USER_ERROR_A0400;

/**
 * 返回信息的包装类
 *
 * @author 黄磊
 * @since 2020/4/29
 */
@Data
public class ReturnResult implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final HashMap<String, Object> EMPTY_DATA = new HashMap<>(0);

    public static ReturnResult getSuccessReturn(String message) {
        return new ReturnResult(SUCCESS, message, EMPTY_DATA, "");
    }

    public static ReturnResult getSuccessReturn(Object data) {
        return new ReturnResult(SUCCESS, "", data, "");
    }

    public static ReturnResult getSuccessReturn(String message, Object data) {
        return new ReturnResult(SUCCESS, message, data, "");
    }

    public static ReturnResult getSuccessReturn(AliErrorCode status, String message, Object data) {
        return new ReturnResult(SUCCESS, message, data, "");
    }

    /**
     * 获取错误的返回
     *
     * @param message 返回的错误信息（用户错误提示、错误排查时的提示）
     * @return 装有错误信息的Return
     */
    public static ReturnResult getFailureReturn(AliErrorCode status, String message) {
        return new ReturnResult(status, message, EMPTY_DATA, "");
    }

    public static ReturnResult getFailureReturn(AliErrorCode status, String message, String errorMessage) {
        return new ReturnResult(status, message, EMPTY_DATA, errorMessage);
    }

    /**
     * 用于包装参数校验出错时的错误信息
     *
     * @param bindingResult 校验结果
     * @return 装有错误信息的Return
     */
    public static ReturnResult getFailureReturn(BindingResult bindingResult) {
        StringBuilder stringBuilder = new StringBuilder();
        bindingResult.getAllErrors().forEach(o -> {
            FieldError error = (FieldError) o;
            if (error.isBindingFailure()) {
                stringBuilder.append(String.format("无法将%s作为%s的值", error.getRejectedValue(), error.getField())).append("\n");
            } else {
                stringBuilder.append(error.getField()).append(" : ").append(error.getDefaultMessage()).append("\n");
            }
        });
        return new ReturnResult(USER_ERROR_A0400, stringBuilder.toString(), EMPTY_DATA, "");
    }

    /**
     * 状态码
     */
    private AliErrorCode status;
    /**
     * 返回给用户的提示信息
     */
    private String message;
    /**
     * 返回数据
     */
    private Object data;
    /**
     * 返回的错误排查时的提示（主要是给前端、纠错人员看的信息）
     */
    private String errorMessage;

    protected ReturnResult() {
    }

    public ReturnResult(AliErrorCode status, String message, Object data, String errorMessage) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.errorMessage = errorMessage;
    }
}
