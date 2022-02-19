package com.wilsonevs.modelos.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AutoFiltroDTO extends PaginacionDTO {

    private Integer id;
    private String marca;
    private String anos;
    private Integer capacidad;
    private Integer precio;

}
