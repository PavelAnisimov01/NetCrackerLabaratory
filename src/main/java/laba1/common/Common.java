package laba1.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Класс общий со свойствами <b>ID</b> , <b>dateOfStartofContract</b> , <b>dateOfEndofContract</b> , <b>numberOfContract</b>, <b>man</b> .
 * @autor Анисимов Павел
 */
public class Common {
    /** Поле ID */
    protected Long ID;
    /** Поле даты начала контракта */
    protected String dateOfStartofContract;
    /** Поле даты окончания контракта */
    protected String dateOfEndofContract;
    /** Поле номера контракта */
    protected Long numberOfContract;
    /** Поле сущности человека */
    protected Man man;

    /**
     * Конструктор - создание нового объекта без значений
     */
    public Common(){

    }
    /**
     * Функция вычисления и получения значения поля даты начала контракта для возможности сортировать
     * @return возвращает значение возраста
     */
    public Integer getDateOfStartofContractForComp() {
        String[] words = dateOfStartofContract.split(":");
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
        int dateOfStartofContractNew=0;
        if (month2 > month1) dateOfStartofContractNew = year2 - year1;
        else if (month1 > month2) dateOfStartofContractNew = year2 - year1 - 1;
        else {
            if (day1 > day2) dateOfStartofContractNew = year2 - year1 - 1;
            if (day2 > day1) dateOfStartofContractNew = year2 - year1;
            if (day1 == day2) dateOfStartofContractNew = year2 - year1;
        }
        return dateOfStartofContractNew;
    }
    /**
     * Функция вычисления и получения значения поля даты окончания контракта для возможности сортировать
     * @return возвращает значение возраста
     */
        public Integer getDateOfEndofContractForComp() {
            String[] words = dateOfEndofContract.split(":");
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
            int dateOfEndofContractNew=0;
            if (month2 > month1) dateOfEndofContractNew = year2 - year1;
            else if (month1 > month2) dateOfEndofContractNew = year2 - year1 - 1;
            else {
                if (day1 > day2) dateOfEndofContractNew = year2 - year1 - 1;
                if (day2 > day1) dateOfEndofContractNew = year2 - year1;
                if (day1 == day2) dateOfEndofContractNew = year2 - year1;
            }

            return  dateOfEndofContractNew;
        }

    /**
     * Функция определения значения поля {@link Common#man}
     *  @param man - сущность человек
     */

    public void setMan(Man man) {
        this.man = man;
    }
    /**
     * Функция получения значения поля {@link Common#dateOfStartofContract}
     * @return возвращает значение даты начала контракта
     */
    public String getDateOfStartofContract() {
        return dateOfStartofContract;
    }
    /**
     * Функция получения значения поля {@link Common#dateOfEndofContract}
     * @return возвращает значение даты окончания контракта
     */
    public String getDateOfEndofContract() {
        return dateOfEndofContract;
    }
    /**
     * Функция получения значения поля {@link Common#numberOfContract}
     * @return возвращает значение номера контракта
     */
    public Long getNumberOfContract() {
        return numberOfContract;
    }
    /**
     * Функция получения значения поля {@link Common#man}
     * @return возвращает значение сущности человека
     */
    public Man getMan() {
        return man;
    }

    /**
     * Функция получения значения поля {@link Common#ID}
     * @return возвращает значение возраста
     */

    public Long getID() {
        return ID;
    }
    /**
     * Функция определения значения поля {@link Common#ID}
     *  @param ID - ID
     */
    public void setID(Long ID) {
        this.ID = ID;
    }
    /**
     * Функция определения значения поля {@link Common#dateOfStartofContract}
     *  @param dateOfStartofContract - дата начала контракта
     */

    public void setDateOfStartofContract(String dateOfStartofContract) {
        this.dateOfStartofContract = dateOfStartofContract;
    }
    /**
     * Функция определения значения поля {@link Common#dateOfEndofContract}
     *  @param dateOfEndofContract - дата окончания контракта
     */
    public void setDateOfEndofContract(String dateOfEndofContract) {
        this.dateOfEndofContract = dateOfEndofContract;
    }
    /**
     * Функция определения значения поля {@link Common#numberOfContract}
     *  @param numberOfContract - номер контракта
     */
    public void setNumberOfContract(Long numberOfContract) {
        this.numberOfContract = numberOfContract;
    }
    /**
     * Функция определения общих свойств для каждого контракта
     * @param count -счётчик, определяющих индивидуальный ID
     * @param scStr -объект типа сканер для ввода строковых значений
     * @param scChislo- объект типа сканер для ввода числовых значений
     */

    public void setCommon(Long count,Scanner scStr,Scanner scChislo){
        Man man=new Man();
        System.out.println("Введите FIO человека");
        man.setFio(scStr.nextLine());
        System.out.println("Введите дату рождения человека(формат dd:mm:yyyy)");
        man.setDateOfBirthday(scStr.nextLine());
        System.out.println("Введите серию и номер паспорта человека через пробел(формат ssss nnnnnn)");
        man.setSeriyAndNumberOfPassport(scStr.nextLine());
        System.out.println("Введите пол человека");
        man.setGender(scStr.nextLine());
        man.setID(count);
        setMan(man);
        System.out.println("Введите дату начала контракта(формат dd:mm:yyyy)");
        setDateOfStartofContract(scStr.nextLine());
        System.out.println("Введите дату окончания контракта(формат dd:mm:yyyy)");
        setDateOfEndofContract(scStr.nextLine());
        System.out.println("Введите номер контракта");
        setNumberOfContract(scChislo.nextLong());
        setID(count);

    }
    /**
     * Конструктор - создание нового объекта с значениями
     * @param ID - ID
     * @param dateOfStartofContract - дата начала контракта
     * @param dateOfEndofContract - дата окончания контракта
     * @param numberOfContract - номер контракта
     * @param man - сущность человек
     */

    public Common(Long ID, String dateOfStartofContract, String dateOfEndofContract, Long numberOfContract, Man man) {
        this.ID = ID;
        this.dateOfStartofContract = dateOfStartofContract;
        this.dateOfEndofContract = dateOfEndofContract;
        this.numberOfContract = numberOfContract;
        this.man = man;
    }
}
