package com.unla.grpc.services.interfaces;

import com.unla.grpc.dtos.ItemDTO;
import com.unla.grpc.dtos.ResponseData;

public interface IItemService {

    ResponseData<ItemDTO> createItem(ItemDTO itemDTO);

    ResponseData<ItemDTO> getListByIdInvoice(long invoice);

    ResponseData<ItemDTO> getById(long id);

    ResponseData<ItemDTO> update(long id, long quantity, float subtotal);
}
