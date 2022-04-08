package com.pps.replace_mule_poc_service;

import com.pps.replace_mule_poc_service.resources.SavePersonDTO;
import org.springframework.stereotype.Service;

@Service
public class GenericService {

    public SavePersonDTO createPerson(SavePersonDTO dto) throws GenericException {
        if (dto.getHeight() == null ) {
            throw new GenericException("Height cannot be null when creating a new person");
        }
        if (dto.getWeight() == null) {
            throw new GenericException("Weight cannot be null when creating a new person");
        }
        dto.setFirstName("Ion");
        dto.setLastName("ILIESCU");
        dto.setNickName("Pharaoh");
        return dto;
    }
}
