package paf.recylclerviewtest.data;

/*
 * *
 *  * Copyright (C) 2017 Ryan Kay Open Source Project
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import paf.recylclerviewtest.R;

/**
 * "Fake objects actually have working implementations, but usually take some shortcut which makes
 * them not suitable for production (an in memory database is a good example)."
 * <p>
 * -Martin Fowler,
 * https://www.martinfowler.com/articles/mocksArentStubs.html
 * <p>
 * Since this is a tutorial about building a RecyclerView, our Activity will be talking to a "Fake"
 * DataSource. As long as our "Fake" Data looks the same as the Data we'd expect from a "Real"
 * Datasource, we can use these Fakes to Test our App!
 * <p>
 * <p>
 * Created by R_KAY on 6/1/2017.
 */

public class FakeDataSource implements DataSourceInterface{

    private static final int SIZE_OF_COLLECTION = 12;
    private Random random;

    private final String[] datesAndTimes = {
            "6:30AM 06/01/2017",
            "9:26PM 04/22/2013",
            "2:01PM 12/02/2015",
            "2:43AM 09/7/2018",
    };

    private final String[] messages = {
            "Check out content like Fragmented Podcast to expose yourself to the knowledge, ideas, " +
                    "and opinions of experts in your field",
            "Look at Open Source Projects like Android Architecture Blueprints to see how experts" +
                    " design and build Apps",
            "Write lots of Code and Example Apps. Writing good Quality Code in an efficient manner "
                    + "is a Skill to be practiced like any other.",
            "If at first something doesn't make any sense, find another explanation. We all " +
                    "learn/teach different from each other. Find an explanation that speaks to you."
    };

    private final int[] colours = {
            R.color.RED,
            R.color.BLUE,
            R.color.GREEN,
            R.color.YELLOW,
    };


    public FakeDataSource() {
        random = new Random();
    }

    /**
     * Creates a list of ListItems.
     *
     * @return A list of 12 semi-random ListItems for testing purposes
     */
    @Override
    public List<ListItem> getListOfData() {
        ArrayList<ListItem> listOfData = new ArrayList<>();
        Random random = new Random();
        //make 12 semi-random items
        for (int i = 0; i < 12; i++) {

            int randOne = random.nextInt(4);
            int randTwo = random.nextInt(4);
            int randThree = random.nextInt(4);

            ListItem listItem = new ListItem(datesAndTimes[randOne],
                    messages[randTwo],
                    colours[randThree]);

            listOfData.add(listItem);
        }

        return listOfData;
    }
}