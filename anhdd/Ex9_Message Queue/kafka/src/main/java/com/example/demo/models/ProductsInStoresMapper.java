package com.example.demo.models;

import com.example.demo.dto.ProductInStoresdto;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedNativeQuery(
        name = "products_in_stores",
        query =
                "Select S.id as store, COALESCE(sum(P.val_amount), 0) as product_num , now() as created_date\n" +
                        "FROM products P RIGHT JOIN stores S\n" +
                        "ON P.store = S.id\n" +
                        "GROUP BY S.id\n" +
                        "ORDER BY product_num DESC;",
        resultSetMapping = "products_in_stores_dto"
)
@SqlResultSetMapping(
        name = "products_in_stores_dto",
        classes = @ConstructorResult(
                targetClass = ProductInStoresdto.class,
                columns = {
                        @ColumnResult(name = "store", type = Integer.class),
                        @ColumnResult(name = "product_num", type = Integer.class),
                        @ColumnResult(name = "created_date", type = Date.class)
                }
        )
)
public class ProductsInStoresMapper{
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
