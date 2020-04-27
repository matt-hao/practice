package com.mario.blog.viewModel;


import com.mario.blog.itemGroup.ValidateCategoryId;
import com.mario.blog.itemGroup.ValidateItemId;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Mario on 2015/9/18.
 */
public class ItemModel {
    @NotNull(message = "输入itemId不能为空", groups = ValidateItemId.class)
    @Min(value = 1, message = "输入itemId非法", groups = ValidateItemId.class)
    private Integer itemId;

    @NotBlank(message = "输入categoryId不能为空", groups = ValidateCategoryId.class)
    private String categoryId;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
