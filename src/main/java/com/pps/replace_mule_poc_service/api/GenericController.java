package com.pps.replace_mule_poc_service.api;

import com.pps.replace_mule_poc_service.GenericException;
import com.pps.replace_mule_poc_service.GenericService;
import com.pps.replace_mule_poc_service.resources.AddressDTO;
import com.pps.replace_mule_poc_service.resources.ErrorResponse;
import com.pps.replace_mule_poc_service.resources.PersonDTO;
import com.pps.replace_mule_poc_service.resources.Resource;
import com.pps.replace_mule_poc_service.resources.SavePersonDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class GenericController {

    public final GenericService genericService;

    public GenericController(GenericService genericService) {
        this.genericService = genericService;
    }

    @GetMapping
    public Mono<PersonDTO> getDummyPerson() {
        return Mono.just(createDummyData());
    }

    @PostMapping
    public ResponseEntity<Resource> saveDummyData(@RequestBody SavePersonDTO dto) {
        final SavePersonDTO savedPersonDTO;
        try {
            savedPersonDTO = genericService.createPerson(dto);
        } catch (GenericException e) {
            return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.name(), e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(savedPersonDTO, HttpStatus.CREATED);
    }

    private PersonDTO createDummyData() {
        return PersonDTO.builder()
                .firstName("Bogdan")
                .lastName("Enache")
                .address(AddressDTO.builder()
                        .city("Bucharest")
                        .district("Ilfov")
                        .streetName("Bd Maniu")
                        .streetNumber("11A")
                        .zipCode("3123321")
                        .build())
                .build();
    }

}
