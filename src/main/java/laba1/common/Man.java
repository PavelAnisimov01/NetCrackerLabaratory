package laba1.common;


import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Класс человек со свойствами <b>ID</b> , <b>fio</b> , <b>dateOfBirthday</b> , <b>gender</b>, <b>seriyAndNumberOfPassport</b>,<b>age</b> .
 * @autor Анисимов Павел
 */


public class Man {
    /** Поле ID */
    private Long ID;
    /** Поле ФИО */
    private  String fio;
    /** Поле дата рождения */
    private  String dateOfBirthday;
    /** Поле пол человека */
    private  String gender;
    /** Поле серия и номер паспорта */
    private  String seriyAndNumberOfPassport;

    /**
     * Конструктор - создание нового объекта без значений
     */

    public Man(){

    }

    /** Поле возраст человека */

    private int age;
    /**
     * Конструктор - создание нового объекта с определёнными значениями
     * @param fio - ФИО
     * @param dateOfBirthday - дата дня рождения
     * @param gender - пол человека
     * @param seriyAndNumberOfPassport - серия и номер паспорта
     */
    public Man( String fio, String dateOfBirthday, String gender, String seriyAndNumberOfPassport) {

        this.fio = fio;
        this.dateOfBirthday = dateOfBirthday;
        this.gender = gender;
        this.seriyAndNumberOfPassport = seriyAndNumberOfPassport;

    }
    /**
     * Функция вычисления и получения значения поля {@link Man#age}
     * @return возвращает значение возраста
     */
    public Integer getAge() {
        String[] words = dateOfBirthday.split(":");
        int year1 = Integer.parseInt(words[2]);
        int month1 = Integer.parseInt(words[1]);
        int day1 = Integer.parseInt(words[0]);
        SimpleDateFormat formater = new SimpleDateFormat("dd:MM:yyyy");
        Date date = new Date();
        String date2 = formater.format(date);
        String[] words2 = date2.split(":");
        int year2 = Integer.parseInt(words2[2]);
        int month2 = Integer.parseInt(words2[1]);
        int day2 = Integer.parseInt(words2[0]);
        if (month2 > month1) age = year2 - year1;
        else if (month1 > month2) age = year2 - year1 - 1;
        else {
            if (day1 > day2) age = year2 - year1 - 1;
            if (day2 > day1) age = year2 - year1;
            if (day1 == day2) age = year2 - year1;
        }

        return age;
    }


    /**
     * Функция получения значения поля {@link Man#ID}
     * @return возвращает значение ID
     */
    public Long getID() {
        return ID;
    }
    /**
     * Функция определения значения поля {@link Man#ID}
     *  @param ID - ID
     */
    public void setID(Long ID) {
        this.ID = ID;
    }
    /**
     * Функция получения значения поля {@link Man#fio}
     * @return возвращает значение fio
     */
    public String getFio() {
        return fio;
    }

    public String getFioForComp() {
        String[] words = fio.split(" ");
        return words[0] + words[1]+ words[2];
    }

    /**
     * Функция получения значения поля {@link Man#dateOfBirthday}
     * @return возвращает значение dateOfBirthday
     */
    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    /**
     * Функция получения значения поля {@link Man#gender}
     * @return возвращает значение gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Функция получения значения поля {@link Man#seriyAndNumberOfPassport}
     * @return возвращает значение seriyAndNumberOfPassport
     */
    public String getDateOfPassport() {
        return seriyAndNumberOfPassport;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }
    /**
     * Функция определения значения поля {@link Man#dateOfBirthday}
     *  @param dateOfBirthday - ID
     */
    public void setDateOfBirthday(String dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }
    /**
     * Функция определения значения поля {@link Man#gender}
     *  @param gender - пол человека
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
    /**
     * Функция определения значения поля {@link Man#seriyAndNumberOfPassport}
     *  @param seriyAndNumberOfPassport - серия и номер паспорта
     */

    public void setSeriyAndNumberOfPassport(String seriyAndNumberOfPassport) {
        this.seriyAndNumberOfPassport = seriyAndNumberOfPassport;
    }
    /**
     * Конструктор - создание нового объекта с значениями
     * @param ID - ID
     * @param fio - FIO человека
     * @param gender - пол человека
     * @param seriyAndNumberOfPassport - серия и номер паспорта человека
     * @param age - возраст человека
     */

    public Man(Long ID, String fio, String dateOfBirthday, String gender, String seriyAndNumberOfPassport, int age) {
        this.ID = ID;
        this.fio = fio;
        this.dateOfBirthday = dateOfBirthday;
        this.gender = gender;
        this.seriyAndNumberOfPassport = seriyAndNumberOfPassport;
        this.age = age;
    }
}
