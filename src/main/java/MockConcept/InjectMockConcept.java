package MockConcept;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

//Mockito is framework, unit testing,sample mock object of real server. (not need to db,server,connection ..)
//call mock object and use it your test.
// we will use with when and thenReturn()..
//Junit for testing
public class InjectMockConcept
{
    @Mock
    List<String> mockList;

    @InjectMocks
    Employee mockEmployee;

    @Before
    public void setUp(){


        MockitoAnnotations.initMocks(this);

    }

    @Test
    public  void mockitoTest1(){

        when(mockList.get(0)).thenReturn("Selen");
        when(mockList.get(1)).thenReturn("Dilek");
        when(mockList.size()).thenReturn(2);
        mockList.add(1,"TOM");

        assertEquals("Selen",mockEmployee.getEmpName().get(0));
        assertEquals(3,mockEmployee.getEmpName().size());

    }

    class Employee{

      List<String> empName;

        public List<String> getEmpName() {
            return empName;
        }

        public void setEmpName(List<String> empName) {
            this.empName = empName;
        }
    }

}
