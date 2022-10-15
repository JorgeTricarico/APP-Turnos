package com.miturno.mapper;

import com.miturno.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserResponse {

    @Mappings({
            @Mapping(target = "password", ignore = true),
            @Mapping(target = "createAt", ignore = true),
            @Mapping(target = "updateAt", ignore = true),

    })
    public User UserResponseToUser(UserResponse userResponse);
    public UserResponse userToUserResponse(User user);
}
