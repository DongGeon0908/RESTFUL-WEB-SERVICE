package com.example.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"password"})
//@JsonFilter("UserInfo")
@ApiModel(description = "사용자 상세 정보를 위한 도메인 객체")
@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    // validation
    @Size(min = 2, message = "Name은 2글자 이상 입력해 주세요!")
    @ApiModelProperty(notes = "사용자의 이름을 입력해 주세요")
    private String name;

    @Past
    @ApiModelProperty(notes = "사용자의 등록일을 입력해 주세요")
    private Date joinDate;

    // 외부에 노출시키고 싶지 않는 데이터들
    @ApiModelProperty(notes = "사용자의 패스워드를 입력해 주세요")
    private String password;

    // 외부에 노출시키고 싶지 않는 데이터들
    // @JsonIgnore // 해당 필드를 무시해 달라! <- 전달하지말아라!, 필드로 지정 가능
    @ApiModelProperty(notes = "사용자의 주민등록번호를 입력해 주세요")
    private String ssn;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    public User(int id, String name, Date joinDate, String password, String ssn) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.ssn = ssn;
    }
}
