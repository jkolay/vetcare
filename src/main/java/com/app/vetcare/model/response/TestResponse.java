package com.app.vetcare.model.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TestResponse {
    private Long id;

    private String testName;


    private Double testCost;
}
