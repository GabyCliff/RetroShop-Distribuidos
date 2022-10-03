package com.unla.grpc.services.implementations;

import com.unla.grpc.constants.Constants;
import com.unla.grpc.converters.ItemConverter;
import com.unla.grpc.converters.ProductConverter;
import com.unla.grpc.dtos.InvoiceDTO;
import com.unla.grpc.dtos.ItemBoughtDTO;
import com.unla.grpc.dtos.ItemDTO;
import com.unla.grpc.dtos.ProductDTO;
import com.unla.grpc.dtos.ResponseData;
import com.unla.grpc.models.Invoice;
import com.unla.grpc.models.Item;
import com.unla.grpc.models.Product;
import com.unla.grpc.repositories.IProductRepository;
import com.unla.grpc.repositories.InvoiceRepository;
import com.unla.grpc.repositories.ItemRepository;
import com.unla.grpc.services.interfaces.IInvoiceService;
import com.unla.grpc.services.interfaces.IItemService;
import com.unla.grpc.utils.Functions;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService implements IItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private IInvoiceService invoiceService;

    @Override
    public ResponseData<ItemDTO> createItem(ItemDTO itemDTO) {
        Functions.viewDetailsInLogIfo(itemDTO.toString()+" ************************************************************\n "+itemDTO.getIdInvoice()+" \n "+itemDTO.getIdProduct()+" \n ");
        Optional<Invoice> invoice = invoiceRepository.findById(itemDTO.getIdInvoice());
        Optional<Product> product = productRepository.findById(itemDTO.getIdProduct());
        if (invoice.isPresent() && product.isPresent()) {
            Item createdItem = itemRepository.save(ItemConverter.fromItemDTO_to_Item(itemDTO));
            return new ResponseData<>(ItemConverter.fromItem_to_ItemDTO(createdItem), Constants.OK);
        } else {
           return new ResponseData<>(null, Constants.ITEM_PRODUCT_AND_OR_INVOICE_NOT_REGISTERED_MESSAGE);
        }
    }

    @Override
    public ResponseData<ItemDTO> getListByIdInvoice(long idInvoice) {
        Optional<Item> itemResult = itemRepository.findByIdInvoice(idInvoice);
        return itemResult.map(
                        item -> new ResponseData<>(ItemConverter.fromItem_to_ItemDTO(item),
                                Constants.OK))
                .orElseGet(
                        () -> new ResponseData<>(null, Constants.ITEM_NOT_FOUND_ERROR_MESSAGE));
    }

    @Override
    public ResponseData<ItemDTO> getById(long id) {
        Optional<Item> itemResult = itemRepository.findById(id);
        return itemResult.map(
                        item -> new ResponseData<>(ItemConverter.fromItem_to_ItemDTO(item),
                                Constants.OK))
                .orElseGet(
                        () -> new ResponseData<>(null, Constants.ITEM_NOT_FOUND_ERROR_MESSAGE));
    }

    @Override
    public ResponseData<ItemDTO> update(long id, long quantity, float subtotal) {
        Optional<Item> item = itemRepository.findById(id);
        if(item.isPresent()) {
            Item createdItem = itemRepository.save(item.get());
            return new ResponseData<>(ItemConverter.fromItem_to_ItemDTO(createdItem), Constants.OK);
        }

        return new ResponseData<>();
    }

    @Override
    public List<ItemDTO> getAllByInvoice(long invoiceId) {
        return itemRepository.findAllByIdInvoice(invoiceId).stream()
                .map(ItemConverter::fromItem_to_ItemDTO).collect(Collectors.toList());
    }

    @Override
    public List<ItemBoughtDTO> getAllBoughtItems(long userId) {
        List<ItemBoughtDTO> itemsBought = new ArrayList<>();
        List<ItemDTO> items = new ArrayList<>();
        List<InvoiceDTO> invoices = invoiceService.getInvoicesByBuyer(userId);
        for (InvoiceDTO inv : invoices){
            items.addAll(getAllByInvoice(inv.getId()));
        }

        for (ItemDTO itemDTO : items){
            Product product = productRepository.findById(itemDTO.getIdProduct()).orElse(null);
            itemsBought.add(new ItemBoughtDTO(itemDTO.getId(),
                    product == null ? new ProductDTO() : ProductConverter.fromProduct_to_ProductDTO(product),
                    itemDTO.getQuantity(), itemDTO.getSubtotal(), itemDTO.getIdInvoice()));
        }

        return itemsBought;
    }

}
