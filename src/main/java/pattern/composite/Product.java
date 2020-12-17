package pattern.composite;

import pattern.visitor.Visitor;

public class Product implements Item{
    private static int staticId = 0;
    private String id;
    private String category;
    private String flavour;
    private String country;
    private String cost;

    public Product() {
        id = String.valueOf(staticId++);
        this.category = "";
        this.flavour = "";
        this.country = "";
        this.cost = "";
    }

    public Product(String category) {
        id = String.valueOf(staticId++);
        this.category = category;
        this.flavour = "";
        this.country = "";
        this.cost = "";
    }

    public Product(String category, String flavour) {
        id = String.valueOf(staticId++);
        this.category = category;
        this.flavour = flavour;
        this.country = "";
        this.cost = "";
    }

    public Product(String category, String flavour, String country, String cost) {
        id = String.valueOf(staticId++);
        this.category = category;
        this.flavour = flavour;
        this.country = country;
        this.cost = cost;
    }

    public Product(String id, String flavour, String country, String cost, String category) {
        this.id = id;
        this.flavour = flavour;
        this.country = country;
        this.cost = cost;
        this.category = category;
    }

    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        if(!flavour.equals(""))
            str.append(flavour).append(" ");
        if(!category.equals(""))
            str.append(category);
        if(!country.equals(""))
            str.append(", ").append(country);
        if(!cost.equals(""))
            str.append(' ').append(cost);
        else
            str.append(" 0");
        str.append(' ').append("\n");

        return str.toString();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCost() {
        return cost;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public double getPrice() {
        if(!cost.equals(""))
            return Double.parseDouble(cost);
        else
            return 0;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public Item clone() {
        return new Product(id, category, flavour, country, cost);
    }
}
