package tonywis.library.listview.pinnedsection.ui.adapter.model;

/**
 * Created by Tony on 19/06/2016.
 */
public class Item<Type> {

    private final Type _object;
    private final String _nameSection;
    private final int _typeItem;

    public static final int ITEM = 0;
    public static final int SECTION = 1;

    public int sectionPosition;
    public int listPosition;

    public Item(int typeItem, String nameSection) {
        this(typeItem, null, nameSection);
    }

    public Item(int typeItem, Type object) {
        this(typeItem, object, null);
    }

    private Item(int typeItem, Type object, String nameSection) {
        this._typeItem = typeItem;
        this._object = object;
        this._nameSection = nameSection;
    }

    public Type getObject() {
        return _object;
    }

    public int getTypeItem() {
        return _typeItem;
    }

    public String getNameSection() {
        return _nameSection;
    }
}
