package org.bigjava.bean;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: Product
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-30 16:04
 * @Version v1.0
 */
public class Product {
    private Integer id;

    private String name;

    /**
     * 简介
     */
    private String introduction;
    /**
     *  成分
     */
    private String ingredient;

    private Integer sell;

    private Integer cost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public Integer getSell() {
        return sell;
    }

    public void setSell(Integer sell) {
        this.sell = sell;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", introduction=").append(introduction);
        sb.append(", ingredient=").append(ingredient);
        sb.append(", sell=").append(sell);
        sb.append(", cost=").append(cost);
        sb.append("]");
        return sb.toString();
    }
}