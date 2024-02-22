package net.will.javatest.basicconcept;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Misc01Test {

    @SuppressWarnings("unchecked")
    @Test
    public void test_CoercionOnNull() {
        Map<String, Object> emptyMap = new HashMap<String, Object>();
        assertNull(emptyMap.get("GiveMeANull"));
        
        List<Object> expectList = (List<Object>) emptyMap.get("GiveMeANull");
        assertNull(expectList);
        
        String expectString = (String) emptyMap.get("GiveMeANull");
        assertNull(expectString);
        
        assertNotNull("There should be no Exception.");
    }

}
