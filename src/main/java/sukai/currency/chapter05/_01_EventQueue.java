package sukai.currency.chapter05;

import sukai.currency.caseV.SmallTool;

import java.util.LinkedList;

/**
 * @author chengsukai
 * @since 2022-08-22 09:11
 */
public class _01_EventQueue {
    private final int max;

    static class Event {
    }

    private final LinkedList<Event> eventQueue = new LinkedList<>();

    private final static int DEFAULT_MAX_EVENT = 10;

    public _01_EventQueue() {
        this(DEFAULT_MAX_EVENT);
    }

    public _01_EventQueue(int max) {
        this.max = max;
    }

    public void offer(Event event) {
        synchronized (eventQueue) {
            if (eventQueue.size() >= max) {
                try {
                    SmallTool.printTimeAndThread("the queue is full.");
                    eventQueue.wait();// 线程执行了某个对象饿饿wait方法后，会加入与之对应的wait set中， 每一个对象的monitor都有一个与之关联的wait set
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            SmallTool.printTimeAndThread("the new event is submitted");
            eventQueue.addLast(event);
            eventQueue.notify();
        }
    }

    public Event take() {
        synchronized (eventQueue) {
            if (eventQueue.isEmpty()) {
                try {
                    SmallTool.printTimeAndThread("the queue is empty.");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Event event = eventQueue.removeFirst();
            this.eventQueue.notify();
            SmallTool.printTimeAndThread("the event " + event + " is handled. ");
            return event;
        }
    }
}
