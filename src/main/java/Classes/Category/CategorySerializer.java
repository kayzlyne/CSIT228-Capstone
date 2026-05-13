package Classes.Category;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CategorySerializer {

    public static void save(Category category,
                            String fileName)
            throws Exception {

        ObjectOutputStream out =
                new ObjectOutputStream(
                        new FileOutputStream(fileName));

        out.writeObject(category);

        out.close();
    }

    public static Category load(String fileName)
            throws Exception {

        ObjectInputStream in =
                new ObjectInputStream(
                        new FileInputStream(fileName));

        Category category =
                (Category) in.readObject();

        in.close();

        return category;
    }
}