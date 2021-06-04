import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SingletonMap {

    private static SingletonMap instance = new SingletonMap();

    private Map<String,Map<ListenerObserver,String>> listenerMap = new ConcurrentHashMap<String,Map<ListenerObserver,String>>();

    public static SingletonMap getInstance() {
        return instance;
    }

    private SingletonMap() {
    }

    public static void addListener(String type, ListenerObserver add) {
        Map setOfListeners =  SingletonMap.getInstance().listenerMap.compute(type, (key,value) ->
                value == null ? new ConcurrentHashMap<ListenerObserver,String>() : value);
        setOfListeners.putIfAbsent(add,"");
    }

    public static void removeListener(String type, ListenerObserver remove) {
       SingletonMap.getInstance().listenerMap.computeIfPresent(type, (k,v) ->
             { v.computeIfPresent(remove ,
                                        (k1,v1) -> null);
               return v;
             }
             );
    };

    public static void listAll() {
        SingletonMap.getInstance().listenerMap.forEach((k,v) -> {
            System.out.println("type : " + k);
            v.forEach((k1,v1) -> {
                System.out.println("listener : " + k1.toString());
            });
        });
    }
}
