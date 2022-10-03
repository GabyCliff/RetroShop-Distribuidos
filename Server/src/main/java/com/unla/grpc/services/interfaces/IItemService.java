package com.unla.grpc.services.interfaces;

import com.unla.grpc.dtos.ItemBoughtDTO;
import com.unla.grpc.dtos.ItemDTO;
import com.unla.grpc.dtos.ResponseData;
import java.util.List;

public interface IItemService {

    ResponseData<ItemDTO> createItem(ItemDTO itemDTO);

    ResponseData<ItemDTO> getListByIdInvoice(long invoice);

    ResponseData<ItemDTO> getById(long id);

    ResponseData<ItemDTO> update(long id, long quantity, float subtotal);

    List<ItemDTO> getAllByInvoice(long invoiceId);

    List<ItemBoughtDTO> getAllBoughtItems(long userId);
}
