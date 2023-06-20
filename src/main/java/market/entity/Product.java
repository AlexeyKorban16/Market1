package market.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.yaml.snakeyaml.events.Event;



@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Product {
    @Id

    private int servicelife;
    private String productName;
    private int capacity;
    private int price;
   // private String reducingcountry;

}
