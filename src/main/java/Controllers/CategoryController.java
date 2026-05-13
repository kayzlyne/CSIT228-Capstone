package Controllers;

import Classes.Category.Category;
import Classes.Category.CategorySerializer;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CategoryController {

    @FXML
    private TextField txtCategoryId;

    @FXML
    private TextField txtCategoryName;

    @FXML
    private TextArea txtDescription;

    private Category category;

    @FXML
    public void handleSaveCategory() {

        int id =
                Integer.parseInt(
                        txtCategoryId.getText());

        String name =
                txtCategoryName.getText();

        String description =
                txtDescription.getText();

        category =
                new Category(
                        id,
                        name,
                        description);

        try {

            CategorySerializer.save(
                    category,
                    "category.dat");

            System.out.println(
                    "Category Saved");

        } catch (Exception e) {

            e.printStackTrace();
        }
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