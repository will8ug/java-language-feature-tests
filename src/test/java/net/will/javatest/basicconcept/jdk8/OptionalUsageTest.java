package net.will.javatest.basicconcept.jdk8;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class OptionalUsageTest {
    private final Supplier<String> assistant = Mockito.spy(new SupplierAssistant());

    @Test
    public void testIsPresent() {
        Optional<String> value = OptionalUsage.getOptionalValue(10);
        assertTrue(value.isPresent());
        assertEquals("positive", value.get());
    }
    
    @Test
    public void testOrElse_WhenNotPresent() {
        Optional<String> value = OptionalUsage.getOptionalValue(-10);
        assertFalse(value.isPresent());
        assertEquals("new", value.orElse(createNewValue()));
    }
    
    @Test
    public void testOrElseGet_WhenNotPresent() {
        Optional<String> value = OptionalUsage.getOptionalValue(-10);
        String endValue = value.orElseGet(assistant);
        assertEquals("assistance", endValue);
        verify(assistant).get();
    }
    
    @Test
    public void testOrElseGet_WhenIsPresent_WithSupplier() {
        Optional<String> value = OptionalUsage.getOptionalValue(10);
        assertEquals("positive", value.orElseGet(assistant));
        verify(assistant, never()).get();
    }
    
    @Test
    public void testOrElseGet_WhenIsPresent_WithLambda() {
        Optional<String> value = OptionalUsage.getOptionalValue(10);
        assertEquals("positive", value.orElseGet(this::createNewValue));
    }
    
    private String createNewValue() {
        return "new";
    }
}
