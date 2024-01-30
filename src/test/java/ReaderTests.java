import org.example.City;
import org.example.Reader;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.*;

import  org.mockito.Answers;


public class ReaderTests {


        City mockedCity = mock(City.class, Answers.RETURNS_DEEP_STUBS);
        City mockedCity2 = mock(City.class, Answers.RETURNS_DEEP_STUBS);
        List<City> cities = new ArrayList<>();
        Reader reader ;

        //before
        @Before
        public void setUp() {
            reader = new Reader();
            Double[]testArray = new Double[]{2.02,5.55};
            Double[]testArray2 = new Double[]{2.05,5.88};
            cities = asList(mockedCity, mockedCity2);
            doReturn("A").when(mockedCity).getName();
            when(mockedCity2.getName()).thenReturn("B");
            doReturn(testArray).when(mockedCity).getCoordinates();
            when(mockedCity2.getCoordinates()).thenReturn(testArray2);
            ;
        }

        @Test
        public void searcherTestTrue(){

            Double[]expectedArray = new Double[]{2.02,5.55};
            Double[]receivedArray = reader.searcher("A", cities);
            Assert.assertEquals(expectedArray,receivedArray);
        }

    @Test
        public void searcherTestTrue2(){
            Double[]expectedArray = new Double[]{2.05,5.88};
            Double[]receivedArray = reader.searcher("B", cities);
            Assert.assertEquals(expectedArray,receivedArray);

        }
        @Test
        public void searcherTestFalse(){
            Double[]expectedArray = new Double[]{2.02, 5.55};
            Assert.assertNotEquals(expectedArray,reader.searcher("B",cities));
        }

    @Test
    public void searcherTestFalse2(){
        Double[]expectedArray = new Double[]{2.05,5.88};
        Assert.assertNotEquals(expectedArray,reader.searcher("C",cities));
    }

    }


