package net.will.javatest.basicconcept.jdk8;

import net.will.javatest.basicconcept.Person;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConstructorMethodRefTest {
    private final List<Person> roster = List.of(new Person("person01"), new Person("person02"));

    @Test
    public void testLambdaExpression() {
        Set<Person> rosterSetLambda = ConstructorMethodRef.transferElements(roster, () -> {
            return new HashSet<>();
        });
        
        assertEquals(2, rosterSetLambda.size());
    }
    
    @Test
    public void testConstructorReference() {
        Set<Person> rosterSet = ConstructorMethodRef.transferElements(roster, HashSet::new);
        
        assertEquals(2, rosterSet.size());
    }
    
    @Test
    public void testConstructorReference_Alternative() {
        Set<Person> rosterSet = ConstructorMethodRef.transferElements(roster, HashSet<Person>::new);
        
        assertEquals(2, rosterSet.size());
    }
}
