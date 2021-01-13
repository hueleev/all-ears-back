import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OptionalTest {

    int idx = 0;

    @Test
    public void main() {
        List<String> list = Stream.iterate("s0", s -> create()).limit(6).collect(Collectors.toList());
        System.out.println(list);
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        System.out.println(intStream.sum());
        //System.out.println(stream.collect(Collectors.toList()));
    }

    public String create() {
        idx++;
        return "s" + String.valueOf(idx);
    }
}
