public class ConcurrentExample {

    public static void main(String args[]){

            SingletonMap listenerMap = SingletonMap.getInstance();

            ListenerImpl test1 = new ListenerImpl( new ListenerObjFx("FX"), "add1");
            ListenerImpl test2 = new ListenerImpl( new ListenerObjFx("FX"), "add2");

            test1.addListener(test1);
            test1.addListener(test2);

            ListenerImpl test3 = new ListenerImpl( new ListenerObjFx("stock"), "add3");
            ListenerImpl test4 = new ListenerImpl( new ListenerObjFx("stock"), "add4");
            test3.addListener(test3);
            test3.addListener(test4);

            test1.removeListener(test2);
            //test1.removeListener(test1);
            listenerMap.listAll();

    }
}
