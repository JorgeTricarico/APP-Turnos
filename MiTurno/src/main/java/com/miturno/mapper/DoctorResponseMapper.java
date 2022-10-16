package com.miturno.mapper;

import com.miturno.models.Doctor;
import com.miturno.models.User;
import com.miturno.models.dto.DoctorResponse;
import com.miturno.models.dto.LoginRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface DoctorResponseMapper extends UserResponseMapper {
    public Doctor doctorResponseToDoctor(DoctorResponse doctorResponse);
    public DoctorResponse doctorToDoctorResponse(Doctor doctor);
}
