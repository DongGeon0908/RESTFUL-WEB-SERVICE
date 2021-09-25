package com.example.restfulwebservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // setter, getter, toString, equalsAndHashCode, RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class HelloWorldBean {
    private String message;
}
