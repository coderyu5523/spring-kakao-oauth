package org.example.loginapp.shop;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Table(name = "shop_tb")
@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String name; // 상품명
    private String price; // 가격
    private Integer qty ; // 재고

    @Builder
    public Shop(Integer id, String name, String price, Integer qty) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }
}
