package com.group.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamUpdateDto {
    private Long id;
    private String teamName;
    private String league;
}
