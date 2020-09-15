package com.hotel.java.application.domain.factories;

import com.hotel.java.application.domain.entitiesHB.ClienteEntity;
import com.hotel.java.application.models.ClienteModel;

import java.util.ArrayList;
import java.util.List;

public class ClienteFactory {

    public ClienteEntity clienteModel2Entity (ClienteModel clienteModel){
        ClienteEntity clienteEntity =
                new ClienteEntity (
                    clienteModel.getNombre (),
                    clienteModel.getApellido (),
                    clienteModel.getEmail ());
        return clienteEntity;
    }

    public ClienteModel clienteEntity2Model (ClienteEntity clienteEntity){
        ClienteModel clienteModel =
                new ClienteModel (
                    clienteEntity.getId (),
                    clienteEntity.getNombre (),
                    clienteEntity.getApellido (),
                    clienteEntity.getEmail ()
                );
        return clienteModel;
    }

    public List<ClienteEntity> clienteListEntity2Model (List<ClienteModel> clienteModels){
        List<ClienteEntity> clienteEntities = new ArrayList<> ();
        for (ClienteModel cliente : clienteModels){
            ClienteEntity clienteEntity =
                    new ClienteEntity (
                        cliente.getNombre (),
                        cliente.getApellido (),
                        cliente.getEmail ()
            );
        }
        return clienteEntities;
    }

    public List<ClienteModel> clienteListModel2Entity (List<ClienteEntity> clienteEntities){
        List<ClienteModel> clienteModels = new ArrayList<> ();
        for (ClienteEntity cliente : clienteEntities){
            ClienteModel clienteModel =
                    new ClienteModel (
                            cliente.getId (),
                            cliente.getNombre (),
                            cliente.getApellido (),
                            cliente.getEmail ()
                    );
        }
        return clienteModels;
    }

}
