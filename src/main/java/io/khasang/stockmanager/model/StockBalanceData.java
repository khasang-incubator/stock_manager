package io.khasang.stockmanager.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class StockBalanceData {
    @Autowired
    Environment environment;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public StockBalanceData(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public StockBalanceData() {
    }

    private List<Category> getListCategory() {
        String sql = "SELECT * FROM CATEGORY ORDER BY name";
        List<Category> categories = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper(Category.class));
        return categories;
    }

    private int updateCategory(Category category) throws DataAccessException {
        String sql = "UPDATE category SET name = ? WHERE id = ?";
        return jdbcTemplate.update(sql, new Object[]{category.getName(), category.getId()});
    }

    public String getCategory() {
        ArrayList<Category> categories = (ArrayList<Category>) getListCategory();
        StringBuilder div = new StringBuilder();
        for (int i = 0; i < categories.size(); i++) {
            Category category = categories.get(i);
            if (i == 0) {
                div.append("<div class=\"navigation__item navigation__item_state_selected\">");
                div.append("<div class=\"category\"><div class=\"category__name\">");
                div.append(category.name);
                div.append("</div></div></div>");
            } else {
                div.append("<div class=\"navigation__item\">");
                div.append("<div class=\"category\"><a class=\"category__url\" id = \"id_");
                div.append(category.id);
                div.append("\" href=\"\" onmousedown=\"\">");
                div.append("<div class=\"category__name\">");
                div.append(category.name);
                div.append("</div></a></div></div>");
            }
        }
        for (Category category : categories) {
            System.out.println(category.getId());
        }
        return div.toString();
    }

    public String getResultUpdate() {
        String result;
        Category category = new Category();
        category.setId(3);
        category.setName("update");
        try {
            result = "Обновлено записей: " + String.valueOf(updateCategory(category));
        } catch (DataAccessException e) {
            result = e.getLocalizedMessage();
        }
        return result;
    }
}
