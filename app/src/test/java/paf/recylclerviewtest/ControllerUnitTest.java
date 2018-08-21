package paf.recylclerviewtest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import paf.recylclerviewtest.data.DataSourceInterface;
import paf.recylclerviewtest.data.ListItem;
import paf.recylclerviewtest.logic.Controller;
import paf.recylclerviewtest.view.ViewInterface;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(MockitoJUnitRunner.class)
public class ControllerUnitTest {

    @Mock
    DataSourceInterface dataSource;

    @Mock
    ViewInterface view;

    Controller controller;

    private static final ListItem testItem = new ListItem("6:30AM 06/01/2017",
                "Check out content like Fragmented Podcast to expose yourself to the ",
                R.color.BLUE
            );

    @Before
    public void setUpTest () {
        MockitoAnnotations.initMocks(this);
        controller = new Controller(view, dataSource);
    }

    @Test
    public void onGetListDataUnsuccessful() {

        ArrayList<ListItem> listOfData = new ArrayList<>();
        listOfData.add(testItem);

        Mockito.when(dataSource.getListOfData()).thenReturn(listOfData);

        controller.getListFromDataSource();

        //Check how the tested class responds to the data it receives
        //Or test its behaviour
        Mockito.verify(view).setUpAdapterAndView(listOfData);
    }

    @Test
    public void onGetListDataSuccessful() {

        ArrayList<ListItem> listOfData = new ArrayList<>();
        listOfData.add(testItem);

        Mockito.when(dataSource.getListOfData()).thenReturn(listOfData);

        controller.getListFromDataSource();

        //Check how the tested class responds to the data it receives
        //Or test its behaviour
        Mockito.verify(view).setUpAdapterAndView(listOfData);
    }

    @Test
    public void onListItemClicked() {

        controller.onListItemClicked(testItem);

        //Check how the tested class responds to the data it receives
        //Or test its behaviour
        Mockito.verify(view).startDetailActivity(
                testItem.getDateAndTime(),
                testItem.getMessage(),
                testItem.getColorResource()
        );
    }

}
