package ge.bog.eventmanager.core;

import ge.bog.eventmanager.model.Category;

public interface CategoryAPI {
    void addCategory(Category category);
    void editCategory(Category category);
    void deleteCategory(Category category);
}
