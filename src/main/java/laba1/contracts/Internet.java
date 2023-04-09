package laba1.contracts;

import laba1.common.Common;
import laba1.common.Man;


/**
 * Класс интернет со свойствами <b>speedOfConnection</b>, наследующий класс общий со свойствами <b>ID</b> , <b>dateOfStartofContract</b> , <b>dateOfEndofContract</b> , <b>numberOfContract</b>, <b>man</b> .
 * @autor Анисимов Павел
 */
public class Internet extends Common {
    /** Поле speedOfConnection */
    private int speedOfConnection;

    /**
     * Конструктор - создание нового объекта без значений
     */
    public Internet(){

    }
    /**
     * Функция определения значения поля {@link Internet#speedOfConnection}
     *  @param speedOfConnection - скорость интернета
     */

    public void setSpeedOfConnection(int speedOfConnection) {
        this.speedOfConnection = speedOfConnection;
    }

    /**
     * Функция переопределения метода toString для вывода информации об объекте
     *  @return возвращает строку с полями объекта Internet
     */
    @Override
    public String toString() {

        return " Контракт на проводной интернет: " +
                " Id=" + ID
                + ", DateOfStartofContract=" + dateOfStartofContract

                + ", DateOfEndofContract=" + dateOfEndofContract

                + ",NumberOfContract=" + numberOfContract


                + ", SpeedOfConnection=" + speedOfConnection
                + ",   Man :" +
                "ID=" + man.getID()
                + ", FIO=" + man.getFio()
                + ", DateOfBirthday=" + man.getDateOfBirthday()
                + ", SeriyAndNumberOfPassport=" + man.getDateOfPassport()
                + ", Gender=" + man.getGender()
                + ", Age=" + man.getAge();

    }
    /**
     * Конструктор - создание нового объекта с значениями
     * @param ID - ID
     * @param dateOfStartofContract - дата начала контракта
     * @param dateOfEndofContract - дата окончания контракта
     * @param numberOfContract - номер контракта
     * @param man - сущность человек
     * @param speedOfConnection - скорость интернета
     */
    public Internet(Long ID, String dateOfStartofContract, String dateOfEndofContract, Long numberOfContract, Man man, int speedOfConnection) {
        super(ID, dateOfStartofContract, dateOfEndofContract, numberOfContract, man);
        this.speedOfConnection = speedOfConnection;
    }
    /**
     * Конструктор - создание нового объекта с значениями
     * @param speedOfConnection - скорость интернета
     */
    public Internet(int speedOfConnection){
        this.speedOfConnection=speedOfConnection;
    }
}


