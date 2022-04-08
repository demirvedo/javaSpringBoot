package com.vedatdemirdev.dto;

import com.vedatdemirdev.entity.Address;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class PersonDto {

    private Long id;

    private String name;

    private String surname;

    private List<String> addresses;
}
