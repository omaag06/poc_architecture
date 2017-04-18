package junit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class JUnitRuleTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void testRule() throws IOException {
        File newFolder = tempFolder.newFolder("Temp Folder");
        assertTrue(newFolder.exists());
    }
}