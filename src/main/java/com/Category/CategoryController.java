package com.Category;

import Classes.Category.Category;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CategoryController {


    private TextField txtCategoryId;


    private TextField txtCategoryName;


    private TextArea txtDescription;

    private Category category;


    public void handleSaveCategory() {

        int id = Integer.parseInt(
                txtCategoryId.getText());

        String name =
                txtCategoryName.getText();

        String description =
                txtDescription.getText();

        category = new Category(
                id,
                name,
                description);

        System.out.println(
                "Category Saved");
    }

    @FXML
    public void handleEditCategory() {

        if (category != null) {

            category.editCategory(
                    txtCategoryName.getText(),
                    txtDescription.getText());

            System.out.println(
                    "Category Updated");
        }
    }

    @FXML
    public void handleClear() {

        txtCategoryId.clear();
        txtCategoryName.clear();
        txtDescription.clear();
    }
}