package com.wilsonevs.modelos.modelo;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Auto {

    private Integer id;
    private String marca;
    private String anos;
    private Integer capacidad;
    private Integer precio;

}
