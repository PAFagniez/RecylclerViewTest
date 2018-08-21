package paf.recylclerviewtest.logic;

import paf.recylclerviewtest.data.DataSourceInterface;
import paf.recylclerviewtest.data.ListItem;
import paf.recylclerviewtest.view.ViewInterface;

public class Controller {

    private ViewInterface view;
    private DataSourceInterface dataSource;

    public Controller(ViewInterface view, DataSourceInterface dataSource) {
        this.view = view;
        this.dataSource = dataSource;

        getListFromDataSource();
    }

    public void getListFromDataSource() {
        view.setUpAdapterAndView(dataSource.getListOfData());
    }

    public void onListItemClicked(ListItem testItem) {
        view.startDetailActivity(
                testItem.getDateAndTime(),
                testItem.getMessage(),
                testItem.getColorResource()
        );
    }
}
