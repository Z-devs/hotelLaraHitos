package com.hotel.java.application.domain.factories;

import com.hotel.java.application.domain.entities.TipoEntity;
import com.hotel.java.application.models.TipoModel;

import java.util.ArrayList;
import java.util.List;

public class TipoFactory {
    public TipoEntity tipoModel2Entity (TipoModel tipoModel){
        TipoEntity tipoEntity = new TipoEntity (
                tipoModel.getId (),
                tipoModel.getNombre (),
                tipoModel.getDescripcion ()
        );
        return tipoEntity;
    }


    public TipoModel tipoEntity2Model (TipoEntity tipoEntity){
        TipoModel tipoModel = new TipoModel (
                tipoEntity.getId (),
                tipoEntity.getNombre (),
                tipoEntity.getDescripcion ()
        );
        return tipoModel;
    }


    public List<TipoEntity> tipoListModel2Entity (List<TipoModel> tipoModels){
        List<TipoEntity> tipoEntities = new ArrayList<> ();
        for (TipoModel tipo : tipoModels){
            TipoEntity tipoEntity =
                    new TipoEntity (
                            tipo.getId (),
                            tipo.getNombre (),
                            tipo.getDescripcion ()
                    );
        }
        return tipoEntities;
    }
}
