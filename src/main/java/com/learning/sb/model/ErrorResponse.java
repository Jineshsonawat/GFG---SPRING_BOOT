package com.learning.sb.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@Getter
@Setter
@Builder
@JsonDeserialize
@JsonSerialize
public class ErrorResponse {

    private String message;
}
