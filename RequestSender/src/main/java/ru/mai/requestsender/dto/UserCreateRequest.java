package ru.mai.requestsender.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequest {

    private String firstname;
    private String lastname;
    private Integer weight;
    private Integer height;

}
