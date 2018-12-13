/**
 * 返回信息
 * @author sjf0115
 * @date 2018/12/12 下午3:20
 */
public class Response<T> {

    private String resultMsg;
    private String exStack;
    private String errorDesc;
    private String errorCode;
    private String code;
    private boolean success;
    private String solution;
    private String opers;
    private T data;

    public String getResultMsg() {
        return resultMsg;
    }

    public String getExStack() {
        return exStack;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getCode() {
        return code;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getSolution() {
        return solution;
    }

    public String getOpers() {
        return opers;
    }

    public T getData() {
        return data;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Response<T> withResultMsg(String resultMsg) {
        this.setResultMsg(resultMsg);
        return this;
    }

    public void setExStack(String exStack) {
        this.exStack = exStack;
    }

    public Response<T> withExStack(String exStack){
        this.setExStack(exStack);
        return this;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public Response<T> withErrorDesc(String errorDesc){
        this.setErrorDesc(errorDesc);
        return this;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Response<T> withErrorCode(String errorCode){
        this.setErrorCode(errorCode);
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Response<T> withCode(String code){
        this.setCode(code);
        return this;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Response<T> withSuccess(boolean success){
        this.setSuccess(success);
        return this;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public Response<T> withSolution(String solution){
        this.setSolution(solution);
        return this;
    }

    public void setOpers(String opers) {
        this.opers = opers;
    }

    public Response<T> withOpers(String opers){
        this.setOpers(opers);
        return this;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Response<T> withData(T data){
        this.setData(data);
        return this;
    }

    public static <T> Response<T> of(boolean isSuccess, T data, String message, String errorDesc) {
        return (new Response()).withData(data)
                .withResultMsg(message)
                .withSuccess(isSuccess)
                .withErrorDesc(errorDesc);
    }

    public static <T> Response<T> error(T data, String message, String errorDesc) {
        return of(false, data, message, errorDesc);
    }

    public static <T> Response<T> error() {
        return error(null, "Internal Server Error", null);
    }

    public static <T> Response<T> error(String message) {
        return error(null, message, null);
    }

    public static <T> Response<T> error(String message, String errorDesc) {
        return error(null, message, errorDesc);
    }

    public static <T> Response<T> ok(T data, String message) {
        return of(true, data, message, null);
    }

    public static <T> Response<T> ok(T data) {
        return ok(data, "OK");
    }

    public static <T> Response<T> ok() {
        return ok(null, "OK");
    }
}
