package com.register.demo.Payload.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommonResponse {
    private String message;
    private int status;

    public CommonResponse(String message) {
        this.message = message;
    }

}
