package com.belajar.mocking.dto.outbound;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserPetstoreOutboundDto {
    public Integer id;
    public String username;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String phone;
    public Integer userStatus;

}
