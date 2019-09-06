package ge.bog.eventmanager.core;

import ge.bog.eventmanager.model.Category;

import java.util.List;
import java.util.Map;

public interface CategoryAPI {
    void addCategory(Category category);
    void deleteCategory(Category category);
    Category getCategory(int id);
    List<Category> getCategories();
    boolean findCategory(Category category);
}
