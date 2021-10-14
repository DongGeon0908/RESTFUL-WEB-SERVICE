package com.example.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(value = {"password"})
public class User {
    private Integer id;

    // validation
    @Size(min = 2, message = "Name은 2글자 이상 입력해 주세요!")
    private String name;

    @Past
    private Date joinDate;

    // 외부에 노출시키고 싶지 않는 데이터들
    private String password;

    // 외부에 노출시키고 싶지 않는 데이터들
    @JsonIgnore // 해당 필드를 무시해 달라! <- 전달하지말아라!, 필드로 지정 가능
    private String ssn;
}
