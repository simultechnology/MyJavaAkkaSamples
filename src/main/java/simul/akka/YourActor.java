package simul.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class YourActor extends UntypedActor {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start!");

        ActorSystem system = ActorSystem.create("MyApps");

        final ActorRef yourActor = system.actorOf(Props.create(YourActor.class));
        final ActorRef myActor = system.actorOf(Props.create(MyActor.class));

        myActor.tell(new MsgB(), yourActor);
        myActor.tell(new MsgA(), yourActor);
        myActor.tell("Hello", yourActor);

        Thread.sleep(1000);

        system.shutdown();
    }

    @Override
    public void onReceive(final Object message) throws Exception {
        if (message instanceof MsgA) {
            System.out.println("MsgA received by you");
        } else {
            System.out.println("UnKnown instance type received by you");
        }
    }
}

class MsgA {

}

class MsgB {

}