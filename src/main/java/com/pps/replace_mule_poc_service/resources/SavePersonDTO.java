package com.pps.replace_mule_poc_service.resources;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class SavePersonDTO extends PersonDTO implements Resource {

    private String nickName;
    private String height;
    private String weight;

}
