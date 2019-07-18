package Service;

import web.impl.Counter;

import javax.xml.ws.Endpoint;

public class Service {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8888/count", new Counter());
    }
}
