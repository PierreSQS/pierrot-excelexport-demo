package pierrot.excelexport.domain;

import java.time.LocalTime;

public class ErrorResponse {
    private String errorMsg;
    private LocalTime timeStamp;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public LocalTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
