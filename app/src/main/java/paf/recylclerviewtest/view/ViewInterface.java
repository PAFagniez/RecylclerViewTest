package paf.recylclerviewtest.view;

import java.util.List;

import paf.recylclerviewtest.data.ListItem;

public interface ViewInterface {

    void startDetailActivity(String dateAndTime, String message, int colorResource);

    void setUpAdapterAndView(List<ListItem> listOfData);

    void addNewListItemToView(ListItem newItem);
}

