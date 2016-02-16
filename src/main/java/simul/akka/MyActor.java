package simul.akka;

import akka.actor.UntypedActor;

public class MyActor extends UntypedActor {

    @Override
    public void onReceive(final Object message) throws Exception {
        if (message instanceof MsgA) {
            System.out.println("MsgA received by me");
        } else if (message instanceof MsgB) {
            System.out.println("MsgB received by me");
        } else if (message instanceof String) {
            System.out.printf("String Message was received by me: %s\n", message);
        } else {
            System.out.println("UnKnown instance type.");
        }

        this.getSender().tell(new MsgA(), getSelf());
    }
}
