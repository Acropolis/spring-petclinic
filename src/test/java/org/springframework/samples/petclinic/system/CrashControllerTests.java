package org.springframework.samples.petclinic.system;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Test class for {@link CrashController}
 *
 * @author Colin But
 */
@Ignore
@WebMvcTest(controllers = CrashController.class)
public class CrashControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testTriggerException() throws Exception {
        mockMvc.perform(get("/oups")).andExpect(view().name("exception"))
                .andExpect(model().attributeExists("exception"))
                .andExpect(forwardedUrl("exception")).andExpect(status().isOk());
    }
}
