package tonywis.library.listview.pinnedsection.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import tonywis.library.listview.pinnedsection.R;
import tonywis.library.listview.pinnedsection.library.PinnedSectionListView;
import tonywis.library.listview.pinnedsection.model.JourneyManager;
import tonywis.library.listview.pinnedsection.ui.adapter.ListViewAdapter;
import tonywis.library.listview.pinnedsection.ui.adapter.model.Item;

public class MainActivity extends AppCompatActivity {

    private PinnedSectionListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (PinnedSectionListView) findViewById(R.id.list);

        List<Item<JourneyManager>> list = new ArrayList<>();
        int sectionPosition = 0, listPosition = 0;

        Item<JourneyManager> item = new Item<>(Item.SECTION, "Section 1");
        item.sectionPosition = sectionPosition;
        item.listPosition = listPosition++;
        list.add(item);
        for (int i = 0; i<10; i++){
            JourneyManager journeyManager = new JourneyManager(String.valueOf((char) ('A' + i)));
            item = new Item<>(Item.ITEM, journeyManager);
            item.sectionPosition = sectionPosition;
            item.listPosition = listPosition++;
            list.add(item);
        }
        sectionPosition++;

        item = new Item<>(Item.SECTION, "Section 2");
        item.sectionPosition = sectionPosition;
        item.listPosition = listPosition++;
        list.add(item);
        for (int i = 10; i<20; i++){
            JourneyManager journeyManager = new JourneyManager(String.valueOf((char) ('A' + i)));
            item = new Item<>(Item.ITEM, journeyManager);
            item.sectionPosition = sectionPosition;
            item.listPosition = listPosition++;
            list.add(item);
        }
        sectionPosition++;

        item = new Item<>(Item.SECTION, "Section 3");
        item.sectionPosition = sectionPosition;
        item.listPosition = listPosition++;
        list.add(item);
        for (int i = 20; i<26; i++){
            JourneyManager journeyManager = new JourneyManager(String.valueOf((char) ('A' + i)));
            item = new Item<>(Item.ITEM, journeyManager);
            item.sectionPosition = sectionPosition;
            item.listPosition = listPosition++;
            list.add(item);
        }
        listView.setAdapter(new ListViewAdapter(MainActivity.this, R.layout.item_listview, list));
        listView.setShadowVisible(true);
    }
}
