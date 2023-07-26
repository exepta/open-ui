package net.exsource.open;

import org.junit.jupiter.api.Test;

public class MasterTest {

    @Test
    void checkApplicationStart() {
        TestApplication.main(new String[]{"ui-logic=THREADED", "gl-version=auto"});
    }

}
