package me.nightwarrior.epay;

import me.nightwarrior.epay.model.Response;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(value = "me.nightwarrior.epay.controller")
@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class ExceptionHandlerAdvice {

    public enum Error{
        RUN_TIME_ERROR("01"),
        ILLEGAL_ARGUMENT_ERROR("02");

        private String name;

        Error( String name ){
            this.name = name;
        }

        public String getName(){
            return this.name;
        }
    }

    private Response exceptionResponse(Exception e, Error error) {
        Response response = new Response();
        response.setErrorCode(error.getName());
        response.setErrorDesc(e.getMessage());
        return response;
    }

    @ExceptionHandler(value = RuntimeException.class)
    public Response handleRunTimeException(RuntimeException e) {
        return exceptionResponse(e, Error.RUN_TIME_ERROR);
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public Response handleRunTimeException(IllegalArgumentException e) {
        return exceptionResponse(e, Error.ILLEGAL_ARGUMENT_ERROR);

    }
}
