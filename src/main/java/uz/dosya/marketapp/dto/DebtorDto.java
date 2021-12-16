package uz.dosya.marketapp.dto;

import lombok.Data;

@Data
public class DebtorDto {
    private String firstName;
    private String lastName;
    private String productName;
    private String description;
    private String phone;
    private Long date;
}
