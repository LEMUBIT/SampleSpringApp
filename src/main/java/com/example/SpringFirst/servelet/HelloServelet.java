package com.example.SpringFirst.servelet;

import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "helloServlet", urlPatterns = "/helloServlet")
public class HelloServelet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        List<Car> cars = Arrays.asList(new Car("Lambo", "1000", "200"), new Car("Toyota", "500", "50"));

        String json = new Gson().toJson(cars);
        response.getWriter().write(json);
        System.out.println("Running Do Get....");
    }
}

class Car {
    public String name;
    public String price;
    public String topSpeed;

    public Car(String name, String price, String topSpeed) {
        this.name = name;
        this.price = price;
        this.topSpeed = topSpeed;
    }
}
