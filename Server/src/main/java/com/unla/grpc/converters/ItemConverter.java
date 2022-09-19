package com.unla.grpc.converters;

import com.unla.grpc.dtos.ItemDTO;
import com.unla.grpc.models.Item;

public class ItemConverter {

    public ItemConverter(){

    }
    public static Item fromItemDTO_to_Item(ItemDTO itemDTO){
        Item item = new Item();
        item.setIdInvoice(itemDTO.getIdInvoice());
        item.setIdProduct(itemDTO.getIdProduct());
        item.setQuantity(itemDTO.getQuantity());
        item.setSubtotal(itemDTO.getSubtotal());

        return item;
    }

    public static ItemDTO fromItem_to_ItemDTO(Item item){
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(item.getId());
        itemDTO.setIdInvoice(item.getIdInvoice());
        itemDTO.setIdProduct(item.getIdProduct());
        itemDTO.setQuantity(item.getQuantity());
        itemDTO.setSubtotal(item.getSubtotal());

        return itemDTO;
    }
}
