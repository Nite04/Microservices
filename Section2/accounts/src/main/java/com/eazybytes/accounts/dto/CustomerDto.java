package com.eazybytes.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {
    @NotEmpty(message = "name can not be empty")
    @Size(min = 3 , max = 50 , message = "Min 3 character and Maximum 50 character are allowed")
    private String name;
    @NotEmpty(message = "Email can not be empty")
    @Email(message = "Should contain proper email format")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number should be of 10 digit ")
    private String mobileNumber;

    private AccountsDto accountsDto ;

}
