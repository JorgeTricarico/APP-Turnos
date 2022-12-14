package com.miturno.models.dto;

import com.miturno.models.Speciality;
import com.miturno.models.Turn;
import lombok.Data;

import java.time.DayOfWeek;
import java.util.List;

@Data
public class DoctorResponse {

    private String roles;
    private Long id;
    private String name;
    private String lastName;
    private String documentType;
    private Long document;
    private String email;

    private List<Speciality> specialties;
    private List<DayOfWeek> attentionDays;
    private List<Integer> attentionTurn;
    private List<Turn> turns;
}
