package com.company;

import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.regex.MatchResult;

public class Person {
    public Person(String str) {
        // could make format check here
        Scanner scan = new Scanner(str);
        secondname = scan.next();
        name = scan.next();
        patronymic = scan.next();
        birthday = scan.next();
    }

    public String getName() {
        return name;
    }

    public String getSecondname() {
        return secondname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getAge() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDateTime now = LocalDateTime.now();
        Scanner curDateScan = new Scanner(dtf.format(now));
        Scanner birthDayScan = new Scanner(birthday);
        curDateScan.findInLine("(\\d+).(\\d+).(\\d+)");
        birthDayScan.findInLine("(\\d+).(\\d+).(\\d+)");
        MatchResult curDateArr = curDateScan.match();
        MatchResult birthdayArr = birthDayScan.match();
        int age = Integer.parseInt(curDateArr.group(3)) - Integer.parseInt(birthdayArr.group(3));
        if(Integer.parseInt(curDateArr.group(2)) < Integer.parseInt(birthdayArr.group(2)) ||
                (Integer.parseInt(curDateArr.group(2)) == Integer.parseInt(birthdayArr.group(2)) &&
                        Integer.parseInt(curDateArr.group(1)) >= Integer.parseInt(birthdayArr.group(1)) )) {
            age--;
        }
        return age;
    }

    public String getSex() {
        if(patronymic.endsWith("вич")) {
            return "Male";
        } else if(patronymic.endsWith("вна")) {
            return "Female";
        } else if(patronymic.endsWith("лы")) {
            return "Male";
        } else if(patronymic.endsWith("зы")) {
            return "Female";
        } else if(patronymic.endsWith("ва")) {
            return "Female";
        }
        return "Undefined";
    }

    public String getFormatted() {
        String out = secondname + " " +
                name.charAt(0) + "." +
                patronymic.charAt(0) + ". " +
                getSex() + " " +
                getAge() + " лет";
        return out;
    }

    private String name;
    private String secondname;
    private String patronymic;
    private String birthday;
}
