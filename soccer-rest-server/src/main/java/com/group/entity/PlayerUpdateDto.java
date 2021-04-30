package com.group.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerUpdateDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Date signedUpDate;
    private Date dateOfBirth;

}
