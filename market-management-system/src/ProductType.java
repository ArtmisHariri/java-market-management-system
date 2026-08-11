import java.lang.reflect.Type;

public enum ProductType implements Type {
    FOOD, ELECTRONIC, STATIONARY, CLOTHING, PHARAMACEUTICAL, ACCESSORY;

    @Override
    public String getTypeName() {
        return Type.super.getTypeName();
    }
}
