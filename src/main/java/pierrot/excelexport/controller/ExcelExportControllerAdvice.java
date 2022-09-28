package pierrot.excelexport.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pierrot.excelexport.domain.ErrorResponse;
import pierrot.excelexport.exception.ExcelTemplateNotReadException;

import java.io.IOException;
import java.time.LocalTime;

@ControllerAdvice("pierrot.excelexport.controller")
public class ExcelExportControllerAdvice {
    @ExceptionHandler({ExcelTemplateNotReadException.class})
    public ResponseEntity<ErrorResponse> handle(IOException ex) {

        ErrorResponse errorResp = new ErrorResponse();
        errorResp.setErrorMsg(ex.getMessage());
        errorResp.setTimeStamp(LocalTime.now());
        return new ResponseEntity<>(errorResp,HttpStatus.BAD_REQUEST);
    }

}
