package com.example.demo.dto;

import lombok.Data;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;

/**
 * Author: Mohammed Kharma
 */
@Data
//Generates getters for all fields, a useful toString method, and hashCode and equals implementations that check all non-transient fields

public class CategoryDto {
    private Long id;

    @NotNull
    @Size(min = 3, max = 250)
    private String name;

    private String description;

    private String CreatedBy;

    private Boolean isActive;

    private Date CreationDate;
}
