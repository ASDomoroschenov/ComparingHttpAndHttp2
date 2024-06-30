package ru.mai.springtestprometheus.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String firstname;
    private String lastname;
    private Integer weight;
    private Integer height;

}
