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
        // Basic check to prevent NumberFormatException if fields are empty
        if (txtCategoryId.getText().isEmpty() || txtCategoryName.getText().isEmpty()) {
            System.out.println("Error: ID and Name cannot be empty.");
            return;
        }

        try {
            int id = Integer.parseInt(txtCategoryId.getText());
            String name = txtCategoryName.getText();
            String description = txtDescription.getText();

            category = new Category(id, name, description);

            // FIX: Removed "category.dat" since the method likely takes only the object
            CategorySerializer.save(category);

            System.out.println("Category Saved");

        } catch (NumberFormatException e) {
            System.out.println("Error: ID must be a valid number.");
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

            System.out.println("Category Updated");
        }
    }

    @FXML
    public void handleClear() {
        txtCategoryId.clear();
        txtCategoryName.clear();
        txtDescription.clear();
    }
}