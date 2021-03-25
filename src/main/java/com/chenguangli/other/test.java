package com.chenguangli.other;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenguangli
 * @date 2021/1/11 23:24
 */
public class test {

    public class Ticket {

        public String from;

        public String to;

        public String time;

        public double price;

    }

    public class TicketManager{

        private List<Ticket> tickets;

        public Ticket search(String from, String to, String time) {
            if (from == null || from.length() == 0 || to == null || to.length() == 0 || time == null || time.length() == 0) {
                throw new RuntimeException("参数异常");
            }
            double minPrice = 0d;
            Ticket bestTicket = null;
            for (Ticket ticket : tickets) {
                String from1 = ticket.from;
                String to1 = ticket.to;
                String time1 = ticket.time;
                double price = ticket.price;
                if (from1.equals(from) && to1.equals(to) && time1.equals(time)) {
                    if (bestTicket == null || price < minPrice) {
                        bestTicket = ticket;
                    }
                }
            }
            return bestTicket;
        }

    }

    @Component
    public class TicketManager1 implements InitializingBean {

        private List<Ticket> tickets;

        private Map<String,Ticket> map = new HashMap<>(tickets.size());

        @Override
        public void afterPropertiesSet() throws Exception {
            //假设tickets已经被初始化
            //tickets.add();
            for (Ticket ticket : tickets) {
                String from1 = ticket.from;
                String to1 = ticket.to;
                String time1 = ticket.time;
                StringBuilder keyBuilder = new StringBuilder();
                keyBuilder.append(from1);
                keyBuilder.append("_");
                keyBuilder.append(to1);
                keyBuilder.append("_");
                keyBuilder.append(time1);
                keyBuilder.append("_");
                map.put(keyBuilder.toString(), ticket);
            }
        }

        public Ticket search(String from, String to, String time) {
            if (from == null || from.length() == 0 || to == null || to.length() == 0 || time == null || time.length() == 0) {
                throw new RuntimeException("参数异常");
            }
            StringBuilder keyBuilder = new StringBuilder();
            keyBuilder.append(from);
            keyBuilder.append("_");
            keyBuilder.append(to);
            keyBuilder.append("_");
            keyBuilder.append(time);
            keyBuilder.append("_");
            return map.get(keyBuilder.toString());
        }
    }
}
