package strategy;

public class Square implements Shape{
    @Override
    public String draw() {
        return ("------\n" +
                "|    |\n" +
                "|    |\n" +
                "------\n");
    }
}
