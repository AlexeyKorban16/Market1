package market.dto;

import lombok.Data;

@Data
public class ProductDto {

    private int id;
    private String productName;
    private int capacity;
    private int price;
}
