package com.example.hexagonalarchitecture.order.shared.util;

import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

@Component
public class GeneratedOrderNumber {
    public String generate(String orderNumber) {
        LocalDate date = LocalDate.parse(orderNumber.substring(0, 6), DateTimeFormatter.ofPattern("yyMMdd"));
        String type = orderNumber.substring(6, 7);
        int code = orderNumber.substring(7, 8).charAt(0);
        int count = Integer.parseInt(orderNumber.substring(8));
        LocalDate today = LocalDate.now();
        if (date.isBefore(today)) {
            return today.format(format("yyMMdd")) + type + "A00001";
        } else {
            return date.format(format("yyMMdd")) + type + calc(code, count);
        }
    }

    private String calc(int code, int count) {
        if (count == 99999) {
            count = 1;
            code += 1;
        } else {
            count++;
        }
        return ((char) code) + String.format("%05d", count);
    }

    private DateTimeFormatter format(String pattern) {
        return DateTimeFormatter.ofPattern(pattern);
    }
}
