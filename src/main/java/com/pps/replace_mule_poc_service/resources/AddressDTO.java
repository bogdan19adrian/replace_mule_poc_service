package com.pps.replace_mule_poc_service.resources;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class AddressDTO {
    private String streetName;
    private String streetNumber;
    private String zipCode;
    private String city;
    private String district;
}
