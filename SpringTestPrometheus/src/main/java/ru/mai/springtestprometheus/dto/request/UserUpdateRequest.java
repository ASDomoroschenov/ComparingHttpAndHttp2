package ru.mai.springtestprometheus.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequest {

    private Long id;
    private String firstname;
    private String lastname;
    private Integer weight;
    private Integer height;

}
