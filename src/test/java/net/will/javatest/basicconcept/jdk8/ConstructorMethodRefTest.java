package net.will.javatest.basicconcept.jdk8;

import net.will.javatest.basicconcept.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConstructorMethodRefTest {
    private List<Person> roster = Collections.emptyList();
    
    @BeforeEach
    public void setup() {
        roster = new ArrayList<>();
        roster.add(new Person("person01"));
        roster.add(new Person("person02"));
    }
    
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
