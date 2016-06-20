package tonywis.library.listview.pinnedsection.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import tonywis.library.listview.pinnedsection.R;
import tonywis.library.listview.pinnedsection.library.PinnedSectionListView;
import tonywis.library.listview.pinnedsection.model.JourneyManager;
import tonywis.library.listview.pinnedsection.ui.adapter.model.Item;

/**
 * Created by Tony on 19/06/2016.
 */
public class ListViewAdapter extends ArrayAdapter<Item<String, JourneyManager>> implements PinnedSectionListView.PinnedSectionListAdapter {

    private int resId;
    private LayoutInflater layoutInflater;
    private static final int[] COLORS = new int[] {
            R.color.green_light, R.color.orange_light,
            R.color.blue_light, R.color.red_light };

    public ListViewAdapter(Context context, int resource, List<Item<String, JourneyManager>> objects) {
        super(context, resource, objects);
        resId = resource;
        layoutInflater = LayoutInflater.from(context);
    }

    public class ViewHolder {
        LinearLayout linearLayoutSection;
        LinearLayout linearLayoutItem;
        TextView titleSection;
        TextView titleItem;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(resId, null);
            vHolder = new ViewHolder();
            vHolder.linearLayoutSection = (LinearLayout) convertView.findViewById(R.id.item_listview_section);
            vHolder.linearLayoutItem = (LinearLayout) convertView.findViewById(R.id.item_listview_item);
            vHolder.titleSection = (TextView) convertView.findViewById(R.id.item_title_section);
            vHolder.titleItem = (TextView) convertView.findViewById(R.id.item_title_item);
            convertView.setTag(vHolder);
        }

        Item<String, JourneyManager> item = getItem(position);
        if (item.getTypeItem() == Item.ITEM)
            return getViewItem(position, convertView, parent);
        if (item.getTypeItem() == Item.SECTION)
            return getViewSection(position, convertView, parent);
        return convertView;
    }

    private View getViewItem(int position, View convertView, ViewGroup parent) {
        ViewHolder vHolder = (ViewHolder) convertView.getTag();
        vHolder.linearLayoutSection.setVisibility(View.GONE);
        vHolder.linearLayoutItem.setVisibility(View.VISIBLE);

        JourneyManager journeyManager = getItem(position).getObjectItem();
        vHolder.titleItem.setText(journeyManager.getValue());
        return convertView;
    }

    private View getViewSection(int position, View convertView, ViewGroup parent) {
        ViewHolder vHolder = (ViewHolder) convertView.getTag();
        vHolder.linearLayoutSection.setVisibility(View.VISIBLE);
        vHolder.linearLayoutItem.setVisibility(View.GONE);

        Item<String, JourneyManager> item = getItem(position);
        vHolder.titleSection.setText(item.getSection());
        vHolder.linearLayoutSection.setBackgroundColor(getContext().getResources().getColor(COLORS[item.sectionPosition % COLORS.length]));

        return convertView;
    }

    /**
     * This method shall return 'true' if views of given type has to be pinned.
     *
     * @param viewType
     */
    @Override
    public boolean isItemViewTypePinned(int viewType) {
        return viewType == Item.SECTION;
    }

    @Override public int getViewTypeCount() {
        return 2;
    }

    @Override public int getItemViewType(int position) {
        return getItem(position).getTypeItem();
    }
}
