public class ListenerObjFx implements ListenerType {
    @Override
    public String getType() {
        return type;
    }

    String type = "FX";

    ListenerObjFx(String type) {
        this.type=type;
    }
}
