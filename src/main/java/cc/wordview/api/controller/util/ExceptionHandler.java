package cc.wordview.api.controller.util;

import java.util.concurrent.Callable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class ExceptionHandler {
        public static <T> ResponseEntity<?> response(Callable<T> callable) {
                try {
                        return (ResponseEntity<?>) callable.call();
                }
                catch (Exception e) {
                        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
                }
        }


}
