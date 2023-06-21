package market.dto;

import lombok.Data;

import java.util.List;

@Data
public class CustomerDto {

    private int id;
    private String name;
    private String email;
    private String gender;
    private int number;
    private List<ProductDto> products;
}
