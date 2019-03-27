/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitaptrenlop;

import java.util.Scanner;

public class MyDate {

    private int day;
    private int month;
    private int year;

    public MyDate() {
    }

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isNamNhuan() {
        if ((this.year % 4 == 0 && this.year % 100 == 0) || (this.year % 400 == 0)) {
            return true;
        }
        return false;
    }

    public boolean isMonth30d() {
        if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) {
            return true;
        }
        return false;
    }

    public boolean isMonth31d() {
        if (isMonth30d() == false && this.month != 2) {
            return true;
        }
        return false;
    }

    public int inputDay(Scanner sc) {
        int day;
        do {
            day = sc.nextInt();
            if (isNamNhuan() == true) {
                if (this.month == 2) {
                    if (day > 0 && day < 30) {
                        break;
                    } else if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) {
                        if (day > 0 && day < 31) {
                            break;
                        }
                    } else if (day > 0 && day < 32) {
                        break;
                    }
                }
            } else {
                if (this.month == 2) {
                    if (day > 0 && day < 29) {
                        break;
                    }
                } else if ((this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11)) {
                    if (day > 0 && day < 31) {
                        break;
                    }
                } else {
                    if (day > 0 && day < 32) {
                        break;
                    }

                }
            }

        } while (true);
        return day;
    }

    public int inputMonth(Scanner sc) {
        int month;
        do {
            month = sc.nextInt();

        } while (month < 0 && month > 13);
        return month;
    }

    public int inputYear(Scanner sc) {
        int year;
        do {
            year = sc.nextInt();
        } while (year < 0);
        return year;
    }

    public void inputDate(Scanner sc) {
        System.out.println("Enter year: ");
        year = inputYear(sc);
        System.out.println("Enter month: ");
        month = inputMonth(sc);
        System.out.println("Enter day: ");
        day = inputDay(sc);
    }

    public void showDate() {
        Scanner sc = new Scanner(System.in);
        int x;

        System.out.println("--Ban muon in theo dinh dang nao?");
        System.out.println("--Chung toi co 2 dinh dang.");
        System.out.println("--1.Dang ngan: Ngay/Thang/Nam");
        System.out.println("--2.Dang dai: Ngay d Thang m Nam y");
        System.out.println("--Nhap 1 chon dang ngan, nhap 2 chon dang dai!");
        x = sc.nextInt();
        switch (x) {
            case 1:
                System.out.println(day + "/" + month + "/" + year);
                break;
            case 2:
                System.out.println("Ngay " + day + " Thang " + month + " Nam " + year);
                break;
            default:
                System.out.println("Ban chi duoc nhap 1 va 2!");
                break;
        }
    }

    public void addYear(int year) {
        this.year += year;
    }

    public void addMonth(int month) {
        this.month += month;
        if (this.month > 12) {
            int years = this.month % 12;
            this.addYear(years);
            this.month = this.month / 12;
        }
    }

    public void addDay(int day) {
        this.day += day;
        switch (this.month) {
            case 2:
                if (this.isNamNhuan()) {
                    if (this.day >= 29) {
                        this.addMonth(1);
                        int diff = this.day - 29;
                        this.day = 0;
                        this.addDay(diff);
                    }
                } else {
                    if (this.day >= 28) {
                        this.addMonth(1);
                        int diff = this.day - 28;
                        this.day = 0;
                        this.addDay(diff);
                    }
                }
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (this.day > 31) {
                    this.addMonth(1);
                    int diff = this.day - 31;
                    this.day = 0;
                    this.addDay(diff);
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (this.day > 30) {
                    this.addMonth(1);
                    int diff = this.day - 30;
                    this.day = 0;
                    this.addDay(diff);
                }
                break;
        }

    }
    
    

    public static void main(String[] args) {
        MyDate date = new MyDate(31,12,2019);
        Scanner sc = new Scanner(System.in);
        date.addDay(1);
        date.showDate();
    }
}
