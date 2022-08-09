package com.example.transakspenjualan.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Integer id;

    private String username;

    private String noTelp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String token;
}
