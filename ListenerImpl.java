import java.util.Objects;

public class ListenerImpl implements ListenerObserver {

    private SingletonMap listenerMap = SingletonMap.getInstance();

    ListenerType obj=null;
    String label = null;

    ListenerImpl(ListenerType obj, String label) {
        this.obj=obj;
        this.label=label;
    }

    public String getType() {
        return obj.getType();
    }

    @Override
    public void addListener(ListenerObserver add) {
        listenerMap.addListener(getType(), add);
    }

    @Override
    public void removeListener(ListenerObserver remove) {
        listenerMap.removeListener(getType(), remove );
    }

    @Override
    public String toString() {
       return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListenerImpl listener = (ListenerImpl) o;
        return obj.getType().equals(listener.obj.getType()) && label.equals(listener.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(obj.getType(), label);
    }
}
