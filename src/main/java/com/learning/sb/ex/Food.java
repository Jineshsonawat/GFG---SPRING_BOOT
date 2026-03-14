package com.learning.sb.ex;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


// These are all comes from Lombok dependency. It provides getter, setter etc.

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Food {

    private String name;

}
