package com.jcstechnol.cinema.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SessaoDTO {

    private Long id;
    private Long filmeId;
    private LocalDateTime horario;
    private String sala;
}
