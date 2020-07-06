package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Logic {

    public static MyQueue splitMyQueue(String text){
        String[] newText = text.split("[.!?,; ]");
        List list = new ArrayList();
        Collections.addAll(list, newText);
        MyQueue queue = new MyQueue();
        for (int i = 0; i < list.size(); i++) {
            String s = (String) list.get(i);
            s = s.replaceAll("\n", " ");
            s = s.trim();
            if(s.equals("")){
                list.remove(i);
                i--;
                continue;
            }
            list.remove(i);
            list.add(i, s);
        }
        for (Object o : list) queue.add(Integer.parseInt((String) o));
        return queue;
    }
    public static MyQueue sortMyQueue(MyQueue queue){
        int t = queue.size();
        int x = 1;
        for (int i = 0; i < t - 1; i++) {
            int tmp = (int) queue.poll();
            for (int j = 0; j < t - x; j++) {
                int value = (int) queue.poll();
                if (tmp > value) {
                    queue.add(value);
                } else {
                    queue.add(tmp);
                    tmp = value;
                }
            }
            queue.add(tmp);
            for (int j = 0; j < x - 1; j++) {
                queue.add(queue.poll());
            }
            x++;
        }
        return queue;
    }

    public static java.util.Queue splitQueue(String text){
        String[] newText = text.split("[.!?,; ]");
        List list = new ArrayList();
        Collections.addAll(list, newText);
        java.util.Queue queue = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            String s = (String) list.get(i);
            s = s.replaceAll("\n", " ");
            s = s.trim();
            if(s.equals("")){
                list.remove(i);
                i--;
                continue;
            }
            list.remove(i);
            list.add(i, s);
        }
        for (int i = list.size() - 1; i >= 0; i--) queue.add(Integer.parseInt((String) list.get(i)));
        return queue;
    }
    public static java.util.Queue sortQueue(java.util.Queue queue){
        int t = queue.size();
        int x = 1;
        for (int i = 0; i < t; i++) {
            int tmp = (int) queue.poll();
            for (int j = 0; j < t - 1; j++) {
                int value = (int) queue.poll();
                if (tmp > value) {
                    queue.add(value);
                } else {
                    queue.add(tmp);
                    tmp = value;
                }
            }
            queue.add(tmp);
            //System.out.println(tmp);
        }
        return queue;
    }

    public static String queueToString(MyQueue queue){
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = queue.getIterator();
        while (iterator.hasNext()){
            stringBuilder.append(iterator.next().toString());
            stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }

}
