package Classes.Category;

import java.io.*;

public class CategorySerializer {

    private static final String FILE_NAME = "category.dat";

    public static void save(Category category) throws IOException {

        try (ObjectOutputStream out =
                     new ObjectOutputStream(
                             new FileOutputStream(FILE_NAME))) {

            out.writeObject(category);
        }
    }

    public static Category load() throws IOException, ClassNotFoundException {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return null;
        }

        try (ObjectInputStream in =
                     new ObjectInputStream(
                             new FileInputStream(FILE_NAME))) {

            return (Category) in.readObject();
        }
    }
}
