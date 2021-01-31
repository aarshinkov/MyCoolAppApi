package com.aarshinkov.rest.mycoolapp.models;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Atanas Yordanov Arshinkov
 * @since 1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductModel implements Serializable {

    private String name;
    private Double price;
    private Integer quantity;
    private String number;
    private String barcode;
}
