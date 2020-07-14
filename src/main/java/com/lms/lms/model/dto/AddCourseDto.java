package com.lms.lms.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lms.lms.enums.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AddCourseDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("espb")
    private double espb;

    @JsonProperty("type")
    private Type type;

    @JsonProperty("accessPassword")
    private String accessPassword;

    @JsonProperty("professorId")
    private long professorId;
}
