package com.eggcampus.util.result;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;

import static com.eggcampus.util.result.AliErrorCode.SUCCESS;

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

    /**
     * 成功结果的创建方法。
     * <p>
     * 用于创建表示操作成功的ReturnResult对象。
     *
     * @param message 操作成功的提示信息。
     * @return ReturnResult对象，表示操作成功。
     */
    public static ReturnResult success(String message) {
        return new ReturnResult(SUCCESS, message, EMPTY_DATA, "");
    }

    /**
     * 成功结果的创建方法。
     * <p>
     * 用于创建表示操作成功的ReturnResult对象，包含数据部分。
     *
     * @param data 操作成功返回的数据。
     * @return ReturnResult对象，表示操作成功。
     */
    public static ReturnResult success(Object data) {
        return new ReturnResult(SUCCESS, "", data, "");
    }

    /**
     * 成功结果的创建方法。
     * <p>
     * 用于创建表示操作成功的ReturnResult对象，包含提示信息和数据部分。
     *
     * @param message 操作成功的提示信息。
     * @param data    操作成功返回的数据。
     * @return ReturnResult对象，表示操作成功。
     */
    public static ReturnResult success(String message, Object data) {
        return new ReturnResult(SUCCESS, message, data, "");
    }

    /**
     * 成功结果的创建方法，允许指定具体的错误码。
     * <p>
     * 用于创建表示操作成功的ReturnResult对象，包含指定的错误码、提示信息和数据部分。
     *
     * @param status  操作成功的错误码。
     * @param message 操作成功的提示信息。
     * @param data    操作成功返回的数据。
     * @return ReturnResult对象，表示操作成功。
     */
    public static ReturnResult success(AliErrorCode status, String message, Object data) {
        return new ReturnResult(status, message, data, "");
    }

    /**
     * 失败结果的创建方法。
     * <p>
     * 用于创建表示操作失败的ReturnResult对象，包含指定的错误码和错误提示信息。
     *
     * @param status  操作失败的错误码。
     * @param message 操作失败的提示信息，用于用户错误提示和错误排查。
     * @return ReturnResult对象，表示操作失败。
     */
    public static ReturnResult failure(AliErrorCode status, String message) {
        return new ReturnResult(status, message, EMPTY_DATA, "");
    }

    /**
     * 失败结果的创建方法。
     * <p>
     * 用于创建表示操作失败的ReturnResult对象，包含指定的错误码、错误提示信息和详细的错误消息。
     *
     * @param status       操作失败的错误码。
     * @param message      操作失败的提示信息，用于用户错误提示和错误排查。
     * @param errorMessage 操作失败的详细错误消息，用于开发人员排查错误。
     * @return ReturnResult对象，表示操作失败。
     */
    public static ReturnResult failure(AliErrorCode status, String message, String errorMessage) {
        return new ReturnResult(status, message, EMPTY_DATA, errorMessage);
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
