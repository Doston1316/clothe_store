package uz.dosya.marketapp.error;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorDetails {
    private String massage;

    public ErrorDetails(String message, String error) {
        this.massage=message;
    }
}
