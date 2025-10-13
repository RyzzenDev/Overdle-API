package com.overdaily.Overdaily.DTO;

import com.overdaily.Overdaily.model.Mapa;

public record MapaSearchDTO (

        String tipoMapa,
        String paisMapa,
        String descricaoMapa,
        String temaMapa,
        String imagemMapa
){
    public MapaSearchDTO (Mapa mapa){
        this(
                mapa.getTipoMapa(),
                mapa.getPaisMapa(),
                mapa.getDescricaoMapa(),
                mapa.getTemaMapa(),
                mapa.getImagemMapa()
        );

    }



}
