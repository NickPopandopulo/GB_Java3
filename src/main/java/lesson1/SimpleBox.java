package lesson1;

//Требуется контейнер для хоранения объектов разного типа

//POJO - Plain Old Java Object
public class SimpleBox {
    private final Object object;

    public SimpleBox(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }
}
