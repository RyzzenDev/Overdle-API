package com.overdaily.Overdaily.DTO;

import com.overdaily.Overdaily.model.Map;

public record MapaSearchDTO (

        String tipoMapa,
        String paisMapa,
        String descricaoMapa,
        String temaMapa,
        String imagemMapa
){
    public MapaSearchDTO (Map map){
        this(
                map.getMapType(),
                map.getMapCountry(),
                map.getMapDescription(),
                map.getMapThemeSong(),
                map.getMapPhoto()
        );

    }



}
