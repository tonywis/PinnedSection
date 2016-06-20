package tonywis.library.listview.pinnedsection.ui.adapter.model;

/**
 * Created by Tony on 19/06/2016.
 */
public class Item<TypeSection, TypeItem> {

    private final TypeSection _objectSection;
    private final TypeItem _objectItem;
    private final int _typeItem;

    public static final int ITEM = 0;
    public static final int SECTION = 1;

    public int sectionPosition;
    public int listPosition;

    public Item(int typeItem, TypeItem objectItem, TypeSection objectSection) {
        this._typeItem = typeItem;
        this._objectItem = objectItem;
        this._objectSection = objectSection;
    }

    public TypeItem getObjectItem() {
        return _objectItem;
    }

    public int getTypeItem() {
        return _typeItem;
    }

    public TypeSection getSection() {
        return _objectSection;
    }
}
