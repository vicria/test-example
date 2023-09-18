package rest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Stations {

    @Test
    public void test() {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        assertThat(arrayList.size()).isEqualTo(1);
    }
}
