package laba1.contracts;

import laba1.common.Common;
import laba1.common.Man;


/**
 * Класс мобильная связь со свойствами <b>minut</b>,<b>sms</b>,<b>gb</b>, наследующий класс общий со свойствами <b>ID</b> , <b>dateOfStartofContract</b> , <b>dateOfEndofContract</b> , <b>numberOfContract</b>, <b>man</b> .
 * @autor Анисимов Павел
 */
public class Mobile extends Common {

    /** Поле minut */
    private  int minut;
    /** sms */
    private int sms;
    /** gb */
    private int gb;

    /**
     * Конструктор - создание нового объекта без значений
     */
    public Mobile(){

    }
    /**
     * Функция определения значения поля {@link Mobile#minut}
     *  @param minut - количество минут
     */
    public void setMinut(int minut) {
        this.minut = minut;
    }
    /**
     * Функция определения значения поля {@link Mobile#sms}
     *  @param sms - количество смс
     */
    public void setSms(int sms) {
        this.sms = sms;
    }
    /**
     * Функция определения значения поля {@link Mobile#gb}
     *  @param gb - количество гигабайт
     */
    public void setGb(int gb) {
        this.gb = gb;
    }


    /**
     * Функция переопределения метода toString для вывода информации об объекте
     *  @return возвращает строку с полями объекта Mobile
     */
    @Override
    public String toString() {

        return " Контракт на мобильную связь: " +
                "  Id= " + ID
                + ", DateOfStartofContract= " + dateOfStartofContract

                + ", DateOfEndofContract= " + dateOfEndofContract

                + ",NumberOfContract= " + numberOfContract

                + ", Minuts= " + minut
                + ", SMS= " + sms
                + ", GB= " + gb
                + ",        Man :" +
                "ID= " + man.getID()
                + ", FIO= " + man.getFio()
                + ", DateOfBirthday= " + man.getDateOfBirthday()
                + ", SeriyAndNumberOfPassport= " + man.getDateOfPassport()
                + ", Gender= " + man.getGender()
                + ", Age= " + man.getAge();


    }
    /**
     * Конструктор - создание нового объекта с значениями
     * @param ID - ID
     * @param dateOfStartofContract - дата начала контракта
     * @param dateOfEndofContract - дата окончания контракта
     * @param numberOfContract - номер контракта
     * @param man - сущность человек
     * @param minut - количество минут
     * @param sms - количество смс
     * @param gb - количество гигабайт
     */
    public Mobile(Long ID, String dateOfStartofContract, String dateOfEndofContract, Long numberOfContract, Man man, int minut, int sms, int gb) {
        super(ID, dateOfStartofContract, dateOfEndofContract, numberOfContract, man);
        this.minut = minut;
        this.sms = sms;
        this.gb = gb;
    }
    /**
     * Конструктор - создание нового объекта с значениями
     * @param minut - количество минут
     * @param sms - количество смс
     * @param gb - количество гигабайт
     */

    public Mobile(int minut, int sms, int gb){
        this.minut = minut;
        this.sms = sms;
        this.gb = gb;
    }
}
