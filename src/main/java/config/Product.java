package config;

public class Product {
    private String name;
    private int age;

    public Product(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.age = id;
    }
}
