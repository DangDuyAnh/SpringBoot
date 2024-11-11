package com.example.dataconnect.modelJPA;

import com.example.dataconnect.dto.CategoryWithAmountDto;

import javax.persistence.*;

@Entity
@NamedNativeQuery(
        name = "category_amount",
        query =
        "Select C.id, C.category_code, C.category_name, C.descript, sum(P.val_amount) as amount " +
                "FROM products P RIGHT JOIN categories C " +
                "ON P.category = C.id " +
                "GROUP BY C.id " +
                "ORDER BY val_amount DESC;",
        resultSetMapping = "category_amount_dto"
)
@SqlResultSetMapping(
        name = "category_amount_dto",
        classes = @ConstructorResult(
                targetClass = CategoryWithAmountDto.class,
                columns = {
                        @ColumnResult(name = "id", type = Integer.class),
                        @ColumnResult(name = "category_code", type = String.class),
                        @ColumnResult(name = "category_name", type = String.class),
                        @ColumnResult(name = "descript", type = String.class),
                        @ColumnResult(name = "amount", type = Integer.class)
                }
        )
)
public class CategoryWithAmount {
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
