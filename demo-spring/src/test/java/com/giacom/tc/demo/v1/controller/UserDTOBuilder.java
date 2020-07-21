package com.giacom.tc.demo.v1.controller;

import com.giacom.tc.demo.v1.dto.UserDTO;

public class UserDTOBuilder {

    private UserDTO dto;

    private UserDTOBuilder() {
    }

    public static UserDTOBuilder create() {
        UserDTOBuilder builder = new UserDTOBuilder();
        builder.dto = new UserDTO();
        builder.dto.setName("name");
        builder.dto.setLastName("last name");
        return builder;
    }

    public UserDTOBuilder withName(String name) {
        dto.setName(name);
        return this;
    }

    public UserDTOBuilder withId(String id) {
        dto.setId(id);
        return this;
    }

    public UserDTOBuilder withLastName(String lastName) {
        dto.setLastName(lastName);
        return this;
    }

    public UserDTOBuilder withAge(int age) {
        dto.setAge(age);
        return this;
    }


    public UserDTO build() {
        return dto;
    }
}
