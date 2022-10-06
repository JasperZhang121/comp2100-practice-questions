
public class SequenceGenerator {

    private static Integer ID_GENERATOR = 0;

    public Integer nextVal() {
        ID_GENERATOR++;
        return ID_GENERATOR;
    }
}
